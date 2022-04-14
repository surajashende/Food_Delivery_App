package com.cybage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.entity.Item;
import com.cybage.service.ItemService;

@RestController
public class ItemController {
	
	@Autowired
	private ItemService itemService;

	@PostMapping("/addItem")
	public ResponseEntity<String>addItem(@RequestBody Item item){
		itemService.addItem(item);
		return new ResponseEntity<String>("Item is added", HttpStatus.CREATED);
	}
	
}
