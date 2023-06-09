package nestorcicardini.D10.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nestorcicardini.D10.exceptions.BadRequestException;
import nestorcicardini.D10.users.payloads.registerUserPayload;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;

	public User createUser(registerUserPayload payload) {

		// Prima devo verificare se su db già esiste l'email
		userRepo.findByEmail(payload.getEmail()).ifPresent(user -> {
			throw new BadRequestException(
					"The email " + user.getEmail() + " is already in use!");
		});

		User createdUser = new User(payload.getSurname(), payload.getName(),
				payload.getSurname(), payload.getEmail(),
				payload.getPassword());
		return userRepo.save(createdUser);
	}
}
