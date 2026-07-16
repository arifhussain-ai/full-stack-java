package Java.PROJECT_FROM_SWING_JDBC.HOSPITAL_MANAGEMENT_SYSTEM;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class CHECK_APPOINTMENT extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField pid;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CHECK_APPOINTMENT frame = new CHECK_APPOINTMENT();
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
	public CHECK_APPOINTMENT() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 668, 469);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLUE);
		panel.setBounds(0, 0, 654, 442);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblSearchAppointmet = new JLabel("CHECK APPOINTMET");
		lblSearchAppointmet.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearchAppointmet.setForeground(Color.WHITE);
		lblSearchAppointmet.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 26));
		lblSearchAppointmet.setBounds(191, 34, 275, 41);
		panel.add(lblSearchAppointmet);
		
		JLabel lblNewLabel_1 = new JLabel("PATIENT ID");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_1.setBounds(143, 105, 113, 34);
		panel.add(lblNewLabel_1);
		
		pid = new JTextField();
		pid.setFont(new Font("Segoe UI", Font.BOLD, 18));
		pid.setColumns(10);
		pid.setBounds(258, 99, 247, 41);
		panel.add(pid);
		
		JButton btnNewButton = new JButton("CHECK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String patientid = pid.getText();
				if (patientid.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Enter Id");
				}
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				model.setRowCount(0);
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hospital","root","Root@123");
					String query = "SELECT * FROM appointment WHERE pid =?";
					PreparedStatement pstm = con.prepareStatement(query);
					pstm.setInt(1, Integer.parseInt(patientid));
					ResultSet rs = pstm.executeQuery();
					while (rs.next()) {
						int patientId = rs.getInt("pid");
						String PatientId = Integer.toString(patientId);
						int doctorid = rs.getInt("did");
						String doctorID = Integer.toString(doctorid);
						String Date = rs.getString("Date");
						String row[] = {PatientId,doctorID,Date};
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
		btnNewButton.setBounds(258, 150, 103, 34);
		panel.add(btnNewButton);
		
		JScrollPane TABEL1 = new JScrollPane();
		TABEL1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		TABEL1.setBounds(33, 194, 581, 209);
		panel.add(TABEL1);

		table = new JTable();
		table.setModel(new DefaultTableModel(
		    new Object[][] {},
		    new String[] { "PATIENT ID", "DOCTOR ID", "DATE" }
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
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MAIN main = new MAIN();
				main.setVisible(true);
				dispose();
			}
		});
		btnBack.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnBack.setBounds(10, 10, 85, 34);
		panel.add(btnBack);
	}

}
