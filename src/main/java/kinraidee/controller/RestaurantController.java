package kinraidee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kinraidee.model.User;
import kinraidee.model.Comment;
import kinraidee.model.Restaurant;
import kinraidee.model.RestaurantRepository;

@RestController
public class RestaurantController {
	@Autowired
	private RestaurantRepository restaurantRepository;

	@GetMapping("/restaurant") // show all restaurant
	public List<Restaurant> getRestaurantList() {
		List<Restaurant> restaurantList = restaurantRepository.findAllRestaurant();
		return restaurantList;
	}

	@PostMapping("/restaurant") // insertRestaurant
	public Restaurant createRestaurant(@RequestBody Restaurant restaurant) {
		return restaurantRepository.insertRestaurant(restaurant);
	}

	@GetMapping("/restaurant/{resId}") // search restaurant by id
	public Restaurant getRestaurantById(@PathVariable Integer resId) {
		Restaurant restaurant = restaurantRepository.findRestaurantById(resId);
		return restaurant;
	}

	@PutMapping("/restaurant/{resId}") // update restaurant information
	public Restaurant updateRestaurant(@PathVariable Integer resId,@RequestBody Restaurant restaurant) {
		Restaurant oldRestaurant = restaurantRepository.findRestaurantById(resId);	
		oldRestaurant.setResId(restaurant.getResId());
		oldRestaurant.setUserId(restaurant.getUserId());
		oldRestaurant.setRestaurantName(restaurant.getRestaurantName());
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
		Restaurant newRestaurant = restaurantRepository.insertRestaurant(oldRestaurant);
		return newRestaurant;
	}
	
	@DeleteMapping("/restaurant/{resId}")
	public void deleteRestaurant(@PathVariable Integer resId) {
		restaurantRepository.deleteRestaurant(resId);
	}
}
