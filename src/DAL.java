import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

public class DAL {
	
	private static String url = "jdbc:sqlserver://localhost:1433;database=University";
	private static String user = "useradmin";
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

	public void InsertCourse(String courseCode, String courseName, String cCredits) throws SQLException {
		conn = sqlConn();
		String query = "INSERT INTO Course VALUES(' " +courseCode + "', '" +  courseName + "'," + cCredits + ")";

		System.out.println(query);
		PreparedStatement ps = conn.prepareStatement(query);
		ps.executeUpdate();
	}
	

	//Lägg till student
	public void InsertStudent(String studentSSN, String studentName) throws SQLException {
		conn = sqlConn();
		String query = "INSERT INTO Student VALUES(' " +studentSSN + "', '" +  studentName +")";

	public void InsertStudent(String ssn, String studentName) throws SQLException {
		conn = sqlConn();
		String query = "INSERT INTO Student VALUES(' " +ssn + "', '" +  studentName + "',"  +")";

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

	
	public String addNewStudent(String[] student) {
		return "INSERT INTO Student VALUES(?, ?, ?)";
	}
	
	
	
	//metod för att lägga till kurs, Adam och måns version
	public boolean addCourse(Course c) throws SQLException{
		String courseCode = c.getCourseCode();
		String courseName = c.getCourseName();
		double credits = c.getCredits();
		
		Connection con = null;
		PreparedStatement state = null;
		
		try {
			con = SqlCon.getConnection();
			state = con.prepareStatement("Insert into Course values(?,?,?)");
			
			state.setString(1, courseCode);
			state.setString(2, courseName);
			state.setDouble(3, credits);
			
			 int row = state.executeUpdate();
	            if (row == 1) {
	                return true;
	         
		}
		
        return false;
    } finally {
        SqlCon.closeResources(con, state);
    }
}
		
		
}

	