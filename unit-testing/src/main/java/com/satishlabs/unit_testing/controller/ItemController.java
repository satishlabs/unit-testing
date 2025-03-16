package com.satishlabs.unit_testing.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.satishlabs.unit_testing.model.Item;

@RestController
public class ItemController {
	
	@GetMapping("/dummy-item")
	public Item helloWorld() {
		return new Item(1,"Ball",10,100);
	}
	
	@GetMapping("/item-from-business-service")
	public Item itemFromBusinessService() {
		return new Item(1,"Ball",10,100);
	}
	
	
	
}
