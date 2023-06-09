package nestorcicardini.D10.users;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import nestorcicardini.D10.users.payloads.RegisterUserPayload;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService userService;

	// CRUD:

	// 1. CREATE (POST METHOD) - http://localhost:3001/users
	@PostMapping("")
	public User saveUser(@RequestBody @Validated RegisterUserPayload body) {
		return userService.createUser(body);
	}

	// 2. READ (GET METHOD) - http://localhost:3001/users
	@GetMapping("")
	public List<User> getAllUsers() {
		return userService.getAll();
	}

	// 3. READ (GET METHOD) - http://localhost:3001/users/:userEmail
	@GetMapping("/email/{userEmail}")
	public User getSpecificUserByEmail(@PathVariable String userEmail) {
		return userService.getUserByEmail(userEmail);

	}

	// 4. READ (GET METHOD) - http://localhost:3001/users/:userId
	@GetMapping("/id/{userId}")
	public User getSpecificUserById(@PathVariable String userId) {
		return userService.getUserById(UUID.fromString(userId));

	}

	// 4. UPDATE (PUT METHOD) - http://localhost:3001/users/:userId + req. body
	@PutMapping("/{userId}")
	public User updateUser(@PathVariable UUID userId, @RequestBody User body)
			throws Exception {
		return userService.findByIdAndUpdate(userId, body);
	}

	// 5. DELETE (DELETE METHOD) - http://localhost:3001/users/:userId
	@DeleteMapping("/{userId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteUser(@PathVariable UUID userId) {
		userService.findByIdAndDelete(userId);
	}

	// 1. CREATE ADMIN (POST METHOD) - http://localhost:3001/users/admin
	@PostMapping("/admin")
	public User saveAdmin(@RequestBody @Validated RegisterUserPayload body) {
		return userService.createUser(body);
	}
}
