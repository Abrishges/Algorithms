package com.Algorithem.Hashmap;

import java.util.HashSet;
import java.util.Set;

//Given an integer array, check if only consecutive integers form the array.
public class Consecutive {

	public static void main(String[] args) {
		
		int arr [] = { -1, 5, 4, 2, 0, 3, 1 };
		Consecutive cons = new Consecutive();
		System.out.println(cons.isConsecutive(arr));

	}

	//The difference b/n the max and min elements in it should be exactly n-1
	// All elements in the array should be distinct
	public boolean isConsecutive (int [] arr) {
		
		if (arr.length <= 1) {
			return true;
		}
		
		//find max and min in the array		
		int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
		
		for (int i = 0; i < arr.length; i++) {			
			max = arr[i] > max ? arr[i]: max;
			min = arr[i] < min ? arr[i]: min;
		}
		
		for (int ele : arr) {

			if (ele > max) {
				max = ele;
			}
			
			if (ele < min) {
				min = ele;
			}
		}
		
		if (max - min != arr.length - 1) {
			return false;
		}
		
		//Check if all elements are distinct
		Set<Integer> set = new HashSet<Integer>();
			for (int ele : arr) {
				if (set.contains(ele)) {
					return false;
				}
				
				set.add(ele);
			}

		return true;
	}
}
