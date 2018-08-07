package com.visa.prj.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.visa.prj.entity.LineItem;
import com.visa.prj.service.FoodieService;

@RestController
@RequestMapping(value="api/lineitems")
public class LineItemController {
	
	@Autowired
	private FoodieService foodieService;
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<LineItem> addLineItem(@RequestBody LineItem lineItem) {
		foodieService.addLineItem(lineItem);
		System.out.println(lineItem);
		return new ResponseEntity<LineItem> (lineItem, HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody List<LineItem> getLineItems() {
		return foodieService.getLineItems();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public @ResponseBody LineItem getLineItem(@PathVariable("id") int id) {
		return foodieService.getLineItem(id);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteLineItem(@PathVariable("id") int id) {
		foodieService.deleteLineItem(id);
		return new ResponseEntity<String> ("Deleted Line Item with id " + id + "!!", HttpStatus.OK);
	}
}
