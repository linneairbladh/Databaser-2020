import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

public class SqlCon {

	private static final SqlCon INSTANCE = new SqlCon();
	
	String url = "jdbc:sqlserver://localhost:1433;database=University";
	String user = "useradmin";
	String password = "password";
	
	private SqlCon () {
	

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

	
	}
	
	

}
