
public class Studies {

	// Attributes
	private String studentSsn;
	private String courseCode;

	// Constructor
	public Studies(String studentSsn, String courseCode) {
		this.studentSsn = studentSsn;
		this.courseCode = courseCode;
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

}


