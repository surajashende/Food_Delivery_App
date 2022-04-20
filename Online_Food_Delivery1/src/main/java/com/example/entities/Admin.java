package com.example.entities;

import java.util.List;

import javax.persistence.*;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="admin")
@Component
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int admin_id;
	@Column(length = 20, nullable = false)
	private String password;
	@Column(nullable = false)
	private String email_id;
	@Column(length=20,nullable = false)
	private Role role;
	@Column(length = 20,nullable = false)
	private String admin_name;
	@Column(length = 50,nullable = false)
	private String phoneNo;
	
	
	 @OneToMany(mappedBy ="ad")
	 @JsonIgnore
	    private List<Rest_Owner> restowner;
	
	    @OneToMany(mappedBy ="adm")
		 @JsonIgnore
		    private List<Restaurant> restaurants;
		

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(String password, String email_id, Role role, String admin_name, String phoneNo,
			List<Rest_Owner> restowner) {
		super();
		this.password = password;
		this.email_id = email_id;
		this.role = role;
		this.admin_name = admin_name;
		this.phoneNo = phoneNo;
		this.restowner = restowner;
	}
	
	

	public Admin(String password, String email_id, Role role, String admin_name, String phoneNo,
			List<Rest_Owner> restowner, List<Restaurant> restaurants) {
		super();
		this.password = password;
		this.email_id = email_id;
		this.role = role;
		this.admin_name = admin_name;
		this.phoneNo = phoneNo;
		this.restowner = restowner;
		this.restaurants = restaurants;
	}
	
	

	public List<Restaurant> getRestaurants() {
		return restaurants;
	}

	public void setRestaurants(List<Restaurant> restaurants) {
		this.restaurants = restaurants;
	}

	public int getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getAdmin_name() {
		return admin_name;
	}

	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public List<Rest_Owner> getRestowner() {
		return restowner;
	}

	public void setRestowner(List<Rest_Owner> restowner) {
		this.restowner = restowner;
	}

	@Override
	public String toString() {
		return "Admin [admin_id=" + admin_id + ", password=" + password + ", email_id=" + email_id + ", role=" + role
				+ ", admin_name=" + admin_name + ", phoneNo=" + phoneNo + ", restowner=" + restowner + ", restaurants="
				+ restaurants + "]";
	}

	

	
}
