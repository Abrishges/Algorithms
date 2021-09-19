package com.java8.practise;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arry[]  = {2, 2, 3,1,2};
		
		Map<Integer, Integer> hashmap = new HashMap<Integer, Integer>();
		
		for (int i = 0 ; i < arry.length ; i++) {
			if (hashmap.containsKey(arry[i])) {
				Integer value = hashmap.get(arry[i]);
				hashmap.put(arry[i], ++value);
			} else {
				hashmap.put(arry[i], 1);	
			}
		}
		
		Entry<Integer, Integer>entry = hashmap.entrySet().stream().max(Map.Entry.comparingByValue()).get();
		System.out.println(arry.length - entry.getValue());
	}
}
