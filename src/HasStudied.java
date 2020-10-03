
public class HasStudied {

	// Attributes
	private String studentSsn;
	private String courseCode;
	private String grade;

	// Constructor
	public HasStudied(String studentSsn, String courseCode, String grade) {
		this.studentSsn = studentSsn;
		this.courseCode = courseCode;
		this.grade = grade;
	}

	// Setters and Getters
	public String getStudentSsn() {
		return studentSsn;
	}

	public void setStudentSsn(String studentSsn) {
		this.studentSsn = studentSsn;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

}

