package com.Algorithem.mymath;

import java.util.Arrays;

//Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
public class ThreeSumClosest {

	public static void main(String[] args) {
		
		ThreeSumClosest threeClosestSum = new ThreeSumClosest();
		
	   // int [] nums = {-1,2,1,-4};	
	    int [] nums = {0,1,2};
		//int target = 1;
		int target = 3;
		int closest = threeClosestSum.threeSumClosest(nums, target);
		
		System.out.println(closest);
	}

	public int threeSumClosest(int [] nums, int target) {
		 
		Arrays.sort(nums);
		int diff = Integer.MAX_VALUE;
		
		for (int i = 0; i < nums.length; i++) {
		    
			 int lo = i + 1; 
			 int hi = nums.length - 1;
			 
			 while (lo < hi) {
				 int sum = nums[lo] + nums[hi] + nums[i];
				  System.out.printf("Sum: %d \n", sum);
				 //no need to check if the sum and target are equal or the first three numbers are equal to target
				 if (sum - target == 0) {
					 break;
				 }
				 
				 if (Math.abs(sum - target) < Math.abs(diff)) {
					 System.out.printf("sum: %d \n", sum);
					 System.out.printf("target: %d \n", target);
					 diff = (sum - target);
					 System.out.printf("diff: %d \n", diff);
				 }
				 
				 if (sum < target) {
					 lo++;
				 } else {
					 hi --; 
				 }
			 }
		}
		
		return target + diff;
	}
}
