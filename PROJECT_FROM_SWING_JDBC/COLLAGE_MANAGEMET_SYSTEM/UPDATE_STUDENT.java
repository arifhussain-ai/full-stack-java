package Java.PROJECT_FROM_SWING_JDBC.COLLAGE_MANAGEMET_SYSTEM;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class UPDATE_STUDENT extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField srollnumber;
	private JTextField sclass;
	private JTextField sname;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UPDATE_STUDENT frame = new UPDATE_STUDENT();
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
	public UPDATE_STUDENT() {
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
		panel1.setBounds(0, 0, 436, 263);
		contentPane.add(panel1);
		panel1.setLayout(null);
		
		JLabel LABEL1 = new JLabel("UPDATE STUDENT");
		LABEL1.setForeground(Color.BLACK);
		LABEL1.setFont(new Font("Segoe UI", Font.BOLD, 24));
		LABEL1.setBounds(96, 0, 215, 40);
		panel1.add(LABEL1);
		
		JScrollPane TABEL1 = new JScrollPane();
		TABEL1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		TABEL1.setBounds(36, 168, 362, 101);
		panel1.add(TABEL1);

		table = new JTable();
		table.setModel(new DefaultTableModel(
		    new Object[][] {},
		    new String[] { "ROLL NO", "NAME", "CLASS" }
		));

		TABEL1.setViewportView(table);
		
		JLabel LABEL2 = new JLabel("STUDENT");
		LABEL2.setForeground(Color.BLACK);
		LABEL2.setFont(new Font("Segoe UI", Font.BOLD, 17));
		LABEL2.setBounds(47, 29, 83, 32);
		panel1.add(LABEL2);
		
		JLabel LABEL3 = new JLabel("CLASS");
		LABEL3.setForeground(Color.BLACK);
		LABEL3.setFont(new Font("Segoe UI", Font.BOLD, 17));
		LABEL3.setBounds(62, 71, 67, 32);
		panel1.add(LABEL3);
		
		JLabel LABEL4 = new JLabel("ROLL NO");
		LABEL4.setForeground(Color.BLACK);
		LABEL4.setFont(new Font("Segoe UI", Font.BOLD, 17));
		LABEL4.setBounds(47, 109, 88, 32);
		panel1.add(LABEL4);
		
		
		srollnumber = new JTextField();
		srollnumber.setColumns(10);
		srollnumber.setBounds(127, 109, 184, 32);
		panel1.add(srollnumber);
		
		sclass = new JTextField();
		sclass.setColumns(10);
		sclass.setBounds(139, 71, 168, 32);
		panel1.add(sclass);
		
		sname = new JTextField();
		sname.setColumns(10);
		sname.setBounds(139, 33, 168, 32);
		panel1.add(sname);
		
		JButton btnNewButton = new JButton("LOAD");
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
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
		btnNewButton.setBounds(317, 72, 109, 32);
		panel1.add(btnNewButton);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String srollNumber = srollnumber.getText();
				String studentName = sname.getText();
				String studentClass = sclass.getText();
				int studentRollNumber = Integer.parseInt(srollNumber);
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/collage4","root","Root@123");
					String query = "UPDATE student SET Name = ?, Class = ? WHERE RollNumber = ?";
					PreparedStatement pstm = con.prepareStatement(query);
					pstm.setString(1, studentName);
					pstm.setString(2, studentClass);
					pstm.setInt(3, studentRollNumber);
					int row = pstm.executeUpdate();
					if(row > 0) {
						JOptionPane.showMessageDialog(null, "Student Updated Scuessfully");
//						DefaultTableModel model = (DefaultTableModel)table.getModel();
//						model.setRowCount(0);
//						PreparedStatement ps = con.prepareStatement("SELECT * FROM student");
//						 ResultSet rs = ps.executeQuery();
//						 while(rs.next()) {
//							 model.addRow(new Object[] {
//								rs.getInt("RollNumber"),
//								rs.getString("Name"),
//								rs.getString("Class")
							 
						 
					}else {
						JOptionPane.showMessageDialog(null, "Roll Number Not Found");
					}
					con.close();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
				
			}
	});
		btnUpdate.setForeground(Color.BLACK);
		btnUpdate.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnUpdate.setBounds(321, 30, 108, 32);
		panel1.add(btnUpdate);
		
	}
}
