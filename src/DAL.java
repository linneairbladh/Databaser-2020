import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

public class DAL {
	//Kod från Klassen SqlCon
	private static final SqlCon INSTANCE = new SqlCon();
	
	String url = "jdbc:sqlserver://localhost:1433;database=University";
	String user = "useradmin";
	String password = "password";
	
	private SqlCon () { //denna är såklart fel pga från klassen SqlCon
	

		try {
			DriverManager.registerDriver(new SQLServerDriver());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private Connection createConnection() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}

	public static Connection getConnection() throws SQLException {
		return INSTANCE.createConnection();
	}

	public static void closeResources(Connection con, Statement state) throws SQLException {
		con.close();
		state.close();
	}

	//slut på den koden

		
	//metod för att hämta alla kurser, copy från Björn
	public ResultSet getCourse(String courseCode) throws SQLException {
	
		String query = "SELECT * FROM COURSE";	
		PreparedStatement ps = con.preparedStatetment(query);
		
		ResultSet resultSet = ps.executeQuery();
		return resultSet;
		
			}
	
	//metod för att lägga till kurs, copy från Björn
	public void InsertCourse(String courseCode, String courseName double credits) throws SQLException {
	
	 
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

	