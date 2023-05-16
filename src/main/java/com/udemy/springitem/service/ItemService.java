package com.udemy.springitem.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udemy.springitem.model.Item;
import com.udemy.springitem.repo.ItemRepository;

@Service
public class ItemService {
	
	@Autowired
	private ItemRepository itemrepository;
	
	public List<Item> getAllItems(){
		List<Item> allItems = new ArrayList<>();
		itemrepository.findAll().forEach(allItems::add);;
		
		return allItems;
	}
	
	public Optional<Item> getItem(Long itemId) {
		return itemrepository.findById(itemId);
	}
	
	public void addItem(Item item) {
		itemrepository.save(item);
	}
	
	public void updateItem(Long itemId,Item item) {
		if(itemrepository.findById(itemId).get() != null) {
			itemrepository.save(item);
		}
	}
	
	public void deleteItem(Long itemId) {
		itemrepository.deleteById(itemId);
	}
}
