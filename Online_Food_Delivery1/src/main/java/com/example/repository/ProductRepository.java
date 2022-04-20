package com.example.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.entities.Product;

@Repository

public interface ProductRepository extends JpaRepository<Product, Integer> {

	@Transactional
	@Modifying
	@Query("select a from Product a where a.product_id=:pId")
	Product getProductById(int pId);

}
