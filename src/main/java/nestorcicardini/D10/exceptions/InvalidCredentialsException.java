package nestorcicardini.D10.exceptions;

@SuppressWarnings("serial")
public class InvalidCredentialsException extends RuntimeException {

	public InvalidCredentialsException(String message) {
		super(message);
	}
}
