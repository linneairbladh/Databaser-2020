import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Controller {
	private DAL dataAccessLayer;
	private UniversityApplication universityApplication;
	
	
	public Controller(DAL dataAccessLayer, UniversityApplication universityApplication) {
		this.dataAccessLayer = dataAccessLayer;
		this.universityApplication = universityApplication;
	}
	
	//Visar alla studenter genom ArrayList
	public List <Student> getAllStudents() throws SQLException {
		return this.dataAccessLayer.getAllStudents();
	}
	
	//Visar alla kurser genom ArrayList
	public List <Course> getAllCourses () throws SQLException {
		return this.dataAccessLayer.getAllCourses();	
	}	
		

	
	//Lägg till student
	public boolean addStudent (String studentName, String ssn, String adress) throws SQLException {
		Student s1 = new Student (studentName, ssn, adress);
	 	return this.dataAccessLayer.addStudent(s1);	
	}

	//Lägg till kurs
	public boolean addCourse (String courseName, String courseCode,int credit) throws SQLException {
		Course c1 = new Course (courseName, courseCode, credit);
	 	return this.dataAccessLayer.addCourse(c1);	
	}



	
	//Registrera kurs på student
	public boolean addStudies (String ssn, String courseCode) throws SQLException {
		Studies s2 = new Studies (ssn, courseCode);
	 	return this.dataAccessLayer.addStudies(s2);	
	}

	//Registrera avklarad kurs på student
	public boolean addHasStudied (String ssn, String courseCode, String grade) throws SQLException {
		HasStudied s3 = new HasStudied (ssn, courseCode, grade);
	 	return this.dataAccessLayer.addHasStudied(s3);	
	}
	
	
	//Hitta en student och dess information
	public Student getStudent (String ssn) throws SQLException {
		return this.dataAccessLayer.getStudent(ssn);
	}
	
	//Hitta en kurs och dess information 
	public Course getCourse (String courseCode) throws SQLException {
		return this.dataAccessLayer.getCourse(courseCode);
	}
	
	//Visar en kurs för en studet
	public Studies getStudies (String courseCode, String ssn) throws SQLException {
			return this.dataAccessLayer.getStudies(courseCode, ssn);
	}
		
	//Visar en student och dess betyg på avklarad student
	public HasStudied getHasStudied(String courseCode, String ssn) throws SQLException {
			return this.dataAccessLayer.getHasStudied (courseCode, ssn);
	}
	
	//Visa alla akutella studenter
	public List <Studies> getAllStudies(String ssn, String courseCode) throws SQLException {
		return this.dataAccessLayer.getAllStudies(courseCode);
	}
	
	//Visar alla avslutade kurser
	public List <HasStudied> getAllHasStudied(String ssn, String courseCode) throws SQLException {
		return this.dataAccessLayer.getAllHasStudied(courseCode);
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
