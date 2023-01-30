package com.Algorithem.ArraysAndLists;

//https://leetcode.com/problems/trapping-rain-water/solution/
// This can be done using stack as well
// we can also solve this problem using two pointer one from left and one from right 
public class TrappingRain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int trap(int[] height) {

		 int n = height.length; 
	        int [] maxLeft = new int [n];
	        int [] maxRight = new int [n];
	        
	        // int max = height[0];
	        maxLeft[0] = height[0];
	        for (int i = 1; i < n ; i++) {
	            
	             if (height[i] > maxLeft[i - 1]) {
	                // max = height[i];
	                 maxLeft[i] = height[i]; 
	             } else {
	                 maxLeft[i] = maxLeft[i - 1]; 
	             }
	        }
	        
	         maxRight[n - 1] = height[n - 1]; 
	        for (int i = n - 2; i >= 0 ; i--) {
	            
	            if (height[i] > maxRight[i + 1]) {
	                 maxRight[i] = height[i];
	                // maxRight[i] = max; 
	             } else {
	                 maxRight[i] = maxRight[i + 1]; 
	             }  
	        }
	        
	        int result = 0;      
	        for (int i = 0; i < n ; i++) {
	            result += Math.min(maxLeft[i], maxRight[i]) - height[i];
	        }
	      
		return result;
	}

}
