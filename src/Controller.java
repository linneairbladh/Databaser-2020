import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;



public class Controller {
	
	private UniversityApplication frame;
	private DAL dal;
	private ErrorHandlingSQL error;
	
    
    public Controller(UniversityApplication frame, DAL dal, ErrorHandlingSQL error ) {
    	this.frame = frame;
    	this.dal = dal;
    	this.error = error;
    	
    	declareEvents();
    
    }

    
    public void declareEvents () {	
    	//Knapp för att fram listan Show All Students
    	frame.getBtnShowAllStudents().addActionListener(new ActionListener() {
          	 public void actionPerformed(ActionEvent e) {
          		try {

					DefaultTableModel studentTable = (DefaultTableModel) frame.getTable_Student().getModel();
					studentTable.setRowCount(0);
					for (Student s : dal.getAllStudents()) {
						studentTable.addRow(new String[] { s.getSsn(), s.getStudentName(), s.getAddress() });
					}
					
				} catch (Exception e1) {
					e1.printStackTrace();

				}

			}
		});	 
          		 
          
    	//Knapp för att ta fram listan Show All Courses
    	frame.getBtnShowAllCourses().addActionListener(new ActionListener() {
          	 public void actionPerformed(ActionEvent e) {
          		 
          		try {

					DefaultTableModel courseTable = (DefaultTableModel) frame.getTable_Course().getModel();
					courseTable.setRowCount(0);
					for (Course c : dal.getAllCourses()) {
						courseTable.addRow(new String[] { c.getCourseCode(), c.getCourseName() });
					}
						
					} catch (Exception e1) {
						e1.printStackTrace();

					}

					
				}
			});
    	
    	
    	//Knapp Add Student
    	
    	frame.getBtnAddStudent().addActionListener(new ActionListener() {
       	 public void actionPerformed(ActionEvent e) {
       		 
       		String name = frame.getTextField_StudentName().getText();
			String address = frame.getTextField_StudentAddress().getText();
			String ssn = frame.getTextField_ssn().getText();
			
			 if(name.isEmpty() || address.isEmpty() || ssn.isEmpty()) {
				 frame.getTextArea_Student().setText("Please type in all fields");
            }else {
                
                try {
                  
                        dal.addStudent(ssn, name, address);
                        frame.getTextArea_Student().setText("Following student added; " +" \nStudentSSN :" + ssn + " \nStudent :" + name + " \nStudentAdress :" + address );
                        
                    }catch (SQLException sql){
                    	 frame.getTextArea_Student().setText(error.MessageFailureCode(sql.getErrorCode(),""));
                    			 
                    }    
                    
                
            }
			 frame.getTextField_StudentName().setText("");	
			 frame.getTextField_StudentAddress().setText("");
			 frame.getTextField_ssn().setText("");

       		 
       	 }
    	});
    	
    	
    	//Knapp Find Student
    	frame.getBtnFindStudent().addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
			String ssn = frame.getTextField_studentFind().getText();
					
			
			if(ssn.isEmpty()){
				frame.getTextArea_Student().setText("Please type in all fields");
			}
			if(!ssn.isEmpty()) {
				try {
					Student s = dal.findStudent(ssn);
						
					if(s == null) {
						frame.getTextArea_Student().setText("Unable to find a student with the given SSN, check spelling ETC");
					} else {
						frame.getTextArea_Student().setText("The following student found; " + "\nSSN: " + s.getSsn() + "\nStudentname: " + s.getStudentName() + "\nStudent Address: " + s.getAddress());
					}
				} catch (SQLException sql) {
					frame.getTextArea_Student().setText(error.MessageFailureCode(sql.getErrorCode(),""));
				}
			}
			
			
			
			}	
		});
    	
    	//Knapp Show Student Result
    	frame.getBtnShowStudentResult().addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {	
    	
	
			String ssn = frame.getTextField_StudentSSNResult().getText();
			String courseCode = frame.getTextField_courseCodeResult().getText();
					
			
			if(ssn.isEmpty() || courseCode.isEmpty()) {
				frame.getTextArea_Student().setText("Please type in all fields");
			}else {
				try {
					Student student = dal.findStudent(ssn);
					Course course = dal.findCourse(courseCode);
					
					
					if(student == null || course == null) {
						frame.getTextArea_Student().setText("That student or course does not exist");
					}else {
						ArrayList<HasStudied> hasstudiedlist = dal.ShowAllCourseResult(ssn, courseCode);
						if (hasstudiedlist.isEmpty()) {
							frame.getTextArea_Student().setText("Student with SSN: " + student.getSsn() + " has not examined from the course");
						}else {
							String sr = "";
							for (HasStudied x : hasstudiedlist) {
								sr = sr + x.toString() + "\n";
								
							}
							frame.getTextArea_Student().setText(sr);
							
						}
					}
				}catch (SQLException sql) {
					frame.getTextArea_Student().setText(error.MessageFailureCode(sql.getErrorCode(),""));
				}
			}
			
			frame.getTextField_StudentSSNResult().setText("");
			frame.getTextField_courseCodeResult().setText("");
			
        	}
		
	});
    	
  	
    	
    	//Knapp Add Course
    	frame.getBtnAddCourse().addActionListener(new ActionListener() {
    	 public void actionPerformed(ActionEvent e) {
 		    
 		    	String courseCode = frame.getTextField_courseCode().getText();
 		    	String courseName = frame.getTextField_courseName().getText();
 		        String credits  = frame.getTextField_courseCredits().getText();
        
 		        if(courseCode.isEmpty() || courseName.isEmpty() || credits.isEmpty()) {
 		        	frame.getTextArea_Course().setText("Please type in all fields");
 		        }else {
 		    
 		                try {
 		                    
 		                    Integer credit = Integer.parseInt(frame.getTextField_courseCredits().getText());
 		                    dal.addCourse(courseCode, courseName, credit);
 		                   frame.getTextArea_Course().setText("Following Course added; " + "\nCourseCode: " + courseCode + "\nCourseName :" + courseName + "\nCredits: " + credits);
 		                    
 		                    
 		                }catch (SQLException sql){
 		                	//frame.getTextArea_Course().setText(Controller.ErrorHandling(sql.getErrorCode(), ""));
 		   
 			            }catch (NumberFormatException ne) {
 			            	frame.getTextArea_Course().setText("Only integers are allowed in credits");
 		            }
 		            
 		        }
 		       frame.getTextField_courseName().setText("");
 		       frame.getTextField_courseCode().setText("");
 		       frame.getTextField_courseCredits().setText("");
 
 		    }
 		           
 		});
    	
    	//knapp Find Course
    	frame.getBtnFindCourse().addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e) {
    			
    			String courseCode = frame.getTextField_findCourse().getText();
				
				if(courseCode.isEmpty()) {
					frame.getTextArea_Course().setText("Please fill in course code.");
					
				}else {
					
					try {
						Course c = dal.findCourse(courseCode);
						
						if ( c != null) {
							frame.getTextArea_Course().setText
							("The following Course found; " + "\nCourseCode: " + " " + c.getCourseCode()  + " \nName: " + c.getCourseName() + " \nCredits: " + c.getCredits());
						
						}else {
							String courseNotFound = dal.courseNotFound(courseCode);
							frame.getTextArea_Course().setText(courseNotFound);
						}
							
					} catch (SQLException sql) {
						frame.getTextArea_Course().setText(sql.getMessage());
						//frame.getTextArea_Course().setText(dal.ErrorHandling(sql.getErrorCode(), ""));
    			
    			
    		}
    		
    		
    	}
    }
    
    
    
    	});
    	
    	
    	
   
    	//Dessa måsvingar = slut på metod och hela klassen
	}
}

    	
    
//	//Lägger till student på kurs
//	   public static void addStudentOnCourse (String ssn, String courseCode) throws SQLException {
//	        dal.addStudentOnCourse(ssn, courseCode);      
//	    }
//	   
//	 //Lägger till student på kurs
//	   public static void addStudentOnFinishedCourse (String ssn, String courseCode, String grade) throws SQLException {
//	        dal.addStudentOnFinishedCourse(ssn, courseCode, grade);     
//	    }
//	   
//	 
//	   //Lägg till student!
//	    public static void addStudent (String ssn, String studentName, String address) throws SQLException {
//	    	dal.addStudent(ssn, studentName, address);
//		} 
//	//Lägg till kurs!
//	    public static void addCourse (String courseCode, String courseName,int credits) throws SQLException {
//	    	dal.addCourse(courseCode, courseName, credits);
//             
//	    }
//    
//    //Hitta kurs!
//	    public static Course findCourse(String courseCode) throws SQLException {
//	    	return dal.findCourse(courseCode);
//	    }
//	
//    //Hitta student!
//	    public static Student findStudent(String ssn) throws SQLException {
//	    	return dal.findStudent(ssn);
//	    	
//	
//
//	    }
//	    
//	    public static Student findCurrentlyStudyingStudent(String ssn) throws SQLException {
//	    	return dal.findCurrentlyStudyingStudent(ssn);
//	    }
//
//	
//	//Visar alla studenter genom ArrayList
//	    public static ArrayList <Student> getAllStudents() throws SQLException {
//	    	return dal.getAllStudents();
//	    }
//	
//	//Visar alla kurser genom ArrayList
//	    public static ArrayList <Course> getAllCourses () throws SQLException {
//	    	return dal.getAllCourses();	
//	    }	
//				
//	//Visar alla resultat för en kurs. 
//		public static ArrayList<HasStudied> showAllStudentResult (String courseCode) throws SQLException {
//			return  dal.ShowAllStudentResult(courseCode);
//		}
// 	
//	 //Visar alla resultat på en student
//
//	   public static ArrayList<HasStudied> showResult(String ssn, String courseCode) throws SQLException {
//			return  dal.ShowAllCourseResult(ssn, courseCode);
//		}
//	
//	
//		public static String courseNotFound(String string) throws SQLException{
//			return dal.courseNotFound(string);
//		}
//
//		public static String studentNotFound(String string) throws SQLException {
//			return dal.studentNotFound(string);
//
//	}
//	
//	//Errorhandling
//	public static String ErrorHandling (int failureCode, String prefix)  {
//			return ErrorHandlingSQL.MessageFailureCode(failureCode, prefix);
//	}

	
