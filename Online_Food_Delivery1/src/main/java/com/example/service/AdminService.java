package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.Admin;
import com.example.entities.Rest_Owner;
import com.example.repository.AdminRepository;
import com.example.repository.Rest_OwnerRepository;

@Service
public class AdminService {

@Autowired
AdminRepository 	adminrepo;


	public Admin adminLogin(String email,String password)
	{
		
		return adminrepo.findByEmailandPassword(email, password);
	}
	
	



}
