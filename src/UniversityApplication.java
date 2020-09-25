import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
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
import javax.swing.JFormattedTextField;

public class UniversityApplication {

	private JFrame frame;
	private Controller controller;
	private JTextField textField_StudentSSN2;
	private JTextField textField_courseCode2;
	private JTextField textField_courseCode;
	private JTextField textField_courseName;
	private JTextField textField_ssn;
	private JTextField textField_courseCredits;
	private JButton button_AddStudent;
	private JButton button_AddCourse;
	private JButton button_FindStudent;
	private JButton button_FindCourse;
	private JButton btnRegisterStudent;
	private JButton BtnRegisterNewStudent;
	private JTextField textField_StudentName;
	private JTextField textField_StudentAddress;
	private JTextField textField_courseCodeRegister;
	private JTextField textField_studentSSN2;


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
		frame.setBounds(100, 100, 450, 460);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 434, 421);
		frame.getContentPane().add(tabbedPane);
		
		//fliken student
		JPanel panel_Student = new JPanel();
		tabbedPane.addTab("Student", null, panel_Student, null);
				
		JPanel panel_Course = new JPanel();
		tabbedPane.addTab("Course", null, panel_Course, null);
		panel_Course.setLayout(null);
				
		JPanel panel_Register = new JPanel();
		tabbedPane.addTab("Register", null, panel_Register, null);
		panel_Register.setLayout(null);
			
		//Comboboxar		
		JComboBox comboBoxGrade = new JComboBox();
		comboBoxGrade.addItem("A");
		comboBoxGrade.addItem("B");
		comboBoxGrade.addItem("C");
		comboBoxGrade.addItem("D");
		comboBoxGrade.addItem("E");
		comboBoxGrade.addItem("F");
		comboBoxGrade.setBounds(261, 232, 49, 22);
		panel_Register.add(comboBoxGrade);
				
		/*JComboBox comboBoxStudentSSN = new JComboBox();
		comboBoxStudentSSN.setBounds(186, 18, 124, 22);
		try {
			for (Student student: controller.getAllStudents()) {
				comboBoxStudentSSN.addItem(student.getSsn());
			}
				
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		panel_Register.add(comboBoxStudentSSN);
		
		JComboBox comboBoxCourseCode = new JComboBox();
		comboBoxCourseCode.setBounds(261, 51, 49, 22);
		try {
		for (Course course: controller.getAllCourses()) {
			comboBoxCourseCode.addItem(course.getCourseCode());
		}
			
	} catch (SQLException e1) {
		e1.printStackTrace();
	}
		panel_Register.add(comboBoxCourseCode);
		*/
		
		//Allt på Student
		
		
		JTextArea textArea_Student = new JTextArea();
		textArea_Student.setBounds(38, 197, 357, 141);
		panel_Student.add(textArea_Student);
		
		textField_ssn = new JTextField();
		textField_ssn.setColumns(10);
		textField_ssn.setBounds(124, 63, 96, 20);
		panel_Student.add(textField_ssn);
		
		JLabel labelStudentSSN = new JLabel("Student SSN *");
		labelStudentSSN.setBounds(22, 66, 82, 14);
		panel_Student.add(labelStudentSSN);
		
		textField_StudentName = new JTextField();
		textField_StudentName.setColumns(10);
		textField_StudentName.setBounds(124, 94, 96, 20);
		panel_Student.add(textField_StudentName);
		
		JLabel labelStudentName = new JLabel("Student name *");
		labelStudentName.setBounds(22, 97, 89, 14);
		panel_Student.add(labelStudentName);
		
		JLabel lblStudentAddress = new JLabel("Student address *");
		lblStudentAddress.setBounds(22, 133, 105, 19);
		panel_Student.add(lblStudentAddress);
		
		textField_StudentAddress = new JTextField();
		textField_StudentAddress.setColumns(10);
		textField_StudentAddress.setBounds(124, 132, 96, 20);
		panel_Student.add(textField_StudentAddress);
		
		JButton btnFindStudent = new JButton("Find Student");
		btnFindStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnFindStudent.setBounds(257, 119, 113, 23);
		panel_Student.setLayout(null);
		panel_Student.add(btnFindStudent);
		
	
		/*JButton btnAddStudent = new JButton("Add Student");
		btnAddStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String name = textField_StudentName.getText();
				String address = textField_StudentAddress.getText();
				String ssn = textField_ssn.getText();
				if (textField_ssn.getText().isEmpty()) {
					textArea_Student.setText("Fill in SSN.");
				} else {
					try {
						if (controller.getStudent(ssn) != null) {
							textArea_Student.setText("Studen with this SSN already exists!");
							textField_ssn.setText("");
						} else {
							controller.addStudent(ssn, name, address); 
							textArea_Student.setText(name + "was added");
							textField_StudentName.setText("");
							textField_StudentAddress.setText("");
							textField_ssn.setText("");
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
				
					}	
					}}
		});
		btnAddStudent.setBounds(257, 76, 113, 23);
		panel_Student.add(btnAddStudent);
		*/
		
		JButton btnAddStudent = new JButton("Add Student");
		btnAddStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String name = textField_StudentName.getText();
				String address = textField_StudentAddress.getText();
				String ssn = textField_ssn.getText();
				
				 if(name.isEmpty() || address.isEmpty() || ssn.isEmpty()) {
					 textArea_Student.setText("Please type in all fields");
	                }else {
	                    
	                    try {
	                      
	                            Controller.addStudent(name, address, ssn);
	                            textArea_Student.setText("Student added");
	                            
	                        }catch (SQLException sql){
	                            textArea_Student.setText("ErrorMessage");
	                        }    
	                        
	                    
	                }
				 	textField_StudentName.setText(" ");
				 	textField_StudentAddress.setText(" ");
				 	textField_ssn.setText(" ");

	            }
		});
		btnAddStudent.setBounds(257, 76, 113, 23);
		panel_Student.add(btnAddStudent);
		
		//SLUT PÅ FLIK STUDENT
		
		//ALLT PÅ FLIK COURSE
		
		JTextArea textArea_Course = new JTextArea();
		textArea_Course.setBounds(31, 256, 357, 101);
		panel_Course.add(textArea_Course);
		
		JLabel label = new JLabel("Course code *");
		label.setBounds(10, 171, 93, 14);
		panel_Course.add(label);
		
		textField_courseCodeRegister = new JTextField();
		textField_courseCodeRegister.setColumns(10);
		textField_courseCodeRegister.setBounds(108, 167, 96, 20);
		panel_Course.add(textField_courseCodeRegister);
		
		textField_studentSSN2 = new JTextField();
		textField_studentSSN2.setColumns(10);
		textField_studentSSN2.setBounds(108, 198, 96, 20);
		panel_Course.add(textField_studentSSN2);
		
		JLabel label_1 = new JLabel("Student SSN *");
		label_1.setBounds(10, 201, 82, 14);
		panel_Course.add(label_1);
		
		
		textField_courseCredits = new JTextField();
		textField_courseCredits.setBounds(108, 95, 96, 20);
		panel_Course.add(textField_courseCredits);
		textField_courseCredits.setColumns(10);
		
		JLabel lblNewLabel_CourseCode = new JLabel("Course code *");
		lblNewLabel_CourseCode.setBounds(10, 39, 93, 14);
		panel_Course.add(lblNewLabel_CourseCode);
		
		JLabel lblNewLabel_CourseName = new JLabel("Course name *");
		lblNewLabel_CourseName.setBounds(10, 67, 93, 14);
		panel_Course.add(lblNewLabel_CourseName);
		
		textField_courseCode = new JTextField();
		textField_courseCode.setBounds(108, 36, 96, 20);
		panel_Course.add(textField_courseCode);
		textField_courseCode.setColumns(10);
		
		textField_courseName = new JTextField();
		textField_courseName.setBounds(108, 64, 96, 20);
		panel_Course.add(textField_courseName);
		textField_courseName.setColumns(10);
		
		JLabel lblCourseCredits = new JLabel("Course credits *");
		lblCourseCredits.setBounds(10, 95, 93, 14);
		panel_Course.add(lblCourseCredits);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(59, 142, 329, 7);
		panel_Course.add(separator);
		
		JButton button_AddCourse = new JButton("Add Course");
        button_AddCourse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            
                String courseName = textField_courseName.getText();
                String courseCode = textField_courseCode.getText();
                //String credits  = textField_courseCredits.getText();
        
                if(courseCode.isEmpty() || courseName.isEmpty() || textField_courseCredits.getText().isEmpty()) {
                    textArea_Course.setText("Please type in all fields");
                }else {
                    
                    try {
                        try {
                            
                            Integer credits = Integer.parseInt(textField_courseCredits.getText());
                            Controller.addCourse(courseCode, courseName, credits);
                            textArea_Course.setText("Course added");
                            
                            
                        }catch (SQLException sql){
                            textArea_Course.setText("ErrorMessage");
                        }    
                        
                        
                        
                    }catch (NumberFormatException ne) {
                        textArea_Course.setText("Only numbers is allowed");
                    }
                    
                }
                textField_courseName.setText(" ");
                textField_courseCode.setText(" ");
                textField_courseCredits.setText(" ");

            }
                    
        });
        button_AddCourse.setBounds(268, 35, 113, 23);	
        panel_Course.add(button_AddCourse); 


		
		JButton button_ShowAllResults = new JButton("Show all results");
		button_ShowAllResults.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_ShowAllResults.setBounds(268, 108, 113, 23);
		panel_Course.add(button_ShowAllResults);
		
		JButton button_findCourse = new JButton("Find Course");
		button_findCourse.setBounds(268, 74, 113, 23);
		panel_Course.add(button_findCourse);
		
		JButton button_RegStudent = new JButton("Register student on course");
		button_RegStudent.setBounds(231, 180, 188, 23);
		panel_Course.add(button_RegStudent);
		
	
		
		//ALLT PÅ FLIK REGISTER
		
		JTextArea textArea_Register = new JTextArea();
		textArea_Register.setBounds(70, 295, 268, 80);
		panel_Register.add(textArea_Register);
		
		/*JButton btnRegisterStudent_1 = new JButton("Register result");
		btnRegisterStudent_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String studentSsn = textField_StudentSSN2.getText();
				String courseCode = textField_courseCode2.getText();
			    String grade = comboBoxGrade.getSelectedItem().toString();
			
			    Student student = controller.getStudent(studentSsn);
			    Course  course = controller.getCourse(courseCode);
			    HasStudied hasStudied = controller.getHasStudied(courseCode, studentSsn);
			  
			}
				
			});
		btnRegisterStudent_1.setBounds(84, 265, 226, 23);
		panel_Register.add(btnRegisterStudent_1);*/
			
		
		textField_StudentSSN2 = new JTextField();
		textField_StudentSSN2.setBounds(186, 167, 124, 20);
		panel_Register.add(textField_StudentSSN2);
		textField_StudentSSN2.setColumns(10);
		
		JLabel lblStudentSSN2 = new JLabel("Student SSN");
		lblStudentSSN2.setBounds(84, 170, 76, 14);
		panel_Register.add(lblStudentSSN2);
		
		JLabel lblGrade = new JLabel("Grade");
		lblGrade.setBounds(84, 236, 58, 14);
		panel_Register.add(lblGrade);
		
		JLabel lblCourseCode = new JLabel("Course code");
		lblCourseCode.setBounds(84, 202, 85, 20);
		panel_Register.add(lblCourseCode);
		
		textField_courseCode2 = new JTextField();
		textField_courseCode2.setBounds(186, 201, 124, 20);
		panel_Register.add(textField_courseCode2);
		textField_courseCode2.setColumns(10);
		
		JLabel label_StudentSSN = new JLabel("Student SSN");
		label_StudentSSN.setBounds(84, 22, 85, 14);
		panel_Register.add(label_StudentSSN);
		
		JLabel label_CourseCode2 = new JLabel("Course code");
		label_CourseCode2.setBounds(84, 57, 85, 14);
		panel_Register.add(label_CourseCode2);
		
		/*JButton btnRegisterResu = new JButton("Show  student result");
		btnRegisterResu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String ssn = comboBoxStudentSSN.getSelectedItem().toString();
				String ccode = comboBoxCourseCode.getSelectedItem().toString();
				
				HasStudied hs = controller.getHasStudied(ssn, ccode);
				
				if(hs==null) {
					 textArea_Register.setText("The student has not studied this course.");					 
				}
				for (HasStudied hasStudied : controller.getHasStudied(ssn, ccode)) {
					textArea_Register.setText("Hello");
				}
			
			}
		});
		btnRegisterResu.setBounds(84, 96, 226, 23);
		panel_Register.add(btnRegisterResu);
		
		*/
		//SLUT PÅ FLIK REGISTER 
		
		//ALLT PÅ FLIK ASSIGNMENT 2
		JPanel panel_Assignment2 = new JPanel();
		tabbedPane.addTab("Assignment 2", null, panel_Assignment2, null);
		
		//SLUT PÅ FLIK ASSIGNMENT 2
	}
}
	