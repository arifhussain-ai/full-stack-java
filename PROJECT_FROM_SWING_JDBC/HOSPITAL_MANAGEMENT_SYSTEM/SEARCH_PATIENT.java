package Java.PROJECT_FROM_SWING_JDBC.HOSPITAL_MANAGEMENT_SYSTEM;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class SEARCH_PATIENT extends JFrame {

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
					SEARCH_PATIENT frame = new SEARCH_PATIENT();
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
	public SEARCH_PATIENT() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 622, 418);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLUE);
		panel.setBounds(0, 0, 608, 381);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblSearchPatient = new JLabel("SEARCH PATIENT");
		lblSearchPatient.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearchPatient.setForeground(Color.WHITE);
		lblSearchPatient.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 26));
		lblSearchPatient.setBounds(177, 10, 247, 41);
		panel.add(lblSearchPatient);
		
		JLabel lblNewLabel_1 = new JLabel("PATIENT ID");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_1.setBounds(115, 71, 113, 34);
		panel.add(lblNewLabel_1);
		
		pid = new JTextField();
		pid.setFont(new Font("Segoe UI", Font.BOLD, 18));
		pid.setColumns(10);
		pid.setBounds(230, 65, 247, 41);
		panel.add(pid);
		
		JButton btnLoad = new JButton("LOAD");
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				model.setRowCount(0);
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hospital","root","Root@123");
					String query = "SELECT * FROM patient";
					PreparedStatement pstm = con.prepareStatement(query);
					ResultSet rs = pstm.executeQuery();
					while(rs.next()) {
						int pid = rs.getInt("id");
						String pateintID = Integer.toString(pid);
						String patientName = rs.getString("Name");
						int pAge = rs.getInt("Age");
						String patientAge = Integer.toString(pAge);
						String doctorName = rs.getString("doctorName");
						String row[] = {pateintID,patientName,patientAge,doctorName};
						model.addRow(row);
					}
					pstm.close();
					rs.close();
					con.close();
				}catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
			}
		});
		btnLoad.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnLoad.setBounds(369, 116, 103, 34);
		panel.add(btnLoad);
		
		JButton btnNewButton = new JButton("SEARCH");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String patientId = pid.getText();
				if(patientId.isEmpty()) {
					JOptionPane.showMessageDialog(null,"Enter Pateint Id");
					 return;
				}
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				model.setRowCount(0);
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hospital","root","Root@123");
					String query = "SELECT * FROM patient WHERE id = ?";
					PreparedStatement pstm = con.prepareStatement(query);
					pstm.setString(1, patientId);
					ResultSet rs = pstm.executeQuery();
					
					boolean hasResult =false;
					while(rs.next()) {
						hasResult = true;
						int pid = rs.getInt("id");
						String patientid = Integer.toString(pid);
						String patientName = rs.getString("Name");
						int pAge = rs.getInt("Age");
						String patientAge = Integer.toString(pAge);
						String doctorName = rs.getString("doctorName");
						String row[] = {patientid,patientName,patientAge,doctorName};
						model.addRow(row);
					}
					if(!hasResult) {
						JOptionPane.showMessageDialog(null, "Invalid Patient Id");
					}
					rs.close();
					pstm.close();
					con.close();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
			}
		});
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnNewButton.setBounds(230, 116, 103, 34);
		panel.add(btnNewButton);
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MAIN main = new MAIN();
				main.setVisible(true);
				dispose();
			}
		});
		btnBack.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnBack.setBounds(10, 10, 90, 34);
		panel.add(btnBack);
		
		JScrollPane TABEL = new JScrollPane();
		TABEL.setFont(new Font("Segoe UI", Font.BOLD, 14));
		TABEL.setBounds(54, 172, 504, 199);
		panel.add(TABEL);

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

		TABEL.setViewportView(table);
		
		
	}
}
