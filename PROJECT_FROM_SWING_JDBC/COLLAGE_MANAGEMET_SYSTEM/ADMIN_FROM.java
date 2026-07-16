package Java.PROJECT_FROM_SWING_JDBC.COLLAGE_MANAGEMET_SYSTEM;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class ADMIN_FROM extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ADMIN_FROM frame = new ADMIN_FROM();
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
	public ADMIN_FROM() {
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
		
		JButton BUTTON1 = new JButton("ADD");
		BUTTON1.setForeground(Color.BLACK);
		BUTTON1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ADD_STUDENT add = new ADD_STUDENT();
		        add.setVisible(true);
		        dispose();
			}
		});
		BUTTON1.setFont(new Font("Segoe UI", Font.BOLD, 18));
		BUTTON1.setBounds(59, 71, 96, 41);
		panel.add(BUTTON1);
		
		JButton BUTTON2 = new JButton("DELETE");
		BUTTON2.setForeground(Color.BLACK);
		BUTTON2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 DELETE_FROM delete = new DELETE_FROM();
			        delete.setVisible(true);
			        dispose();
			}
		});
		BUTTON2.setFont(new Font("Segoe UI", Font.BOLD, 18));
		BUTTON2.setBounds(263, 71, 96, 41);
		panel.add(BUTTON2);
		
		JButton BUTTON3 = new JButton("SEARCH");
		BUTTON3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 STUDENT_SEARCH search = new STUDENT_SEARCH();
			        search.setVisible(true);
			        dispose();
			}
		});
		BUTTON3.setForeground(Color.BLACK);
		BUTTON3.setFont(new Font("Segoe UI", Font.BOLD, 16));
		BUTTON3.setBounds(59, 160, 96, 41);
		panel.add(BUTTON3);
		
		JButton BUTTON4 = new JButton("UPDATE");
		BUTTON4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UPDATE_STUDENT update = new UPDATE_STUDENT();
		        update.setVisible(true);
		        dispose();
			}
		});
		BUTTON4.setForeground(Color.BLACK);
		BUTTON4.setFont(new Font("Segoe UI", Font.BOLD, 16));
		BUTTON4.setBounds(263, 160, 96, 41);
		panel.add(BUTTON4);
		
		JLabel LABEL1 = new JLabel("WHICH OPERATION DO YOU PERFORMED");
		LABEL1.setForeground(Color.BLACK);
		LABEL1.setFont(new Font("Segoe UI", Font.BOLD, 18));
		LABEL1.setBounds(31, 10, 370, 39);
		panel.add(LABEL1);

	}

}
