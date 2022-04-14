package com.cybage.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.cybage.entity.Category;
import com.cybage.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public void addCategory(Category category) {
		categoryRepository.save(category);
	}
	

}
