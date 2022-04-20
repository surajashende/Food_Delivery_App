package com.example.entities;

import javax.persistence.*;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Component
@Table(name="product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer product_id;
	@Column(length = 20)
	private String product_name;
	@Column(length = 20)
	private String product_price;	
	@ManyToOne
	//@JsonIgnore
    @JoinColumn(name = "cat_id")
    private Category cat;
	
     @ManyToOne
	//@JsonIgnore
    @JoinColumn(name = "owner_id")
    private Rest_Owner owner1;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}




public Product(String product_name, String product_price, Category cat, Rest_Owner owner1) {
		super();
		this.product_name = product_name;
		this.product_price = product_price;
		this.cat = cat;
		this.owner1 = owner1;
	}




public Rest_Owner getOwner1() {
	return owner1;
}




public void setOwner1(Rest_Owner owner1) {
	this.owner1 = owner1;
}




public Integer getProduct_id() {
	return product_id;
}

public void setProduct_id(Integer product_id) {
	this.product_id = product_id;
}

public String getProduct_name() {
	return product_name;
}

public void setProduct_name(String product_name) {
	this.product_name = product_name;
}

public String getProduct_price() {
	return product_price;
}

public void setProduct_price(String product_price) {
	this.product_price = product_price;
}

public Category getCat() {
	return cat;
}

public void setCat(Category cat) {
	this.cat = cat;
}




@Override
public String toString() {
	return "Product [product_id=" + product_id + ", product_name=" + product_name + ", product_price=" + product_price
			+ ", cat=" + cat + ", owner1=" + owner1 + "]";
}


}
