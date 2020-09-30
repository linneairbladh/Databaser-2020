
public class ErrorHandlingSQL {
	
	public static String MessageFailureCode (int failureCode, String prefix ) {
	String code = "Something went wrong.";
	
	
	if (failureCode == 8152) {
		code = "Too many characters. ";
	}
	
	if (failureCode == 18456) {
		code = "The login to the database didn't work, try again.";
	}
	
	if (failureCode == 2627) {
		code = "You cant's insert the same number twice, please try another one. ";
	}
	
	if (failureCode == 0) {
		code = "Connection problems, check your Wi-fi.";
	}
			return code;
	}
	
}

