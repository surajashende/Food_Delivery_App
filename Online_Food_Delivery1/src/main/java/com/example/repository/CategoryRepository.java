package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

	@Query("select a from Category a where a.cat_id=:catId")
	Category getCategoryById(int catId);

}
