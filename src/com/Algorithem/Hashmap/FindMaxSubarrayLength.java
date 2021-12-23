package com.Algorithem.Hashmap;

import java.util.HashMap;
import java.util.Map;

public class FindMaxSubarrayLength {

	public static void main(String[] args) {
		 int[] X = { 0, 0, 1, 1, 1, 1 };
	     int[] Y = { 0, 1, 1, 0, 1, 0 };
	     
	     FindMaxSubarrayLength arrayLenght = new FindMaxSubarrayLength();
	     
	     System.out.println(arrayLenght.findMaxSubarrayLength(X, Y));
	}
	
	//Given two binary arrays, X and Y, find the lenght of the longest continuous sequence that starts
	//and ends at the same index in both arrays and have the same sum.
	//Assuming the two arrays are equal
	public int findMaxSubarrayLength(int [] x, int [] y) {
		
	  Map<Integer, Integer> mp = new HashMap<Integer, Integer>();
	  mp.put(0, -1);
	  
	  int sumX = 0;
	  int sumY = 0; 
	  int lenght = 0;
	  
	  for (int i = 0; i < x.length; i++) {
		  
		  sumX += x[i];
		  sumY += y[i];
		  
		  int diff = sumX - sumY; 
		  
		  if (!mp.containsKey(diff)) {
			  mp.put(diff, i);
		  } else {
			  lenght = Math.max(lenght, i - mp.get(diff));
		  }
	  }
	  
	  return lenght;
	}
}