package com.Algorithem.slidingwindow;

/*
 *  looking for the  maximum number of 0s that you can form in a given array of 0s and 1s,
 *  if you have the ability to flip some number of those 0s to 1s.
 */
public class BitFlip {

	public static void main(String[] args) {
		
     int arr[] = {0, 1, 0, 0, 1, 1, 0};
     
      BitFlip bitFlip = new BitFlip();
      System.out.println(bitFlip.maxOneCount(arr));
      
      int arr1[] = {0, 0, 0, 1, 0, 1};
      System.out.println(bitFlip.maxOneCount(arr1));
	}

	public int maxOneCount(int[] arr) {
		
		int temp = 0; int countMax = 0;
		int coutZero = 0;
		for (int i = 0 ; i < arr.length ; i++) {
			
			if (arr[i] == 0) {
				temp = 0;
				coutZero++;
			} else {
				temp++;
			}
			
			if (countMax < temp) {
				countMax = temp;
			}
		}
		
		return countMax + coutZero;
	}
	
	//Largest subarray sum problem
	//https://www.geeksforgeeks.org/maximize-number-0s-flipping-subarray/
	public int findMaxZeroCount(int[] arr) {
		
	
		return 0;
	}
}
