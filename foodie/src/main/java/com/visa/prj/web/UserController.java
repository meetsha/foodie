package com.visa.prj.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.visa.prj.entity.User;
import com.visa.prj.service.FoodieService;

@RestController
public class UserController {
	
	private User userData;

	@Autowired
	private FoodieService foodieService;
	
	@RequestMapping(value="userDirect.do")
	public String directUser() {
		return "user.jsp";
	}
	
	@RequestMapping(value="api/users", method=RequestMethod.POST)
	public ResponseEntity<User> placeOrder(@RequestBody User user) {
		foodieService.addUser(user);
		userData = user;
		System.out.println(userData.getName());
		return new ResponseEntity<User>(user,HttpStatus.CREATED);
	}
}