package com.visa.prj.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.visa.prj.entity.Order;
import com.visa.prj.service.FoodieService;

@RestController
@RequestMapping(value="api/orders")
public class OrderController {
	
	@Autowired
	private FoodieService foodieService;
	
	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody List<Order> getOrders() {
		return foodieService.getOrders();
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Order> placeOrder(@RequestBody Order order) {
		foodieService.addOrder(order);
		 return new ResponseEntity<Order>(order,HttpStatus.CREATED);
	}
}