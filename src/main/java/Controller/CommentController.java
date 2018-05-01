package Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Model.Comment;
import Model.CommentRepository;

@RestController
public class CommentController {
	@Autowired
	private CommentRepository commentRepository;
	
	//Show all comment
	@GetMapping("/comment")
	public List<Comment> getCommentList(){
		List<Comment> commentList = commentRepository.findAllComment();
		return commentList;
	}
	
	//insert comment
	@PostMapping("/comment")
	public Comment createComment(@RequestBody Comment comment) {
		return commentRepository.insertComment(comment);
	}
	
	//delete comment
	@DeleteMapping("/comment/{comment_id}")
	public void deleteComment(@PathVariable Integer comment_id) {
		commentRepository.deleteComment(comment_id);
	}
}
