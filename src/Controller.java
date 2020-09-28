import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class Controller {
	
	static DAL dataAccessLayer = new DAL();
	static ErrorHandlingSQL error = new ErrorHandlingSQL();
    
    public Controller() {
    
    }

	//Lägger till student på kurs
	   public static void addStudentOnCourse (String ssn, String courseCode) throws SQLException {
	        dataAccessLayer.addStudentOnCourse(ssn, courseCode);      
	    }
	   
	 //Lägger till student på kurs
	   public static void addStudentOnFinishedCourse (String ssn, String courseCode, String grade) throws SQLException {
	        dataAccessLayer.addStudentOnFinishedCourse(ssn, courseCode, grade);     
	    }
	   
	 
	   //Lägg till student!
	    public static void addStudent (String ssn, String studentName, String address) throws SQLException {
	    	dataAccessLayer.addStudent(ssn, studentName, address);
		} 
	//Lägg till kurs!
	    public static void addCourse (String courseName, String courseCode,int credits) throws SQLException {
	    	dataAccessLayer.addCourse(courseCode, courseName, credits);
             
	    }
    
    //Hitta kurs!

    public static Course findCourse(String courseCode) throws SQLException {
        return dataAccessLayer.findCourse(courseCode);
    }

    //Lägg till student!
    public static void addStudent (String ssn, String studentName, String address) throws SQLException {
    	dataAccessLayer.addStudent(ssn, studentName, address);
	}

	    public static Course findCourse(String courseCode) throws SQLException {
	    	return dataAccessLayer.findCourse(courseCode);
	    }

	
    //Hitta student!
	    public static Student findStudent(String ssn) throws SQLException {
	    	return dataAccessLayer.findStudent(ssn);
	    }
	    
	    public static Student findCurrentlyStudyingStudent(String ssn) throws SQLException {
	    	return dataAccessLayer.findCurrentlyStudyingStudent(ssn);
	    }
	
	//Visar alla studenter genom ArrayList
	    public List <Student> getAllStudents() throws SQLException {
	    	return this.dataAccessLayer.getAllStudents();
	    }
	
	//Visar alla kurser genom ArrayList
	    public List <Course> getAllCourses () throws SQLException {
	    	return this.dataAccessLayer.getAllCourses();	
	    }	
				
	//Visar alla resultat för en kurs. 
		public static ArrayList<HasStudied> showAllStudentResult (String courseCode) throws SQLException {
			return  dataAccessLayer.ShowAllStudentResult(courseCode);
		}
 	
	 //Visar alla resultat på en student

	   public static ArrayList<HasStudied> showResult(String ssn, String courseCode) throws SQLException {
			return  dataAccessLayer.ShowAllCourseResult(ssn, courseCode);
		}
	
	
		public static String courseNotFound(String string) {
			return dataAccessLayer.courseNotFound(string);
		}

		public static String studentNotFound(String string) {
			return dataAccessLayer.studentNotFound(string);
		}
		
		public static String ErrorHandling (int failureCode, String prefix) {
			return  error.MessageFailureCode(failureCode, prefix);
		}
	
	

	
	/*public void declareEvents() {
		universityApplication.getButton_FindCourse().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String courseCode = universityApplication.getTextField_courseCode().getText();
				try {
					ResultSet courseResultSet = dataAccessLayer.getCourse(courseCode);
					
					while(courseResultSet.next()) {
						String cCourseCode = courseResultSet.getString("courseCode");
						String cCourseName = courseResultSet.getString("courseName");
						String cCredits = courseResultSet.getString("credits");
						
						universityApplication.getTextField_courseCode().setText(cCourseCode);
						universityApplication.getTextField_courseCode().setText(cCourseName);
						universityApplication.getTextField_courseCode().setText(cCredits);
					}
					courseResultSet.close();
				} catch(SQLException sqlException) {
					
				}
			}
		});

		universityApplication.getButton_AddCourse().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					addallcourses(e); 
			}
		});
		
		
		universityApplication.getButton_AddStudent().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Studentssn = universityApplication.getTextField_ssn().getText();
				String StudentstudentName = universityApplication.getTextField_studentName().getText();
			
				try {
					dataAccessLayer.InsertStudent(Studentssn, StudentstudentName);
				} catch(SQLException sqlException) {
			}
		}
	});
	}
	public DAL getDataAccessLayer() {
		return dataAccessLayer;
	}
	public void setDataAccessLayer(DAL dataAccessLayer) {
		this.dataAccessLayer = dataAccessLayer;
	}
	public UniversityApplication getUniversityApplication() {
		return universityApplication;
	}
	public void setUniversityApplication(UniversityApplication universityApplication) {
		this.universityApplication = universityApplication;
	}
	
*/
	}

	





