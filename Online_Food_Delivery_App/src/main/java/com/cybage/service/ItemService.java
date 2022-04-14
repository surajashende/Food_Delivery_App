package com.cybage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cybage.entity.Item;
import com.cybage.repository.ItemRepository;

@Service
public class ItemService {
	
	@Autowired
	private ItemRepository itemRepository;

	public void addItem(Item item) {
		itemRepository.save(item);
	}
}
