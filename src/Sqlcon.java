import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import com.microsoft.sqlserver.jdbc.SQLServerDriver;

public class Sqlcon {
	
	private static final Sqlcon INSTANCE = new Sqlcon();
	
	String url = "jdbc:sqlserver://localhost:1433;database=University";
	String user = "useradmin";
	String password = "password";

	
	private Sqlcon() {
		
		try {
				DriverManager.deregisterDriver(new SQLServerDriver());
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	private Connection createConnection() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}
	public static Connection getConnection() throws SQLException {
		return INSTANCE.createConnection();		
	}
	public static void closeSqlCon(Connection conn, Statement sql) throws SQLException {
		conn.close();
		sql.close();
	}
}
