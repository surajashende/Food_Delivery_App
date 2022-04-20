package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.*;
import com.example.repository.*;

@Service
public class OrderService {
	
	@Autowired
	OrderRepository orderrepo;
	
	@Autowired
	CartRepository cartrepo;
	
	public String addOrder(Order order) {
		Order addOrder = orderrepo.save(order);
		return addOrder.getOrder_id()
				+",sucessfully Placed ";
	}
	
public Order getOrderById(int id) {
		
		return orderrepo.findById(id).get();
	}

	
//	public Order updateOrderDetails(Order order,int orderId,int cartId) {
//		
//		Order order1=orderrepo.getOrderById(orderId);
//		Cart cart1=cartrepo.getCartById(cartId);
//
//		//if(rest_owner.getRole().equals(Role.RESTAURANT_OWNER)) {
//		
//		cart1.setProduct(cart1.getProduct().getProduct_id());
//		cart1.getProduct().getProduct_name()
//		    Order orderDetails = orderrepo.save(order);
//		return orderDetails;
//	}
	
	
	public String deleteOrderDetails(int orderId) {
		
		orderrepo.deleteById(orderId);
		return "Order deleted successfully with id : "+orderId;
	}

	public List<Order> getOrder() {
		// TODO Auto-generated method stub
		return orderrepo.findAll();
	}
	

	
	

}
