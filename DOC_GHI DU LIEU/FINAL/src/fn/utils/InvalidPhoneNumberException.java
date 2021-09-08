package fn.utils;

public class InvalidPhoneNumberException extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidPhoneNumberException() {
		super();
	}

	public InvalidPhoneNumberException(String message) {
		super(message);
	}
	
}
