package Model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<User> findAllUser(){
		Query query = entityManager.createQuery("from user"); 
		return query.getResultList();
	}
	
	public User findById(Integer user_id) {
		return entityManager.find(User.class, user_id); 
	}
	
	@Transactional
	public User insertUser(User user) {
		entityManager.persist(user); 
		return user;
	}
	
	public void deleteUser(Integer user_id) {
		User user = entityManager.find(User.class, user_id); 
		entityManager.remove(user); 
	}
	
}
