package Java.PROJECT_FROM_SWING_JDBC.HOSPITAL_MANAGEMENT_SYSTEM;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class ADD_PATIENT extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField patientid;
	private JTextField patientName;
	private JTextField patientAge;
	private JTextField dName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ADD_PATIENT frame = new ADD_PATIENT();
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
	public ADD_PATIENT() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 617, 407);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLUE);
		panel.setBounds(0, 0, 603, 370);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ADD PATIENT");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 24));
		lblNewLabel.setBounds(201, 10, 184, 41);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("PATIENT ID");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblNewLabel_1.setBounds(119, 71, 103, 34);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("PATIENT NAME");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblNewLabel_1_1.setBounds(87, 110, 135, 34);
		panel.add(lblNewLabel_1_1);
		
		patientid = new JTextField();
		patientid.setFont(new Font("Segoe UI", Font.BOLD, 15));
		patientid.setBounds(221, 77, 247, 29);
		panel.add(patientid);
		patientid.setColumns(10);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("PATIENT AGE");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblNewLabel_1_1_1.setBounds(97, 150, 125, 34);
		panel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("DOCTOR NAME");
		lblNewLabel_1_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_1_2.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblNewLabel_1_1_2.setBounds(87, 189, 124, 34);
		panel.add(lblNewLabel_1_1_2);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pid = patientid.getText();
				int patientId  = Integer.parseInt(pid);
				String pname = patientName.getText();
				String page = patientAge.getText();
				int patientAge = Integer.parseInt(page);
				String dname = dName.getText();
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hospital","root","Root@123");
					String query = "INSERT INTO patient VALUES(?,?,?,?)";
					PreparedStatement pstm = con.prepareStatement(query);
					pstm.setInt(1, patientId);
					pstm.setString(2, pname);
					pstm.setString(3, page);
					pstm.setString(4, dname);
					pstm.executeUpdate();
					con.close();
					JOptionPane.showMessageDialog(null, "Patient Added Scuessfully");
				}catch(Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
			}
		});
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnNewButton.setBounds(229, 249, 90, 34);
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
		btnBack.setBounds(10, 326, 90, 34);
		panel.add(btnBack);
		
		patientName = new JTextField();
		patientName.setFont(new Font("Segoe UI", Font.BOLD, 15));
		patientName.setColumns(10);
		patientName.setBounds(221, 115, 247, 29);
		panel.add(patientName);
		
		patientAge = new JTextField();
		patientAge.setFont(new Font("Segoe UI", Font.BOLD, 15));
		patientAge.setColumns(10);
		patientAge.setBounds(221, 153, 247, 29);
		panel.add(patientAge);
		
		dName = new JTextField();
		dName.setFont(new Font("Segoe UI", Font.BOLD, 15));
		dName.setColumns(10);
		dName.setBounds(221, 194, 247, 29);
		panel.add(dName);

	}
}
