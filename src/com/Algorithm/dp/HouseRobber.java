package com.Algorithm.dp;


/*
 * All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system
 * connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * Input: nums = [2,3,2]
 * Output: 3
 */
public class HouseRobber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	   public int rob(int[] nums) {
	        
	        int n = nums.length;
	        
	        if (n == 0) return 0;
	        
	        if (n == 1) return nums[0];
	       
	        int max1 = houseRober(nums, 0, n - 2);
	        int max2 = houseRober(nums, 1, n - 1);  
	        
	        return Math.max(max1, max2);
	    }
	    
	    public int houseRober(int [] nums, int start, int end) {
	         
	        int value1 = 0;
	        int value2 = 0;
	        int curMax = 0;

	        for (int i = start; i <= end; i++) {   
	            curMax = Math.max(nums[i] + value2, value1);
	            value2 = value1;
	            value1 = curMax;
	        }

	        return curMax;
	    }
}
