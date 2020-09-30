import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class Controller {
	
	static DAL dataAccessLayer = new DAL();
	
    
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
	    public static void addCourse (String courseCode, String courseName,int credits) throws SQLException {
	    	dataAccessLayer.addCourse(courseCode, courseName, credits);
             
	    }
    
    //Hitta kurs!
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
	    public static ArrayList <Student> getAllStudents() throws SQLException {
	    	return dataAccessLayer.getAllStudents();
	    }
	
	//Visar alla kurser genom ArrayList
	    public static ArrayList <Course> getAllCourses () throws SQLException {
	    	return dataAccessLayer.getAllCourses();	
	    }	
				
	//Visar alla resultat för en kurs. 
		public static ArrayList<HasStudied> showAllStudentResult (String courseCode) throws SQLException {
			return  dataAccessLayer.ShowAllStudentResult(courseCode);
		}
 	
	 //Visar alla resultat på en student

	   public static ArrayList<HasStudied> showResult(String ssn, String courseCode) throws SQLException {
			return  dataAccessLayer.ShowAllCourseResult(ssn, courseCode);
		}
	
	
		public static String courseNotFound(String string) throws SQLException{
			return dataAccessLayer.courseNotFound(string);
		}

		public static String studentNotFound(String string) throws SQLException {
			return dataAccessLayer.studentNotFound(string);

	}
	
	//Errorhandling
	public static String ErrorHandling (int failureCode, String prefix)  {
			return ErrorHandlingSQL.MessageFailureCode(failureCode, prefix);
	}

		}
		

