import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.CardLayout;

public class UniversityApplication {

	private JFrame frame;
	private Controller controller;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UniversityApplication window = new UniversityApplication();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UniversityApplication() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Overview", null, panel_1, null);
		
		JButton btnShowAllCourses = new JButton("Show all courses");
		panel_1.add(btnShowAllCourses);
		
		JButton btnShowAllStudents = new JButton("Show all students");
		panel_1.add(btnShowAllStudents);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Register", null, panel, null);
		
		JButton btnAddCourse = new JButton("Add Course");
		panel.add(btnAddCourse);
		
		
		
		JButton btnAddStudent = new JButton("Add Student");
		btnAddStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
		});
		panel.add(btnAddStudent);
		
		JButton btnRegisterStudentOn = new JButton("Register new student on course");
		panel.add(btnRegisterStudentOn);
		
		JButton btnRemoveStudent = new JButton("Remove student");
		panel.add(btnRemoveStudent);
		
		JButton btnNewButton = new JButton("Register student on finished course");
		panel.add(btnNewButton);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Assignment 2", null, panel_2, null);
	}
}
