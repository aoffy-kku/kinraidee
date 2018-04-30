package Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Model.User;
import Model.UserRepository;

@RestController
public class UserController {
	@Autowired
	private UserRepository UserRepository;
	
	//insert user
	@PostMapping("/user")
	public User createUser(@RequestBody User user) {
		return UserRepository.insertUser(user);
	}
	
	//show all user
	@GetMapping("/allUser")
	public List<User> getAllUser(){
		List<User> userList = UserRepository.findAllUser();
		return userList;
	}
	
	//search by user_id
	@GetMapping("/user/{user_id}")
	public User getUserByID(@PathVariable Integer user_id) {
		User user = UserRepository.findById(user_id);
		return user;
	}
	
	//update new information of user
	@PutMapping("/user/{user_id}")
	public User updateUser(@PathVariable Integer user_id,@RequestBody User user) {
		User userDefault = UserRepository.findById(user_id);
		userDefault.setFirstName(user.getFirstName());
		userDefault.setLastName(user.getLastName());
		userDefault.setUserName(user.getUserName());
		userDefault.setPassword(user.getPassword());
		userDefault.setEmail(user.getEmail());
		userDefault.setBirthDate(user.getBirthDate());
		User userNewInformation = UserRepository.insertUser(userDefault);
		return userNewInformation;
	}
	
	
	@DeleteMapping("/user/{user_id}")
	public void deleteUser(@PathVariable Integer user_id) {
	UserRepository.deleteUser(user_id);
	}
	
}
