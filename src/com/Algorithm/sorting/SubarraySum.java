package com.Algorithm.sorting;

import java.util.HashMap;

// https://leetcode.com/problems/subarray-sum-equals-k/
/*
 * Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
   A subarray is a contiguous non-empty sequence of elements within an array.
   -1000 <= nums[i] <= 1000
 */
public class SubarraySum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public int subarraySum(int[] nums, int k) {
	        
	     int count = 0, sum = 0;
	        HashMap < Integer, Integer > map = new HashMap < > ();
	        map.put(0, 1);
	        for (int i = 0; i < nums.length; i++) {
	            sum += nums[i];
	            if (map.containsKey(sum - k))
	                count += map.get(sum - k);
	            map.put(sum, map.getOrDefault(sum, 0) + 1);
	        }
	        return count;
	    }

}
