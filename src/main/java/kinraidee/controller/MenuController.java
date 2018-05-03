package kinraidee.controller;

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

import kinraidee.model.Menu;
import kinraidee.model.MenuRepository;
import kinraidee.model.Restaurant;
import kinraidee.model.RestaurantRepository;

@CrossOrigin(origins = "*" ,maxAge = 3600)
@RestController
public class MenuController {
	@Autowired
	private MenuRepository menuRepository;

	@GetMapping("/menu") // show all menu
	public List<Menu> getMenuList() {
		List<Menu> menuList = menuRepository.findAllMenu();
		return menuList;
	}

	@PostMapping("/menu") // insertMenu
	public Menu createMenu(@RequestBody Menu menu) {
		return menuRepository.insertMenu(menu);
	}

	@GetMapping("/menu/{id}") // search menu by id
	public Menu getMenuById(@PathVariable Integer id) {
		Menu menu = menuRepository.findMenuById(id);
		return menu;
	}

	@PutMapping("/menu/{id}") // update menu information
	public Menu updateMenu(@PathVariable Integer id, @RequestBody Menu menu) {
		Menu newMenu = menuRepository.updateMenu(id, menu);
		return newMenu;
	}

	@DeleteMapping("/menu/{id}") // delete menu
	public void deleteMenu(@PathVariable Integer id) {
		menuRepository.deleteMenu(id);
	}
}
