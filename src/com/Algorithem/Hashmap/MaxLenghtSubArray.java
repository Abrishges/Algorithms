package com.Algorithem.Hashmap;

import java.util.HashMap;
import java.util.Map;

public class MaxLenghtSubArray {
	
	public static void main(String[] args) {
		
		 int[] arry = { 5, 6, -5, 5, 3, 5, 3, -2, 0 };
	     int target = 8;
	     
	     MaxLenghtSubArray subArray = new MaxLenghtSubArray();
	     subArray.findLargestSubarray(arry, target);
	}

   //Given an integer array, find the maximum length subarray having a given sum.
	public void findLargestSubarray(int [] arry, int target) {
		
		Map<Integer, Integer>mp = new HashMap<Integer, Integer>();
		mp.put(0, -1);
		
		int sumSofar = 0; 
		int lenght = 0;
		int index = -1;
		
		for (int i = 0; i < arry.length; i++) {
			
			sumSofar += arry[i];
			System.out.printf("%d  %d \n", sumSofar, i);
			mp.putIfAbsent(sumSofar, i);
			
			
			if(mp.containsKey(sumSofar - target) && lenght < (i - mp.get(sumSofar - target))){
			   				  
				  lenght = i - mp.get(sumSofar - target);
				  index = i;
			}
		}
		
		
    System.out.println(mp);		
    System.out.printf("Largest subarray index:  [%d to %d]" , index - lenght + 1, index);
	}

}
