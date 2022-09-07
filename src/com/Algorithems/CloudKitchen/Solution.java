package com.Algorithems.CloudKitchen;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	// May be I should convert them Category to interface and both option Dish will implement them
	 public List<Category> parse(MenuStream menuStream) {
		 
		 List<Category> items = new ArrayList<Category>();
		 Category catagory = new Category();

	      String current = menuStream.nextLine();
	      List<String> store = new ArrayList<String>();

	      while (current != null) {
	          if(current.isEmpty()) {
	             // create object and process 
	              if (ItemType.valueOf(store.get(1)).equals(ItemType.DISH)) {
	            	  Category dish = new dish();
	                // dish.id =  store.get(0);
	                 dish.setId(store.get(0));
	                 dish.type = ItemType.valueOf(store.get(1));
	                 dish.name = store.get(2);
	                 dish.price = store.get(3);
	                 dish.linkedItems = new ArrayList<>();

	                 if (store.size() > 4) {
	                   for (int i = 4; i < store.size(); i++) {
	                    dish.linkedItems.add(store.get(i));
	                   }
	                 }
	                 items.add(dish);
	                store.clear();
	              } else if (ItemType.valueOf(store.get(1)).equals(ItemType.CATEGORY)) {
	            	  Category catagory = new catagory();
	                 catagory.id =  store.get(0);
	                 catagory.type = ItemType.valueOf(store.get(1));
	                 catagory.name = store.get(2);
	                 catagory.linkedItems = new ArrayList<>();

	                 
	                 if (store.size() > 3) {
	                   for (int i = 3; i < store.size(); i++) {
	                    catagory.linkedItems.add(store.get(i));
	                   }
	                 }
	                 items.add(catagory);
	                 store.clear();
	              } else {
	            	  Category option = new option();

	                 option.id =  store.get(0);
	                 option.type = ItemType.valueOf(store.get(1));
	                 option.name = store.get(2);
	                 option.price = store.get(3);  
	                 items.add(option);             
	                 store.clear();
	              }
	          } else {
	             store.add(current);
	          }

	          current = menuStream.nextLine();
	      }

	   return item;
	}

}
