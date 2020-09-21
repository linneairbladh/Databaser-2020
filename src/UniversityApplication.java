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
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import javax.swing.SpinnerNumberModel;
import javax.swing.JList;
import javax.swing.JTextPane;

public class UniversityApplication {

	private JFrame frame;
	private Controller controller;
	private JTextField textField_StudentSSN2;
	private JTextField textField_courseCode2;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_courseCode;
	private JTextField textField_courseName;
	private JTextField textField_StudentSSN;
	private JTextField textField_StudentName;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_4;

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
		frame.setBounds(100, 100, 450, 371);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 434, 306);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel_Overview = new JPanel();
		tabbedPane.addTab("Overview", null, panel_Overview, null);
		
		JButton btnFindStudent = new JButton("Find Student");
		btnFindStudent.setBounds(257, 46, 113, 23);
		btnFindStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_Overview.setLayout(null);
		panel_Overview.add(btnFindStudent);
		
		JButton btnFindCourse = new JButton("Find Course");
		btnFindCourse.setBounds(257, 180, 119, 23);
		panel_Overview.add(btnFindCourse);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(111, 71, 96, 20);
		panel_Overview.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(111, 26, 96, 20);
		panel_Overview.add(textField_1);
		
		JLabel label = new JLabel("Student SSN *");
		label.setBounds(22, 29, 82, 14);
		panel_Overview.add(label);
		
		JLabel label_1 = new JLabel("Student name *");
		label_1.setBounds(22, 74, 89, 14);
		panel_Overview.add(label_1);
		
		JLabel label_2 = new JLabel("Course code *");
		label_2.setBounds(22, 184, 78, 14);
		panel_Overview.add(label_2);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(110, 181, 62, 20);
		panel_Overview.add(textField_4);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(83, 209, 222, 58);
		panel_Overview.add(textPane);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(83, 106, 216, 41);
		panel_Overview.add(textPane_1);
		
		JPanel panel_Add = new JPanel();
		tabbedPane.addTab("Add", null, panel_Add, null);
		panel_Add.setLayout(null);
		
		JButton button_AddCourse = new JButton("Add Course");
		button_AddCourse.setBounds(273, 63, 89, 23);
		panel_Add.add(button_AddCourse);
		
		JButton button_AddStudent = new JButton("Add Student");
		button_AddStudent.setBounds(269, 202, 93, 23);
		panel_Add.add(button_AddStudent);
		
		JLabel lblNewLabel_CourseCode = new JLabel("Course code *");
		lblNewLabel_CourseCode.setBounds(10, 39, 78, 14);
		panel_Add.add(lblNewLabel_CourseCode);
		
		JLabel lblNewLabel_CourseName = new JLabel("Course name *");
		lblNewLabel_CourseName.setBounds(10, 67, 78, 14);
		panel_Add.add(lblNewLabel_CourseName);
		
		textField_courseCode = new JTextField();
		textField_courseCode.setBounds(98, 36, 62, 20);
		panel_Add.add(textField_courseCode);
		textField_courseCode.setColumns(10);
		
		textField_courseName = new JTextField();
		textField_courseName.setBounds(98, 64, 96, 20);
		panel_Add.add(textField_courseName);
		textField_courseName.setColumns(10);
		
		JSpinner credit_spinner = new JSpinner();
		credit_spinner.setModel(new SpinnerNumberModel(0, 0, 45, 0));
		credit_spinner.setBounds(98, 95, 47, 20);
		panel_Add.add(credit_spinner);
		
		JLabel lblNewLabel_StudentSSN = new JLabel("Student SSN *");
		lblNewLabel_StudentSSN.setBounds(10, 176, 82, 14);
		panel_Add.add(lblNewLabel_StudentSSN);
		
		JLabel lblNewLabel_StudentName = new JLabel("Student name *");
		lblNewLabel_StudentName.setBounds(10, 221, 89, 14);
		panel_Add.add(lblNewLabel_StudentName);
		
		textField_StudentSSN = new JTextField();
		textField_StudentSSN.setBounds(99, 173, 96, 20);
		panel_Add.add(textField_StudentSSN);
		textField_StudentSSN.setColumns(10);
		
		textField_StudentName = new JTextField();
		textField_StudentName.setBounds(99, 218, 96, 20);
		panel_Add.add(textField_StudentName);
		textField_StudentName.setColumns(10);
		
		JLabel lblCourseCredits = new JLabel("Course credits *");
		lblCourseCredits.setBounds(10, 95, 93, 14);
		panel_Add.add(lblCourseCredits);
		
		JPanel panel_Register = new JPanel();
		tabbedPane.addTab("Register", null, panel_Register, null);
		panel_Register.setLayout(null);
		
		JButton BtnRegisterNewStudent = new JButton("Register new student on course");
		BtnRegisterNewStudent.setBounds(112, 82, 187, 23);
		panel_Register.add(BtnRegisterNewStudent);
		
		JComboBox comboBoxGrade = new JComboBox();
		comboBoxGrade.addItem("A");
		comboBoxGrade.addItem("B");
		comboBoxGrade.addItem("C");
		comboBoxGrade.addItem("D");
		comboBoxGrade.addItem("E");
		comboBoxGrade.addItem("F");
		

		comboBoxGrade.setBounds(320, 200, 43, 22);
		panel_Register.add(comboBoxGrade);
		
		JButton btnRegisterStudent = new JButton("Register student on finished course");
		btnRegisterStudent.setBounds(106, 232, 205, 23);
		panel_Register.add(btnRegisterStudent);
		
		textField_StudentSSN2 = new JTextField();
		textField_StudentSSN2.setBounds(93, 201, 49, 20);
		panel_Register.add(textField_StudentSSN2);
		textField_StudentSSN2.setColumns(10);
		
		JLabel lblStudentSSN2 = new JLabel("Student SSN");
		lblStudentSSN2.setBounds(25, 204, 61, 14);
		panel_Register.add(lblStudentSSN2);
		
		JLabel lblGrade = new JLabel("Grade");
		lblGrade.setBounds(287, 204, 43, 14);
		panel_Register.add(lblGrade);
		
		JLabel lblCourseCode = new JLabel("Course code");
		lblCourseCode.setBounds(152, 204, 68, 14);
		panel_Register.add(lblCourseCode);
		
		textField_courseCode2 = new JTextField();
		textField_courseCode2.setBounds(228, 201, 49, 20);
		panel_Register.add(textField_courseCode2);
		textField_courseCode2.setColumns(10);
		
		JLabel label_StudentSSN = new JLabel("Student SSN");
		label_StudentSSN.setBounds(79, 50, 61, 14);
		panel_Register.add(label_StudentSSN);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(147, 47, 49, 20);
		panel_Register.add(textField_2);
		
		JLabel label_CourseCode2 = new JLabel("Course code");
		label_CourseCode2.setBounds(206, 50, 68, 14);
		panel_Register.add(label_CourseCode2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(269, 47, 49, 20);
		panel_Register.add(textField_3);
		
		JPanel panel_Assignment2 = new JPanel();
		tabbedPane.addTab("Assignment 2", null, panel_Assignment2, null);
	}
}
