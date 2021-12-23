package com.Algorithem.Hashmap;

import java.util.HashMap;
import java.util.Map;

//Given a binary array containing 0’s and 1’s, find the largest subarray with equal numbers of 0’s and 1’s.
public class FindLargestSubarray {

	public static void main(String [] array) {
		
		int[] arry = { 0, 0, 1, 0, 1, 0, 0 };
		FindLargestSubarray subArray = new FindLargestSubarray();
		subArray.findLargetSubArray(arry);
	}
	
	public void findLargetSubArray(int [] array) {
	   	
		Map<Integer, Integer> mp = new HashMap<Integer, Integer>();		
		int index = 0; 
		int lenght = 0;
		int sumSofar = 0;
		mp.put(0, -1);
		
		for (int i = 0 ; i < array.length; i++) {
			
			sumSofar += (array[i] == 0) ? -1 : 1;		
			
			
			if (mp.containsKey(sumSofar) && lenght < (i - mp.get(sumSofar))) {				
				lenght = i - mp.get(sumSofar);
				index = i;
			} else {
				mp.put(sumSofar, i);
			}
		}
		
		if (index != -1) {
			System.out.printf("Sub array exists: [%d to %d]", index - lenght + 1, index);
		} else {
			System.out.println("No subarray exists !");
		}
	}
}
