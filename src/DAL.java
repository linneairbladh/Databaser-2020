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
}

	

	



	