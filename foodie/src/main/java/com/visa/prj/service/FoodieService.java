package com.visa.prj.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.visa.prj.dao.OrdersDao;
import com.visa.prj.dao.UserDao;
import com.visa.prj.entity.Order;
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
	private OrdersDao orderDao;
	
	public List<Order> getOrders() {
		return orderDao.findAll();
	}
	
	@Transactional
	public void addOrder(Order order) {
		orderDao.save(order);
	}
}
