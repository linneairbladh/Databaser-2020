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
        //sql.close();
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
			ssn = resultset.getString("ssn");
			String studentName = resultset.getString("studentName");
			String address = resultset.getString("address");
			s = new Student(ssn, studentName, address);

			conn.close();
			return s;
		}
		return null;
		
		}

	
	public Student findCurrentlyStudyingStudent(String ssn) throws SQLException {
		Student stud;
		   String sqlString = "SELECT * FROM Studies WHERE ssn = '" + ssn + "';";
				   ResultSet resultSet = runExecuteQuery(sqlString);
		   if (resultSet.next()) {
			   ssn = resultSet.getString("ssn");
			   String name = resultSet.getString("studentName");
			   String address = resultSet.getString("address");
			   
			    stud = new Student (ssn, name, address);
					  
					   conn.close();
					   return stud;
		   }
		   return null;
		
	}
	
	
	//Hitta kurs!
    public Course findCourse(String courseCode) throws SQLException {
        Course c;
    	String sqlString = "SELECT * FROM Course WHERE courseCode = '" + courseCode + "';";
        ResultSet rs = runExecuteQuery(sqlString);
        if (rs.next()) {
            courseCode = rs.getString("courseCode");
            String courseName = rs.getString("courseName");
            int credits = rs.getInt("credits");
            c = new Course(courseCode, courseName, credits);
   
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
			String courseCode = rs.getString("courseCode");
			String courseName = rs.getString("courseName");
			int credits = rs.getInt("credits");
					
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
			String ssn = rs.getString("ssn");
			String studentName = rs.getString("studentName");
			String address = rs.getString("address");
				
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
		String sqlString = "SELECT * FROM hasStudied WHERE courseCode = ' " + courseCode + "' AND ssn = '" + ssn + "';";
		ResultSet rs = runExecuteQuery(sqlString);
		
		if (rs.next()) {
			
			 ssn = rs.getString("ssn"); 
			 courseCode = rs.getString("courseCode");
			 grade = rs.getString("grade");
			 hs = new HasStudied(ssn, courseCode, grade);	
		}
		
		  conn.close();      
	      return hs;
				
	}
	
	//Lista på alla kursers resultat!
	public ArrayList <HasStudied> ShowAllCourseResult (String ssn, String courseCode) throws SQLException {
		ArrayList <HasStudied> courseResultList = new ArrayList <HasStudied>();
		String sqlString = "SELECT * FROM hasStudied WHERE ssn = '" + ssn + "' AND courseCode = '" + courseCode + "';";
		
		ResultSet rs = runExecuteQuery(sqlString);
		
		while (rs.next()) {
			String ssn1 = rs.getString("ssn");
			String courseCode1 = rs.getString("courseCode");
			String grade = rs.getString("grade");
					
			HasStudied hs = new HasStudied(ssn1, courseCode1, grade);
			courseResultList.add(hs);
		}
		  //sql.close();
	      conn.close();      
	      return courseResultList;
	}
	
	// Lista på alla studenters resultat!
	public ArrayList <HasStudied> ShowAllStudentResult (String courseCode) throws SQLException {
		ArrayList <HasStudied> studentResultList = new ArrayList <HasStudied>();
		String sqlString = "SELECT * FROM hasStudied WHERE  courseCode = '" + courseCode + "';";
		
		ResultSet rs = runExecuteQuery(sqlString);
		
		while (rs.next()) {
			String studentSsn = rs.getString("ssn");
			String specCourseCode = rs.getString("courseCode");
			String grade = rs.getString("grade");
					
			HasStudied hs = new HasStudied(studentSsn, specCourseCode, grade);
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