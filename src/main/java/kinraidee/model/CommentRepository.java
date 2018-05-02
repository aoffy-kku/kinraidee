package kinraidee.model;

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
	
	public List<Comment> findAllComment(){
		Query query = entityManager.createQuery("from comment");
		return query.getResultList();
	}
	
	@Transactional
	public Comment insertComment(Comment comment) {
		entityManager.persist(comment);
		return comment;
	}
	
	@Transactional
	public void deleteComment(Integer comment_id) {
		Comment comment = entityManager.find(Comment.class, comment_id);
		entityManager.remove(comment);
	}
}
