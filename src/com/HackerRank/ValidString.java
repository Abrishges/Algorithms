package com.HackerRank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem
public class ValidString {

	public static void main(String[] args) {
		
		System.out.println(isValid("aaabbcc"));
	}
	
    public static String isValid(String s) {
    	
    	 //System.out.println(s.matches("\\A\\p{ASCII}*\\z"));
    	
    	if (s.isEmpty())
    		return "NO";
    	if(s.length() <= 3)
    		return "YES";
    	 
    	Map<Character, Integer> mp = new HashMap<Character, Integer>();
    	int max = 1 ; 
    	for (int i = 0; i < s.length(); i++) {
    	
    		if(mp.containsKey(s.charAt(i))) {
    			
    			int value = mp.get(s.charAt(i));
    			value++;
    			if(value > max) {
    				max = value;
    			}
    			mp.put(s.charAt(i), value);
    		} else {
    			mp.put(s.charAt(i), 1);
    		}
    	}
    	
        if (max == 1) {
    		return "YES";
    	} else {
    		
    		 List<Integer> list = new ArrayList<>(mp.values());
    		
//    		 Map<Integer, Long> counts = list.stream().collect(Collectors.groupingByConcurrent(Function.identity(), Collectors.counting()));
//    		
//    		 List<Long> freqCounts = new ArrayList<Long>(counts.values());
//    		 
//    		 if (freqCounts.size() == 1) {
//    			 return "YES";
//    		 }
    		 
    		 int count = max - 1;
      		 int freqMax = Collections.frequency(list, max);
    		 int freq = Collections.frequency(list, count);
    		 
    		 if (freqMax == list.size()) {
    			 return "YES";
    		 } else if (freq == 0) {
    			 //abbbbccccdddd
    			 freq = Collections.frequency(list, 1); 		 
    			 if (freqMax == list.size() - 1 && freq == 1) {
    				 return "YES";
    			 } else {
    				 return "NO";
    			 }
    		 } else if (list.size() > (freq + freqMax)) {
    			return "NO";
    		 } else if (freqMax == 1 && freq == list.size() - 1 || freq == 1 && freqMax == list.size() - 1) {
    			return "YES";
    		 } else {
    			return "NO";
    		 }
    	} 	
    }
}

