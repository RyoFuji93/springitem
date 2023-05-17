package com.udemy.springitem.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import com.udemy.springitem.model.Item;
import com.udemy.springitem.repo.ItemRepository;

@Service
public class ItemService {
	
	@Autowired
	private ItemRepository itemrepository;
	
	@Cacheable(value = "getItems")
	public List<Item> getAllItems(){
		List<Item> allItems = new ArrayList<>();
		itemrepository.findAll().forEach(allItems::add);;
		
		return allItems;
	}
	
	@Cacheable(value = "getItem", key="#p0")
	public Optional<Item> getItem(Long itemId) {
		return itemrepository.findById(itemId);
	}
	
	@CacheEvict(value = "getItems", allEntries=true)
	public void addItem(Item item) {
		itemrepository.save(item);
	}
	
	@Caching(evict = {
			@CacheEvict(value="getItem", key="#p0"),
			@CacheEvict(value="getItems", allEntries=true)
	})
	public void updateItem(Long itemId,Item item) {
		if(itemrepository.findById(itemId).get() != null) {
			itemrepository.save(item);
		}
	}
	
	@Caching(evict = {
			@CacheEvict(value="getItem", key="#p0"),
			@CacheEvict(value="getItems", allEntries=true)
	})
	public void deleteItem(Long itemId) {
		itemrepository.deleteById(itemId);
	}
}
