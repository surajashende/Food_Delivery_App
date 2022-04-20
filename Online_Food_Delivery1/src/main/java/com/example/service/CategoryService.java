package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.Category;
import com.example.entities.Product;
import com.example.entities.Rest_Owner;
import com.example.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	CategoryRepository catrepo;
	
	public String addCategory(Category category) {
		Category addCategory = catrepo.save(category);
		return addCategory.getCat_name()
				+",sucessfully added with id : "
				 +addCategory.getCat_id();
	}
	
public Category getCategoryById(int id) {
		
		return catrepo.findById(id).get();
	}

	
	public Category updateCategoryDetails(Category category,int catId) {
		
		Category category1=catrepo.getCategoryById(catId);
		//if(rest_owner.getRole().equals(Role.RESTAURANT_OWNER)) {
		
		category1.setCat_name(category.getCat_name());
		    Category catDetails = catrepo.save(category1);
		return catDetails;
	}
	
	
	public String deleteCategoryDetails(int catId) {
		
		catrepo.deleteById(catId);
		return "Category deleted successfully with id : "+catId;
	}

	public List<Category> getCategory() {
		// TODO Auto-generated method stub
		return catrepo.findAll();
	}
	
	
}
