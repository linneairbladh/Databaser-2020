
public class HasStudied {

	private String studentSsn;
	private String courseCode; 
	private String grade;
	
	public HasStudied() {
	}
	public HasStudied (String studentSsn, String courseCode, String grade) {
		this.studentSsn = studentSsn;
		this.courseCode = courseCode;
		this.grade = grade;
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

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

}

