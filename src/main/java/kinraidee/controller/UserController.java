package kinraidee.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kinraidee.model.User;
import kinraidee.model.UserRepository;
@CrossOrigin(origins = "*" ,maxAge = 3600)
@RestController
public class UserController {
	@Autowired
	private UserRepository UserRepository;

	// insert user
	@PostMapping("/user")
	public User createUser(@RequestBody User user) {
		return UserRepository.insert(user);
	}

	// show all user
	@GetMapping("/user")
	public List<User> getAllUser() {
		List<User> userList = UserRepository.findAll();
		return userList;
	}

	// search by user_id
	@GetMapping("/user/{id}")
	public User getUserByID(@PathVariable Integer id) {
		User user = UserRepository.findById(id);
		return user;
	}

	// update new information of user
	@PutMapping("/user/{id}")
	public User updateUser(@PathVariable Integer id, @RequestBody User user) {
		User newUser = UserRepository.update(id, user);
		return newUser;
	}

	@DeleteMapping("/user/{id}")
	public void deleteUser(@PathVariable Integer id) {
		UserRepository.delete(id);
	}

	@PostMapping("/user/signin")
	public Map<String, Object> signin(@RequestBody User user) {
		return UserRepository.signin(user.getUsername(), user.getPassword());
	}
}
