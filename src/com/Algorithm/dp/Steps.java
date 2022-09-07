package com.Algorithm.dp;

import java.util.ArrayList;

/*
 *There is a staircase with n steps. A person standing at the 0-th step wants to reach the n-th one. They are capable of
 * jumping up by certain numbers of steps at a time.
   Given how the person can jump, count the number of ways they can reach the top.
 *  
 *  {
   "steps": [1, 2],
    "n": 1
   }
 *  
 *  {
      "steps": [2, 3],
      "n": 7
    }
 *  
 *  Let us try to solve this problem for steps = [1, 2, 3] using recursion.

Let s(n) be the number of possible ways to reach the n-th step.

We can reach step n from n - 1, n - 2 and n - 3 in one step by jumping up 1, 2 and 3 steps respectively. Thus we get
the recurrence relationship: s(n) = s(n - 1) + s(n - 2) + s(n - 3)
Base case would be 0. There is only one way to reach the 0-th step: by remaining there. So s(0) = 1.
 *  
 *  
 *  
 *  
 */

public class Steps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	

public Long countWaysToClimb(ArrayList<Integer> steps, Integer n) {
	
	long [] arr = new long [n + 1];
	
	for (int i = 1; i <= n; i++) {
		for (int step : steps) {
			int prevStep = i - step;
			if (prevStep >= 0) {
				arr[i] += arr[prevStep];
			}
		}
	}
	
  return arr[n];
}

}
