package com.visa.prj.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.visa.prj.dao.LineItemDao;
import com.visa.prj.dao.UserDao;
import com.visa.prj.entity.LineItem;
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
}
