package com.example.controller;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.AdminService;
import com.example.service.Rest_OwnerService;
import com.example.service.RestaurantService;
import com.example.dto.LoginRequest;
import com.example.entities.Admin;
import com.example.entities.Rest_Owner;
import com.example.entities.Restaurant;

@RestController
@EnableAutoConfiguration
@RequestMapping("/admin")
@CrossOrigin(origins = "*")
@Transactional
public class AdminController {
	
	@Autowired
	AdminService adminservice;
	
	@Autowired
	Rest_OwnerService rest_ownerservice;
	
	@Autowired
	RestaurantService restservice;
	
	@PostMapping("/addowner")
	public ResponseEntity<?>saveownerDetails(@RequestBody @Valid Rest_Owner rest_owner)
	{
		System.out.println("In save Rest_owner");
		return new ResponseEntity<>(rest_ownerservice.saveOwnerDetails(rest_owner),HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
	public Admin adminLogin(@RequestBody @Valid LoginRequest payload)
	{
		System.out.println("auth vendor"+payload);
		return adminservice.adminLogin(payload.getEmail(),payload.getPassword());
		
	}
	
	@PostMapping("/loginowner")
	public Rest_Owner loginOwner(@RequestBody @Valid LoginRequest payload){
		System.out.println("auth vendor "+payload);
		return rest_ownerservice.ownerLogin(payload.getEmail(),payload.getPassword());
	}
	
	@GetMapping("/{ownerId}")
	public ResponseEntity<?> getOwnerDetailsById(@PathVariable int ownerId){
		System.out.println("in get vendor details "+ownerId);
		return ResponseEntity.ok(rest_ownerservice.getOwnerById(ownerId));
		
	}
	@DeleteMapping("/{ownerId}")
	public ResponseEntity<String> deleteownerDetails(@PathVariable int ownerId){
		System.out.println("in del vendor Details "+ownerId);
		return ResponseEntity.ok(rest_ownerservice.deleteOwnerDetails(ownerId));
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateownerDetails(@RequestBody Rest_Owner detachedOwner,@PathVariable("id") int ownerId){
		//check if user exit by id
	//	rest_ownerservice.getOwnerById(detachedOwner.getId());
		return ResponseEntity.ok(rest_ownerservice.updateOwnerDetails(detachedOwner,ownerId));}
		
	@GetMapping("/getOwner")
		public List<Rest_Owner> getOwner()
		{
			return rest_ownerservice.getOwner();
		}
	
	//========================Restaurant Opeartions======================

	@PostMapping("/addrestaurant")
	public ResponseEntity<?>saveRestoDetails(@RequestBody @Valid Restaurant restaurant)
	{
		System.out.println("In save Restaurant");
		return new ResponseEntity<>(restservice.saveRestaurant(restaurant),HttpStatus.CREATED);
	}
	
	@GetMapping("/findresto/{restId}")
	public ResponseEntity<?> getRestoDetailsById(@PathVariable int restId){
		System.out.println("in get vendor details "+restId);
		return ResponseEntity.ok(restservice.getRestoById(restId));
		
	}
	
	@DeleteMapping("/deleteresto/{restId}")
	public ResponseEntity<String> deleteRestoDetails(@PathVariable int restId){
		System.out.println("in del vendor Details "+restId);
		return ResponseEntity.ok(restservice.deleteRestoDetails(restId));
	}
	
	@PutMapping("/update1/{id}")
	public ResponseEntity<?> updateRestoDetails(@RequestBody Restaurant detachedrest,@PathVariable("id") int restId){
		//check if user exit by id
	//	rest_ownerservice.getOwnerById(detachedOwner.getId());
		return ResponseEntity.ok(restservice.updateRestoDetails(detachedrest,restId));
	}
	
	@GetMapping("/getRest")
	public List<Restaurant> getRestaurant()
	{
		return restservice.getall();
	}

}
