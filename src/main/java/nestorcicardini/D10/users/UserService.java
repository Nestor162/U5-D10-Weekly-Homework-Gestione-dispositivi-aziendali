package nestorcicardini.D10.users;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nestorcicardini.D10.exceptions.BadRequestException;
import nestorcicardini.D10.exceptions.NotFoundException;
import nestorcicardini.D10.users.payloads.RegisterNormalUserPayload;
import nestorcicardini.D10.users.payloads.RegisterUserPayload;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;

	// Questo metodo serve per l'endpoin /users. Quindi si puo scegliere il
	// ruolo e creare dei nuovi admin
	public User createUser(RegisterUserPayload payload) {

		// Prima devo verificare se su db già esiste l'email
		userRepo.findByEmail(payload.getEmail()).ifPresent(user -> {
			throw new BadRequestException(
					"The email " + user.getEmail() + " is already in use!");
		});

		User createdUser = new User(payload.getSurname(), payload.getName(),
				payload.getSurname(), payload.getEmail(), payload.getPassword(),
				UserRole.valueOf(payload.getUserRole()));

		return userRepo.save(createdUser);
	}

	// Questo metodo e per l'endpoit /auth. Quindi non si potra scegliere il
	// ruolo
	public User registerUser(RegisterNormalUserPayload payload) {

		// Prima devo verificare se su db già esiste l'email
		userRepo.findByEmail(payload.getEmail()).ifPresent(user -> {
			throw new BadRequestException(
					"The email " + user.getEmail() + " is already in use!");
		});

		User createdUser = new User(payload.getSurname(), payload.getName(),
				payload.getSurname(), payload.getEmail(), payload.getPassword(),
				UserRole.USER);

		return userRepo.save(createdUser);
	}

	public List<User> getAll() {
		return userRepo.findAll();
	}

	public User getUserByEmail(String email) {
		return userRepo.findByEmail(email)
				.orElseThrow(() -> new NotFoundException(
						"User not found for email: " + email));
	}

	public User getUserById(UUID id) {
		return userRepo.findById(id).orElseThrow(
				() -> new NotFoundException("User not found for id: " + id));
	}

	public User findByIdAndUpdate(UUID id, User user) throws NotFoundException {
		User found = this.getUserById(id);

		found.setId(id);
		found.setName(user.getName());
		found.setSurname(user.getSurname());
		found.setUsername(user.getUsername());
		found.setPassword(user.getPassword());
		found.setEmail(user.getEmail());

		return userRepo.save(found);
	}

	public void findByIdAndDelete(UUID id) throws NotFoundException {
		User found = this.getUserById(id);
		userRepo.delete(found);
	}

}
