import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

public class Sqlcon {
	

	
	private static String url = "jdbc:sqlserver://localhost:1433;database=University";
	private static String user = "useradmin";
	private static String password = "password";

	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url, user, password);
	}
	public static void closeSqlCon(Connection con, PreparedStatement sql) throws SQLException {
		con.close();
		sql.close();
	}
}
