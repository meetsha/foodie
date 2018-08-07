package com.visa.prj.web;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	
	@RequestMapping(value="/{date}", method=RequestMethod.GET)
	public @ResponseBody List<Order> getOrdersByDate(@RequestParam("date") Date date) {
		return foodieService.getOrdersByDate(date);
	}
	
	@RequestMapping(value="/{date1}/{date2}", method=RequestMethod.GET)
	public @ResponseBody List<Order> getOrdersByRange(@RequestParam("date1") Date date1, @RequestParam("date2") Date date2) {
		return foodieService.getOrdersByRange(date1,date2);
	}
	
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Order> placeOrder(@RequestBody Order order) {
		foodieService.addOrder(order);
		 return new ResponseEntity<Order>(order,HttpStatus.CREATED);
	}
	
	
}