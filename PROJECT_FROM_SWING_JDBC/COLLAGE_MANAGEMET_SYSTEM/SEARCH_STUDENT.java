package Java.PROJECT_FROM_SWING_JDBC.COLLAGE_MANAGEMET_SYSTEM;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
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

public class SEARCH_STUDENT extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField1;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SEARCH_STUDENT frame = new SEARCH_STUDENT();
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
	public SEARCH_STUDENT() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setSize(new Dimension(600, 400));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel1 = new JPanel();
		panel1.setBackground(Color.GRAY);
		panel1.setSize(new Dimension(600, 400));
		panel1.setBounds(0, 0, 436, 273);
		contentPane.add(panel1);
		panel1.setLayout(null);
		
		JLabel LABEL1 = new JLabel("SEARCH STUDENT");
		LABEL1.setForeground(Color.BLACK);
		LABEL1.setFont(new Font("Segoe UI", Font.BOLD, 24));
		LABEL1.setBounds(100, 0, 215, 40);
		panel1.add(LABEL1);
		
		JLabel LABEL2 = new JLabel("ROLL NO");
		LABEL2.setForeground(Color.BLACK);
		LABEL2.setFont(new Font("Segoe UI", Font.BOLD, 17));
		LABEL2.setBounds(79, 35, 84, 32);
		panel1.add(LABEL2);
		
		textField1 = new JTextField();
		textField1.setColumns(10);
		textField1.setBounds(164, 39, 215, 32);
		panel1.add(textField1);
		
		JButton button1 = new JButton("SEARCH");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String studentRollNumer = textField1.getText();
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				if(studentRollNumer.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please Enter Roll No");
					 return;
				}
				try {
					model.setRowCount(0);
					//load driver
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					//create connection
					Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/collage4","root","Root@123");
					String query = "SELECT * FROM student WHERE RollNumber = ?";
					PreparedStatement pstm = con.prepareStatement(query);
					pstm.setString(1, studentRollNumer);
					ResultSet rs = pstm.executeQuery();
					
					boolean hasResult =false;
					while(rs.next()) {
						hasResult =true;
						int sRollNumber = rs.getInt("RollNumber");
						String studentRollNumber = Integer.toString(sRollNumber);
						String studentName = rs.getString("Name");
						String studentClass = rs.getString("Class");
						
						String row[] = {studentRollNumber,studentName,studentClass};
						model.addRow(row);
						
					}
					if(!hasResult) {
						JOptionPane.showMessageDialog(null, "Not Found");
					}
					con.close();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
				
			}
		});
		button1.setForeground(Color.BLACK);
		button1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		button1.setBounds(164, 77, 108, 32);
		panel1.add(button1);
		
		JButton BUTTON2 = new JButton("LOAD");
		BUTTON2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//load driver
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					//create connection
					Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/collage4","root","Root@123");
					
					//create query
					String query = "SELECT * FROM student";
					PreparedStatement pstm = con.prepareStatement(query);
					
					//execute query
					ResultSet rs = pstm.executeQuery();
					
					DefaultTableModel model = (DefaultTableModel)table.getModel();
					while(rs.next()) {
						int sRollNumber = rs.getInt("RollNumber");
						String studentRollNumber = Integer.toString(sRollNumber);
						String studentName = rs.getString("Name");
						String studentClass = rs.getString("Class");
						String row[] = {studentRollNumber,studentName,studentClass};
						model.addRow(row);
					}
							
					//close connection
					con.close();
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
			}
		});
		BUTTON2.setForeground(Color.BLACK);
		BUTTON2.setFont(new Font("Segoe UI", Font.BOLD, 14));
		BUTTON2.setBounds(288, 77, 108, 32);
		panel1.add(BUTTON2);
		
		JScrollPane TABEL = new JScrollPane();
		TABEL.setFont(new Font("Segoe UI", Font.BOLD, 14));
		TABEL.setBounds(34, 119, 362, 134);
		panel1.add(TABEL);

		table = new JTable();
		table.setModel(new DefaultTableModel(
		    new Object[][] {},
		    new String[] { "ROLL NO", "NAME", "CLASS" }
		));

		TABEL.setViewportView(table);
	}
}
