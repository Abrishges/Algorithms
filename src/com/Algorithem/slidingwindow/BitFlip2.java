package com.Algorithem.slidingwindow;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Given a binary array and an integer m, find the position of zeroes flipping which creates maximum number
 *  of consecutive 1’s in array.
 */

//https://www.geeksforgeeks.org/find-zeroes-to-be-flipped-so-that-number-of-consecutive-1s-is-maximized/
public class BitFlip2 {
	
	public static void main(String[] args) {
		
		int arr[] = new int[]{1, 0, 0, 1, 1, 0, 1, 0, 1, 1};
		
		BitFlip2 bitFlip = new BitFlip2();
		System.out.println(bitFlip.findZeroes(2, arr));
	}

	
	public Queue<Integer> findZeroes(int m , int [] arr) {

		Queue<Integer> indexs = new LinkedList<Integer>();
		
		int l = 0;
		int zeroCount = 0; 
		int bestWindow = 0; 
		
		for (int i = 0 ; i < arr.length; i ++) {
			
			 if (arr[i] == 0) {
				 zeroCount ++ ;
				 indexs.add(i);
			 }
			 
			 if (zeroCount > m) {	 
				 if (arr[l] == 0) {
					 zeroCount--;
					 indexs.remove(l);
				 } 
				 l++;
			 }
			 
			 if (bestWindow < i-l && zeroCount <= m) {
				 bestWindow = i - l;
			 }
		}
		
		return indexs;
	}
}	
