package kinraidee.model;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.util.Date;
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
		Date date = new Date();
		Timestamp ts = new Timestamp(date.getTime());
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
		oldRestaurant.setUpdateAt(ts);
		entityManager.persist(oldRestaurant);
		return oldRestaurant;
	}

	@Transactional
	public void deleteRestaurant(Integer resId) {
		Restaurant restaurant = entityManager.find(Restaurant.class, resId);
		entityManager.remove(restaurant);
	}
	
	
	public List<Restaurant> findByResName(String resname) throws UnsupportedEncodingException {
		Query nativeQuery = entityManager.createNativeQuery(
				"select * from restaurant WHERE name LIKE '%"+resname+"%'" ,Restaurant.class);
		return nativeQuery.getResultList();

	}

}
