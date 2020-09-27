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
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.SpinnerNumberModel;
import javax.swing.JList;
import javax.swing.JTextPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;
import java.awt.Color;
import java.awt.Font;

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
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_studentFind;
	private JTextField textField_findCourse;
	private JTextField textField_showResult;


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

	
	public UniversityApplication(Controller controller) {
		this.controller = controller; 
	}
	public UniversityApplication() {
		
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 494);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 434, 455);
		frame.getContentPane().add(tabbedPane);
		
			//fliken student
			JPanel panel_Student = new JPanel();
			tabbedPane.addTab("Student", null, panel_Student, null);
			
			//Allt på Student
			
			
			JTextArea textArea_Student = new JTextArea();
			textArea_Student.setBounds(22, 262, 373, 141);
			panel_Student.add(textArea_Student);
			
			textField_ssn = new JTextField();
			textField_ssn.setColumns(10);
			textField_ssn.setBounds(124, 45, 96, 20);
			panel_Student.add(textField_ssn);
			
			JLabel labelStudentSSN = new JLabel("Student SSN *");
			labelStudentSSN.setBounds(22, 79, 82, 14);
			panel_Student.add(labelStudentSSN);
			
			textField_StudentName = new JTextField();
			textField_StudentName.setColumns(10);
			textField_StudentName.setBounds(124, 76, 96, 20);
			panel_Student.add(textField_StudentName);
			
			JLabel labelStudentName = new JLabel("Student name *");
			labelStudentName.setBounds(22, 118, 89, 14);
			panel_Student.add(labelStudentName);
			
			JLabel lblStudentAddress = new JLabel("Student address *");
			lblStudentAddress.setBounds(22, 46, 105, 19);
			panel_Student.add(lblStudentAddress);
			
			textField_StudentAddress = new JTextField();
			textField_StudentAddress.setColumns(10);
			textField_StudentAddress.setBounds(124, 115, 96, 20);
			panel_Student.add(textField_StudentAddress);
			
			JButton btnFindStudent = new JButton("Find Student");
			btnFindStudent.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				String ssn = textField_studentFind.getText();
				if(!ssn.isEmpty()) {
					try {
						Student s = Controller.findStudent(ssn);
							
						if(s == null) {
							textArea_Student.setText("Unable to find a student with the given SSN, check spelling ETC");
						} else {
							textArea_Student.setText(s.getStudentName() + " " + "Was found");
						}
					} catch (SQLException e1) {
						textArea_Student.setText("An error occured please try again");
					}
				}
				
				
				
				}	
			});
			btnFindStudent.setBounds(257, 191, 113, 23);
			panel_Student.setLayout(null);
			panel_Student.add(btnFindStudent);
			
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
			btnAddStudent.setBounds(257, 40, 113, 23);
			panel_Student.add(btnAddStudent);
			

			JLabel lblFieldsMarkedWith = new JLabel("Fields marked with (*) are mandatory to fill in.");
			lblFieldsMarkedWith.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblFieldsMarkedWith.setForeground(new Color(178, 34, 34));
			lblFieldsMarkedWith.setBounds(22, 240, 322, 14);
			panel_Student.add(lblFieldsMarkedWith);
			
					textField_studentFind = new JTextField();
					textField_studentFind.setBounds(124, 192, 96, 20);
					panel_Student.add(textField_studentFind);
					textField_studentFind.setColumns(10);
					
					JLabel lblNewLabel = new JLabel("Insert SSN in the box below to find Student");
					lblNewLabel.setBounds(25, 172, 255, 14);
					panel_Student.add(lblNewLabel);
					
					JSeparator separator_4 = new JSeparator();
					separator_4.setBounds(41, 154, 329, 7);
					panel_Student.add(separator_4);
		
		JPanel panel_Course = new JPanel();
		tabbedPane.addTab("Course", null, panel_Course, null);
		panel_Course.setLayout(null);
		
				
				//SLUT PÅ FLIK STUDENT
				
				//ALLT PÅ FLIK COURSE
				
				JTextArea textArea_Course = new JTextArea();
				textArea_Course.setBounds(31, 315, 357, 101);
				panel_Course.add(textArea_Course);
				

				JLabel label = new JLabel("Course code *");
				label.setBounds(10, 230, 93, 14);
				panel_Course.add(label);
				
				textField_courseCodeRegister = new JTextField();
				textField_courseCodeRegister.setColumns(10);
				textField_courseCodeRegister.setBounds(108, 226, 96, 20);
				panel_Course.add(textField_courseCodeRegister);
				
				textField_studentSSN2 = new JTextField();
				textField_studentSSN2.setColumns(10);
				textField_studentSSN2.setBounds(108, 257, 96, 20);
				panel_Course.add(textField_studentSSN2);
				
				JLabel label_1 = new JLabel("Student SSN *");
				label_1.setBounds(10, 260, 82, 14);
				panel_Course.add(label_1);
				
		textField_courseCredits = new JTextField();
		textField_courseCredits.setBounds(108, 71, 96, 20);
		panel_Course.add(textField_courseCredits);
		textField_courseCredits.setColumns(10);
		
		JLabel lblNewLabel_CourseCode = new JLabel("Course code *");
		lblNewLabel_CourseCode.setBounds(10, 15, 93, 14);
		panel_Course.add(lblNewLabel_CourseCode);
		
		JLabel lblNewLabel_CourseName = new JLabel("Course name *");
		lblNewLabel_CourseName.setBounds(10, 43, 93, 14);
		panel_Course.add(lblNewLabel_CourseName);
		
		textField_courseCode = new JTextField();
		textField_courseCode.setBounds(108, 12, 96, 20);
		panel_Course.add(textField_courseCode);
		textField_courseCode.setColumns(10);
		
		textField_courseName = new JTextField();
		textField_courseName.setBounds(108, 40, 96, 20);
		panel_Course.add(textField_courseName);
		textField_courseName.setColumns(10);
		
		JLabel lblCourseCredits = new JLabel("Course credits *");
		lblCourseCredits.setBounds(10, 71, 93, 14);
		panel_Course.add(lblCourseCredits);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(59, 150, 329, 7);
		panel_Course.add(separator);
		
		JButton button_AddCourse_1 = new JButton("Add Course");
		button_AddCourse_1.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    
		        String courseName = textField_courseName.getText();
		        String courseCode = textField_courseCode.getText();
		        //String credits  = textField_courseCredits.getText();
       
		        if(courseCode.isEmpty() || courseName.isEmpty() || textField_courseCredits.getText().isEmpty()) {
		            textArea_Course.setText("Please type in all fields");
		        }else {
		            
		            try {
		                try {
		                    
		                    Integer credit = Integer.parseInt(textField_courseCredits.getText());
		                    Controller.addCourse(courseCode, courseName, credit);
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
		
		        button_AddCourse_1.setBounds(275, 11, 113, 23);	
		        panel_Course.add(button_AddCourse_1); 
		        
		        
		        		
		        		JButton button_ShowAllResults = new JButton("Show all results");
		        		button_ShowAllResults.addActionListener(new ActionListener() {
		        			public void actionPerformed(ActionEvent e) {
		        				
		        				String courseCode = textField_showResult.getText();
		        			if (courseCode.isEmpty()) {
		        				textArea_Course.setText("Please fill in course code.");
		        			}else {
		        				try {
		        					Course course = controller.findCourse(courseCode);
		        				
		        				if (course == null ) {
		        					String courseNotFound = controller.courseNotFound(courseCode);
		        					textArea_Course.setText(courseNotFound);
		        			}else {
		        				ArrayList <HasStudied> courseResultList = controller.showAllStudentResult(courseCode);
		        			if (courseResultList.isEmpty()) {
		        					textArea_Course.setText("No students has finished this course.");
		        			} else {
		        				for (HasStudied hs : courseResultList) {
		        					textArea_Course.setText(hs.getGrade() + hs.getCourseCode());
		        				}
		        			}
		        				
		        			}
		        			
		        			}catch (SQLException sql) {
		        				textArea_Course.setText(controller.ErrorHandling(sql.getErrorCode(), ""));
		        			}
		        			}
		        			}
		        		});
		        		button_ShowAllResults.setBounds(275, 120, 113, 23);
		        		panel_Course.add(button_ShowAllResults);
		        		
		        		JButton button_findCourse = new JButton("Find Course");
		        		
		        				button_findCourse.addActionListener(new ActionListener() {
		        					public void actionPerformed(ActionEvent e) {
		        						
		        						String courseCode = textField_findCourse.getText();
		        						
		        						if(courseCode.isEmpty()) {
		        							textArea_Course.setText("Please fill in course code.");
		        						}else {
		        							
		        							try {
		        								Course c = controller.findCourse(courseCode);
		        								
		        								if ( c != null) {
		        									textArea_Course.setText
		        									("Course with code: " + " " + c.getCourseCode()  + " Name: " + c.getCourseName() + " and Credits: " + c.getCredits() + " " + "found");
		        								
		        								}else {
		        									String courseNotFound = controller.courseNotFound(courseCode);
		        									textArea_Course.setText(courseNotFound);
		        								}
		        									
		        							} catch (SQLException sql) {
		        								textArea_Course.setText(controller.ErrorHandling(sql.getErrorCode(), ""));
		        							}
		        						}
		        										
		        					}
		        				});
		        				
		        						button_findCourse.setBounds(275, 178, 113, 23);
		        						panel_Course.add(button_findCourse);
		        						
		        						
		        						
		        						JButton button_RegStudent = new JButton("Register student on course");
		        						button_RegStudent.addActionListener(new ActionListener() {
		        							public void actionPerformed(ActionEvent e) {
		        								
		        								String ssn = textField_StudentSSN2.getText();
		        								String courseCode = textField_courseCodeRegister.getText();
		        								
		        								 if(courseCode.isEmpty() || ssn.isEmpty()) {
	                    textArea_Course.setText("Please type in all fields");
	                    	
		        								 } else {
		        									 try {
		        										 Student student = Controller.findStudent(ssn);
		        										 Course course = controller.findCourse(courseCode);
		        										 
		        										 if (student == null) {
		        											 String studentNotFound = controller.studentNotFound(ssn);
		        											 textArea_Course.setText(studentNotFound);
		        										
		        										 } else if (course == null) {
		        											 String courseNotFound = Controller.courseNotFound(courseCode);
		        											 textArea_Course.setText(courseNotFound);
		        											 
		        										 }else {
		        											 Controller.addStudentOnCourse(ssn, courseCode);
		        											 textArea_Course.setText("Student with ssn" + ssn + "was added");
		        										 }
		        									 
		        									 }catch (SQLException sql) {
		        											 textArea_Course.setText(controller.ErrorHandling(sql.getErrorCode(), ""));
		        										 }
		        										 
		        										 
		        									 }
		        							}
		        						});
		        						button_RegStudent.setBounds(230, 239, 175, 23);
		        						panel_Course.add(button_RegStudent);
		        						
		        						JLabel label_2 = new JLabel("Fields marked with (*) are mandatory to fill in.");
		        						label_2.setForeground(new Color(178, 34, 34));
		        						label_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		        						label_2.setBounds(31, 301, 322, 14);
		        						panel_Course.add(label_2);
		        						
		        						JSeparator separator_2 = new JSeparator();
		        						separator_2.setBounds(59, 212, 329, 7);
		        						panel_Course.add(separator_2);
		        						
		        						JLabel lblInsertCourseCode = new JLabel("Insert course code in the box below to find course.");
		        						lblInsertCourseCode.setBounds(10, 162, 255, 14);
		        						panel_Course.add(lblInsertCourseCode);
		        						
		        						textField_findCourse = new JTextField();
		        						textField_findCourse.setColumns(10);
		        						textField_findCourse.setBounds(108, 179, 96, 20);
		        						panel_Course.add(textField_findCourse);
		        						
		        						JSeparator separator_3 = new JSeparator();
		        						separator_3.setBounds(59, 102, 329, 7);
		        						panel_Course.add(separator_3);
		        						
		        						JLabel lblInsertCourseCode_1 = new JLabel("Insert course code in the box below to show course result");
		        						lblInsertCourseCode_1.setBounds(10, 102, 365, 14);
		        						panel_Course.add(lblInsertCourseCode_1);
		        						
		        						textField_showResult = new JTextField();
		        						textField_showResult.setColumns(10);
		        						textField_showResult.setBounds(108, 119, 96, 20);
		        						panel_Course.add(textField_showResult);
				
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
		comboBoxGrade.setBounds(261, 194, 49, 22);
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

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(320, 18, 30, 22);
		panel_Register.add(comboBox);
		
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(320, 53, 30, 22);
		panel_Register.add(comboBox_1);
		

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
		
	
		/*JButton btnAddStudent = new JButton("Add Student");
		btnAddStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
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

				String studentName = textField_StudentName.getText();
				String address  = textField_StudentAddress.getText();
		
				if(ssn.isEmpty() || studentName.isEmpty() || address.isEmpty()) {
					textArea_Student.setText("Please type in all fields");
				}else {
					
					try {
						try {
							
							
							controller.addStudent(ssn, studentName, address);
							textArea_Student.setText("Course added");
							
							
						}catch (SQLException sql){
							textArea_Student.setText("ErrorMessage");
						}	
						
						
						
					}catch (NumberFormatException ne) {
						textArea_Student.setText("Only numbers is allowed");
					}
					
				}
				textField_courseName.setText(" ");
				textField_courseCode.setText(" ");
				textField_courseCredits.setText(" ");

	}
					
			

		});
						
				
		
		btnAddStudent.setBounds(257, 76, 113, 23);
		panel_Student.add(btnAddStudent);
		*/
		
	
		
		//ALLT PÅ FLIK REGISTER
		
		JTextArea textArea_Register = new JTextArea();
		textArea_Register.setBounds(50, 302, 289, 114);
		panel_Register.add(textArea_Register);
		
		JButton btnShowStudentResult = new JButton("Show student result");
		btnShowStudentResult.setBounds(84, 82, 226, 23);
		panel_Register.add(btnShowStudentResult);
		
		JButton btnRegisterStudent_1 = new JButton("Register result");
		btnRegisterStudent_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				String studentSsn = textField_StudentSSN2.getText();
				String courseCode = textField_courseCode2.getText();
			    String grade = comboBoxGrade.getSelectedItem().toString();
			   
			    try {
					Student student = Controller.findStudent(studentSsn);
				
			    Student student1 = Controller.findCurrentlyStudyingStudent(studentSsn);
			    Course  course = controller.findCourse(courseCode);
			    
			    
			    if(courseCode.isEmpty() || studentSsn.isEmpty() || grade.isBlank()) {
					textArea_Course.setText("Please type in all fields");

			   }
			    } catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
				
			});
		btnRegisterStudent_1.setBounds(84, 227, 226, 23);
		panel_Register.add(btnRegisterStudent_1);
			
		
		textField_StudentSSN2 = new JTextField();
		textField_StudentSSN2.setBounds(186, 129, 124, 20);
		panel_Register.add(textField_StudentSSN2);
		textField_StudentSSN2.setColumns(10);
		
		JLabel lblStudentSSN2 = new JLabel("Student SSN *");
		lblStudentSSN2.setBounds(84, 132, 76, 14);
		panel_Register.add(lblStudentSSN2);
		
		JLabel lblGrade = new JLabel("Grade *");
		lblGrade.setBounds(84, 198, 58, 14);
		panel_Register.add(lblGrade);
		
		JLabel lblCourseCode = new JLabel("Course code *");
		lblCourseCode.setBounds(84, 164, 85, 20);
		panel_Register.add(lblCourseCode);
		
		textField_courseCode2 = new JTextField();
		textField_courseCode2.setBounds(186, 163, 124, 20);
		panel_Register.add(textField_courseCode2);
		textField_courseCode2.setColumns(10);
		
		JLabel lblStudentSsn = new JLabel("Student SSN *");
		lblStudentSsn.setBounds(84, 22, 85, 14);
		panel_Register.add(lblStudentSsn);
		
		JLabel lblCourseCode_1 = new JLabel("Course code * ");
		lblCourseCode_1.setBounds(84, 57, 85, 14);
		panel_Register.add(lblCourseCode_1);
		
		textField = new JTextField();
		textField.setBounds(186, 19, 124, 20);
		panel_Register.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(186, 54, 124, 20);
		panel_Register.add(textField_1);
		textField_1.setColumns(10);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(32, 116, 354, 2);
		panel_Register.add(separator_1);
		
		JLabel label_3 = new JLabel("Fields marked with (*) are mandatory to fill in.");
		label_3.setForeground(new Color(178, 34, 34));
		label_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_3.setBounds(50, 281, 322, 14);
		panel_Register.add(label_3);
		
		//SLUT PÅ FLIK ASSIGNMENT 2
	}
}
	