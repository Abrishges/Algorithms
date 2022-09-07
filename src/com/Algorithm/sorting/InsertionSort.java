package com.Algorithm.sorting;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
	
		InsertionSort sort = new InsertionSort();
		System.out.println("****Iterative****");
		int [] arr = {10, 5, 13, 6, 12, 1, 2};
		System.out.println(Arrays.toString(arr));
		
		sort.InsertionSortIterative(arr);
		System.out.println(Arrays.toString(arr));
		
		System.out.println("\n****Recursive****");
		int [] arr2 = {10, 5, 13, 6, 12, 1, 2};
		System.out.println(Arrays.toString(arr2));
		sort.insertionSortRecursive(arr2, arr2.length - 1);
		System.out.println(Arrays.toString(arr2));
	}
	
	
	public int [] InsertionSortIterative (int [] arr) {
		if (arr.length == 1) return arr;
		
		for (int i = 1; i < arr.length; i++) {			
			int temp = arr[i];
			int j = i - 1; 
			
			while (j >= 0 && temp < arr[j]) {
				 arr[j + 1] = arr[j];
				 j--;
			}
			
			arr[j + 1] = temp;			
		}
		
		return arr;
	}
	
	public int [] insertionSortRecursive(int [] arr, int n) {
		
		if (n <= 0) return arr; 
		insertionSortRecursive(arr, n - 1);
		
		int temp = arr[n];
		int j = n - 1; 
		
		while (j >= 0 && temp < arr[j]) {
			 arr[j + 1] = arr[j];
			 j--;
		}
		
		arr[j + 1] = temp;	
		
		return arr;
	}

}
