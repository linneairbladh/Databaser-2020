import java.sql.SQLException;

public class Controller {
	private DAL dataAccessLayer;
	private UniversityApplication universityApplication;
	
	public Controller(DAL dataAccessLayer, UniversityApplication universityApplication) {
		this.dataAccessLayer = dataAccessLayer;
		this.universityApplication = universityApplication;
	declareEvents();
}
	public void declareEvents() {
			universityApplication.getButton_AddCourse().addActionListener(new ActionListener) {
				
			}
	
	universityApplication.get
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






}

//Lägg till kurs

//Lägg till student

//Registrera kurs på student

//Registrera avklarad kurs på student