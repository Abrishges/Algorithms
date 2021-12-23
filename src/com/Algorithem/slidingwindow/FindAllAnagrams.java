package com.Algorithem.slidingwindow;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

/*
 * Find all substrings of a string that are a permutation of another string
 * Find substring of a string that contains all characters of another string. In other words find all substrings 
 * of the first string that are anagrams of the second string
 */

public class FindAllAnagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String X = "XYYZXZYZXXYZ";
        String Y = "XYZ";
        FindAllAnagrams anagrams = new FindAllAnagrams();
        anagrams.findAllAnagrams(X, Y);
	}

	
	public void findAllAnagrams(String str1, String str2) {
		
		int n = str1.length();
		int m = str2.length();
		Multiset<Character> window = HashMultiset.create();
		Multiset<Character> multiset = HashMultiset.create();
		
		if (n < m || str2.isBlank()) {
			return;
		}
		
		for (int i = 0 ; i < m; i ++) {
			multiset.add(str2.charAt(i));
		}
		

		for (int j = 0 ; j < n; j++) {
			
			if (j < m) {
				window.add(str1.charAt(j));
			} else {

				 if (window.equals(multiset))
	                {
	                    System.out.println("Anagram " + str1.substring(j - m, j) +
	                                " present at index " + (j - m));
	                }
				
				 if (window.contains(str1.charAt(j - m))) {
	                    window.remove(str1.charAt(j - m));
	                }
	 
	                // insert the next character of the string 'X' into the current window
	                window.add(str1.charAt(j));
			}
		}
		
	}
}
