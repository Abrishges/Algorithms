package com.Algorithem.Hashmap;

import java.util.HashMap;
import java.util.Map;

//Subarray sum can be done using sliding window. The best way to do it is using
//hashing
public class SubArraySum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // an integer array
        int[] array = {0, 5, -7, 1, -4, 7, 6, 1, 4, 1, 10};
        int target = 15;
        
        int [] array2 = { 3, 4, -7, 3, 1, 3, 1, -4, -2, -2 };
        int target2 = 0;
        
        SubArraySum subArray = new SubArraySum();
        subArray.findSubArraySum(array, target);
        
        System.out.println("-----Second test------");
        //it should return siz subarrays
        subArray.findSubArraySum(array2, target2);
	}
	
	
	public void findSubArraySum(int [] array, int target) {
		int sumSoFar = 0; 
		Map<Integer, Integer> mp = new HashMap<Integer, Integer> ();
		mp.put(0, -1);
		
		for (int i = 0; i < array.length; i++) {
			
			sumSoFar += array[i];
			if(mp.containsKey(sumSoFar - target)) {
				System.out.printf("Target sum exists b/n indexs: [%d - %d] \n", mp.get(sumSoFar - target) + 1, i);
			} else {
				mp.put(sumSoFar, i);
			}
		}
		
	}

}
