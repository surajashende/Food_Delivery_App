package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.Rest_Owner;
import com.example.entities.Restaurant;
import com.example.repository.RestaurantRepository;

@Service
public class RestaurantService {
	
	@Autowired
	RestaurantRepository restrepo;
	
	public String saveRestaurant(Restaurant restaurant) {
		Restaurant restDetails = restrepo.save(restaurant);
		return restDetails.getRest_name()
				+", successfully registered";}
	
		
	public Restaurant updateRestoDetails(Restaurant restaurant,int restId) {
		
		Restaurant restaurant1=restrepo.findById(restId).get();
		//if(rest_owner.getRole().equals(Role.RESTAURANT_OWNER)) {
		
		restaurant1.setRest_name(restaurant.getRest_name());
		restaurant1.setAddress(restaurant.getAddress());
		restaurant1.setArea(restaurant.getArea());
		restaurant1.setCity(restaurant.getCity());
		restaurant1.setPincode(restaurant.getPincode());
		restaurant1.setEstimated_deliver_time(restaurant.getEstimated_deliver_time());
		restaurant1.setOpen_time(restaurant.getOpen_time());
		restaurant1.setClose_time(restaurant.getClose_time());


		Restaurant restDetails = restrepo.save(restaurant1);
		return restDetails;
	}
	
	public Restaurant getRestoById(int id) {
		
		return restrepo.findById(id).get();
	}

	
	public String deleteRestoDetails(int restId) {
		
		restrepo.deleteById(restId);
		return "Restaurant details deleted successfully with id : "+restId;
	}


	public List<Restaurant> getall() {
		// TODO Auto-generated method stub
		return restrepo.findAll();
	}

	

}
