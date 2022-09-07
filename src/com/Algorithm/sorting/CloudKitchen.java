package com.Algorithm.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class CloudKitchen {

	public static void main(String[] args) {
		
		CloudKitchen ck = new CloudKitchen();
		MenuStreamImpl menuStream = ck.new MenuStreamImpl();
		
		List<Item> menuItems = new ArrayList<>();
		Item item = ck.new Item();

		
		String current = menuStream.nextLine();
		List<String> buffer = new ArrayList<String>();
		while(current != null) {
			if(current.isEmpty()) {
		        item.id = Long.parseLong(buffer.get(0));
		        item.type = ItemType.valueOf(buffer.get(1));
		        item.name = buffer.get(2);
		        
		        if (item.type.equals(ItemType.DISH) || item.type.equals(ItemType.option)) {
		          item.price = Double.parseDouble(buffer.get(3));
		        } else {
		          item.linkedIds.add(Long.parseLong(buffer.get(3)));
		        }
		        
		        if (buffer.size() > 4) {
		          for (int i = 4; i < buffer.size(); i++) {
		            item.linkedIds.add(Long.parseLong(buffer.get(i)));
		          }
		        }
		        menuItems.add(item);
		        item = ck.new Item();
		        buffer.clear();
			} else {
				buffer.add(current);
			}
			current = menuStream.nextLine();
		}

	}
	
	enum ItemType {
		DISH, 
		Catagory,
		option
	}
	
	class Item {
		private long id; 
		private String name;
		private ItemType type; 
		private double price; 
		private List<Long> linkedIds; 
		
		public Item() {
			id = 0;
			name = new String();
			price = 0.0;
		}

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public ItemType getType() {
			return type;
		}

		public void setType(ItemType type) {
			this.type = type;
		}

		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}

		public List<Long> getLinkedIds() {
			return linkedIds;
		}

		public void setLinkedIds(List<Long> linkedIds) {
			this.linkedIds = linkedIds;
		}
		
	}
	
	interface MenuStream {
		/**
		 * 
		 * @return next input line or null when the stream is empty
		 */
		public String nextLine();
	}
	
	class MenuStreamImpl implements MenuStream {
		
		private List<String> lines = new ArrayList<>(Arrays.asList("4", "DISH", "Spaghetti", "10.95", "2", "3", "", "1", "CATEGORY", "Pasta", "4", "5", "", "2", "OPTION", "Meatballs", "1.00", "", "3", "OPTION", "Chicken", "2.00", "", "5", "DISH", "Lasagna", "12.00", "", "6", "DISH", "Caesar Salad", "9.75", "3", ""));
        private Iterator<String> it = lines.iterator();
        
		@Override
		public String nextLine() {
			if (it.hasNext()) {
				return it.next();
			} else {
			   return null;
			}
		}
	}
}
