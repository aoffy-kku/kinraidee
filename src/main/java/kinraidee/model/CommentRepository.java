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

	public List<Comment> findAll() {
		Query query = entityManager.createQuery("from Comment");
		return query.getResultList();
	}

	public Comment findById(Integer commentId) {
		return entityManager.find(Comment.class, commentId);
	}

	@Transactional
	public Comment insert(Comment comment) {
		entityManager.persist(comment);
		return comment;
	}

	@Transactional
	public Comment update(Integer commentId, Comment comment) {
		Date date = new Date();
		Timestamp ts = new Timestamp(date.getTime());
		Comment oldComment = entityManager.find(Comment.class, commentId);
		oldComment.setDetail(comment.getDetail());
		oldComment.setUpdateAt(ts);
		entityManager.persist(oldComment);
		return comment;
	}

	@Transactional
	public void delete(Integer commentId) {
		Comment comment = entityManager.find(Comment.class, commentId);
		entityManager.remove(comment);
	}
}
