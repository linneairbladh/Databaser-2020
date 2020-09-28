
public class ErrorHandlingSQL {
	
	public static String MessageFailureCode (int failureCode, String prefix ) {
	String code = "Something went wrong.";
	
	if (failureCode == 8152) {
		code = "Too many characters";
	}
	
	if (failureCode == 18456) {
		code = "The login to the database didn't work, try again.";
	}
	
	if (failureCode == 2627) {
		code = "This is already registered";
	}
	
	if (failureCode == 0) {
		code = "The course has already been read.";
	}
			return code;
	}
	
	
}
