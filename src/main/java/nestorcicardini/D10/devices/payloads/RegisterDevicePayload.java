package nestorcicardini.D10.devices.payloads;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class RegisterDevicePayload {

	@NotNull(message = "Il tipo di dispositivo non può essere nullo")
	private String deviceType;

	@NotNull(message = "Lo stato del dispositivo non può essere nullo")
	private String deviceStatus;

	@NotNull(message = "L'ID dell'utente non può essere nullo")
	private String userId;

}
