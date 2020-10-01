import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.util.ArrayList;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class UniversityApplication extends JFrame {
	
	Controller controller;
	private JFrame frame;
	
	//Textfält
	private JTextField textField_StudentSSN2;
	private JTextField textField_courseCode2;
	private JTextField textField_courseCode;
	private JTextField textField_courseName;
	private JTextField textField_ssn;
	private JTextField textField_courseCredits;
	
	//Knappar
	private JButton btnAddStudent;
	private JButton btnAddCourse;
	private JButton btnFindStudent;
	private JButton btnFindCourse;
	private JButton btnShowStudentResult;
	private JButton btnShowAllResults;
	private JButton btnRegisterResultCourse;
	private JButton btnRegisterResult;
	private JButton btnShowAllCourses;
	private JButton btnShowAllStudents;
	
	//Textfält
	private JTextField textField_StudentName;
	private JTextField textField_StudentAddress;
	private JTextField textField_studentFind;
	private JTextField textField_findCourse;
	private JTextField textField_showResult;
	private JTextField textField_courseCodeResult;
	private JTextField textField_StudentSSNResult;
	private JTextField textField_courseCodeRegister;
	private JTextField textField_studentSSNRegister;
	
	//Tabeller 
	private JTable table_Course;
	private JTable table_Student;
	
	//Textareas
	private JTextArea textArea_Student; 
	private JTextArea textArea_Course; 
	private JTextArea textArea_Register; 

	
	public UniversityApplication(Controller controller) {
		this.controller = controller; 
	}
	public UniversityApplication() {
		
	
		//frame = new JFrame();
		this.setBounds(100, 100, 450, 494);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
	
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 434, 455);
		this.getContentPane().add(tabbedPane);;
			
		JPanel panel_Overview = new JPanel();
		tabbedPane.addTab("Overview", null, panel_Overview, null);
		panel_Overview.setLayout(null);
			
		table_Course = new JTable(new DefaultTableModel(new String[] { "Course code", "Course name" }, 0));	
		JScrollPane courseScrollPane = new JScrollPane(table_Course);
		courseScrollPane.setBounds(41, 86, 345, 114);
		panel_Overview.add(courseScrollPane);
			
		table_Student = new JTable(new DefaultTableModel(new String[] { "SSN", "Student name", "Address" }, 0));		
		JScrollPane studentScrollPane = new JScrollPane(table_Student);
		studentScrollPane.setBounds(41, 281, 345, 114);
		panel_Overview.add(studentScrollPane);

			
		//Button - Show all Courses
		btnShowAllCourses = new JButton("Show all courses");
//		btnShowAllCourses.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				try {
//
//					DefaultTableModel courseTable = (DefaultTableModel) table_Course.getModel();
//					courseTable.setRowCount(0);
//					for (Course c : Controller.getAllCourses()) {
//						courseTable.addRow(new String[] { c.getCourseCode(), c.getCourseName() });
//					}
//						
//					} catch (Exception e1) {
//						e1.printStackTrace();
//
//					}
//
//					
//				}
//			});
			btnShowAllCourses.setBounds(125, 52, 163, 23);
			panel_Overview.add(btnShowAllCourses);
			
			//Button Show All Student
			btnShowAllStudents = new JButton("Show all students");
//			btnShowAllStudents.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent e) {
//					try {
//
//						DefaultTableModel studentTable = (DefaultTableModel) table_Student.getModel();
//						studentTable.setRowCount(0);
//						for (Student s : Controller.getAllStudents()) {
//							studentTable.addRow(new String[] { s.getSsn(), s.getStudentName(), s.getAddress() });
//						}
//						
//					} catch (Exception e1) {
//						e1.printStackTrace();
//
//					}
//
//				}
//			});
			btnShowAllStudents.setBounds(125, 247, 163, 23);
			panel_Overview.add(btnShowAllStudents);
		
			//fliken student
			JPanel panel_Student = new JPanel();
			tabbedPane.addTab("Student", null, panel_Student, null);
			
			//Allt på Student
			
			
			JTextArea textArea_Student = new JTextArea();
			textArea_Student.setEditable(false);
			textArea_Student.setBounds(21, 313, 373, 101);
			panel_Student.add(textArea_Student);
			
			textField_ssn = new JTextField();
			textField_ssn.setColumns(10);
			textField_ssn.setBounds(124, 18, 96, 20);
			panel_Student.add(textField_ssn);
			
			JLabel labelStudentSSN = new JLabel("Student SSN *");
			labelStudentSSN.setBounds(21, 21, 82, 14);
			panel_Student.add(labelStudentSSN);
			
			textField_StudentName = new JTextField();
			textField_StudentName.setColumns(10);
			textField_StudentName.setBounds(124, 49, 96, 20);
			panel_Student.add(textField_StudentName);
			
			JLabel labelStudentName = new JLabel("Student name *");
			labelStudentName.setBounds(21, 52, 89, 14);
			panel_Student.add(labelStudentName);
			
			JLabel lblStudentAddress = new JLabel("Student address *");
			lblStudentAddress.setBounds(21, 89, 105, 19);
			panel_Student.add(lblStudentAddress);
			
			textField_StudentAddress = new JTextField();
			textField_StudentAddress.setColumns(10);
			textField_StudentAddress.setBounds(124, 88, 96, 20);
			panel_Student.add(textField_StudentAddress);
			
			//Button - Find Student
			btnFindStudent = new JButton("Find Student");
//			btnFindStudent.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent e) {
//				String ssn = textField_studentFind.getText();
//				if(ssn.isEmpty()){
//					textArea_Student.setText("Please type in all fields");
//				}
//				if(!ssn.isEmpty()) {
//					try {
//						Student s = Controller.findStudent(ssn);
//							
//						if(s == null) {
//							textArea_Student.setText("Unable to find a student with the given SSN, check spelling ETC");
//						} else {
//							textArea_Student.setText("The following student found; " + "\nSSN: " + s.getSsn() + "\nStudentname: " + s.getStudentName() + "\nStudent Address: " + s.getAddress());
//						}
//					} catch (SQLException sql) {
//						textArea_Student.setText(Controller.ErrorHandling(sql.getErrorCode(), ""));
//					}
//				}
//				
//				
//				
//				}	
//			});
			btnFindStudent.setBounds(257, 164, 113, 23);
			panel_Student.setLayout(null);
			panel_Student.add(btnFindStudent);
			
			//Button - Add Student
			btnAddStudent = new JButton("Add Student");
			btnAddStudent.setBounds(257, 13, 113, 23);
			panel_Student.add(btnAddStudent);
			
			//Button - Show Student Result
			btnShowStudentResult = new JButton("Show student result");
			btnShowStudentResult.setFont(new Font("Tahoma", Font.BOLD, 10));
//			btnShowStudentResult.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent e) {
//					
//					String ssn =textField_StudentSSNResult.getText();
//					String courseCode = textField_courseCodeResult.getText();
//					
//					
//					if(ssn.isEmpty() || courseCode.isEmpty()) {
//						textArea_Student.setText("Please type in all fields");
//					}else {
//						try {
//							Student student = Controller.findStudent(ssn);
//							Course course = Controller.findCourse(courseCode);
//							
//							
//							if(student == null || course == null) {
//								textArea_Student.setText("That student or course does not exist");
//							}else {
//								ArrayList<HasStudied> hasstudiedlist = Controller.showResult(ssn, courseCode);
//								if (hasstudiedlist.isEmpty()) {
//									textArea_Student.setText("Student with SSN: " + student.getSsn() + " has not examined from the course");
//								}else {
//									String sr = "";
//									for (HasStudied x : hasstudiedlist) {
//										sr = sr + x.toString() + "\n";
//										
//									}
//									textArea_Student.setText(sr);
//									
//								}
//							}
//						}catch (SQLException sql) {
//							textArea_Student.setText(Controller.ErrorHandling(sql.getErrorCode(), ""));
//						}
//					}
//					textField_StudentSSNResult.setText("");
//					textField_courseCodeResult.setText("");
//					}
//				
//			});
			btnShowStudentResult.setBounds(257, 238, 162, 23);
			panel_Student.add(btnShowStudentResult);

		JLabel lblFieldsMarkedWith = new JLabel("Fields marked with (*) are mandatory to fill in.");
		lblFieldsMarkedWith.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFieldsMarkedWith.setForeground(new Color(178, 34, 34));
		lblFieldsMarkedWith.setBounds(21, 298, 322, 14);
		panel_Student.add(lblFieldsMarkedWith);
			
		textField_studentFind = new JTextField();
		textField_studentFind.setBounds(124, 165, 96, 20);
		panel_Student.add(textField_studentFind);
		textField_studentFind.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Insert SSN in the box below to find Student");
		lblNewLabel.setBounds(25, 145, 255, 14);
		panel_Student.add(lblNewLabel);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(41, 127, 329, 7);
		panel_Student.add(separator_4);
		
		textField_courseCodeResult = new JTextField();
		textField_courseCodeResult.setColumns(10);
		textField_courseCodeResult.setBounds(120, 257, 124, 20);
		panel_Student.add(textField_courseCodeResult);
		
		JLabel label_4 = new JLabel("Course code * ");
		label_4.setBounds(18, 260, 85, 14);
		panel_Student.add(label_4);
		
		JLabel label_5 = new JLabel("Student SSN *");
		label_5.setBounds(18, 225, 85, 14);
		panel_Student.add(label_5);
		
		textField_StudentSSNResult = new JTextField();
		textField_StudentSSNResult.setColumns(10);
		textField_StudentSSNResult.setBounds(120, 222, 124, 20);
		panel_Student.add(textField_StudentSSNResult);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(41, 198, 329, 7);
		panel_Student.add(separator_5);
		
		JLabel lblxxxx = new JLabel("SSN Format: 000000-XXXX");
		lblxxxx.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
		lblxxxx.setBounds(58, 0, 162, 14);
		panel_Student.add(lblxxxx);
		
		JPanel panel_Course = new JPanel();
		tabbedPane.addTab("Course", null, panel_Course, null);
		panel_Course.setLayout(null);
		
				
				//SLUT PÅ FLIK STUDENT
				
				//ALLT PÅ FLIK COURSE
				
		textArea_Course = new JTextArea();
		textArea_Course.setEditable(false);
		textArea_Course.setBounds(31, 315, 357, 101);
		panel_Course.add(textArea_Course);
				
		textField_courseCredits = new JTextField();
		textField_courseCredits.setBounds(120, 91, 96, 20);
		panel_Course.add(textField_courseCredits);
		textField_courseCredits.setColumns(10);
		
		JLabel lblNewLabel_CourseCode = new JLabel("Course code *");
		lblNewLabel_CourseCode.setBounds(22, 35, 93, 14);
		panel_Course.add(lblNewLabel_CourseCode);
		
		JLabel lblNewLabel_CourseName = new JLabel("Course name *");
		lblNewLabel_CourseName.setBounds(22, 63, 93, 14);
		panel_Course.add(lblNewLabel_CourseName);
		
		textField_courseCode = new JTextField();
		textField_courseCode.setBounds(120, 32, 96, 20);
		panel_Course.add(textField_courseCode);
		textField_courseCode.setColumns(10);
		
		textField_courseName = new JTextField();
		textField_courseName.setBounds(120, 60, 96, 20);
		panel_Course.add(textField_courseName);
		textField_courseName.setColumns(10);
		
		JLabel lblCourseCredits = new JLabel("Course credits *");
		lblCourseCredits.setBounds(22, 91, 93, 14);
		panel_Course.add(lblCourseCredits);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(71, 198, 329, 7);
		panel_Course.add(separator);
		
		//Button - Add Course
		 btnAddCourse = new JButton("Add Course");  
//		    	String courseCode = textField_courseCode.getText();
//		    	String courseName = textField_courseName.getText();
//		        String credits  = textField_courseCredits.getText();
//       
//		        if(courseCode.isEmpty() || courseName.isEmpty() || credits.isEmpty()) {
//		            textArea_Course.setText("Please type in all fields");
//		        }else {
//		    
//		                try {
//		                    
//		                    Integer credit = Integer.parseInt(textField_courseCredits.getText());
//		                    Controller.addCourse(courseCode, courseName, credit);
//		                    textArea_Course.setText("Following Course added; " + "\nCourseCode: " + courseCode + "\nCourseName :" + courseName + "\nCredits: " + credits);
//		                    
//		                    
//		                }catch (SQLException sql){
//		                    textArea_Course.setText(Controller.ErrorHandling(sql.getErrorCode(), ""));
//		   
//			            }catch (NumberFormatException ne) {
//			                textArea_Course.setText("Only integers are allowed in credits");
//		            }
//		            
//		        }
//		        textField_courseName.setText("");
//		        textField_courseCode.setText("");
//		        textField_courseCredits.setText("");
//
//		    }
//		           
//		});
		
	    btnAddCourse.setBounds(287, 31, 113, 23);	
	    panel_Course.add(btnAddCourse); 
	    
	    
	    //Button - Show All Results for Course
	    btnShowAllResults = new JButton("Show all results");
//	    btnShowAllResults.setFont(new Font("Tahoma", Font.BOLD, 10));
//	    btnShowAllResults.addActionListener(new ActionListener() {
//	    	public void actionPerformed(ActionEvent e) {
//	    	textArea_Course.setText("");			
//	    	String courseCode = textField_showResult.getText();
//	    			if (courseCode.isEmpty()) {
//	    				textArea_Course.setText("Please fill in course code.");
//	    			}else {
//	    				try {
//	    					Course course = Controller.findCourse(courseCode);
//	    				
//	    				if (course == null ) {
//	    					String courseNotFound = Controller.courseNotFound(courseCode);
//	    					textArea_Course.setText(courseNotFound);
//	    			}else {
//	    				ArrayList <HasStudied> courseResultList = Controller.showAllStudentResult(courseCode);
//	    			if (courseResultList.isEmpty()) {
//	    					textArea_Course.setText("No students has finished this course.");
//	    			} else {
//	
//	    				for (HasStudied hs : courseResultList) {
//	
//	    					textArea_Course.append("Student: " + hs.getStudentSsn() + " grade: " + hs.getGrade() + "\n");
//	
//	    				}
//	    			}
//	    				
//	    			}
//	    			
//	    			}catch (SQLException sql) {
//	    				textArea_Course.setText(Controller.ErrorHandling(sql.getErrorCode(), ""));
//	    			}
//	    			}
//	    			}
//	    		});
	    		btnShowAllResults.setBounds(267, 248, 133, 23);
	    		panel_Course.add(btnShowAllResults);
		        		
		        		
		//Button - Find Course
		btnFindCourse = new JButton("Find Course");
//		
//				btnFindCourse.addActionListener(new ActionListener() {
//					public void actionPerformed(ActionEvent e) {
//						
//						String courseCode = textField_findCourse.getText();
//						
//						if(courseCode.isEmpty()) {
//							textArea_Course.setText("Please fill in course code.");
//						}else {
//							
//							try {
//								Course c = Controller.findCourse(courseCode);
//								
//								if ( c != null) {
//									textArea_Course.setText
//									("The following Course found; " + "\nCourseCode: " + " " + c.getCourseCode()  + " \nName: " + c.getCourseName() + " \nCredits: " + c.getCredits());
//								
//								}else {
//									String courseNotFound = Controller.courseNotFound(courseCode);
//									textArea_Course.setText(courseNotFound);
//								}
//									
//							} catch (SQLException sql) {
//								textArea_Course.setText(Controller.ErrorHandling(sql.getErrorCode(), ""));
//							}
//						}
//										
//					}
//				});
//		        				
		btnFindCourse.setBounds(287, 154, 113, 23);
		panel_Course.add(btnFindCourse);
		
		JLabel label_2 = new JLabel("Fields marked with (*) are mandatory to fill in.");
		label_2.setForeground(new Color(178, 34, 34));
		label_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_2.setBounds(31, 301, 322, 14);
		panel_Course.add(label_2);
		
		JLabel lblInsertCourseCode = new JLabel("Insert course code in the box below to find course.");
		lblInsertCourseCode.setBounds(22, 138, 255, 14);
		panel_Course.add(lblInsertCourseCode);
		
		textField_findCourse = new JTextField();
		textField_findCourse.setColumns(10);
		textField_findCourse.setBounds(120, 155, 96, 20);
		panel_Course.add(textField_findCourse);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(71, 122, 329, 7);
		panel_Course.add(separator_3);
		
		JLabel lblInsertCourseCode_1 = new JLabel("Insert course code in the box below to show course result");
		lblInsertCourseCode_1.setBounds(22, 225, 365, 14);
		panel_Course.add(lblInsertCourseCode_1);
		
		textField_showResult = new JTextField();
		textField_showResult.setColumns(10);
		textField_showResult.setBounds(120, 249, 96, 20);
		panel_Course.add(textField_showResult);
				
		JPanel panel_Register = new JPanel();
		tabbedPane.addTab("Register", null, panel_Register, null);
		panel_Register.setLayout(null);
			
		//Comboboxar		
		JComboBox <String> comboBoxGrade = new JComboBox <String>();
		comboBoxGrade.addItem("A");
		comboBoxGrade.addItem("B");
		comboBoxGrade.addItem("C");
		comboBoxGrade.addItem("D");
		comboBoxGrade.addItem("E");
		comboBoxGrade.addItem("F");
		comboBoxGrade.setBounds(261, 194, 49, 22);
		panel_Register.add(comboBoxGrade);
						
		
		//ALLT PÅ FLIK REGISTER
		
		JTextArea textArea_Register = new JTextArea();
		textArea_Register.setEditable(false);
		textArea_Register.setBounds(50, 302, 289, 114);
		panel_Register.add(textArea_Register);
		
		//Button - Register Student on Course
		btnRegisterResultCourse = new JButton("Register student on course");
//		btnRegisterResultCourse.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				
//				String ssn = textField_studentSSNRegister.getText();
//				String courseCode = textField_courseCodeRegister.getText();
//				
//				 if(courseCode.isEmpty() || ssn.isEmpty()) {
//					 textArea_Register.setText("Please type in all fields");
//
//				 } else {
//					 try {
//						 Student student = Controller.findStudent(ssn);
//						 Course course = Controller.findCourse(courseCode);
//						 
//						 if (student == null) {
//							 String studentNotFound = Controller.studentNotFound(ssn);
//							 textArea_Register.setText(studentNotFound);
//						
//						 } else if (course == null) {
//							 String courseNotFound = Controller.courseNotFound(courseCode);
//							 textArea_Register.setText(courseNotFound);
//							 
//						 }else {
//							 Controller.addStudentOnCourse(ssn, courseCode);
//							 textArea_Register.setText("StudentName: " + student.getStudentName() + "\nStudentSSN: " + student.getSsn() + "\nWas registred on course: " + course.getCourseName());
//						 }
//					 
//					 }catch (SQLException sql) {
//							 textArea_Register.setText(Controller.ErrorHandling(sql.getErrorCode(), ""));
//						 }
//						 
//						 
//					 }
//			}
//				
//			
//		});
		btnRegisterResultCourse.setBounds(84, 83, 226, 23);
		panel_Register.add(btnRegisterResultCourse);
		
		
		btnRegisterResult = new JButton("Register result");
//		btnRegisterResult_1.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				
//				
//				
//				String ssn = textField_StudentSSN2.getText();
//				String courseCode = textField_courseCode2.getText();
//			    String grade = comboBoxGrade.getSelectedItem().toString();
//			    
//			    if(courseCode.isEmpty() || ssn.isEmpty() || grade.isBlank()) {
//					textArea_Register.setText("Please type in all fields");
//			    } else {
//			    try {
//				Student student = Controller.findStudent(ssn);
//			    Course  course = Controller.findCourse(courseCode);
//			    
//			     if (student == null) {
//					 String studentNotFound = Controller.studentNotFound(ssn);
//					 textArea_Register.setText(studentNotFound);
//				
//				 } else if (course == null) {
//					 String courseNotFound = Controller.courseNotFound(courseCode);
//					 textArea_Register.setText(courseNotFound);
//			    
//			    
//				 } else {	Controller.addStudentOnFinishedCourse(ssn, courseCode, grade);
//			    	textArea_Register.setText("The result [" + grade + "] for following student was added; " + "\nSSN: " + student.getSsn() + "\nStudentname: " + student.getStudentName() + "\nFor course: " + "\nCourseCode: " + course.getCourseCode() + "\nCourseName: " + course.getCourseName());
//
//			    }
//			    } catch (SQLException sql) {
//			    	textArea_Register.setText(Controller.ErrorHandling(sql.getErrorCode(), ""));
//				}
//			}
//			}
//			});
		btnRegisterResult.setBounds(84, 227, 226, 23);
		panel_Register.add(btnRegisterResult);
			
		
		textField_StudentSSN2 = new JTextField();
		textField_StudentSSN2.setBounds(214, 129, 96, 20);
		panel_Register.add(textField_StudentSSN2);
		textField_StudentSSN2.setColumns(10);
		
		JLabel lblStudentSSN2 = new JLabel("Student SSN *");
		lblStudentSSN2.setBounds(84, 132, 82, 14);
		panel_Register.add(lblStudentSSN2);
		
		JLabel lblGrade = new JLabel("Grade *");
		lblGrade.setBounds(84, 198, 85, 14);
		panel_Register.add(lblGrade);
		
		JLabel lblCourseCode = new JLabel("Course code *");
		lblCourseCode.setBounds(84, 157, 82, 20);
		panel_Register.add(lblCourseCode);
		
		textField_courseCode2 = new JTextField();
		textField_courseCode2.setBounds(214, 163, 96, 20);
		panel_Register.add(textField_courseCode2);
		textField_courseCode2.setColumns(10);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(32, 116, 354, 2);
		panel_Register.add(separator_1);
		
		JLabel label_3 = new JLabel("Fields marked with (*) are mandatory to fill in.");
		label_3.setForeground(new Color(178, 34, 34));
		label_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_3.setBounds(50, 281, 322, 14);
		panel_Register.add(label_3);
		
		
		textField_courseCodeRegister = new JTextField();
		textField_courseCodeRegister.setColumns(10);
		textField_courseCodeRegister.setBounds(214, 12, 96, 20);
		panel_Register.add(textField_courseCodeRegister);
		
		JLabel label_6 = new JLabel("Course code *");
		label_6.setBounds(84, 15, 93, 14);
		panel_Register.add(label_6);
		
		JLabel label_7 = new JLabel("Student SSN *");
		label_7.setBounds(84, 45, 82, 14);
		panel_Register.add(label_7);
		
		textField_studentSSNRegister = new JTextField();
		textField_studentSSNRegister.setColumns(10);
		textField_studentSSNRegister.setBounds(214, 42, 96, 20);
		panel_Register.add(textField_studentSSNRegister);
	
	}
	// GETTERS FOR CONTROLLER

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
	public JTextField getTextField_courseCode() {
		return textField_courseCode;
	}
	public JTextField getTextField_courseName() {
		return textField_courseName;
	}
	public JTextField getTextField_ssn() {
		return textField_ssn;
	}
	public JTextField getTextField_courseCredits() {
		return textField_courseCredits;
	}
	public JButton getBtnAddStudent() {
		return btnAddStudent;
	}
	public JButton getBtnAddCourse() {
		return btnAddCourse;
	}
	public JButton getBtnFindStudent() {
		return btnFindStudent;
	}
	public JButton getBtnFindCourse() {
		return btnFindCourse;
	}
	public JButton getBtnShowStudentResult() {
		return btnShowStudentResult;
	}
	public JButton getBtnShowAllResults() {
		return btnShowAllResults;
	}
	public JButton getbtnRegisterResultCourse() {
		return btnRegisterResultCourse;
	}
	public JButton getbtnRegisterResult() {
		return btnRegisterResult;
	}
	
	public JButton getBtnShowAllCourses() {
		return btnShowAllCourses;
	}
	public JButton getBtnShowAllStudents() {
		return btnShowAllStudents;
	}
	public JTextField getTextField_StudentName() {
		return textField_StudentName;
	}
	public JTextField getTextField_StudentAddress() {
		return textField_StudentAddress;
	}
	public JTextField getTextField_studentFind() {
		return textField_studentFind;
	}
	public JTextField getTextField_findCourse() {
		return textField_findCourse;
	}
	public JTextField getTextField_showResult() {
		return textField_showResult;
	}
	public JTextField getTextField_courseCodeResult() {
		return textField_courseCodeResult;
	}
	public JTextField getTextField_StudentSSNResult() {
		return textField_StudentSSNResult;
	}
	public JTextField getTextField_courseCodeRegister() {
		return textField_courseCodeRegister;
	}
	public JTextField getTextField_studentSSNRegister() {
		return textField_studentSSNRegister;
	}
	public JTable getTable_Course() {
		return table_Course;
	}
	public JTable getTable_Student() {
		return table_Student;
	}
	public JTextArea getTextArea_Student() {
		return textArea_Student;
	}
	public JTextArea getTextArea_Course() {
		return textArea_Course;
	}
	public JTextArea getTextArea_Register() {
		return textArea_Register;
	}
	public void setTextField_StudentSSN2(JTextField textField_StudentSSN2) {
		this.textField_StudentSSN2 = textField_StudentSSN2;
	}
	public void setTextField_courseCode2(JTextField textField_courseCode2) {
		this.textField_courseCode2 = textField_courseCode2;
	}
	public void setTextField_courseCode(JTextField textField_courseCode) {
		this.textField_courseCode = textField_courseCode;
	}
	public void setTextField_courseName(JTextField textField_courseName) {
		this.textField_courseName = textField_courseName;
	}
	public void setTextField_ssn(JTextField textField_ssn) {
		this.textField_ssn = textField_ssn;
	}
	public void setTextField_courseCredits(JTextField textField_courseCredits) {
		this.textField_courseCredits = textField_courseCredits;
	}
	public void setBtnAddStudent(JButton btnAddStudent) {
		this.btnAddStudent = btnAddStudent;
	}
	public void setBtnAddCourse(JButton btnAddCourse) {
		this.btnAddCourse = btnAddCourse;
	}
	public void setBtnFindStudent(JButton btnFindStudent) {
		this.btnFindStudent = btnFindStudent;
	}
	public void setBtnFindCourse(JButton btnFindCourse) {
		this.btnFindCourse = btnFindCourse;
	}
	public void setBtnShowStudentResult(JButton btnShowStudentResult) {
		this.btnShowStudentResult = btnShowStudentResult;
	}
	public void setBtnShowAllResults(JButton btnShowAllResults) {
		this.btnShowAllResults = btnShowAllResults;
	}
	public void setbtnRegisterResultCourse(JButton btnRegisterResultCourse) {
		this.btnRegisterResultCourse = btnRegisterResultCourse;
	}
	public void setbtnRegisterResult(JButton btnRegisterResult) {
		this.btnRegisterResult = btnRegisterResult;
	}
	public void setBtnShowAllCourses(JButton btnShowAllCourses) {
		this.btnShowAllCourses = btnShowAllCourses;
	}
	public void setBtnShowAllStudents(JButton btnShowAllStudents) {
		this.btnShowAllStudents = btnShowAllStudents;
	}
	public void setTextField_StudentName(JTextField textField_StudentName) {
		this.textField_StudentName = textField_StudentName;
	}
	public void setTextField_StudentAddress(JTextField textField_StudentAddress) {
		this.textField_StudentAddress = textField_StudentAddress;
	}
	public void setTextField_studentFind(JTextField textField_studentFind) {
		this.textField_studentFind = textField_studentFind;
	}
	public void setTextField_findCourse(JTextField textField_findCourse) {
		this.textField_findCourse = textField_findCourse;
	}
	public void setTextField_showResult(JTextField textField_showResult) {
		this.textField_showResult = textField_showResult;
	}
	public void setTextField_courseCodeResult(JTextField textField_courseCodeResult) {
		this.textField_courseCodeResult = textField_courseCodeResult;
	}
	public void setTextField_StudentSSNResult(JTextField textField_StudentSSNResult) {
		this.textField_StudentSSNResult = textField_StudentSSNResult;
	}
	public void setTextField_courseCodeRegister(JTextField textField_courseCodeRegister) {
		this.textField_courseCodeRegister = textField_courseCodeRegister;
	}
	public void setTextField_studentSSNRegister(JTextField textField_studentSSNRegister) {
		this.textField_studentSSNRegister = textField_studentSSNRegister;
	}
	public void setTable_Course(JTable table_Course) {
		this.table_Course = table_Course;
	}
	public void setTable_Student(JTable table_Student) {
		this.table_Student = table_Student;
	}
	public void setTextArea_Student(JTextArea textArea_Student) {
		this.textArea_Student = textArea_Student;
	}
	public void setTextArea_Course(JTextArea textArea_Course) {
		this.textArea_Course = textArea_Course;
	}
	public void setTextArea_Register(JTextArea textArea_Register) {
		this.textArea_Register = textArea_Register;
	}

	
}