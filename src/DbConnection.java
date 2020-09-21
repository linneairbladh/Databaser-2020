import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbConnection {

	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	String url = "jdbc:sqlserver://localhost:1433;database=University";
	String user = "useradmin";
	String password = "password";
	Connection con = DriverManager.getConnection(url,user,password);
	
	String query = "SELECT * FROM Student";
	
	PreparedStatement ps = con.prepareStatement(query);
	
	ResultSet rs = ps.executeQuery();
	
	while(rs.next()){
		System.out.println(rs.getString(1));
	}
		
} catch (ClassNotFoundException | SQLException e) {
	e.printStackTrace();
