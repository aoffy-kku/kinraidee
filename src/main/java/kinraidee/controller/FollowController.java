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

import kinraidee.model.Follow;
import kinraidee.model.FollowRepository;

@RestController
public class FollowController {
	@Autowired
	private FollowRepository followRepository;
	
	//insert follow
	@PostMapping("/follow")
	public Follow createFollow(@RequestBody Follow follow) {
		return followRepository.insert(follow);
	}
	
	//show all follow
	@GetMapping("/follow")
	public List<Follow> getFollowList(){
		List<Follow> followList = followRepository.findAll();
		return followList;
	}
	
	//search by follow_id
	@GetMapping("/follow/{id}")
	public Follow getFollowById(@PathVariable Integer id) {
		Follow follow = followRepository.findById(id);
		return follow;
	}
	
	//delete follow
	@DeleteMapping("/follow/{id}")
	public void deleteFollow(@PathVariable Integer id) {
		followRepository.delete(id);
	}
	
}
