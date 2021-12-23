package com.Algorithem.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/*
 * Find a subarray having the given sum in an integer array
 */

public class FindSubArray {

	public static void main(String[] args) {

        int[] A = { 2, 6, 0, 9, 7, 3, 1, 4, 1, 10 };
        int target = 15;

        FindSubArray sb = new FindSubArray();
        sb.findSubArray(A, target);
        
        //How can we improve it and make it work for negative numbers
      int array [] = {0, 5, -7, 1, -4, 7, 6, 1, 4, 1, 10};
      int target2 = 15;
      //Output: {1, -4, 7, 6, 1, 4} or {4, 1, 10}
      System.out.println(" -------------using Hashtable-------------");
      sb.findSubArray2(array, target2);
	}
	
	
	public void findSubArray(int [] array, int value) {
		
		if (array.length == 0) {
			return;
		}
		
		int sum = 0;
		for (int i = 0 , j = 0 ; j < array.length; j++) {
		  

		    sum += array[j];
		 
			while (sum > value && i < j)	{
				 sum -= array[i];
				 i++;	
			}
			 
			if (sum == value) {
				 System.out.printf("Sub array found b/n [%d - %d] %n", i , j);
			}
		}
	}
	
	
	//The best solution that works for both positive and negative numbers is using hashing
	public void findSubArray2(int [] array, int target) {
		
		int sum = 0;
		Map<Integer, Integer> mp = new HashMap<Integer, Integer>();
		mp.put(0, -1);
		
		for (int i  = 0 ; i < array.length; i++) {
			
			sum += array[i];
			
			if (mp.containsKey(sum - target)) {
				System.out.printf("Subarray found b/n [%d - %d] %n" , mp.get(sum - target) + 1, i);
			}
			
			mp.put(sum, i);
		}
	}
}
