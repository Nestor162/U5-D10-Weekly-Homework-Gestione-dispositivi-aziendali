package nestorcicardini.D10.users.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class registerUserPayload {

	@NotNull(message = "Il nome non puo essere Null")
	@Size(min = 3, max = 30, message = "Il nome non rispetta i parametri (Min 3 / Max 30 caratteri)")
	String name;

	@NotNull(message = "Il cognome non puòessere Null")
	@Size(min = 3, max = 30, message = "Il cognome non rispetta i parametri (Min 3 / Max 30 caratteri)")
	String surname;

	@NotNull(message = "L'username non puòessere Null")
	@Size(min = 3, max = 30, message = "L'username non rispetta i parametri (Min 3 / Max 30 caratteri)")
	String username;

	@Email(message = "Non hai inserito un indirizzo email valido")
	String email;

	@NotNull(message = "La password non può essere Null")
	String password;
}