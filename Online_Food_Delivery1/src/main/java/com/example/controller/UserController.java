package com.example.controller;

import java.lang.System.Logger;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.LoggerFactory;
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

import com.example.entities.Cart;
import com.example.entities.Order;
import com.example.entities.User;
import com.example.service.CartService;
import com.example.service.OrderService;
import com.example.service.UserService;



@RestController
@EnableAutoConfiguration
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {
	
	@Autowired
	UserService userservice;
	@Autowired
	CartService cartservice;
	
	@Autowired
	OrderService orderservice;
	
	//==============CartOperations===============
	

	org.slf4j.Logger logger = LoggerFactory.getLogger(UserController.class);

	 

	
	@PostMapping("/addCart")
	public ResponseEntity<?>addCart(@RequestBody @Valid Cart cart)
	{
		System.out.println("In save cart");
		logger.debug("cart added");

		return new ResponseEntity<>(cartservice.addCart(cart),HttpStatus.CREATED);
	}
	
	@GetMapping("/getcart/{cartId}")
	public ResponseEntity<?> getCartById(@PathVariable int cartId){
		System.out.println("in get cart details "+cartId);
		logger.debug("cart found");

		return ResponseEntity.ok(cartservice.getCartById(cartId));
		
	}
	@DeleteMapping("/deletecart/{cartId}")
	public ResponseEntity<String> deleteCartDetails(@PathVariable int cartId){
		System.out.println("in del cart Details "+cartId);
		logger.debug("cart deleted");

		return ResponseEntity.ok(cartservice.deleteCartDetails(cartId));
	}
	
	@PutMapping("/updatecart/{id}")
	public ResponseEntity<?> updateCartDetails(@RequestBody Cart detachedCart,@PathVariable("id") int cartId){
		//check if user exit by id
	//	rest_ownerservice.getOwnerById(detachedOwner.getId());
		logger.debug("cart updated");

		return ResponseEntity.ok(cartservice.updateCartDetails(detachedCart,cartId));
	}
	
	
	@GetMapping("/getCart")
	public List<Cart> getCart()
	{
		return cartservice.getCart();
	}


	//=====================User Operations=================
	
	
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateUserDetails(@RequestBody User detacheduser,@PathVariable("id") int userId){
		//check if user exit by id
	//	rest_ownerservice.getOwnerById(detachedOwner.getId());
		logger.debug("user updated");

		return ResponseEntity.ok(userservice.updateUserDetails(detacheduser,userId));
	}
	@DeleteMapping("/{userId}")
	public ResponseEntity<String> deleteuserDetails(@PathVariable int userId){
		System.out.println("in del user Details "+userId);
		logger.debug("userdeleted");

		return ResponseEntity.ok(userservice.deleteuserDetails(userId));
	}
	
	@GetMapping("/getUser")
	public List<User> getUser()
	{
		return userservice.getUser();
	}



//===========================Order operations


@PostMapping("/placeOrder")
public ResponseEntity<?>addOrder(@RequestBody @Valid Order order)
{
	System.out.println("In save order");
	logger.debug("order added");

	return new ResponseEntity<>(orderservice.addOrder(order),HttpStatus.CREATED);
}

@DeleteMapping("/deleteorder/{orderId}")
public ResponseEntity<String> deleteOrderDetails(@PathVariable int orderId){
	System.out.println("in del user Details "+orderId);
	logger.debug("order deleted");

	return ResponseEntity.ok(orderservice.deleteOrderDetails(orderId));
}
@GetMapping("/getOrder")
public List<Order> getOrder()
{
	return orderservice.getOrder();
}

}

