import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

public class DAL {


	private Connection conn = null;
    private PreparedStatement sql = null;
    
    public DAL() {     
    	
    }
    
    //Starta kopplingen, kör sql och få restultset
    private ResultSet runExecuteQuery(String sqlString) throws SQLException {
        conn = Sqlcon.getConnection();
        sql = conn.prepareStatement(sqlString);
        ResultSet rs = sql.executeQuery();
        return rs;
    }
    
    //Starta kopplingen, kör sql och uppdatera 
    private void runExecuteUpdate (String sqlString) throws SQLException {
        conn = Sqlcon.getConnection();
        sql = conn.prepareStatement(sqlString);
        sql.executeUpdate();
    }

    ///////// Metoder
    
  //Lägg till student!
  	public void addStudent(String ssn, String studentName, String address) throws SQLException {
  		String sqlString = "INSERT INTO Student VALUES( '" + ssn + "', '" + studentName + "', '" + address + "');";
  		runExecuteUpdate(sqlString);
  		conn.close();
  	}
  	
    //Lägg till kurs! 
	public void addCourse(String courseCode, String courseName, int credits) throws SQLException {
        String sqlString = "INSERT INTO Course VALUES ( '" + courseCode + "', '" + courseName + "', " + credits + ");";
        runExecuteUpdate(sqlString);
        conn.close();
            
    }
	
	//Registrerar student på kurs!
		public void addStudentOnCourse (String ssn, String courseCode) throws SQLException {
	  		String sqlString = "INSERT INTO Studies VALUES( '" + ssn + "', '" + courseCode + "');";
	  		runExecuteUpdate(sqlString);
	  		conn.close();
	  	}
	  	
	//Registrerar resultat för en student på en kurs!
		public void addStudentOnFinishedCourse (String ssn, String courseCode, String grade) throws SQLException {
	  		String sqlString = "INSERT INTO HasStudied VALUES('" + ssn + "', '" + courseCode + "', '" + grade + "');";
	  		runExecuteUpdate(sqlString);
	  		conn.close();
	  	}
	
	//Hitta student!
	public Student findStudent(String ssn) throws SQLException {
		Student s;
		String sqlString = "SELECT * FROM Student WHERE ssn = '" + ssn + "'";

		ResultSet resultset = runExecuteQuery(sqlString);
		if (resultset.next()) {
			ssn = resultset.getString(1);
			String name = resultset.getString(2);
			String address = resultset.getString(3);
			s = new Student(ssn, name, address);

		ResultSet resultSet = runExecuteQuery(sqlString);
		if (resultSet.next()) {
			ssn = resultSet.getString(1);
			String name = resultSet.getString(2);
			String email = resultSet.getString(3);
			s = new Student(ssn, name, email);

			conn.close();
			return s;
		}
		return null;
		
		
	}
	



    ///////// Metoder
 
	


	public Student findCurrentlyStudyingStudent(String ssn) throws SQLException {
		Student stud;
		   String sqlString = "SELECT * FROM Studies WHERE ssn = '" + ssn + "';";
				   ResultSet resultSet = runExecuteQuery(sqlString);
		   if (resultSet.next()) {
			   ssn = resultSet.getString(1);
			   String name = resultSet.getString(2);
			   String address = resultSet.getString(3);
			   
			    stud = new Student (ssn, name, address);
					  
					   conn.close();
					   return stud;
		   }
		   return null;
		
	}
	
	

	
	//Hitta kurs!
    public Course findCourse(String courseCode) throws SQLException {
        String sqlString = "SELECT * FROM Course WHERE courseCode = '" + courseCode + "';";
        ResultSet rs = runExecuteQuery(sqlString);
        if (rs.next()) {
            courseCode = rs.getString(1);
            String courseName = rs.getString(2);
            int credits = rs.getInt(3);
            Course c = new Course(courseCode, courseName, credits);
            sql.close();
            conn.close();      
            return c;
        
        }
        return null;
    }
   
    
		//Hittar alla kurser!
	public ArrayList<Course> getAllCourses() throws SQLException{
		ArrayList <Course> courseList = new ArrayList <Course>(); 
		String sqlString = "SELECT * FROM Course";
		
		ResultSet rs = runExecuteQuery(sqlString);
		while (rs.next()) {
			String courseCode = rs.getString(1);
			String courseName = rs.getString(2);
			int credits = rs.getInt(3);
					
			Course course = new Course(courseCode, courseName, credits);
			courseList.add(course);
	}
	  sql.close();
      conn.close();      
      return courseList;
	
}
	
	//Hittar alla studenter!
	public ArrayList<Student> getAllStudents() throws SQLException{
		ArrayList <Student> studentList = new ArrayList <Student>(); 
		String sqlString = "SELECT * FROM Student";
	
	ResultSet rs = runExecuteQuery(sqlString);
	while (rs.next()) {
		String ssn = rs.getString(1);
		String studentName = rs.getString(2);
		String address = rs.getString(3);
				
		Student student = new Student(ssn, studentName, address);
		studentList.add(student);
	}
		sql.close();
		conn.close();      
		return studentList;

}

		//Hittar en students betyg för en kurs!
	public HasStudied ShowStudentResult (String ssn, String courseCode, String grade) throws SQLException{
		
		HasStudied hs = null;
		String sqlString = "SELECT * FROM HasStudied WHERE coursCode = ' " + courseCode + "' AND ssn = '" + ssn + "';";
		ResultSet rs = runExecuteQuery(sqlString);
		
		if (rs.next()) {
			
			 courseCode = rs.getString(1);
			 ssn = rs.getString(2);
			 grade = rs.getString(3);
			 hs = new HasStudied(ssn, courseCode, grade);	
		}
		
		  conn.close();      
	      return hs;
				
	}
	
	//Lista på alla kursers resultat!
	public ArrayList <HasStudied> ShowAllCourseResult (String ssn, String courseCode) throws SQLException {
		ArrayList <HasStudied> courseResultList = new ArrayList <HasStudied>();
		String sqlString = "SELECT * FROM HasStudied WHERE ssn = '" + ssn + "' AND courseID = '" + courseCode + "';";
		
		ResultSet rs = runExecuteQuery(sqlString);
		
		while (rs.next()) {
			String ssn1 = rs.getString(1);
			String courseCode1 = rs.getString(2);
			String grade = rs.getString(3);
					
			HasStudied hs = new HasStudied(ssn1, courseCode1, grade);
			courseResultList.add(hs);
	}
	  sql.close();
      conn.close();      
      return courseResultList;
		}
	
	// Lista på alla studenters resultat!
	public ArrayList <HasStudied> ShowAllStudentResult (String courseCode) throws SQLException {
		ArrayList <HasStudied> studentResultList = new ArrayList <HasStudied>();
		String sqlString = "SELECT * FROM HasStudied WHERE  courseID = '" + courseCode + "';";
		
		ResultSet rs = runExecuteQuery(sqlString);
		
		while (rs.next()) {
			String ssn1 = rs.getString(1);
			String courseCode1 = rs.getString(2);
			String grade = rs.getString(3);
					
			HasStudied hs = new HasStudied(ssn1, courseCode1, grade);
			studentResultList.add(hs);
		}
      conn.close();      
      return studentResultList;
		}
		
	
	
	//Om en student inte finns!
	public String studentNotFound(String str) {
		String studentNotExistMessage = "The student was not found";
		return studentNotExistMessage;
	}
	
	//Om en kurs inte finns!
	public String courseNotFound(String str) {
		String courseNotExistMessage = "The course was not found";
		return courseNotExistMessage;
	}

	
	
			

			
}		

	