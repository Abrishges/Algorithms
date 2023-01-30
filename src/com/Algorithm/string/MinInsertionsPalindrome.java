package com.Algorithm.string;

import java.util.Arrays;

//https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/
public class MinInsertionsPalindrome {

	public static void main(String[] args) {
		String str = "leetcode";
		MinInsertionsPalindrome mp = new MinInsertionsPalindrome();
		System.out.println(mp.minInsertions(str));
	}

	//Min Inseartion palindrome
	//zzazz
	//mbadm
	//This might be done using memo or bottom up
	
    public int minInsertions(String s) {
       
    	 int [][] dp = new int [s.length()][s.length()];
    	 
    	 for (int [] arr : dp) {
    		 Arrays.fill(arr, -1);
    	 }
    	 
    	return minInsertions(s, 0, s.length() - 1, dp);
    }
    
    //We should be able to do this using recursion as well
    public int minInsertions(String str, int i , int j, int [][] dp) {
    	
    	if (i >= j) return 0;
    	
    	if (dp[i][j] != -1) return dp[i][j];
    	
    	if (str.charAt(i) == str.charAt(j)) {
    		return dp[i][j] = minInsertions(str, i + 1, j - 1, dp);
    	} else  {
    		return dp[i][j] = 1 + Math.min(minInsertions(str, i + 1, j, dp), minInsertions(str, i, j - 1, dp));
    	}
    }
    
    //Using bottom up approach
    
    
    
}
