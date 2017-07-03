/**
 * 
 */
package com.HackerRank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author aberehamwodajie
 *
 * May 20, 2017
 */
public class RoadsAndLibraries {
	
	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        HashMap<Integer, ArrayList<Integer>> cityMap = new HashMap<>();
        int n = scan.nextInt();
        int m = scan.nextInt();
        int libraryCost = scan.nextInt();
        int roadCost = scan.nextInt();
        for (int i = 1; i <= n; i++) {
        	ArrayList<Integer> list = new ArrayList<Integer>();
        	list.add(i);
        	cityMap.put(i, list);
        }
        cityMap.forEach((k,v) -> System.out.println("keys:" + k + " values: " + v));
    System.out.println("enter edges: ");
        for (int a1 = 0; a1 < m; a1++) {
        	int x = scan.nextInt();
        	int y = scan.nextInt();
        	ArrayList<Integer> list1 = cityMap.get(x);
        	System.out.println("list1: " + list1);
        	ArrayList<Integer> list2 = cityMap.get(y);
        	System.out.println("list2:" + list2);
        	if (list1 != list2) {
        		list1.addAll(list2);
        		System.out.println("after adding to list1: "+list1);
        		System.out.println("map before: " + cityMap);
        		list2.forEach(i -> cityMap.put(i, list1));
        		System.out.println("Containt of the map after adding to list2: " + list2);
        		System.out.println("map after: " + cityMap);
        	}
        }
        
        cityMap.forEach((k,v)->System.out.println("keys:" +k + "  values:" + v));
        
        scan.close();
        if (libraryCost < roadCost)
        	System.out.println((long) n * libraryCost);
        else {
        	long cost = 0;
        	 System.out.println("Content of the map: " + cityMap.values());
        	for (ArrayList<Integer> list : cityMap.values()) {
        		System.out.println("Content: " + list);
        		int size = list.size();
        		if (size > 0) {
        			cost += libraryCost;
        			cost += (size - 1) * roadCost;
        			list.removeIf(i -> true);  //removes duplicate elements
        			
        			System.out.println("list after removal: " + list);
        		}
        	}
        	System.out.println(cost);
        }
    }

}
