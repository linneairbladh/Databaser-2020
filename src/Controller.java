import java.sql.SQLException;
import java.util.ArrayList;


public class Controller {
	
	static DAL dataAccessLayer = new DAL();
	
    
	//Constructor
    public Controller() {
    }

	//Add student to Course
    public static void addStudentOnCourse (String ssn, String courseCode) throws SQLException {
	        dataAccessLayer.addStudentOnCourse(ssn, courseCode);      
	}
	   
	//Add student to finished course
	public static void addStudentOnFinishedCourse (String ssn, String courseCode, String grade) throws SQLException {
	        dataAccessLayer.addStudentOnFinishedCourse(ssn, courseCode, grade);     
	}
	   
	//Add Student
    public static void addStudent (String ssn, String studentName, String address) throws SQLException {
	    	dataAccessLayer.addStudent(ssn, studentName, address);
	} 
    
	//Add Course
    public static void addCourse (String courseCode, String courseName,int credits) throws SQLException {
	    	dataAccessLayer.addCourse(courseCode, courseName, credits);    
	}
    
    //Find Course
    public static Course findCourse(String courseCode) throws SQLException {
	    	return dataAccessLayer.findCourse(courseCode);
	}
	
    //Find Student
    public static Student findStudent(String ssn) throws SQLException {
	    	return dataAccessLayer.findStudent(ssn);
	}
    
	//Find Currently Studying Students    
    public static Student findCurrentlyStudyingStudent(String ssn) throws SQLException {
	    	return dataAccessLayer.findCurrentlyStudyingStudent(ssn);
	}
	
	//Show all Students ArrayList
    public static ArrayList <Student> getAllStudents() throws SQLException {
	    	return dataAccessLayer.getAllStudents();
	}
	
	//Show all Courses ArrayList
    public static ArrayList <Course> getAllCourses () throws SQLException {
	    	return dataAccessLayer.getAllCourses();	
	}	
				
	//Show all results for Course 
    public static ArrayList<HasStudied> showAllStudentResult (String courseCode) throws SQLException {
			return  dataAccessLayer.ShowAllStudentResult(courseCode);
	}
 	
	 //All results for Student

    public static ArrayList<HasStudied> showResult(String ssn, String courseCode) throws SQLException {
			return  dataAccessLayer.ShowAllCourseResult(ssn, courseCode);
	}
	
	// If course is not found
	public static String courseNotFound(String string) throws SQLException{
			return dataAccessLayer.courseNotFound(string);
	}

	// If Student is not found
	public static String studentNotFound(String string) throws SQLException {
			return dataAccessLayer.studentNotFound(string);
	}
	
	//Errorhandling
	public static String ErrorHandling (int failureCode, String prefix)  {
			return ErrorHandlingSQL.MessageFailureCode(failureCode, prefix);
	}

}
