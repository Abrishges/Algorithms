package com.Algorithm.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
 * Given a string s, sort it in decreasing order based on the frequency of the characters.
 *  The frequency of a character is the number of times it appears in the string.
 *  https://leetcode.com/problems/sort-characters-by-frequency/
 */
class FrequencySort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FrequencySort fqSort = new FrequencySort();
		System.out.println(fqSort.freqSort("Hello buDdy"));
	}

	//Time complexity for this one is o(nlogn)
	public String freqSort(String str) {
		
		Map<Character, Integer> mp = new HashMap<Character, Integer>();
		
		for (int i = 0; i < str.length(); i++) {
			Character key = str.charAt(i);
			mp.put(key, mp.getOrDefault(key, 0)+ 1);
		}
		
		System.out.println(mp);
        List<Character> charList = new ArrayList<Character>(mp.keySet());
        //sort list in reverse order
        Collections.sort(charList, (a, b) -> mp.get(b) - mp.get(a));
        
        StringBuilder strBuilder = new StringBuilder();
        
        for(Character ch : charList) {
        	int count = mp.get(ch);
        	for (int i = 0; i < count ; i++) {
        		strBuilder.append(ch);
        	}
        }
        
        return (strBuilder.toString());
	}
	
	//How about we use bucker sort here, 
	// How about using priority queue
}
