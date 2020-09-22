import java.sql.SQLException;

public class Controller {

private DAL dal;
private UniversityApplication universityApplication;

public Controller(DAL dal, UniversityApplication universityApplication) {
	this.dal = dal;
	this.universityApplication = universityApplication;
	
}



public boolean addCourse(String courseCode, String courseName, double credits) throws SQLException {
	Course c = new Course(courseCode, courseName, credits);
	return this.dal.addCourse(c);
	
	universityApplication.textField_StudentName.get
}


}

//Lägg till kurs

//Lägg till student

//Registrera kurs på student

//Registrera avklarad kurs på student