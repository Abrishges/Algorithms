package com.Algorithm.recurs;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/strobogrammatic-number-ii/
//This can also be done using level order traversal
public class Strobogrammatic {

	 private String [][] pairs = {
             {"0", "0"},
             {"1", "1"},	
             {"6", "9"},
             {"8", "8"},
             {"9", "6"}
           };
	 
	public static void main(String[] args) {
		
		Strobogrammatic sb = new Strobogrammatic();
		List<String> result = sb.findStrobogrammatic(4);
		
        System.out.print(result);
	}
	
	 public List<String> findStrobogrammatic(int n) {
		 return findStrobogrammatic(n, n);
	 }
	
	 public List<String> findStrobogrammatic(int n, int finalNumber) {
		 

		 
		 if (n == 0 ) {
			 return new ArrayList<String>(List.of(""));
		 }
		 
		 if (n == 1) {
			 return new ArrayList<String>(List.of("0", "1", "8"));
		 }
		 
		 List<String> preStrobo = findStrobogrammatic(n - 2, finalNumber);
		 List<String> currentStrobo = new ArrayList<String>();
		 
		 for (String prev : preStrobo) {
			 
			 for (String [] pair : pairs) {
				 
				 // n != finalNumber, 00 will be append unless it is final number 
				 //for example if n = 2, we can have 00  and if n = 4 , we can't have 
				 // 0110. we can append 00 if it not final number
				 if (pair[0] != "0" || n != finalNumber) {
					 
					 currentStrobo.add(pair[0] + prev + pair[1]);
				 }
			 }
			 
		 }
		return currentStrobo; 
	 }
}