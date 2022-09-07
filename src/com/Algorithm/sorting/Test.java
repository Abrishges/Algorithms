package com.Algorithm.sorting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Test {

	public static void main(String[] args) {
       int [] s = {-1, -1, 1}; int k = 1;
		
		Test test = new Test();
		
		System.out.println(test.subarraySum(s, k));
	}
 
	  public int subarraySum(int[] nums, int k) {
	        
	        int sum = 0;
	        int count = 0;
	        int i = 0, j = 0;
	        
	         while (j < nums.length) {
	        	 
	        	
	             
	             sum += nums[j];
	             if (sum == k) {
	                 count++;
	             }
	             
	              

	             while ((Math.abs(sum) >= k && i < j) || j == nums.length - 1 && i < j) {
	                 
	                 sum -= nums[i];
	                 if(sum == k) {
	                     count++;
	                 }
	                 i++;
	             }
	              
	             j++;
	             
	         }
	      return count;  
	    }
}
