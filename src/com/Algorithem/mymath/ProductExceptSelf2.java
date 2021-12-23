package com.Algorithem.mymath;

import java.util.Arrays;

public class ProductExceptSelf2 {

	public static void main(String[] args) {
	// TODO Auto-generated method stub
		
		int [] nums = {1, 2, 3, 4};
		ProductExceptSelf self = new ProductExceptSelf();
		
		int [] result = self.productExceptSelf(nums);
		System.out.println(Arrays.toString(result));
	}
	
	
	public void productExceptSelf(int [] nums) {
		
		int [] answers = new int[nums.length];
		answers[0] = 1;
		
		for (int j = 1 ; j < nums.length; j++) {
			
			answers[j] = answers[j - 1] * nums[j - 1]; 
		}
		
		int R = 1;		
		for (int i = nums.length - 1; i > 0; i--) {
				
			answers[i] = answers[i] * R;
			R = R * nums[i];
		}
		
	}
}
