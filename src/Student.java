
public class Student {
	
	private String ssn;
	private String studentName;
	private String address;
	
	public Student (String studentName, String ssn, String address ) {
	this.ssn = ssn;
	this.studentName = studentName;
	this.address = address;
	}
	
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	
	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
}
