package com.udemy.springitem.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.udemy.springitem.model.Item;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long>{
	
}
