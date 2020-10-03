import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import com.microsoft.sqlserver.jdbc.SQLServerDriver;

public class Sqlcon {

	// Holds the sole instance of Sqlcon.
	private static final Sqlcon INSTANCE = new Sqlcon();

	// Used to access database
	String url = "jdbc:sqlserver://localhost:1433;database=University";
	String user = "useradmin";
	String password = "password";

	// Constructor to handle JDBC Drivers
	private Sqlcon() {

		try {
			DriverManager.deregisterDriver(new SQLServerDriver());
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	// Creates Connection with Database
	private Connection createConnection() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}

	// Instances CreateConnection
	public static Connection getConnection() throws SQLException {
		return INSTANCE.createConnection();
	}

	// Used to close connection
	public static void closeSqlCon(Connection conn, Statement sql) throws SQLException {
		conn.close();
		sql.close();
	}
}
