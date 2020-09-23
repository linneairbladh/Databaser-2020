import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

public class DAL {

	

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
			}


	public ArrayList<Student> AllStudents() throws SQLException {
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
				String mail = rSet.getString("mail");
				
				Student s = new Student(ssn, name, address, mail);
				AllS.add(s);
			}
			return AllS;
		} finally { 
			Sqlcon.closeSqlCon(conn, sql);
			}
	}
	
	public boolean addStudent(Student s) throws SQLException {
		String ssn = s.getSsn();
		String name = s.getStudentName();
		String address = s.getAdress();
		String mail = s.getMail();
		
		Connection conn = null;
		PreparedStatement sql = null;
		
		try {
			conn = Sqlcon.getConnection();
			sql = conn.prepareStatement("INSERT INTO Student VALUES (?,?,?,?)");
			
			sql.setString(1, ssn);
			sql.setString(2, name);
			sql.setString(3, address);
			sql.setString(4, mail);
			
			int i = sql.executeUpdate();	
			if (i == 1) {
				return true;
			}
			return false;
		}	finally {
				Sqlcon.closeSqlCon(conn, sql);
		}
		
		
	}
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
				String mail = rSet.getString("mail");
				
				s = new Student(ssn, name, address, mail);
			}
			return s;
		} finally { 
			Sqlcon.closeSqlCon(conn, sql);
		}
	}
		public boolean addHasStudies(HasStudied hs) throws SQLException{
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
				Sqlcon.closeSqlCon(con, sql);
			}
		}
	
}

	

	



	