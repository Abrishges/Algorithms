package com.Algorithem.Hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
 * Given an integer array, find the length of the longest subsequence formed by the consecutive integers. 
 * The subsequence should contain all distinct values, and the character set should be consecutive, 
 * irrespective of its order.
 */
public class LongestSubsequence {

	public static void main(String[] args) {
		int [] arr = {2, 0, 6, 1, 5, 3, 7};
		LongestSubsequence sub = new LongestSubsequence();
		int maxLen = sub.findMaxLenghSubsequenc(arr);
		
		System.out.println(maxLen);
	}
	
	
	public int findMaxLenghSubsequenc(int[] arr) {
		
        // construct a set out of input elements
        Set<Integer> set = IntStream.of(arr)        // Returns IntStream
                                .boxed()
                                .collect(Collectors.toSet());
        // initialize result by 0
        int maxLen = 0;

        for (int e : arr) {
       	
        	  if (!set.contains(e - 1)) {
        		  
        		  int len = 1; 
        		  
        		  while (set.contains(e + len)) {
        			  len ++;
        		  }
        		  
            	  maxLen = Math.max(maxLen, len);
        	  }
        	 	  
        }
        
		return maxLen;
	}

}
