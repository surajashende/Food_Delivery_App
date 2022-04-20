package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.Restaurant;
@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {
	
	


}
