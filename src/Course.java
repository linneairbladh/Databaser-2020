import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Course {

	private String courseCode; 
	private String courseName;
	private int credits;

	//Constructor för Course 
	public Course(String courseCode, String courseName, int credits) {
	this.courseCode = courseCode;
	this.courseName = courseName;
	this.credits = credits;
	}

	//Constructor för Course 
	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}
	
	public static void main(String[] args) {
	try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String url = "jdbc:sqlserver://localhost:1433;database=University";
		String user = "useradmin";
		String password = "password";
		Connection con = DriverManager.getConnection(url,user,password);
		
		String query = "SELECT * FROM HasStudied";
		
		PreparedStatement ps = con.prepareStatement(query);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()){
			System.out.println(rs.getString(1));
		}
			
	} catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();

	}
	
		
	}

}	


