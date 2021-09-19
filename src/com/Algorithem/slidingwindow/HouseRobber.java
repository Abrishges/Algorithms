package com.Algorithem.slidingwindow;

/**
 * 
 * There are n houses build in a line, each of which contains some value in it. A thief is going to steal 
 * the maximal value of these houses, but he can’t steal in two adjacent houses because the owner 
 * of the stolen houses will tell his two neighbors left and right side. What is the maximum stolen value?
 *
 */

public class HouseRobber {

	public static void main(String[] args) {

		int array[] = {6, 7, 1, 3, 8, 2, 4};
		
		HouseRobber houseRobber = new HouseRobber();
		int maxValue = houseRobber.maximumPossibleStolen(array);
        System.out.println(maxValue);
	}
	
	//Using dynamic programming
	public int maximumPossibleStolenValue(int [] array) {
		 int n = array.length;
		 
		 if (n == 0) {
			 return 0;
		 }
		 
		 if (n == 1) {
			 return array[1];
		 }
		 
		 if (n == 2 ) {
			 return Math.max(array[0], array[1]);
		 }
		 
	    //dp[i] represent the maximum value stolen
        //so far after reaching house i.	 
        int[] dp = new int[n];
        dp[0] = array[0];
        dp[1] = Math.max(array[0], array[1]);
        
       for (int i = 2; i < n; i++) {
    	   dp[i] = Math.max(array[i] + dp[i - 2], dp[i - 1]);   	    
       }
        
		return dp[n - 1];
	}
	
	// Using sliding window, Fast/Lagging
	// time O(n) and space o(1)
	public int maximumPossibleStolen(int [] array) {
		
		int n = array.length;
		
		if (n == 0) {
			return 0;
		}
		
		int value1 = array[0];
		if (n == 1) {
			return value1;
		}
		
		int value2 = Math.max(array[0], array[1]);
		if (n == 2) {
			return value2;
		}
		
		int maxValue = 0;
		
		for (int i = 2; i < array.length; i++) {
			  maxValue = Math.max(value1 + array[i], value2);
			  value1 = value2; 
			  value2 = maxValue;
		}
		
		return maxValue;
	}
}
