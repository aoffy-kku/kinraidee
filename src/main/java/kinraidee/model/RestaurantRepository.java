package kinraidee.model;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class RestaurantRepository {
	@PersistenceContext
	private EntityManager entityManager;

	public List<Restaurant> findAllRestaurant() {
		Query query = entityManager.createQuery("from restaurant");
		return query.getResultList();
	}

	public Restaurant findRestaurantById(Integer resId) {
		return entityManager.find(Restaurant.class, resId);
	}
	
	@Transactional
	public Restaurant insertRestaurant(Restaurant restaurant) {
	entityManager.persist(restaurant);
	return restaurant;
	}
	
	@Transactional
	public void deleteRestaurant(Integer resId) {
	Restaurant restaurant = entityManager.find(Restaurant.class, resId);
	entityManager.remove(restaurant);
	}
}
