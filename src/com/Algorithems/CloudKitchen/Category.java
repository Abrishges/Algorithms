package com.Algorithems.CloudKitchen;

import java.util.ArrayList;
import java.util.List;

public class Category {
   
	private long id; 
	private ItemType type;
	private String name;
	private List<Long> linkerdItems;
	
	public Category() {
		this.id = 0;
		this.linkerdItems = new ArrayList<>();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public ItemType getType() {
		return type;
	}

	public void setType(ItemType type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Long> getLinkerdItems() {
		return linkerdItems;
	}

	public void setLinkerdItems(List<Long> linkerdItems) {
		this.linkerdItems = linkerdItems;
	}

	@Override
	public String toString() {
		return "Catagory [id=" + id + ", type=" + type + ", name=" + name + ", linkerdItems=" + linkerdItems + "]";
	}
}
