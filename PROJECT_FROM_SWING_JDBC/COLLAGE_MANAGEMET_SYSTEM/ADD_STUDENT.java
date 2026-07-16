package Java.PROJECT_FROM_SWING_JDBC.COLLAGE_MANAGEMET_SYSTEM;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class ADD_STUDENT extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField sname;
	private JTextField sclass;
	private JTextField srollnumber;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ADD_STUDENT frame = new ADD_STUDENT();
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
	public ADD_STUDENT() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setSize(new Dimension(600, 400));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setSize(new Dimension(600, 400));
		panel.setBounds(0, 0, 436, 263);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel LABEL1 = new JLabel("ADD STUDENT");
		LABEL1.setForeground(Color.BLACK);
		LABEL1.setFont(new Font("Segoe UI", Font.BOLD, 24));
		LABEL1.setBounds(128, 10, 174, 40);
		panel.add(LABEL1);
		
		JLabel LABEL2 = new JLabel("STUDENT");
		LABEL2.setFont(new Font("Segoe UI", Font.BOLD, 17));
		LABEL2.setForeground(Color.BLACK);
		LABEL2.setBounds(73, 73, 125, 32);
		panel.add(LABEL2);
		
		sname = new JTextField();
		sname.setBounds(198, 73, 168, 32);
		panel.add(sname);
		sname.setColumns(10);
		
		sclass = new JTextField();
		sclass.setColumns(10);
		sclass.setBounds(198, 115, 168, 32);
		panel.add(sclass);
		
		JLabel LABEL3 = new JLabel("CLASS");
		LABEL3.setForeground(Color.BLACK);
		LABEL3.setFont(new Font("Segoe UI", Font.BOLD, 17));
		LABEL3.setBounds(73, 115, 125, 32);
		panel.add(LABEL3);
		
		srollnumber = new JTextField();
		srollnumber.setColumns(10);
		srollnumber.setBounds(198, 157, 168, 32);
		panel.add(srollnumber);
		
		JLabel LABEL4 = new JLabel("ROLL NO");
		LABEL4.setForeground(Color.BLACK);
		LABEL4.setFont(new Font("Segoe UI", Font.BOLD, 17));
		LABEL4.setBounds(73, 157, 125, 32);
		panel.add(LABEL4);
		
		JButton BUTTTON1 = new JButton("ADD");
		BUTTTON1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String studentName = sname.getText();
				String studentClass = sclass.getText();
				String sRollNumber = srollnumber.getText();
				int studentRollNumber = Integer.parseInt(sRollNumber);
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/collage4","root","Root@123");
					String query = "INSERT INTO student (RollNumber, Name, Class) VALUES (?, ?, ?)";

					PreparedStatement pstm = con.prepareStatement(query);
					pstm.setInt(1, studentRollNumber);
					pstm.setString(2, studentName);
					pstm.setString(3, studentClass);

					pstm.executeUpdate();

					JOptionPane.showMessageDialog(null, "Data Added Successfully");
					con.close();
				}catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
			}
		});
		BUTTTON1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		BUTTTON1.setForeground(Color.BLACK);
		BUTTTON1.setBounds(150, 207, 108, 32);
		panel.add(BUTTTON1);

	}

}
