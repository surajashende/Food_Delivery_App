package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.Cart;
import com.example.repository.CartRepository;

@Service
public class CartService {
	
	@Autowired
	CartRepository cartrepo;
	
	public String addCart(Cart cart) {
		Cart addCart = cartrepo.save(cart);
		return addCart.getCart_id()
				+",sucessfully added ";
	}
	
public Cart getCartById(int id) {
		
		return cartrepo.findById(id).get();
	}

	
	public Cart updateCartDetails(Cart cart,int cartId) {
		
		Cart cart1=cartrepo.getCartById(cartId);
		//if(rest_owner.getRole().equals(Role.RESTAURANT_OWNER)) {
		
		cart1.setQuantity(cart1.getQuantity());
		    Cart cartDetails = cartrepo.save(cart1);
		return cartDetails;
	}
	
	
	public String deleteCartDetails(int cartId) {
		
		cartrepo.deleteById(cartId);
		return "Cart deleted successfully with id : "+cartId;
	}

	public List<Cart> getCart() {
		// TODO Auto-generated method stub
		return cartrepo.findAll();
	}

	

}
