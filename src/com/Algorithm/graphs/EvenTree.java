/**
 * 
 */
package com.Algorithm.graphs;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author aberehamwodajie
 *
 * May 15, 2017
 */
public class EvenTree {
	
	
	
	public Integer getNoOfChildes(Integer data, Map<Integer, ArrayList<Integer>>map) {
		Map<Integer, Integer> mp = new ConcurrentHashMap<Integer, Integer>();
		
		if( map.get(data).size() == 0){
			mp.put(data, 1);
			System.out.println("return 1" + data);
			return 1;
		 }
		if(mp.get(data) != null){
			System.out.println("return 2" + data);
		  return mp.get(data);
		}
		else {
			// ArrayList<Integer> list = map.get(data);
			 Integer childs = 0;
			for(Integer adj : map.get(data))
				 childs += getNoOfChildes(adj, map);
			mp.put(data, childs);
		}
		for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
			System.out.println("Item : " + entry.getKey() + " Count : " + entry.getValue());
		}
		
		return mp.get(data);
	}

	public static void main(String []args){
		Map<Integer, ArrayList<Integer>> map = new ConcurrentHashMap<Integer, ArrayList<Integer>>();
		Scanner in = new Scanner(System.in);
		Integer vertax = in.nextInt();
		 for (int j= 1; j <= vertax; j++){
			  map.put(j, new ArrayList<Integer>());
		 }
		Integer edges = in.nextInt();
		
		for(int i = 1; i <= edges; i++) {
			Integer u = in.nextInt();
			Integer v = in.nextInt();
			  ArrayList<Integer>list1 = map.get(u);
			     list1.add(v);
			     map.put(u, list1);
			  ArrayList<Integer>list2 = map.get(v);
			     list2.add(u);
			     map.put(v, list2);
		}
		
		EvenTree tree = new EvenTree();
		tree.getNoOfChildes(1, map);
		
		in.close();
	}
	
	
}


