import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Course {

	private String courseCode; 


	private String courseName;
	
	private double credits;

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

	public double getCredits() {
		return credits;
	}

	public void setCredits(double credits) {
		this.credits = credits;
	}
	private String itsFridayThen;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String url = "jdbc:sqlserver://LAPTOP-K0LPK14A:1433; database=sqldepartment1";
		String user = "user3";
		String password = "sql";
		Connection con = DriverManager.getConnection(url,user,password);
		
		String query = "SELECT * FROM Employee";
		
		PreparedStatement ps = con.prepareStatement(query);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()){
			System.out.println(rs.getString(2));
		}
		
		
		
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();

	}
	
		
	}

}	


