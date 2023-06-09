package nestorcicardini.D10;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import nestorcicardini.D10.exceptions.BadRequestException;
import nestorcicardini.D10.exceptions.NotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<String> handleBadRequestException(
			BadRequestException ex) {

		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(ex.getMessage());
	}

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<String> handleNotFoundException(
			NotFoundException ex) {

		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(ex.getMessage());
	}

//	@ExceptionHandler(InvalidCredentialsException.class)
//	public ResponseEntity<String> handleInvalidCredentialsException(
//			InvalidCredentialsException ex) {
//
//		return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
//				.body(ex.getMessage());
//	}
//
//	@ExceptionHandler(InvalidTokenException.class)
//	public ResponseEntity<String> HandleInvalidTokenException(
//			InvalidTokenException ex) {
//
//		return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
//				.body(ex.getMessage());
//	}

//	@ExceptionHandler(Exception.class)
//	public ResponseEntity<String> handleException(Exception ex) {
//
//		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//				.body("Errore generico sul server...");
//	}

}
