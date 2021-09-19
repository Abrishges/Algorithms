package com.HackerRank;

import java.util.List;

// Min and max of the four elements of five size array
//For example, arr = [1, 3, 5, 7, 9]. Our minimum sum is 1 + 3 + 5 + 7 = 16
//and our maximum sum is 3 + 5 + 7 + 9 = 24. We would print

public class MinMax {
	
	public static void miniMaxSum(List<Integer> arr) {
	    // Write your code here
	        long max = Long.MIN_VALUE;
	        long min = Long.MAX_VALUE;
	        long sum = 0;
	      for (int i = 0 ; i < 5; i++) {
	           if(arr.get(i) < min) {
	               min = arr.get(i);
	           }
	           if(arr.get(i) > max ) {
	               max = arr.get(i);
	           }
	           
	           sum += arr.get(i);
	      }  
	      System.out.println((sum - max) + " " + (sum - min));
	    }
	
	public static void main(final String[] args) {
	    final int[] ar = {1, 2 , 3, 4, 5};
	     //print max and min for four size array
	  }
}
