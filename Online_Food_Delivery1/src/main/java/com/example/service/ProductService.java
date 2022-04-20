package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.Category;
import com.example.entities.Product;
import com.example.repository.CategoryRepository;
import com.example.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productrepo;

	
	public String addProduct(Product product) {
		Product addProduct =productrepo.save(product);
		return addProduct.getProduct_name()
				+",sucessfully added with id : "
				 +addProduct.getProduct_id();
	}
	
public Product getProductById(int id) {
		
		return productrepo.findById(id).get();
	}

	
	public Product updateProductDetails(Product product,int pId) {
		
		Product product1=productrepo.getProductById(pId);
		//if(rest_owner.getRole().equals(Role.RESTAURANT_OWNER)) {
		
		product1.setProduct_name(product.getProduct_name());
		product1.setProduct_price(product.getProduct_price());
		//product1.setCategory(product.getCat());
		Product productDetails = productrepo.save(product1);
		return productDetails;
	}
	
	
	public String deleteProductDetails(int pId) {
		
		productrepo.deleteById(pId);
		return "Product deleted successfully with id : "+pId;
	}

	public List<Product> getProduct() {
		// TODO Auto-generated method stub
		return productrepo.findAll();
	}
	
	

}
