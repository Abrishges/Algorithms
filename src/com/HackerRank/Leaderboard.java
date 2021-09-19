package com.HackerRank;

import java.util.ArrayList;
import java.util.List;

// Climbing Leaderboard 
// https://www.hackerrank.com/challenges/climbing-the-leaderboard/problem
// This code returned timeout for some of the tests
public class Leaderboard {

	public static void main(String[] args) {
		
		List<Integer> ranked = new ArrayList<Integer>();
		             ranked.add(100);
		             ranked.add(100);
		             ranked.add(50);
		             ranked.add(40);
		             ranked.add(40);
		             ranked.add(20);
		             ranked.add(10);
		             
		List<Integer> player = new ArrayList<Integer>();
		
		player.add(5);
		player.add(25);
		player.add(50);
		player.add(120);
		
		System.out.println(leaderBoard(ranked, player));
	}
	
	public static List<Integer> leaderBoard(List<Integer> ranked, List<Integer> player) {
		
		// 100, 90, 90,80 
		// 70, 80, 105 	
		Integer n = ranked.size();
		List<Integer> ranks = new ArrayList<Integer>();
	    ranks.add(1);

	     for (int i = 1 ; i < n; i++) {	    	 
	    	 if (ranked.get(i) == ranked.get(i - 1)) {
	    		 ranks.add(ranks.get(i -1));
	    	 } else {
	        	 ranks.add(ranks.get(i -1) + 1); 
	    	 }
	     }
		
		
		List<Integer> aliceRank = new ArrayList<Integer>();
		
	    for (int j = 0; j < player.size(); j++ ) {	
			   Integer aliceScore = player.get(j);
			 if (aliceScore >= ranked.get(0)) {
				 aliceRank.add(1);
			 } else if (aliceScore < ranked.get(n - 1)) {
				 aliceRank.add(ranks.get(n - 1) + 1);
			 } else {
				 int i = binarySearch(ranked, aliceScore);
				 aliceRank.add(ranks.get(i));
			 }
		}
		
		return aliceRank;
	}
	
	public static Integer binarySearch(List<Integer> array, int a) {
		  
		int l = 0; 
		int r = array.size();
		
		   while (l <= r) {
			   
			   int m = l + (r-l)/2;
			   Integer midValue = array.get(m);
			   if (a == midValue) {
				   return m;
			   } else if (a < midValue && a > array.get(m + 1) ) {
				   return m + 1;
			   } else if ( a > midValue && a < array.get(m - 1)) {
				   return m;
			   } else if (a > midValue) {
				   r = m - 1 ;
			   } else if (a < midValue) {
				   l = m + 1;
			   }
		   }
		   	
		return -1;
	}
}
