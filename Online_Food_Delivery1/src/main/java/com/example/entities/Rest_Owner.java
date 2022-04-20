package com.example.entities;

import java.util.List;

import javax.persistence.*;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="rest_owner")
@Component
public class Rest_Owner {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer owner_id;
	@Column(length = 20)
	private String password;
	@Column
	private String email;
	@Column(length=20)
	private Role role;
	@Column(length = 20)
	private String owner_name;
	@Column(length = 10)
	private String phoneNo;

	 @ManyToOne
	    @JoinColumn(name = "admin_id")
	    private Admin ad;
		
	 @OneToMany(mappedBy ="owner")
	 //@JsonIgnore
	    private List<Category> category1;
	 
	 
	 @OneToMany(mappedBy ="owner1")
	 //@JsonIgnore
	    private List<Product> product;
	
	public Rest_Owner() {
		super();
		// TODO Auto-generated constructor stub
	}
		


	public Rest_Owner(String password, String email, Role role, String owner_name, String phoneNo, Admin ad,
			List<Category> category1, List<Product> product) {
		super();
		this.password = password;
		this.email = email;
		this.role = role;
		this.owner_name = owner_name;
		this.phoneNo = phoneNo;
		this.ad = ad;
		this.category1 = category1;
		this.product = product;
	}



	public List<Product> getProduct() {
		return product;
	}



	public void setProduct(List<Product> product) {
		this.product = product;
	}



	public List<Category> getCategory1() {
			return category1;
		}
		public void setCategory1(List<Category> category1) {
			this.category1 = category1;
		}
	public String getOwner_name() {
		return owner_name;
	}




	public void setOwner_name(String owner_name) {
		this.owner_name = owner_name;
	}




	public Admin getAd() {
		return ad;
	}


	public void setAd(Admin ad) {
		this.ad = ad;
	}


	public void setOwner_id(Integer owner_id) {
		this.owner_id = owner_id;
	}


	public Integer getOwner_id() {
		return owner_id;
	}

	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	
	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}



	@Override
	public String toString() {
		return "Rest_Owner [owner_id=" + owner_id + ", password=" + password + ", email=" + email + ", role=" + role
				+ ", owner_name=" + owner_name + ", phoneNo=" + phoneNo + ", ad=" + ad + ", category1=" + category1
				+ ", product=" + product + "]";
	}









}
