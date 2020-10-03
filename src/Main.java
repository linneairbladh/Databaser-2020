
public class Main {

	public static void main(String[] args) {

		DAL dal = new DAL();
		UniversityApplication frame = new UniversityApplication();
		ErrorHandlingSQL error = new ErrorHandlingSQL();
		Controller controller = new Controller(frame, dal, error);

		frame.setVisible(true);
		frame.setController(controller);

	}

}
