package kinraidee.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kinraidee.model.Follow;
import kinraidee.model.Restaurant;
import kinraidee.model.RestaurantRepository;

@CrossOrigin(origins = "*" ,maxAge = 3600)
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
		return restaurantRepository.insert(restaurant);
	}

	@GetMapping("/restaurant/{id}") // search restaurant by id
	public Restaurant getRestaurantById(@PathVariable Integer id) {
		Restaurant restaurant = restaurantRepository.findRestaurantById(id);
		return restaurant;
	}

	
	@GetMapping("/restaurant/name/{resname}")
	public List<Restaurant> getUserByResId(@PathVariable String resname) throws UnsupportedEncodingException  {
		List<Restaurant> res = (List<Restaurant>) restaurantRepository.findByResName(resname);
		return res;
	}


	@PutMapping("/restaurant/{id}") // update restaurant information
	public Restaurant updateRestaurant(@PathVariable Integer id, @RequestBody Restaurant restaurant) {
		Restaurant newRestaurant = restaurantRepository.updateRestaurant(id, restaurant);
		return newRestaurant;
	}

	@DeleteMapping("/restaurant/{id}") // delete restaurant
	public void deleteRestaurant(@PathVariable Integer id) {
		restaurantRepository.deleteRestaurant(id);
	}
}
