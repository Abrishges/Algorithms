package com.Algorithem.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class MinWindSubString2 {

	public static void main(String[] args) {
	  
//		String str = "a";
//		String sub = "b";
		
//		String str = "ADOBECODEBANC";
//		String sub = "ABC";
		
		String str = "aaaaaaaaaaaabbbbbcdd";
		String sub = "abcdd";
		
//		String str = "a";
//		String sub = "aa";
		
		MinWindSubString2 test =  new MinWindSubString2();
		System.out.println(test.minWindow(str, sub));
	}
	
	public String minWindow(String s, String t) {
        
        if (s.length() < t.length() || t.isBlank()){
            return "";
        }
       
       int right = Integer.MAX_VALUE;
       int left = 0;
       
       Map<Character, Integer> mp = new HashMap<Character, Integer>();
       Map<Character, Integer> mpstr = new HashMap<Character, Integer>();
       
       for (int i = 0; i < t.length(); i++) {
           //mp.merge(String.valueOf(t.charAt(i)), 1, Integer::sum);
           //mp.compute(String.valueOf(t.charAt(i)), (k, v) -> (v == null) ? 1: v + 1 );
    	   
    	   // The above two also works, For the sake of readability
    	   int value = mp.getOrDefault(t.charAt(i), 1);
    	   mp.put(t.charAt(i), value + 1);
       }
       
       int i = 0;
       int length = t.length();
       
       for (int j = 0; j < s.length(); j++) {
    	   
    	   Character key = s.charAt(j);
           
           if (mp.containsKey(key)){
      	       int count = mpstr.getOrDefault(key, 0);
               mpstr.put(key, count + 1);     
               
        	   if(mpstr.containsKey(key)) {
                   if (mpstr.get(key).intValue() <= mp.get(key).intValue()) {
                       length--; 
                   }
        	   }
           }
                      
               while (length == 0) {
            	   if (j - i < right - left) {
                       right = j;
                       left = i;  
            	   }
            	   
            	   Character ch = s.charAt(i);   
                   if (mpstr.containsKey(ch)) {
                	     
                       if (mpstr.get(ch).intValue() <= mp.get(ch).intValue()) {
                           length++;  
                       }
                       
                       mpstr.compute(ch, (k, v) -> v - 1);
                   }
                   
                   i++;
               } 
       }  
       
       if (right == Integer.MAX_VALUE) {
    	   return "";
       }

       return s.substring(left, right + 1);
   }
}
