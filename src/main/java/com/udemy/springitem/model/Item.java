package com.udemy.springitem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity(name = "m_item")
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long itemId;
	private String itemName;
	private String itemCategory;
	
	public Item(String itemName, String itemCategory) {
		this.itemName = itemName;
		this.itemCategory = itemCategory;
	}
}
