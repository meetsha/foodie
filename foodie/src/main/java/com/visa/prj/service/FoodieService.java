package com.visa.prj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.visa.prj.dao.MenuDao;
import com.visa.prj.dao.RestaurantDao;
import com.visa.prj.dao.UserDao;
import com.visa.prj.entity.Menu;
import com.visa.prj.entity.Restaurant;
import com.visa.prj.entity.User;

@Service
public class FoodieService {
	@Autowired
	private RestaurantDao resDao;
	public List<Restaurant> getRestaurants() {
		return resDao.findAll();
	}

	public List<Restaurant> getVegRestaurants() {
		return resDao.getVegRestaurants();
	}

	public List<Restaurant> getResByCuisine(String cuisine){
		return resDao.getResByCuisine(cuisine);
	}
	@Transactional
	public void addRestaurant(Restaurant r) {
		resDao.save(r);
	}

	@Transactional
	public void deleteRestaurant(int id) {
		Restaurant r=resDao.findById(id).get();
	resDao.delete(r);	
	}

	public Restaurant getResById(int id) {
		return resDao.findById(id).get();
	}

	@Transactional
	public void addMenu(List<Menu> menu_items,int id) {
		Restaurant r=resDao.findById(id).get();
		r.setMenu_items(menu_items);
	}	

	@Autowired
	private UserDao userDao;
	
	@Transactional
	public void addUser(User user) {
		userDao.save(user);
	}
	@Autowired
	private MenuDao menuDao;
	
	@Transactional
	public void addMenuItem(Menu menu) {
		menuDao.save(menu);
	}
	
	public Menu getMenuById(int id) {
		return menuDao.findById(id).get();
	}
	
	public List<Menu> getAvailableMenuItems() {
		return menuDao.findAll();
	}
	
	public List<Menu> getAvailableVegItems(boolean veg){
		return menuDao.getAvailableVegItems(veg);
	}

	
	@Transactional
	public void deleteMenuItem(int id) {
		Menu m = menuDao.findById(id).get();
		menuDao.delete(m);
	}
}
