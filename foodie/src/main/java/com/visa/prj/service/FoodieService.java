package com.visa.prj.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.visa.prj.dao.UserDao;
import com.visa.prj.entity.User;

@Service
public class FoodieService {
	
	@Autowired
	private UserDao userDao;
	
	@Transactional
	public void addUser(User user) {
		userDao.save(user);
	}
}
