package com.visa.prj.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.visa.prj.entity.Menu;
import com.visa.prj.entity.Restaurant;
import com.visa.prj.service.FoodieService;

@RestController
@RequestMapping("api/restaurants")
public class RestaurantController {
	@Autowired
	private FoodieService foodService;
	
	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody List<Restaurant> getRestaurants() {
		return foodService.getRestaurants();
	}
	@RequestMapping(value="/veg",method=RequestMethod.GET)
	public @ResponseBody List<Restaurant> getVegRestaurants() {
		return foodService.getVegRestaurants();
	}
	@RequestMapping(value="/cuisine",method=RequestMethod.GET)
	public @ResponseBody List<Restaurant> getResByCuisine(@RequestParam ("cuisine")  String cuisine) {
		return foodService.getResByCuisine(cuisine);
	}
	@RequestMapping(value="/menuitems/{id}",method=RequestMethod.GET)
	public void addMenu(List<Menu>menu_items,@PathVariable("id")int id) {
		foodService.addMenu(menu_items,id);
	}
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public @ResponseBody Restaurant getRestaurant(@PathVariable("id") int id) {
		return foodService.getResById(id);
	}
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Restaurant> addRestaurant(@RequestBody Restaurant restaurant) {
		foodService.addRestaurant(restaurant);
		return new ResponseEntity<Restaurant>(restaurant,HttpStatus.CREATED);
	}
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteRestaurant(@PathVariable("id") int id) {
		foodService.deleteRestaurant(id);
		return new ResponseEntity<String>("Restaurant with id " + id + " deleted !!!",HttpStatus.OK);
	}
	

}
