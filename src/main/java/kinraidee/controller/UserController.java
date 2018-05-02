package kinraidee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kinraidee.model.User;
import kinraidee.model.UserRepository;

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
	@PutMapping("/user/{userId}")
	public User updateUser(@PathVariable Integer userId, @RequestBody User user) {
		User newUser = UserRepository.update(userId, user);
		return newUser;
	}

	@DeleteMapping("/user/{userid}")
	public void deleteUser(@PathVariable Integer userId) {
		UserRepository.delete(userId);
	}

}
