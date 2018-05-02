package kinraidee.model;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
public class MenuRepository {
	@PersistenceContext
	private EntityManager entityManager;

	public List<Menu> findAllMenu() {
		Query query = entityManager.createQuery("from Menu");
		return query.getResultList();
	}

	public Menu findMenuById(Integer menuId) {
		return entityManager.find(Menu.class, menuId);
	}

	@Transactional
	public Menu insertMenu(Menu menu) {
		entityManager.persist(menu);
		return menu;
	}

	@Transactional
	public Menu updateMenu(Integer menuId, Menu menu) {
		Menu oldMenu = entityManager.find(Menu.class, menuId);
		oldMenu.setName(menu.getName());
		oldMenu.setImage(menu.getImage());
		oldMenu.setPrice(menu.getPrice());
		oldMenu.setType(menu.getType());
		oldMenu.setLove(menu.getLove());
		oldMenu.setCreateAt(menu.getCreateAt());
		oldMenu.setUpdateAt(menu.getUpdateAt());
		entityManager.persist(menu);
		return menu;
	}

	@Transactional
	public void deleteMenu(Integer menuId) {
		Menu menu = entityManager.find(Menu.class, menuId);
		entityManager.remove(menu);
	}
}
