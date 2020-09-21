import java.sql.PreparedStatement;
import java.util.ArrayList;

public class CourseData {


	public ArrayList<Course> getAllCourses() {
		
		String query = "SELECT * FROM Student";
		
		PreparedStatement ps = con.prepareStatement(query);
	}
	
}
