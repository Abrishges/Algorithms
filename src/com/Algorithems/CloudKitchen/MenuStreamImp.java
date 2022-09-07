package com.Algorithems.CloudKitchen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class MenuStreamImp implements MenuStream {

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
