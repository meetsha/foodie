package com.visa.prj.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.visa.prj.dao.MenuDao;
import com.visa.prj.dao.UserDao;
import com.visa.prj.entity.Menu;
import com.visa.prj.entity.User;

@Service
public class FoodieService {
	
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
	
	public Menu getById(int id) {
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
