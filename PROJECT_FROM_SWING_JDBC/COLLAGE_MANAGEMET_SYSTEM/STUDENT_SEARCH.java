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

public class STUDENT_SEARCH extends JFrame {

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
					STUDENT_SEARCH frame = new STUDENT_SEARCH();
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
	public STUDENT_SEARCH() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setSize(new Dimension(600, 400));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel1 = new JPanel();
		panel1.setBackground(Color.GRAY);
		panel1.setBounds(10, 0, 426, 263);
		contentPane.add(panel1);
		panel1.setLayout(null);
		
		JLabel LABEL1 = new JLabel("SEARCH STUDENT");
		LABEL1.setForeground(Color.BLACK);
		LABEL1.setFont(new Font("Segoe UI", Font.BOLD, 24));
		LABEL1.setBounds(101, 10, 215, 40);
		panel1.add(LABEL1);
		
		JLabel LABEL2 = new JLabel("ROLL NO");
		LABEL2.setForeground(Color.BLACK);
		LABEL2.setFont(new Font("Segoe UI", Font.BOLD, 17));
		LABEL2.setBounds(80, 45, 84, 32);
		panel1.add(LABEL2);
		
		textField1 = new JTextField();
		textField1.setColumns(10);
		textField1.setBounds(165, 49, 215, 32);
		panel1.add(textField1);
		
		JButton button1 = new JButton("SEARCH");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String studentRollNumber = textField1.getText();
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				
				if(studentRollNumber.isEmpty()) {
					JOptionPane.showMessageDialog(null, "PLEASE ENTER ROLL NO");
					return;
				}
				try {
					model.setRowCount(0);
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/collage4","root","Root@123");
					String query = "SELECT * FROM student WHERE RollNumber = ?";
					PreparedStatement pstm = con.prepareStatement(query);
					pstm.setString(1, studentRollNumber);
					ResultSet rs = pstm.executeQuery();
					boolean hasResult = false;
					while(rs.next()) {
						hasResult = true;
						int sRollNumber = rs.getInt("RollNumber");
						String studentrollNumber = Integer.toString(sRollNumber);
						String studentName = rs.getString("Name");
						String studentClass = rs.getString("Class");
						
						String row[] = {studentrollNumber,studentName,studentClass};
						model.addRow(row);
					}
					if(!hasResult) {
						JOptionPane.showMessageDialog(null, "Not Found");
					}
					con.close();
				}catch(Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
			}
		});
		button1.setForeground(Color.BLACK);
		button1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		button1.setBounds(165, 87, 108, 32);
		panel1.add(button1);
		
		JScrollPane TABEL1 = new JScrollPane();
		TABEL1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		TABEL1.setBounds(35, 129, 362, 134);
		panel1.add(TABEL1);

		table = new JTable();
		table.setModel(new DefaultTableModel(
		    new Object[][] {},
		    new String[] { "ROLL NO", "NAME", "CLASS" }
		));

		TABEL1.setViewportView(table);
		
	}
}
