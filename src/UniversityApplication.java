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
import javax.swing.JSeparator;
import javax.swing.JTextArea;

public class UniversityApplication {

	private JFrame frame;
	private Controller controller;
	private JTextField textField_StudentSSN2;
	private JTextField textField_courseCode2;
	private JTextField textField_StudentSSN3;
	private JTextField textField_CourseCode3;
	private JTextField textField_courseCode;
	private JTextField textField_courseName;
	private JTextField textField_StudentSSN;
	private JTextField textField_StudentName;
	private JTextField textField_studentName;
	private JTextField textField_ssn;
	private JTextField textField_courseCodeFind;
	private JTextField textField_courseCredits;
	private JButton button_AddStudent;
	private JButton button_AddCourse;
	private JButton button_FindStudent;
	private JButton button_FindCourse;
	private JButton btnRegisterStudent;
	private JButton BtnRegisterNewStudent;
	private Course course;

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

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
	
	public UniversityApplication(Controller controller) {
		this.controller = controller; 
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 416);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 434, 377);
		frame.getContentPane().add(tabbedPane);
		
		//ALLT PÅ FLIK OVERVIEW
		JPanel panel_Overview = new JPanel();
		tabbedPane.addTab("Overview", null, panel_Overview, null);
		
		JTextArea textArea_Overview = new JTextArea();
		textArea_Overview.setBounds(83, 222, 233, 64);
		panel_Overview.add(textArea_Overview);
		
		textField_studentName = new JTextField();
		textField_studentName.setColumns(10);
		textField_studentName.setBounds(111, 71, 96, 20);
		panel_Overview.add(textField_studentName);
		
		textField_ssn = new JTextField();
		textField_ssn.setColumns(10);
		textField_ssn.setBounds(111, 26, 96, 20);
		panel_Overview.add(textField_ssn);
		
		JLabel label = new JLabel("Student SSN *");
		label.setBounds(22, 29, 82, 14);
		panel_Overview.add(label);
		
		JLabel label_1 = new JLabel("Student name *");
		label_1.setBounds(22, 74, 89, 14);
		panel_Overview.add(label_1);
		
		JLabel label_2 = new JLabel("Course code *");
		label_2.setBounds(22, 137, 89, 14);
		panel_Overview.add(label_2);
		
		textField_courseCodeFind = new JTextField();
		textField_courseCodeFind.setColumns(10);
		textField_courseCodeFind.setBounds(110, 134, 62, 20);
		panel_Overview.add(textField_courseCodeFind);
		
		JButton btnFindStudent = new JButton("Find Student");
		btnFindStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnFindStudent.setBounds(257, 46, 113, 23);
		panel_Overview.setLayout(null);
		panel_Overview.add(btnFindStudent);
		
		JButton btnFindCourse = new JButton("Find Course");
		btnFindCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnFindCourse.setBounds(257, 133, 119, 23);
		panel_Overview.add(btnFindCourse);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(22, 117, 349, 2);
		panel_Overview.add(separator);
		
		
		//SLUT PÅ FLIK OVERVIEW
		
		//ALLT PÅ FLIK ADD
		JPanel panel_Add = new JPanel();
		tabbedPane.addTab("Add", null, panel_Add, null);
		panel_Add.setLayout(null);
		
		JTextArea textArea_Add = new JTextArea();
		textArea_Add.setBounds(67, 263, 236, 54);
		panel_Add.add(textArea_Add);
		
		JButton button_AddCourse = new JButton("Add Course");
		button_AddCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String courseName = textField_courseName.getText();
				String courseCode = textField_courseCode.getText();
				String creditString = textField_courseCredits.getText();
				int credit = Integer.parseInt(creditString);
				
				if (textField_courseCode.getText().isEmpty()) {
					textArea_Add.setText("Fyll i kurskod.");
				} else {
					try {

						if (controller.getCourse(courseCode) != null) {
							textArea_Add.setText("Kursen ﬁnns redan");
						} else {
							boolean success = controller.addallcourses(courseCode, courseName, credit);
							if (success) {
								textArea_Add.setText(courseCode + " har lagts till.");
								textField_courseName.setText("");
								textField_courseCode.setText("");
								textField_courseCredits.setText("");
							} else {
								textArea_Add.setText("Kurs med denna kurskod ﬁnns redan");
							}
						}
					} catch (SQLException e1) {
						textArea_Add.setText("Se till att du satt r‰tt v‰rde pÂ kurspo‰ng");
					} catch (Exception e) {
						textField_courseCredits.setText("MÂste vara en siﬀra!");
					}
				}
			} 


		});
		button_AddCourse.setBounds(273, 63, 89, 23);	
		panel_Add.add(button_AddCourse); 
		

		JButton button_AddStudent = new JButton("Add Student");
		button_AddStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String name = textField_StudentName.getText();
				//String address = regAddressTextField.getText();
				String ssn = textField_StudentSSN.getText();
				if (textField_StudentSSN.getText().isEmpty()) {
					textArea_Add.setText("Fyll i personnummer.");
				} else {
					try {
						if (controller.getStudent(ssn) != null) {
							textArea_Add.setText("Student med detta personnummer exsiterar redan!");
							textField_StudentSSN.setText("");
						} else {
							controller.insertStudent(ssn, name); //address
							textArea_Add.setText(name + " har lagts till");
							textField_StudentName.setText("");
							//textField_StudentAddress.setText("");
							textField_StudentSSN.setText("");
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
	
		});
		button_AddStudent.setBounds(269, 202, 93, 23);
		panel_Add.add(button_AddStudent);
		
		textField_courseCredits = new JTextField();
		textField_courseCredits.setBounds(98, 95, 96, 20);
		panel_Add.add(textField_courseCredits);
		textField_courseCredits.setColumns(10);
		
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
		
		
		
		//ALLT PÅ FLIK REGISTER
		JPanel panel_Register = new JPanel();
		tabbedPane.addTab("Register", null, panel_Register, null);
		panel_Register.setLayout(null);
		
		JTextArea textArea_Register = new JTextArea();
		textArea_Register.setBounds(112, 271, 220, 22);
		panel_Register.add(textArea_Register);
		
		JButton BtnRegisterNewStudent = new JButton("Register new student on course");
		BtnRegisterNewStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		BtnRegisterNewStudent.setBounds(112, 82, 187, 23);
		panel_Register.add(BtnRegisterNewStudent);
		
		JButton btnRegisterStudent = new JButton("Register student on finished course");
		btnRegisterStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String studentSsn = textField_StudentSSN2.getText();
				String courseCode = textField_courseCode2.getText();
			//	String grade = comboBoxGrade.getSelectedItem().toString();
			
			}
		});
		btnRegisterStudent.setBounds(126, 198, 205, 23);
		panel_Register.add(btnRegisterStudent);
		

		
		JComboBox comboBoxGrade = new JComboBox();
		comboBoxGrade.addItem("A");
		comboBoxGrade.addItem("B");
		comboBoxGrade.addItem("C");
		comboBoxGrade.addItem("D");
		comboBoxGrade.addItem("E");
		comboBoxGrade.addItem("F");
		
		comboBoxGrade.setBounds(340, 166, 43, 22);
		panel_Register.add(comboBoxGrade);
		
	
		
		textField_StudentSSN2 = new JTextField();
		textField_StudentSSN2.setBounds(113, 167, 49, 20);
		panel_Register.add(textField_StudentSSN2);
		textField_StudentSSN2.setColumns(10);
		
		JLabel lblStudentSSN2 = new JLabel("Student SSN");
		lblStudentSSN2.setBounds(45, 170, 61, 14);
		panel_Register.add(lblStudentSSN2);
		
		JLabel lblGrade = new JLabel("Grade");
		lblGrade.setBounds(307, 170, 43, 14);
		panel_Register.add(lblGrade);
		
		JLabel lblCourseCode = new JLabel("Course code");
		lblCourseCode.setBounds(172, 170, 68, 14);
		panel_Register.add(lblCourseCode);
		
		textField_courseCode2 = new JTextField();
		textField_courseCode2.setBounds(248, 167, 49, 20);
		panel_Register.add(textField_courseCode2);
		textField_courseCode2.setColumns(10);
		
		JLabel label_StudentSSN = new JLabel("Student SSN");
		label_StudentSSN.setBounds(79, 50, 61, 14);
		panel_Register.add(label_StudentSSN);
		
		textField_StudentSSN3 = new JTextField();
		textField_StudentSSN3.setColumns(10);
		textField_StudentSSN3.setBounds(147, 47, 49, 20);
		panel_Register.add(textField_StudentSSN3);
		
		JLabel label_CourseCode2 = new JLabel("Course code");
		label_CourseCode2.setBounds(206, 50, 68, 14);
		panel_Register.add(label_CourseCode2);
		
		textField_CourseCode3 = new JTextField();
		textField_CourseCode3.setColumns(10);
		textField_CourseCode3.setBounds(269, 47, 49, 20);
		panel_Register.add(textField_CourseCode3);
		
	
		//SLUT PÅ FLIK REGISTER 
		
		//ALLT PÅ FLIK ASSIGNMENT 2
		JPanel panel_Assignment2 = new JPanel();
		tabbedPane.addTab("Assignment 2", null, panel_Assignment2, null);
		
		//SLUT PÅ FLIK ASSIGNMENT 2
	}
	
	public JFrame getFrame() {
		return frame;
	}
	
	

	public Controller getController() {
		return controller;
	}
	

	public JTextField getTextField_StudentSSN2() {
		return textField_StudentSSN2;
	}

	public JTextField getTextField_courseCode2() {
		return textField_courseCode2;
	}

	public JTextField getTextField_StudentSSN3() {
		return textField_StudentSSN3;
	}

	public JTextField getTextField_CourseCode3() {
		return textField_CourseCode3;
	}

	public JTextField getTextField_courseCode() {
		return textField_courseCode;
	}

	public JTextField getTextField_courseName() {
		return textField_courseName;
	}

	public JTextField getTextField_StudentSSN() {
		return textField_StudentSSN;
	}

	public JTextField getTextField_StudentName() {
		return textField_StudentName;
	}

	public JTextField getTextField_studentName() {
		return textField_studentName;
	}

	public JTextField getTextField_ssn() {
		return textField_ssn;
	}

	public JTextField getTextField_courseCodeFind() {
		return textField_courseCodeFind;
	}

	public JTextField getTextField_courseCredits() {
		return textField_courseCredits;
	}

	public JButton getButton_AddStudent() {
		return button_AddStudent;
	}

	public JButton getButton_AddCourse() {
		return button_AddCourse;
	}

	public JButton getButton_FindStudent() {
		return button_FindStudent;
	}

	public JButton getButton_FindCourse() {
		return button_FindCourse;
	}

	public JButton getBtnRegisterStudent() {
		return btnRegisterStudent;
	}

	public JButton getBtnRegisterNewStudent() {
		return BtnRegisterNewStudent;
	}
	
	}	