package com.cybage.entity;

import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Item")
public class Item {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="item_id")
	private int itemId;
	
	@Column(name="itemName")
	private String itemName;
	
	@Column(name="cost")
	private String cost;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cat_id")
	private Category category;
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Item() {
		super();
	}
	
	public Item(int itemId, String itemName, String cost, Category category) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.cost = cost;
		this.category = category;
	}

	public int getItemId() {
		return itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public String getCost() {
		return cost;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemName=" + itemName + ", cost=" + cost + "]";
	}
}
