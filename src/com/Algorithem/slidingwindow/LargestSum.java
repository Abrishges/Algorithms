package com.Algorithem.slidingwindow;
import java.util.ArrayList;
import java.util.List;

/*
 * Fast/Catchup
 * Write an efficient program to find the sum of contiguous subarray within a one-dimensional
 * array of numbers that has the largest sum. 
 */
public class LargestSum {

	public static void main(String[] args) {
		LargestSum largestSum = new LargestSum();
		int [] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
		System.out.println(largestSum.largestSum(arr));
	}
	
	public List<Integer> largestSum(int [] arr) {
		
		int max = Integer.MIN_VALUE;
		int indexL = 0; 
		int indexR = 0;
		int temp = 0;
		for (int i = 0, j = 0; j < arr.length; j++) {
			
			temp += arr[j];
			// we can also do 
			// temp = Math.max(arr[i], temp  + arr[i]);
			
			if (temp > max) {
				max = temp;
				indexR = j;
			}
			
			if (arr[j] > max) {
				max = arr[j];
				i = j;
				indexL = i;
				indexR = j;
				temp = arr[j];
			}
		}
		
		List<Integer> list = new ArrayList<Integer>();
        list.add(indexL);
        list.add(indexR);
        
        System.out.println("Max: " + max);
        return list;
	}

}
