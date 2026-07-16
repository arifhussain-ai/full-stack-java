package Java.PROJECT_FROM_SWING_JDBC.HOSPITAL_MANAGEMENT_SYSTEM;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Dimension;
import javax.swing.UIManager;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MAIN extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MAIN frame = new MAIN();
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
	public MAIN() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 602, 401);
		contentPane = new JPanel();
		contentPane.setSize(new Dimension(1000, 800));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLUE);
		panel.setSize(new Dimension(1000, 800));
		panel.setBounds(0, 0, 588, 364);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("HOSPITAL MANAGEMET SYSTEM");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 27));
		lblNewLabel.setBounds(76, 10, 432, 46);
		panel.add(lblNewLabel);
		
		JButton JBUTTON1 = new JButton("ADD PATIENT");
		JBUTTON1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ADD_PATIENT add_patient = new ADD_PATIENT();
				add_patient.setVisible(true);
				dispose();
			}
		});
		JBUTTON1.setFont(new Font("Segoe UI", Font.BOLD, 12));
		JBUTTON1.setBounds(62, 80, 145, 39);
		panel.add(JBUTTON1);
		
		JButton btnCheckPatient = new JButton("SEARCH PATIENT");
		btnCheckPatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SEARCH_PATIENT search_patient= new SEARCH_PATIENT();
				search_patient.setVisible(true);
				dispose();
			}
		});
		btnCheckPatient.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnCheckPatient.setBounds(62, 144, 145, 39);
		panel.add(btnCheckPatient);
		
		JButton btnSearchDoctor = new JButton("SEARCH DOCTOR");
		btnSearchDoctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SEARCH_DOCTOR search_doctor= new SEARCH_DOCTOR();
				search_doctor.setVisible(true);
				dispose();
			}
		});
		btnSearchDoctor.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnSearchDoctor.setBounds(363, 80, 171, 39);
		panel.add(btnSearchDoctor);
		
		JButton btnViewDoctor = new JButton("VIEW DOCTOR");
		btnViewDoctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VIEW_DOCTOR view_doctor = new VIEW_DOCTOR();
				view_doctor.setVisible(true);
				dispose();
			}
		});
		btnViewDoctor.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnViewDoctor.setBounds(363, 144, 171, 39);
		panel.add(btnViewDoctor);
		
		JButton btnDeletePatient = new JButton("DELETE PATIENT");
		btnDeletePatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DELETE_PATIENT delete_patient = new DELETE_PATIENT();
				delete_patient.setVisible(true);
				dispose();
			}
		});
		btnDeletePatient.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnDeletePatient.setBounds(62, 272, 145, 39);
		panel.add(btnDeletePatient);
		
		JButton btnGetApp = new JButton("GET APPOINTMENT");
		btnGetApp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GET_APPOINTMENT get_appointment = new GET_APPOINTMENT();
				get_appointment.setVisible(true);
				dispose();
			}
		});
		btnGetApp.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnGetApp.setBounds(364, 213, 170, 39);
		panel.add(btnGetApp);
		
		JButton btnViewPatient = new JButton("VIEW PATIENT");
		btnViewPatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VIEW_PATIENT view_patient = new VIEW_PATIENT();
				view_patient.setVisible(true);
				dispose();
			}
		});
		btnViewPatient.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnViewPatient.setBounds(62, 213, 145, 39);
		panel.add(btnViewPatient);
		
		JButton btnCheckAppointment = new JButton("CHECK APPOINTMENT");
		btnCheckAppointment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CHECK_APPOINTMENT check_appointment = new CHECK_APPOINTMENT();
				check_appointment.setVisible(true);
				dispose();
			}
		});
		btnCheckAppointment.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnCheckAppointment.setBounds(363, 272, 171, 39);
		panel.add(btnCheckAppointment);

	}
}
