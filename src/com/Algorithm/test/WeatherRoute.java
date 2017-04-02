/**
 * 
 */
package com.Algorithm.test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author aberehamwodajie
 *
 * Dec 19, 2016
 */
public class WeatherRoute {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	    
		List<String> list1 = new LinkedList<String>(Arrays.asList("Seattle", "Tacoma", "Portland", "Los Angeles", "Austin", "Dallas"));
	    String [] list2 = { "Portland", "Los Angeles", "Seattle", "Addis Ababa" };

		 System.out.println("Org route: " + list1);
		 System.out.println("Weather route: " + list2);
		
		updateRoute(list1, list2);
		
		System.out.println("Updated route: " + list1);
		 System.out.println("Weather route: " + list2);

	}
	
	public static void updateRoute(List<String> list1, String [] list2) {
		
		 for(String city : list2){
			 list1.remove(city);
		 }
		
	}

}
