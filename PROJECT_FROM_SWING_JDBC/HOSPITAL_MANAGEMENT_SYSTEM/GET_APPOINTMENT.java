package Java.PROJECT_FROM_SWING_JDBC.HOSPITAL_MANAGEMENT_SYSTEM;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class GET_APPOINTMENT extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField pid;
	private JTextField did;
	private JTextField date;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GET_APPOINTMENT frame = new GET_APPOINTMENT();
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
	public GET_APPOINTMENT() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 663, 436);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLUE);
		panel.setBounds(0, 0, 649, 409);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("PATIENT ID");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblNewLabel_1.setBounds(179, 85, 103, 34);
		panel.add(lblNewLabel_1);
		
		pid = new JTextField();
		pid.setColumns(10);
		pid.setBounds(281, 91, 247, 29);
		panel.add(pid);
		
		did = new JTextField();
		did.setColumns(10);
		did.setBounds(281, 129, 247, 29);
		panel.add(did);
		
		JLabel lblNewLabel_1_1 = new JLabel("DOCTOR ID");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblNewLabel_1_1.setBounds(179, 124, 103, 34);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("DATE");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblNewLabel_1_1_1.setBounds(221, 164, 61, 34);
		panel.add(lblNewLabel_1_1_1);
		
		date = new JTextField();
		date.setColumns(10);
		date.setBounds(281, 170, 247, 29);
		panel.add(date);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String patientid = pid.getText();
				int patientID = Integer.parseInt(patientid);
				String doctorid = did.getText();
				int doctorID = Integer.parseInt(doctorid);
				String Date = date.getText();
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hospital","root","Root@123");
					String query = "INSERT INTO appointment VALUES(?,?,?)";
					PreparedStatement pstm = con.prepareStatement(query);
					pstm.setInt(1, patientID);
					pstm.setInt(2, doctorID);
					pstm.setString(3, Date);
					pstm.executeUpdate();
					JOptionPane.showMessageDialog(null, "Data Inserted");
					pstm.close();
					con.close();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
			}
		});
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnNewButton.setBounds(295, 222, 90, 34);
		panel.add(btnNewButton);
		
		JLabel lblGetAppointment = new JLabel("GET APPOINTMENT");
		lblGetAppointment.setHorizontalAlignment(SwingConstants.CENTER);
		lblGetAppointment.setForeground(Color.WHITE);
		lblGetAppointment.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 26));
		lblGetAppointment.setBounds(199, 10, 247, 41);
		panel.add(lblGetAppointment);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MAIN main = new MAIN();
				main.setVisible(true);
				dispose();
			}
		});
		btnBack.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnBack.setBounds(25, 347, 90, 34);
		panel.add(btnBack);

	}

}
