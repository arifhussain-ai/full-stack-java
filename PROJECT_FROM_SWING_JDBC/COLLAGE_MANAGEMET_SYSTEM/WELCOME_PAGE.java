package Java.PROJECT_FROM_SWING_JDBC.COLLAGE_MANAGEMET_SYSTEM;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;

public class WELCOME_PAGE extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WELCOME_PAGE frame = new WELCOME_PAGE();
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
	public WELCOME_PAGE() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setSize(new Dimension(600, 400));
		contentPane.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		panel.setBackground(new Color(192, 192, 192));
		panel.setSize(new Dimension(600, 400));
		panel.setBounds(0, 0, 436, 263);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel JLABLE1 = new JLabel("COLLAGE MANAGEMENT SYSTEM");
		JLABLE1.setBounds(26, 5, 384, 32);
		JLABLE1.setForeground(Color.BLACK);
		JLABLE1.setHorizontalAlignment(SwingConstants.CENTER);
		JLABLE1.setFont(new Font("Segoe UI", Font.BOLD, 24));
		panel.add(JLABLE1);
		
		JButton BUTTON1 = new JButton("ADMIN");
		BUTTON1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		BUTTON1.setBounds(52, 119, 110, 39);
		BUTTON1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LOGIN_FORM login = new LOGIN_FORM();
				login.show();
				dispose();
			}
		});
		BUTTON1.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		panel.add(BUTTON1);
		
		JLabel JLABLE2 = new JLabel("WELCOME");
		JLABLE2.setForeground(Color.BLACK);
		JLABLE2.setBackground(Color.BLACK);
		JLABLE2.setBounds(166, 47, 118, 32);
		JLABLE2.setHorizontalAlignment(SwingConstants.CENTER);
		JLABLE2.setFont(new Font("Segoe UI", Font.BOLD, 24));
		panel.add(JLABLE2);
		
		JButton BUTTON2 = new JButton("SEARCH");
		BUTTON2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SEARCH_STUDENT search_student = new SEARCH_STUDENT();
				search_student.show();
				dispose();
			}
		});
		BUTTON2.setFont(new Font("Segoe UI", Font.BOLD, 15));
		BUTTON2.setCursor(Cursor.getPredefinedCursor(Cursor.SW_RESIZE_CURSOR));
		BUTTON2.setBounds(250, 119, 110, 39);
		panel.add(BUTTON2);
		
		JLabel JLABEL3 = new JLabel("ARIF HUSSAIN");
		JLABEL3.setForeground(Color.BLACK);
		JLABEL3.setFont(new Font("Segoe UI", Font.BOLD, 14));
		JLABEL3.setBounds(10, 230, 100, 12);
		panel.add(JLABEL3);

	}
}
