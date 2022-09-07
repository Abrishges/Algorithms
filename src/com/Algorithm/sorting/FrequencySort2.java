package com.Algorithm.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrequencySort2 {

	public static void main(String [] args) {
		FrequencySort2 fqSort = new FrequencySort2();
		System.out.println(fqSort.frequencySort("tree"));
	}
	
	public String frequencySort(String str) {
		
		Map<Character, Integer> freq = new HashMap<Character, Integer>();
			
			for (Character ch : str.toCharArray()) {
				freq.put(ch, freq.getOrDefault(ch, 0) + 1);
			}

		
		System.out.println(freq);
		int max = Collections.max(freq.values());
		
		System.out.println(max);
		
		List<ArrayList<Character>> buckets = new ArrayList<ArrayList<Character>>();
		
		for (int i = 0; i <= max; i++) {		
			  buckets.add(new ArrayList<Character>());
		}
				
		for (Character key : freq.keySet()) {
			 int count = freq.get(key);
			 buckets.get(count).add(key);
		}
		
		System.out.println(buckets);
		
		StringBuilder strBuilder = new StringBuilder();
		
		for (int i = buckets.size() - 1; i >= 1; i--) {
			 
			    ArrayList<Character> listOfChar = buckets.get(i);
			    
			    for (Character ch : listOfChar) {
				    for (int j = 0; j < i; j++) {
				    	strBuilder.append(ch);
				    }
			    }
		}
		
		return strBuilder.toString(); 
	}
}
