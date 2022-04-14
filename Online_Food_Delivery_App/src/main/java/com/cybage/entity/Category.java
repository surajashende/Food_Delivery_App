package com.cybage.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="category")
public class Category {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="cat_id")
	private int catId;
	
	@Column(name="categoryName")
	private String categoryName;

	@OneToMany(fetch = FetchType.EAGER, mappedBy="category",cascade=CascadeType.ALL)
	private Set<Item>Items;
	
	public Set<Item> getItems() {
		return Items;
	}

	public void setItems(Set<Item> items) {
		Items = items;
	}

	public Category() {
		super();
	}
	
	public Category(int catId, String categoryName, Set<Item> items) {
		super();
		this.catId = catId;
		this.categoryName = categoryName;
		Items = items;
	}


	public int getCatId() {
		return catId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	

	@Override
	public String toString() {
		return "Category [catId=" + catId + ", categoryName=" + categoryName + "]";
	}
}
