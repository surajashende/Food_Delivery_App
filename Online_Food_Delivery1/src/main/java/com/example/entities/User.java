package com.example.entities;

import java.sql.Time;
import java.util.List;

import javax.persistence.*;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="user")
public class User {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int user_id;
	@Column(length = 20, nullable = false)
	private String password;
	@Column(unique = true, nullable = false)
	private String email;
	@Column(length=20,nullable = false)
	private Role role;
	@Column(length = 20,nullable = false)
	private String user_name;
	@Column(length = 50,nullable = false)
	private String phoneNo;
	@Column(length = 50,nullable = false)
	private String address;
	@Column(length = 50,nullable = false)
	private String area;
	@Column(length = 50,nullable = false)
	private String city;
	@Column(length = 50,nullable = false)
	private String pincode;
	
	
public User() {
		super();
		// TODO Auto-generated constructor stub
	}


public User(String password, String email, Role role, String user_name, String phoneNo, String address, String area,
		String city, String pincode) {
	super();
	this.password = password;
	this.email = email;
	this.role = role;
	this.user_name = user_name;
	this.phoneNo = phoneNo;
	this.address = address;
	this.area = area;
	this.city = city;
	this.pincode = pincode;
}


public int getUser_id() {
	return user_id;
}


public void setUser_id(int user_id) {
	this.user_id = user_id;
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


public String getUser_name() {
	return user_name;
}


public void setUser_name(String user_name) {
	this.user_name = user_name;
}


public String getPhoneNo() {
	return phoneNo;
}


public void setPhoneNo(String phoneNo) {
	this.phoneNo = phoneNo;
}


public String getAddress() {
	return address;
}


public void setAddress(String address) {
	this.address = address;
}


public String getArea() {
	return area;
}


public void setArea(String area) {
	this.area = area;
}


public String getCity() {
	return city;
}


public void setCity(String city) {
	this.city = city;
}


public String getPincode() {
	return pincode;
}


public void setPincode(String pincode) {
	this.pincode = pincode;
}


@Override
public String toString() {
	return "User [user_id=" + user_id + ", password=" + password + ", email=" + email + ", role=" + role
			+ ", user_name=" + user_name + ", phoneNo=" + phoneNo + ", address=" + address + ", area=" + area
			+ ", city=" + city + ", pincode=" + pincode + "]";
}
		 
	

}
