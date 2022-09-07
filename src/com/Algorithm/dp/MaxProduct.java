package com.Algorithm.dp;

public class MaxProduct {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MaxProduct maxProduct = new MaxProduct();
		
		int [ ] nums = {-4, -3, -2};

		 System.out.println(maxProduct.maxProduct(nums));
	}
	
	
	 public int maxProduct(int[] nums) {
	        
	        if (nums.length == 0) return 0;
	        
	        int maxSofar = nums[0];
	        int minSofar = nums[0];
	        
	        int result = maxSofar;
	        
	        for (int i = 1; i < nums.length ; i++) {
	            
	            int tempMax = Math.max(nums[i], Math.max(nums[i] * maxSofar, nums[i] * minSofar));
	            minSofar = Math.min(nums[i], Math.min(nums[i] * maxSofar, nums[i] * minSofar));
	            
	            maxSofar  = tempMax;
	            result = Math.max(result, maxSofar);
	            
	        }
	 
	        return result;
	    }
}
