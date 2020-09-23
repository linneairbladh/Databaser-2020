import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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

	public ArrayList<Student> AllStudents() throws SQLException {
		PreparedStatement sql = null;
		Connection conn = null;
		
		try {
			
		}
	}
	
		

}

	