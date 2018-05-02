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
public class FollowRepository {
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Follow> findAll(){
		Query query = entityManager.createQuery("from Follow");
		return query.getResultList();
	}
	
	public Follow findById(Integer followId) {
		return entityManager.find(Follow.class, followId);
	}
	
	@Transactional
	public Follow insert(Follow follow) {
		entityManager.persist(follow);
		return follow;
	}
	
	@Transactional
	public void delete(Integer followId) {
		Follow follow = entityManager.find(Follow.class, followId);
		entityManager.remove(follow);
	}
}