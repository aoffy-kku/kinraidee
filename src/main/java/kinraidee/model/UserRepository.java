package kinraidee.model;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
	@PersistenceContext
	private EntityManager entityManager;

	public List<User> findAll() {
		Query query = entityManager.createQuery("from User");
		return query.getResultList();
	}

	public User findById(Integer user_id) {
		return entityManager.find(User.class, user_id);
	}

	@Transactional
	public User insert(User user) {
		entityManager.persist(user);
		return user;
	}

	@Transactional
	public User update(Integer userId, User user) {
		Date date = new Date();
		Timestamp ts = new Timestamp(date.getTime());
		User oldUser = entityManager.find(User.class, userId);
		oldUser.setFirstname(user.getFirstname());
		oldUser.setLastname(user.getLastname());
		oldUser.setBirthdate(user.getBirthdate());
		oldUser.setPassword(user.getPassword());
		oldUser.setUpdateAt(ts);
		entityManager.persist(oldUser);
		return oldUser;
	}

	@Transactional
	public void delete(Integer user_id) {
		User user = entityManager.find(User.class, user_id);
		entityManager.remove(user);
	}

	@Transactional
	public Map<String, Object> signin(String username, String password) {
		Map map = new HashMap();
		Query nativeQuery = entityManager.createNativeQuery(
				"select * from user WHERE username = '" + username + "' AND " + " password = '" + password + "'",
				User.class);
		User user = (User) nativeQuery.getSingleResult();
		map.put("user", user);
		try {
			nativeQuery = entityManager.createNativeQuery(
					"select * from restaurant WHERE user_id = '" + user.getUserId() + "'",
					Restaurant.class);
			Restaurant restaurant = (Restaurant) nativeQuery.getSingleResult();
			map.put("restaurant", restaurant);
		} catch(Exception e) {
			map.put("restaurant", null);
		}
		return map;
	}

}
