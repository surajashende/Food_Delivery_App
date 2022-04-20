package com.example.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.Rest_Owner;
import com.example.entities.User;
import com.example.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	  private UserRepository userrepo;

public User updateUserDetails(User user,int userId) {
		
	User user1=userrepo.getUserById(userId);
		//if(rest_owner.getRole().equals(Role.RESTAURANT_OWNER)) {
		
	user1.setUser_name(user.getUser_name());
	user1.setAddress(user.getAddress());
	user1.setEmail(user.getEmail());
	user1.setPhoneNo(user.getPhoneNo());
	user1.setPassword(user.getPassword());
	user1.setArea(user.getArea());
	user1.setCity(user.getCity());
	user1.setPincode(user.getPincode());
			User userDetails = userrepo.save(user1);
		return userDetails;
	}


public String deleteuserDetails(int userId) {
		
	userrepo.deleteById(userId);
		return "User details deleted successfully with id : "+userId;
	}


public List<User> getUser() {
	// TODO Auto-generated method stub
	return userrepo.findAll();
}
}
