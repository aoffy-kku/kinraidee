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

import kinraidee.model.Comment;
import kinraidee.model.Follow;
import kinraidee.model.Post;
import kinraidee.model.PostRepository;

@RestController
public class PostController {
	@Autowired
	private PostRepository postRepository;
	
	//insert post
	@PostMapping("/post")
	public Post createPost(@RequestBody Post post) {
		return postRepository.insert(post);
	}
	
	//Show all post
	@GetMapping("/post")
	public List<Post> getPostList(){
		List<Post> postList = postRepository.findAll();
		return postList;
	}
	
	//search by post_id
	@PutMapping("/post/{id}")
	public Post getPostById(@PathVariable Integer postId) {
		Post post = postRepository.findById(postId);
		return post;
	}
	
	//update post
	@PutMapping("/post/{id}")
	public Post updatePost(@PathVariable Integer postId, @RequestBody Post post) {
		Post newPost = postRepository.update(postId, post);
		return newPost;
	}
	
	//delete post
	@DeleteMapping("/post/{id}")
	public void deletePost(@PathVariable Integer postId) {
		postRepository.delete(postId);
	}
			
}
