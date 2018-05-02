package kinraidee.model;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
public class CommentRepository {
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Comment> findAll(){
		Query query = entityManager.createQuery("from Comment");
		return query.getResultList();
	}
	
	public Comment findById(Integer comment_id) {
		return entityManager.find(Comment.class, comment_id);
	}
	
	@Transactional
	public Comment insert(Comment comment) {
		entityManager.persist(comment);
		return comment;
	}
	
	@Transactional
	public Comment update(Integer comment_id, Comment comment) {
		Date date = new Date();
		Timestamp ts = new Timestamp(date.getTime());
		Comment oldComment = entityManager.find(Comment.class, comment_id);
		oldComment.setDetail(comment.getDetail());
		oldComment.setUpdate_at(ts);
		entityManager.persist(oldComment);
		return comment;
	}
	
	@Transactional
	public void delete(Integer comment_id) {
		Comment comment = entityManager.find(Comment.class, comment_id);
		entityManager.remove(comment);
	}
}
