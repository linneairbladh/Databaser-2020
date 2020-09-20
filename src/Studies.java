
public class Studies {
	private String studentSsn;
	private String courseCode; 
	
	public Studies() {
	}
	
	public Studies (String studentSsn, String courseCode) {
		this.studentSsn = studentSsn;
		this.courseCode = courseCode;	
	}

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



