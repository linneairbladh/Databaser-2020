import java.util.ArrayList;

public class HasStudied {

	private String studentSsn;
	private String courseCode; 
	private String grade;
	private ArrayList<HasStudied> showResult = new ArrayList<HasStudied>();
	
	public ArrayList<HasStudied> getShowResult() {
		return showResult;
	}

	public void setShowResult(ArrayList<HasStudied> showResult) {
		this.showResult = showResult;
	}

	//Constructor för HasStudied
	public HasStudied (String studentSsn, String courseCode, String grade) {
		this.studentSsn = studentSsn;
		this.courseCode = courseCode;
		this.grade = grade;
	}

	//Set & Get 
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

