import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DAL {
		
	
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

	