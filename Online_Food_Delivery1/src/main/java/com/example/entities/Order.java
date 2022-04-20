package com.example.entities;

import javax.persistence.*;

@Entity
@Table(name="order_details")
public class Order {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int order_id;

@OneToOne
private Cart cart;

public Order() {
	super();
	// TODO Auto-generated constructor stub
}

public Order(int order_id, Cart cart) {
	super();
	this.order_id = order_id;
	this.cart = cart;
}

public int getOrder_id() {
	return order_id;
}

public void setOrder_id(int order_id) {
	this.order_id = order_id;
}

public Cart getCart() {
	return cart;
}

public void setCart(Cart cart) {
	this.cart = cart;
}



}
