package com.Algorithem.Hashmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//Find a triplet with the given sum in an array
public class Triplet {
	
	public static void main(String []arg) {
		
		  int[] arr = { 2, 7, 4, 0, 9, 5, 1, 3 };
	      int target = 6;
		
	      Triplet triplet = new Triplet();
	      
	       System.out.println(triplet.isTripletExist(arr, target));
	       
	       triplet.printAllTriplets(arr, target);
	}
	
	
	//Using hashing
	//Insert each element into hash table. Then consider all pairs present in the array 
	// and check if the remaining sum exists in the map or not. Time complexity is o(n)
	public boolean isTripletExist(int [] array, int target) {
		Map<Integer, Integer> mp = new HashMap<Integer, Integer>();
		
		for(int i = 0 ; i < array.length; i++) {
			mp.put(array[i], i);
		}
		
		for (int i = 0 ; i < array.length; i++) {
			
			for (int j = i + 1 ; j < array.length; j++) {
				
				int diff = target - array[i] - array[j];
				
				if (mp.containsKey(diff)){
					  int value = mp.get(diff);
					  if(value != i && value != j) {
						 return true;
					  }
				}
			}
		}
		
		return false;
	}
	
	
	//Sort the array and for each element arr[i] in the array, check if the triplet is formed by arr[i] and a
	// pair from subarray arr[i+1...n]. The same complexity and doesn't require space
	public void printAllTriplets(int [] array, int target) {
	
		//sort the array
		Arrays.sort(array);
		
		for (int i = 0 ; i < array.length; i ++) {
			
			int k = target - array[i];
			int low = i + 1; 
			int high = array.length - 1; 
			
			while(low < high) {
				
				if (array[low] + array[high] < k) {
					low++;
				}
				else if (array[low] + array[high] > k) {
					high--;
				} else {
					System.out.printf("[%d, %d, %d] \n", array[i], array[low], array[high]);
					low++;
					high--;
				}
				
			}		
		}
		
	}
}
