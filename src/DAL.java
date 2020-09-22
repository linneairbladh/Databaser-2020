import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

public class DAL {
	
	private String url = "jdbc:sqlserver://localhost:1433;database=University";
	private String user = "useradmin";
	private static String password = "password";
	
	private Connection conn = null;
	
	private Connection sqlConn() throws SQLException {
			try { 
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			Connection conn = DriverManager.getConnection(url, user, password);
			return conn;
	}

	//Hitta kurs
	public ResultSet getCourse(String courseCode) throws SQLException {
	
		conn = sqlConn();
		String query = "SELECT * FROM COURSE";	
		PreparedStatement ps = conn.prepareStatement(query);
		
		ResultSet resultSet = ps.executeQuery();
		return resultSet;	
	}
	
	//Hitta student
	public ResultSet getStudent(String studentSSN, String studentName) throws SQLException {
		
		conn = sqlConn();
		String query = "SELECT * FROM Student";	
		PreparedStatement ps = conn.prepareStatement(query);
		
		ResultSet resultSet = ps.executeQuery();
		return resultSet;	
	}
	
	//Lägg till kurs
	public void InsertCourse(String courseCode, String courseName, double credits) throws SQLException {
		conn = sqlConn();
		String query = "INSERT INTO Course VALUES('" +courseCode + "', '" +  courseName + "','" + credits + "')";
		System.out.println(query);
		PreparedStatement ps = conn.prepareStatement(query);
		ps.executeUpdate();
	}
	
	//Lägg till student
	public void InsertStudent(String studentSSN, String studentName) throws SQLException {
		conn = sqlConn();
		String query = "INSERT INTO Student VALUES(' " +studentSSN + "', '" +  studentName +")";
		System.out.println(query);
		PreparedStatement ps = conn.prepareStatement(query);
		ps.executeUpdate();
	}

	
	//Registrera kurs på student
	public void InsertCourseStudent(String studentSsn, String courseCode) throws SQLException {
		conn = sqlConn();
		String query = "INSERT INTO Studies VALUES('" + studentSsn + "', '" +  courseCode +"')";
		System.out.println(query);
		PreparedStatement ps = conn.prepareStatement(query);
		ps.executeUpdate();
	}
	
	//Registrera avklarad kurs på student
	public void InsertFinishedCourseStudent(String studentSsn, String courseCode, String grade) throws SQLException {
	conn = sqlConn();
	String query = "INSERT INTO HasStudied VALUES('" + studentSsn + "', '" +  courseCode + "','" + grade + "')";
	System.out.println(query);
	PreparedStatement ps = conn.prepareStatement(query);
	ps.executeUpdate();
	}
}

	