package com.Algorithem.Hashmap;

// Given an unsorted integer array whose elements lie in the range 0 to n-1 where n is the array size, 
// calculate the frequency of all array elements in linear time and using constant space. 
public class Frequency {

	public static void main(String[] args) {

		int[] A = { 2, 3, 3, 2, 1 };		
		Frequency freq = new Frequency();
	    freq.findFrequency(A);
	}
	
	//calculate frequency of each element in an array. 
	// we can use map or array, however we can also do it without using any extra space
	public void findFrequency(int [] arr) {
		
	       int n = arr.length;
	       
	        // For each element `A[i]`, increment the value present at index
	        // `(A[i] % n)` by `n`
	        for (int i = 0; i < n; i++) {
	        	arr[arr[i] % n] += n;
	        }
	 
	        // Traverse the modified array and print their frequencies.
	        // If `A[i] > n`, then `i` appears in array `A[i]/n` times.
	        for (int i = 0; i < n; i++)
	        {
	            if (arr[i] / n != 0) {
	                System.out.printf("Element %d appears %d times\n", i, arr[i] / n);
	            }
	        }
	 
	        // Restore the array
	        for (int i = 0; i < n; i++) {
	        	arr[i] = arr[i] % n;
	        }

	}
}