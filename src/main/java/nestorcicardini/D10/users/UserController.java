package nestorcicardini.D10.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nestorcicardini.D10.users.payloads.registerUserPayload;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService userService;

	// CRUD:

	// 1. CREATE (POST METHOD) - http://localhost:3001/users
	@PostMapping("")
	public User saveUser(@RequestBody @Validated registerUserPayload body) {
		return userService.createUser(body);
	}
}
