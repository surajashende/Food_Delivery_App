package com.example.controller;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.Category;
import com.example.entities.Product;
import com.example.entities.Rest_Owner;
import com.example.service.CategoryService;
import com.example.service.ProductService;
import com.example.service.Rest_OwnerService;

@RestController
@EnableAutoConfiguration
@RequestMapping("/restowner")
@CrossOrigin(origins = "*")
@Transactional
public class Rest_Owner_Controller {
	

	@Autowired
	Rest_OwnerService rest_ownerservice;
	
	@Autowired
	CategoryService catservice;
	
	@Autowired
	ProductService productservice;
	
	@PostMapping("/addCategory")
	public ResponseEntity<?>saveCategoryDetails(@RequestBody @Valid Category category)
	{
		System.out.println("In save category");
		return new ResponseEntity<>(catservice.addCategory(category),HttpStatus.CREATED);
	}
	
	@GetMapping("/{catId}")
	public ResponseEntity<?> getOwnerDetailsById(@PathVariable int catId){
		System.out.println("in get cat details "+catId);
		return ResponseEntity.ok(catservice.getCategoryById(catId));
		
	}
	@DeleteMapping("/{catId}")
	public ResponseEntity<String> deleteCategoryDetails(@PathVariable int catId){
		System.out.println("in del cat Details "+catId);
		return ResponseEntity.ok(catservice.deleteCategoryDetails(catId));
	}
	
	@PutMapping("/updatecategory/{id}")
	public ResponseEntity<?> updateCategoryDetails(@RequestBody Category detachedcategory,@PathVariable("id") int catId){
		//check if user exit by id
	//	rest_ownerservice.getOwnerById(detachedOwner.getId());
		return ResponseEntity.ok(catservice.updateCategoryDetails(detachedcategory,catId));
	}
	
		

	@GetMapping("/getCategory")
		public List<Category> getCategory()
		{
			return catservice.getCategory();
		}
//------------------------Product Operation----------------------------------------
	
	
	@GetMapping("/getProduct")
	public List<Product> getProduct()
	{
		return productservice.getProduct();
	}

	
	

	@PostMapping("/addProduct")
	public ResponseEntity<?>saveProductDetails(@RequestBody @Valid Product product)
	{
		System.out.println("In save product");
		return new ResponseEntity<>(productservice.addProduct(product),HttpStatus.CREATED);
	}
	
	@GetMapping("/getproduct/{pId}")
	public ResponseEntity<?> getProductDetailsById(@PathVariable int pId){
		System.out.println("in get product details "+pId);
		return ResponseEntity.ok(productservice.getProductById(pId));
		
	}
	@DeleteMapping("/deleteproduct/{pId}")
	public ResponseEntity<String> deleteProductDetails(@PathVariable int pId){
		System.out.println("in del cat Details "+pId);
		return ResponseEntity.ok(productservice.deleteProductDetails(pId));
	}
	
	@PutMapping("/updateproduct/{id}")
	public ResponseEntity<?> updateownerDetails(@RequestBody Product detachedproduct,@PathVariable("id") int catId){
		//check if user exit by id
	//	rest_ownerservice.getOwnerById(detachedOwner.getId());
		return ResponseEntity.ok(productservice.updateProductDetails(detachedproduct,catId));
	}
}
