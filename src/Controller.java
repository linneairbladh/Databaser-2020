import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Controller {
	private DAL dataAccessLayer;
	private UniversityApplication universityApplication;
	
	
	public Controller(DAL dataAccessLayer, UniversityApplication universityApplication) {
		this.dataAccessLayer = dataAccessLayer;
		this.universityApplication = universityApplication;
		
	//Visar alla studenter genom ArrayList
	public List <Student> getAllStudents() throws (SQLException) {
		return this.dataAccessLayer.getAllStudents();
	}
	
	//Visar alla kurser genom ArrayList
	public List <Course> getAllCourses () throws (SQLException)	{
		return this.dataAccessLayer.getAllCourses();
		


	
	//Lägg till kurs

	//Lägg till student

	//Registrera kurs på student

	//Registrera avklarad kurs på student

	
}
}
	
	/*public void declareEvents() {
		universityApplication.getButton_FindCourse().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String courseCode = universityApplication.getTextField_courseCode().getText();
				try {
					ResultSet courseResultSet = dataAccessLayer.getCourse(courseCode);
					
					while(courseResultSet.next()) {
						String cCourseCode = courseResultSet.getString("courseCode");
						String cCourseName = courseResultSet.getString("courseName");
						String cCredits = courseResultSet.getString("credits");
						
						universityApplication.getTextField_courseCode().setText(cCourseCode);
						universityApplication.getTextField_courseCode().setText(cCourseName);
						universityApplication.getTextField_courseCode().setText(cCredits);
					}
					courseResultSet.close();
				} catch(SQLException sqlException) {
					
				}
			}
		});

		universityApplication.getButton_AddCourse().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					addallcourses(e); 
			}
		});
		
		
		universityApplication.getButton_AddStudent().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Studentssn = universityApplication.getTextField_ssn().getText();
				String StudentstudentName = universityApplication.getTextField_studentName().getText();
			
				try {
					dataAccessLayer.InsertStudent(Studentssn, StudentstudentName);
				} catch(SQLException sqlException) {
			}
		}
	});
	}
	public DAL getDataAccessLayer() {
		return dataAccessLayer;
	}
	public void setDataAccessLayer(DAL dataAccessLayer) {
		this.dataAccessLayer = dataAccessLayer;
	}
	public UniversityApplication getUniversityApplication() {
		return universityApplication;
	}
	public void setUniversityApplication(UniversityApplication universityApplication) {
		this.universityApplication = universityApplication;
	}
	
	//metod för att lägga till kurser
	public void addallcourses(String CourseCode, String CourseName, String Credits) { //action event e 
		String cCourseCode = universityApplication.getTextField_courseCode().getText();
		String cCourseName = universityApplication.getTextField_courseName().getText();
		String cCredits = universityApplication.getTextField_courseCredits().getText();
	
		try {
			dataAccessLayer.InsertCourse(cCourseCode, cCourseName, cCredits);
		} catch(SQLException sqlException) {
	}
	}






}*/
