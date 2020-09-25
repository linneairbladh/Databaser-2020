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
	
	//Hitta student!
	public Student findStudent(String ssn) throws SQLException {
		Student student;
		String sqlString = "SELECT * FROM Student WHERE ssn = '" + ssn + "'";
		ResultSet resultset = runExecuteQuery(sqlString);
		if (resultset.next()) {
			ssn = resultset.getString(1);
			String name = resultset.getString(2);
			String email = resultset.getString(3);
			student = new Student(ssn, name, email);
			conn.close();
			return student;
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
   
    
    
    
			//Get all courses
			public ArrayList<Course> getAllCourses() throws SQLException{
				Connection conn = null;
				PreparedStatement sql = null;
			try {
				conn = Sqlcon.getConnection();
				sql = conn.prepareStatement("SELECT * FROM Course");
				
				ResultSet rSet = sql.executeQuery();
			
				ArrayList<Course> allC = new ArrayList<>();
				while(rSet.next()) {
					String courseCode = rSet.getString("courseCode");
					String courseName = rSet.getString("courseName");
					int credits = rSet.getInt("credits");
				
				Course c = new Course(courseCode, courseName, credits);
				allC.add(c);
				
				}
				return allC;
				
			} finally {
				Sqlcon.closeSqlCon(conn, sql);
			}
			}
			
			

			
			/*/// add new course
			public boolean addCourse(Course c) throws SQLException{
				String courseCode = c.getCourseCode();
				String courseName = c.getCourseName();
				int credits = c.getCredits();
				
				
				Connection conn = null;
				PreparedStatement sql = null; 
			
			try {
				conn = Sqlcon.getConnection();
				sql = conn.prepareStatement("INSERT INTO Course VALUES(?, ?, ?)");
				sql.setString(1, courseCode);
				sql.setString(2, courseName);
				sql.setInt(3, credits);
				
				int row = sql.executeUpdate();
				if (row == 1) {
					return true;
				}
					return false;
			} finally {
				Sqlcon.closeSqlCon(conn, sql);
			}

			}
			
			// find course tied to specific courseCode
			public Course getCourse(String courseCode) throws SQLException{
				Connection conn = null;
				PreparedStatement sql = null;
				
				try {
					conn = Sqlcon.getConnection();
					sql = conn.prepareStatement("SELECT * FROM Course WHERE courseCode = ? ");
					sql.setString(1, courseCode);
					
					ResultSet rSet = sql.executeQuery();
					if(rSet.next()) {
						String courseName = rSet.getString("courseName");
						int credits = rSet.getInt("credits");
						
						return new Course(courseCode, courseName, credits);
						
					}
						return null;
				} finally {
					Sqlcon.closeSqlCon(conn, sql);
				}
			}*/

			// get all Students
			public ArrayList<Student> getAllStudents() throws SQLException {
				PreparedStatement sql = null;
				Connection conn = null;
		
				try {
					conn = Sqlcon.getConnection();
					sql = conn.prepareStatement("SELECT * FROM Student");
			
					ResultSet rSet = sql.executeQuery();
			
					ArrayList<Student> AllS = new ArrayList<>();
					while(rSet.next()) {
						String ssn = rSet.getString("ssn");
						String name = rSet.getString("name");
						String address = rSet.getString("address");
				
						Student s = new Student(ssn, name, address);
						AllS.add(s);
					}
					return AllS;
				} finally { 
					Sqlcon.closeSqlCon(conn, sql);
				}
			}
	
			// add new student
			public boolean addStudent(Student s) throws SQLException {
				String ssn = s.getSsn();
				String name = s.getStudentName();
				String address = s.getAddress();
		
				Connection conn = null;
				PreparedStatement sql = null;
		
				try {
					conn = Sqlcon.getConnection();
					sql = conn.prepareStatement("INSERT INTO Student VALUES (?,?,?)");
			
					sql.setString(1, ssn);
					sql.setString(2, name);
					sql.setString(3, address);
			
					int i = sql.executeUpdate();	
					if (i == 1) {
						return true;
					}
					return false;
				}	finally {
					Sqlcon.closeSqlCon(conn, sql);
		}
		
		
			}
			
			// find student with specific studentSsn
			public Student getStudent(String ssn) throws SQLException {
				Connection conn = null;
				PreparedStatement sql = null;
		
				try { 
					conn = Sqlcon.getConnection();
					sql = conn.prepareStatement("SELECT * FROM Student WHERE ssn = ?");
					sql.setString(1, ssn);
			
					ResultSet rSet = sql.executeQuery();
			
					Student s = null;
					if (rSet.next()) {
						String name = rSet.getString("name");
						String address = rSet.getString("address");
				
				
						s = new Student(ssn, name, address);
					}
					return s;
				} finally { 
					Sqlcon.closeSqlCon(conn, sql);
				}
			}
			
			// add new studies 
			public boolean addStudies(Studies st) throws SQLException {
				String studentSsn = st.getStudentSsn();
				String courseCode = st.getCourseCode();
		
				Connection conn = null;
				PreparedStatement sql = null;
				try {
					conn = Sqlcon.getConnection();
					sql = conn.prepareStatement("INSERT INTO Studies VALUES (?,?)");
					sql.setString(1, studentSsn);
					sql.setString(2, courseCode);
						
					int i = sql.executeUpdate();
					if (i == 1) {
						return true;
					}
					return false;
				} finally {
					Sqlcon.closeSqlCon(conn, sql);
				}
			}
			
			
			public Studies getStudies (String ssn, String courseCode) throws SQLException {
				Connection conn = null;
				PreparedStatement sql = null;
			
				try {
					conn = Sqlcon.getConnection();
					sql = conn.prepareStatement("SELECT * FROM Studies WHERE ssn = ? AND courseCode = ?");
				
					sql.setString(1, ssn);
					sql.setString(2, courseCode);
				
					ResultSet rSet = sql.executeQuery();
				
					if(rSet.next()) {
						String grade = rSet.getString("grade");
					
						return new Studies(ssn, courseCode);
					}
					return null;
				} finally {
					Sqlcon.closeSqlCon(conn, sql);
			}
		}
			
			public ArrayList<Studies> getAllStudies(String courseCode) throws SQLException{
				Connection conn = null;
				PreparedStatement sql = null;
				
				try {
					conn = Sqlcon.getConnection();
					sql = conn.prepareStatement("SELECT * FROM Studies");
					sql.setString(1, courseCode);
					
					ResultSet rSet = sql.executeQuery();
					ArrayList<Studies> listStudies = new ArrayList<Studies>();
					while(rSet.next()) {
						String ssn = rSet.getString(1);
						String grade = rSet.getString(3);
						
						Studies studies = new Studies(ssn, courseCode);
						listStudies.add(studies);
					}
					return listStudies;
				} finally {
					Sqlcon.closeSqlCon(conn, sql);
				}
				
			}
			
			
			// add new has studied
			public boolean addHasStudied(HasStudied hs) throws SQLException{
				String ssn = hs.getStudentSsn();
				String courseCode = hs.getCourseCode();
				String grade = hs.getGrade();
				
				Connection conn = null; 
				PreparedStatement sql = null;
			
				try {
					conn = Sqlcon.getConnection();
				
					sql= conn.prepareStatement("INSERT INTO HasStudied VALUES(?, ?, ?)");
					sql.setString(1, ssn);
					sql.setString(2, courseCode);
					sql.setString(3, grade);
				
					int rows = sql.executeUpdate();
					if(rows == 1) {
						return true;
					}
					return false;
				} finally {
					Sqlcon.closeSqlCon(conn, sql);
				}
			}

		
			
			public HasStudied getHasStudied (String ssn, String courseCode) throws SQLException {
				Connection conn = null;
				PreparedStatement sql = null;
			
				try {
					conn = Sqlcon.getConnection();
					sql = conn.prepareStatement("SELECT * FROM HasStudied WHERE ssn = ? AND courseCode = ?");
				
					sql.setString(1, ssn);
					sql.setString(2, courseCode);
				
					ResultSet rSet = sql.executeQuery();
				
					if(rSet.next()) {
						String grade = rSet.getString("grade");
					
						return new HasStudied(ssn, courseCode, grade);
					}
					return null;
				} finally {
					Sqlcon.closeSqlCon(conn, sql);
			}
		}

		//get all that has studied grade
		public ArrayList<HasStudied> getAllHasStudied(String courseCode) throws SQLException{
			Connection conn = null;
			PreparedStatement sql = null;
			
			try {
				conn = Sqlcon.getConnection();
				sql = conn.prepareStatement("SELECT * FROM HasStudied WHERE courseCode = ?");
				sql.setString(1, courseCode);
				
				ResultSet rSet = sql.executeQuery();
				ArrayList<HasStudied> hs = new ArrayList<HasStudied>();
				while(rSet.next()) {
					String ssn = rSet.getString(1);
					String grade = rSet.getString(3);
					
					HasStudied studied = new HasStudied(ssn,courseCode, grade);
					hs.add(studied);
				}
				return hs;
			} finally {
				Sqlcon.closeSqlCon(conn, sql);
			}
			
		}

		

}

	