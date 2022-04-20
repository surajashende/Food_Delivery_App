package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.entities.Cart;
import com.example.entities.User;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
	
	public List<Cart> findByUser(User user);

	@Query("select a from Cart a where a.cart_id=:cartId")
	public Cart getCartById(int cartId);

}
