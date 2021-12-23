package com.Algorithem.mymath;

import java.util.Arrays;
//Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
//You must write an algorithm that runs in O(n) time and without using the division operation.
public class ProductExceptSelf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [] nums = {1, 2, 3, 4};
		ProductExceptSelf self = new ProductExceptSelf();
		
		int [] result = self.productExceptSelf(nums);
		System.out.println(Arrays.toString(result));

	}

	 public int[] productExceptSelf(int[] nums) {

		  int [] left = new int[nums.length];
		  int [] right = new int[nums.length];
		  
		  left[0] = 1;
		  right[nums.length - 1] = 1; 
		  
		  for (int i = 1; i < nums.length; i++) {
			  left[i] = left[i - 1] * nums[i - 1];
		  }
		  
		  for (int j = nums.length - 2; j >= 0; j--) {
			  right[j] = right[j + 1] * nums[j + 1];
		  }
		 
		  int [] result = new int[nums.length];
		  for (int k = 0 ; k < nums.length ; k++) {
			  result[k] = left[k] * right[k];
		  }
		     
        return result;
    }
}
