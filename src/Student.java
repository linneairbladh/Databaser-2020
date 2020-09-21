
public class Student {
	
	private String ssn;
	private String studentName;
	private String mail;
	private String adress;
	
	public Student (String studentName, String ssn, String mail, String adress ) {
	this.ssn = ssn;
	this.studentName = studentName;
	this.mail = mail;
	this.adress = adress;
	}
	
	public String getSsn() {
		return ssn;
	}
	public void setSssn(String ssn) {
		this.ssn = ssn;
	}
	
	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
}
