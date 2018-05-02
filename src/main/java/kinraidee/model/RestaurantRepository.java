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
		Query query = entityManager.createQuery("from Restaurant");
		return query.getResultList();
	}

	public Restaurant findRestaurantById(Integer resId) {
		return entityManager.find(Restaurant.class, resId);
	}

	@Transactional
	public Restaurant insert(Restaurant restaurant) {
		entityManager.persist(restaurant);
		return restaurant;
	}

	@Transactional
	public Restaurant updateRestaurant(Integer resId, Restaurant restaurant) {
		Restaurant oldRestaurant = entityManager.find(Restaurant.class, resId);
		oldRestaurant.setName(restaurant.getName());
		oldRestaurant.setDescription(restaurant.getDescription());
		oldRestaurant.setType(restaurant.getDescription());
		oldRestaurant.setVegan(restaurant.isVegan());
		oldRestaurant.setWifi(restaurant.isWifi());
		oldRestaurant.setPlug(restaurant.isPlug());
		oldRestaurant.setAir(restaurant.isAir());
		oldRestaurant.setMotorcycle(restaurant.isMotorcycle());
		oldRestaurant.setCar(restaurant.isCar());
		oldRestaurant.setOpen(restaurant.isOpen());
		oldRestaurant.setLat(restaurant.getLat());
		oldRestaurant.setLng(restaurant.getLng());
		oldRestaurant.setLogo(restaurant.getLogo());
		oldRestaurant.setCover(restaurant.getCover());
		oldRestaurant.setCreateAt(restaurant.getCreateAt());
		oldRestaurant.setUpdateAt(restaurant.getUpdateAt());
		entityManager.persist(restaurant);
		return restaurant;
	}

	@Transactional
	public void deleteRestaurant(Integer resId) {
		Restaurant restaurant = entityManager.find(Restaurant.class, resId);
		entityManager.remove(restaurant);
	}

}
