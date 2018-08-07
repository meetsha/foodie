package com.visa.prj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import com.visa.prj.dao.RestaurantDao;
import com.visa.prj.entity.Menu;
import com.visa.prj.entity.Restaurant;

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

public Restaurant getById(int id) {
	return resDao.findById(id).get();
}

@Transactional
public void addMenu(List<Menu> menu_items,int id) {
	Restaurant r=resDao.findById(id).get();
	r.setMenu_items(menu_items);
	

}

}
