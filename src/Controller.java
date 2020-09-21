import java.sql.SQLException;

public class Controller {

private DAL dal;

public Controller() {
	this.dal = new DAL();
}

public boolean addCourse(String courseCode, String courseName, double credits) throws SQLException {
	Course c = new Course(courseCode, courseName, credits);
	return this.dal.addCourse(c);
}


}
