package com.example.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="cart")
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cart_id;
	@Column(length = 20)
	private String quantity;
	
	@ManyToOne
	//@JsonIgnore
	@JoinColumn(name="product_id")
	private Product product;
	
	@ManyToOne
	//@JsonIgnore
	@JoinColumn(name="user_id")
	private User user;
	
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Cart(String quantity, Product product, User user) {
		super();
		this.quantity = quantity;
		this.product = product;
		this.user = user;
	}



	public Product getProduct() {
		return product;
	}



	public void setProduct(Product product) {
		this.product = product;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public int getCart_id() {
		return cart_id;
	}
	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}



	@Override
	public String toString() {
		return "Cart [cart_id=" + cart_id + ", quantity=" + quantity + ", product=" + product + ", user=" + user + "]";
	}
	
	

}
