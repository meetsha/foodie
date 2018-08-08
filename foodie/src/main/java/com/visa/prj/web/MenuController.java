package com.visa.prj.web;

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

import com.visa.prj.dao.MenuDao;
import com.visa.prj.entity.Menu;
import com.visa.prj.service.FoodieService;

@RestController
@RequestMapping("api/menu")
public class MenuController {
	
	@Autowired
	private FoodieService foodService;
	
	
	
	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody List<Menu> getMenuItems() {
		return foodService.getAvailableMenuItems();
	}
	
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Menu> placeOrder(@RequestBody Menu menu) {
		foodService.addMenuItem(menu);
		 return new ResponseEntity<Menu>(menu,HttpStatus.CREATED);
	}

	@RequestMapping(value="/veg",method=RequestMethod.GET)
	public @ResponseBody List<Menu> getAvailableVegItems(@RequestParam("veg") boolean veg) {
		return foodService.getAvailableVegItems(veg);
	}
}