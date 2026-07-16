package Java.PROJECT_FROM_SWING_JDBC.COLLAGE_MANAGEMET_SYSTEM;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LOGIN_FORM extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField username;
	private JTextField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LOGIN_FORM frame = new LOGIN_FORM();
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
	public LOGIN_FORM() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setSize(new Dimension(600, 400));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel Jpanel1 = new JPanel();
		Jpanel1.setBackground(new Color(192, 192, 192));
		Jpanel1.setSize(new Dimension(600, 400));
		Jpanel1.setBounds(0, 0, 436, 273);
		contentPane.add(Jpanel1);
		Jpanel1.setLayout(null);
		
		JLabel JLABEL1 = new JLabel("ADMIN LOGIN");
		JLABEL1.setForeground(Color.BLACK);
		JLABEL1.setHorizontalAlignment(SwingConstants.CENTER);
		JLABEL1.setFont(new Font("Segoe UI", Font.BOLD, 28));
		JLABEL1.setBounds(114, 59, 210, 28);
		Jpanel1.add(JLABEL1);
		
		JLabel JLABEL2 = new JLabel("USER NAME");
		JLABEL2.setForeground(Color.BLACK);
		JLABEL2.setFont(new Font("Segoe UI", Font.BOLD, 16));
		JLABEL2.setBounds(53, 114, 99, 28);
		Jpanel1.add(JLABEL2);
		
		JLabel JLABEL3 = new JLabel("PASSWORD");
		JLABEL3.setForeground(Color.BLACK);
		JLABEL3.setFont(new Font("Segoe UI", Font.BOLD, 16));
		JLABEL3.setBounds(53, 144, 99, 28);
		Jpanel1.add(JLABEL3);
		
		username = new JTextField();
		username.setBounds(150, 118, 171, 28);
		Jpanel1.add(username);
		username.setColumns(10);
		
		password = new JTextField();
		password.setColumns(10);
		password.setBounds(150, 148, 171, 28);
		Jpanel1.add(password);
		
		JButton JBUTTON1 = new JButton("LOGIN");
		JBUTTON1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String UserName = "Arif";
				String Password = "@arif123";
				String userInput = username.getText();
				String passwordInput = password.getText();
				
				if(userInput.equals(UserName) && passwordInput.equals(Password)) {
					ADMIN_FROM admin = new ADMIN_FROM();
					admin.show();
					dispose();
				}else {
					JOptionPane.showMessageDialog(null, "INCORRECT USERNAME OR PASSWORD");
				}
			}
		});
		JBUTTON1.setFont(new Font("Segoe UI", Font.BOLD, 20));
		JBUTTON1.setBounds(172, 186, 106, 28);
		Jpanel1.add(JBUTTON1);

	}
}
