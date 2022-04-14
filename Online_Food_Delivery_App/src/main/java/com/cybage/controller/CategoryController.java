package com.cybage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.entity.Category;
import com.cybage.service.CategoryService;

@RestController
@CrossOrigin("*")
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	
	@PostMapping("/addCateory")
	public ResponseEntity<String>addCategory(@RequestBody Category category){
		categoryService.addCategory(category);
		return new ResponseEntity<String>("category added sucessfully", HttpStatus.CREATED);
	}

}
