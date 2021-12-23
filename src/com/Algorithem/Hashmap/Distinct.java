package com.Algorithem.Hashmap;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
//Give an array list and an integer k, find the count of distinct elements in every subarray of size k.
//This can be done for arrays as well
public class Distinct {

	public void findDistinct(List<Integer> list, int k) {
		
		for (int i = 0; i < list.size() - (k-1); i++) {
			
			Set<Integer> set = new HashSet<Integer>();
			set.addAll(list.subList(i, i + k));
			
		    System.out.printf("Distinct elements in subarray: [%d, %d] is: %d \n", i,  i + (k-1), set.size());
		}
	}
	
	public static void main(String[] args) {
	
		 List<Integer> list = Arrays.asList(2, 1, 2, 3, 2, 1, 4, 5);
		 int k = 5; 
		 
		 Distinct distinct = new Distinct();
		 distinct.findDistinct(list, k);

	}
}
