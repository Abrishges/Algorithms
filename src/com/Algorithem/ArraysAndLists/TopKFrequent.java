package com.Algorithem.ArraysAndLists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequent {

	 public int[] topKFrequent(int[] nums, int k) {
	        
	        Map<Integer, Integer> mp = this.freq(nums);
	        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<Map.Entry<Integer, Integer>>(mp.entrySet());
	        
	        
	        Collections.sort(entryList, new Comparator<Map.Entry<Integer, Integer>>()
	        {              
	        
	        public int compare(Map.Entry<Integer, Integer> entry1, 
	                           Map.Entry<Integer, Integer> entry2)  
	        {
	            
	            return -(entry1.getValue().compareTo(entry2.getValue()));
	        }   
	        });
	            
	        System.out.println(entryList);
	        
	        int [] array = new int[k];
	            
	        int i = 0;
	        for (Map.Entry<Integer, Integer> entry : entryList) {
	            if(k == 0) break;
	            array[i] = entry.getKey();
	            i++;
	            k--;
	        }               
	        
	        return array;
	    }
	    
	    public Map<Integer, Integer> freq(int[] nums) {
	     
	         Map<Integer, Integer> mp = new HashMap<Integer, Integer>();
	        
	         for (int num : nums) {       
	             mp.compute(num, (k, v) -> v == null ? 1 : v + 1);
	         } 
	        
	        return mp;
	    }
	    
	 public static void main(String arg[]) {
		  //[1,1,1,2,2,3], k = 2
		 int [] nums = {1,1,1,2,2,3};
		 int k = 2;
		 
		 TopKFrequent topKFreq = new TopKFrequent();
		 topKFreq.topKFrequent(nums, k);
		 
	 }
}
