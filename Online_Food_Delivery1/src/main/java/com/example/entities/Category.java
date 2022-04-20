package com.example.entities;

import java.util.List;

import javax.persistence.*;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Component
@Table(name="category")
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cat_id;
	@Column(length = 20)
	private String cat_name;
	

	 @OneToMany(mappedBy ="cat")
	 @JsonIgnore
	    private List<Product> products;

	 @ManyToOne
		//@JsonIgnore
	    @JoinColumn(name = "owner_id")
	    private Rest_Owner owner;
		


	public Category(String cat_name, List<Product> products, Rest_Owner owner) {
		super();
		this.cat_name = cat_name;
		this.products = products;
		this.owner = owner;
	}


	public Rest_Owner getOwner() {
		return owner;
	}


	public void setOwner(Rest_Owner owner) {
		this.owner = owner;
	}


	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getCat_id() {
		return cat_id;
	}


	public void setCat_id(int cat_id) {
		this.cat_id = cat_id;
	}


	public String getCat_name() {
		return cat_name;
	}


	public void setCat_name(String cat_name) {
		this.cat_name = cat_name;
	}


	public List<Product> getProducts() {
		return products;
	}


	public void setProducts(List<Product> products) {
		this.products = products;
	}


	@Override
	public String toString() {
		return "Category [cat_id=" + cat_id + ", cat_name=" + cat_name + ", products=" + products + ", restowner="
				+ owner + "]";
	}


	 
	 
		 
	
}
