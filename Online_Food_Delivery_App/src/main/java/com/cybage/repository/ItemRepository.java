package com.cybage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cybage.entity.Item;
@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
	

}
