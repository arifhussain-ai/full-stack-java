package Java.PROJECT_FROM_SWING_JDBC.HOSPITAL_MANAGEMENT_SYSTEM;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class VIEW_PATIENT extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VIEW_PATIENT frame = new VIEW_PATIENT();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VIEW_PATIENT() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 679, 416);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.BLUE);
		panel.setBounds(0, 0, 656, 380);
		contentPane.add(panel);
		
		JButton btnNewButton = new JButton("VIEW");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				model.setRowCount(0);
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hospital","root","Root@123");
					String query = "SELECT * FROM  patient";
					PreparedStatement pstm = con.prepareStatement(query);
					ResultSet rs = pstm.executeQuery();
					while(rs.next()) {
						int patientid = rs.getInt("id");
						String patientId = Integer.toString(patientid);
						String patientName = rs.getString("Name");
						int patientage = rs.getInt("Age");
						String patientAge = Integer.toString(patientage);
						String doctorName = rs.getString("doctorName");
						String row[] = {patientId,patientName,patientAge,doctorName};
						model.addRow(row);
					}
					pstm.close();
					rs.close();
					con.close();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
			}
		});
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnNewButton.setBounds(530, 53, 103, 34);
		panel.add(btnNewButton);
		
		JScrollPane TABEL1 = new JScrollPane();
		TABEL1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		TABEL1.setBounds(37, 94, 596, 277);
		panel.add(TABEL1);

		table = new JTable();
		table.setModel(new DefaultTableModel(
		    new Object[][] {},
		    new String[] { "ID", "NAME", "AGE", "DOCTOR NAME" }
		));

		// Increase data font
		table.setFont(new Font("Segoe UI", Font.PLAIN, 16));

		// Increase row height
		table.setRowHeight(30);

		// Increase header font
		table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));

		// Optional: Increase header height
		table.getTableHeader().setPreferredSize(new java.awt.Dimension(100, 35));

		TABEL1.setViewportView(table);
		
		JLabel lblNewLabel_1 = new JLabel("View Patient");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 23));
		lblNewLabel_1.setBounds(388, 53, 139, 34);
		panel.add(lblNewLabel_1);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MAIN main = new MAIN();
				main.setVisible(true);
				dispose();
			}
		});
		btnBack.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnBack.setBounds(10, 10, 88, 34);
		panel.add(btnBack);

	}

}
