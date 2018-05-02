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
public class PostRepository {
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Post> findAll(){
		Query query = entityManager.createQuery("from Post");
		return query.getResultList();
	}
	
	public Post findById(Integer postId) {
		return entityManager.find(Post.class, postId);
	}
	
	@Transactional
	public Post insert(Post post) {
		entityManager.persist(post);
		return post;
	}
	
	@Transactional
	public Post update(Integer postId, Post post) {
		Date date = new Date();
		Timestamp ts = new Timestamp(date.getTime());
		Post oldPost = entityManager.find(Post.class, postId);
		oldPost.setTitle(post.getTitle());
		oldPost.setDetail(post.getDetail());
		oldPost.setImage(post.getImage());
		oldPost.setUpdateAt(ts);
		entityManager.persist(oldPost);
		return post;
	}
	
	@Transactional
	public void delete(Integer postId) {
		Post post = entityManager.find(Post.class, postId);
		entityManager.remove(post);
	}
}
