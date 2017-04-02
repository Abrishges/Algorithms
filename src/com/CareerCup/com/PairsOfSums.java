/**
 * 
 */
package com.CareerCup.com;

import java.util.HashSet;

/**
 * @author aberehamwodajie
 *
 *         Dec 6, 2016
 */
public class PairsOfSums {

	public static void main(String[] args) {
		int[] myArray = { 2, 3, 5, 10, 7 };
		
		int[] input = {10, 1, 3, 5, 9, 25, 11};
		
		pairsOfSums(myArray);
		pairsOfSums(input);

		// Arrays.sort(myArray); //user merge or heap sort instade of this

	}

	public static void pairsOfSums(int[] array) {
		
		//Hashtable<Integer, Integer> hashtable = new Hashtable<Integer, Integer>();

		HashSet<Integer> hashset = new HashSet<Integer>();

		for (int arr : array) {
			hashset.add(arr);
			//hashtable.put(arr, arr);
		}
     System.out.println("Numbers who's sum exist in the array");
		for (int i = 0; i < array.length; i++) {
			for (int j = i+1; j < array.length ; j++){
				
				/*if(hashtable.contains(array[i] + array[j])){
					System.out.println("{" + array[i] + " " + array[j] + "}");
				}*/
				if(hashset.contains(array[i] + array[j])){
					System.out.println("{" + array[i] + " " + array[j] + "}");
				}
			}
	}
}
}
