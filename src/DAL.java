import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

public class DAL {

	public ArrayList<Student> AllStudents() throws SQLException {
		PreparedStatement sql = null;
		Connection conn = null;
		
		try {
			conn = Sqlcon.getConnection();
			sql = conn.prepareStatement("SELECT * FROM Student");
			
			ResultSet rSet = sql.executeQuery();
			
			ArrayList<Student> AllS = new ArrayList<>();
			while(rSet.next()) {
				String ssn = rSet.getString("ssn");
				String name = rSet.getString("name");
				String address = rSet.getString("address");
				String mail = rSet.getString("mail");
				
				Student s = new Student(ssn, name, address, mail);
				AllS.add(s);
			}
			return AllS;
		} finally { 
			Sqlcon.closeSqlCon(conn, sql);
			}
	}
	
	public boolean addStudent(Student s) throws SQLException {
		String ssn = s.getSsn();
		String name = s.getStudentName();
		String address = s.getAdress();
		String mail = s.getMail();
		
		Connection conn = null;
		PreparedStatement sql = null;
		
		try {
			conn = Sqlcon.getConnection();
			sql = conn.prepareStatement("INSERT INTO Student VALUES (?,?,?,?)");
			
			sql.setString(1, ssn);
			sql.setString(2, name);
			sql.setString(3, address);
			sql.setString(4, mail);
			
			int i = sql.executeUpdate();	
			if (i == 1) {
				return true;
			}
			return false;
		}	finally {
				Sqlcon.closeSqlCon(conn, sql);
		}
		
		
	}
	public Student getStudent(String ssn) throws SQLException {
		Connection conn = null;
		PreparedStatement sql = null;
		
		try { 
			conn = Sqlcon.getConnection();
			sql = conn.prepareStatement("SELECT * FROM Student WHERE ssn = ?");
			sql.setString(1, ssn);
			
			ResultSet rSet = sql.executeQuery();
			
			Student s = null;
			if (rSet.next()) {
				String name = rSet.getString("name");
				String address = rSet.getString("address");
				String mail = rSet.getString("mail");
				
				s = new Student(ssn, name, address, mail);
			}
			return s;
		} finally { 
			Sqlcon.closeSqlCon(conn, sql);
		}
	}
	
	
}

	