package com.visa.prj.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.visa.prj.dao.LineItemDao;
import com.visa.prj.dao.MenuDao;
import com.visa.prj.dao.OrdersDao;
import com.visa.prj.dao.RestaurantDao;
import com.visa.prj.dao.UserDao;
import com.visa.prj.entity.LineItem;
import com.visa.prj.entity.Menu;
import com.visa.prj.entity.Order;
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
	private LineItemDao lineItemDao;
	
	@Transactional
	public void addLineItem(LineItem lineItem) {
		lineItemDao.save(lineItem);
	}
	
	public List<LineItem> getLineItems() {
		return lineItemDao.findAll();
	}
	
	public LineItem getLineItem(int id) {
		return lineItemDao.findById(id).get();
	}
	
	@Transactional
	public void deleteLineItem(int id) {
		LineItem l = lineItemDao.getOne(id);
		lineItemDao.delete(l);
	}
	
	private OrdersDao orderDao;
	
	public List<Order> getOrders() {
		return orderDao.findAll();
	}
	
	@Transactional
	public void addOrder(Order order) {
		orderDao.save(order);
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
