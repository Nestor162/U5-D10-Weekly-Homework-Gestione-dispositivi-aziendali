package nestorcicardini.D10.exceptions;

@SuppressWarnings("serial")

public class InvalidTokenException extends RuntimeException {

	public InvalidTokenException(String message) {
		super(message);
	}
}
