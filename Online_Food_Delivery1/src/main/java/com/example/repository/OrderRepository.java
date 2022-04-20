package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.entities.Order;


@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

	@Query("select a from Order a where a.order_id=:id")
	public Order getOrderById(int id);

}
