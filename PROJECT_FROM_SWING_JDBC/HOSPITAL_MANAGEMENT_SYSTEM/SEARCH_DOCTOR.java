package Java.PROJECT_FROM_SWING_JDBC.HOSPITAL_MANAGEMENT_SYSTEM;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
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

public class SEARCH_DOCTOR extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField did;
	private JTable table;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SEARCH_DOCTOR frame = new SEARCH_DOCTOR();
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
	public SEARCH_DOCTOR() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 628, 412);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLUE);
		panel.setBounds(0, 0, 624, 375);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblSearchDoctor = new JLabel("SEARCH DOCTOR");
		lblSearchDoctor.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearchDoctor.setForeground(Color.WHITE);
		lblSearchDoctor.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 26));
		lblSearchDoctor.setBounds(176, 10, 247, 41);
		panel.add(lblSearchDoctor);
		
		JLabel lblNewLabel_1 = new JLabel("DOCTOR ID");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_1.setBounds(114, 71, 113, 34);
		panel.add(lblNewLabel_1);
		
		did = new JTextField();
		did.setFont(new Font("Segoe UI", Font.BOLD, 18));
		did.setColumns(10);
		did.setBounds(229, 65, 297, 41);
		panel.add(did);
		
		JButton btnNewButton = new JButton("SEARCH");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String doctorID = did.getText();
				if (doctorID.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Enter Id");
					return;
				}
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				model.setRowCount(0);
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hospital","root","Root@123");
					String query = "SELECT * FROM doctor WHERE id = ?";
					PreparedStatement pstm = con.prepareStatement(query);
					pstm.setString(1, doctorID);
					ResultSet rs = pstm.executeQuery();
					boolean hashResult = false;
					while (rs.next()) {
						hashResult = true;
						int did = rs.getInt("id");
						String doctorId = Integer.toString(did);
						String doctorName = rs.getString("Name");
						String department = rs.getString("department");
						String row[] = {doctorId,doctorName,department};
						model.addRow(row);
					}
					if (!hashResult) {
						JOptionPane.showMessageDialog(null, "Invaild Id");
					}
					pstm.close();
					rs.close();
					con.close();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
			}
		});
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnNewButton.setBounds(229, 116, 103, 34);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("LOAD");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				model.setRowCount(0);
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hospital","root","Root@123");
					String query = "SELECT * FROM doctor";
					PreparedStatement pstm = con.prepareStatement(query);
					ResultSet rs = pstm.executeQuery();
					while(rs.next()) {
						int did = rs.getInt("id");
						String doctorId = Integer.toString(did);
						String doctorName = rs.getString("Name");
						String department = rs.getString("department");
						String row[] = {doctorId,doctorName,department};
						model.addRow(row);
					}
					pstm.close();
					rs.close();
					con.close();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
			}
		});
		btnNewButton_1.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnNewButton_1.setBounds(389, 116, 103, 34);
		panel.add(btnNewButton_1);
		
		JScrollPane table1 = new JScrollPane();
		table1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		table1.setBounds(37, 172, 534, 199);
		panel.add(table1);

		table = new JTable();
		table.setModel(new DefaultTableModel(
		    new Object[][] {},
		    new String[] { "ID", "NAME", "DEPARTMENT"}
		));

		// Increase data font
		table.setFont(new Font("Segoe UI", Font.PLAIN, 16));

		// Increase row height
		table.setRowHeight(30);

		// Increase header font
		table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));

		// Optional: Increase header height
		table.getTableHeader().setPreferredSize(new java.awt.Dimension(100, 35));

		table1.setViewportView(table);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MAIN main = new MAIN();
				main.setVisible(true);
				dispose();
			}
		});
		btnBack.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnBack.setBounds(10, 10, 97, 34);
		panel.add(btnBack);
		
	}
}
