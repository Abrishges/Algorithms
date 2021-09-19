package com.HackerRank;

public class HighestValuePalindrome {
	
	
	public static void main(String [] arg) {
		
		highestValuePalindrome("1234", 4, 1);
		
	}
	
    public static String highestValuePalindrome(String s, int n, int k) {
    // Write your code here
    	 Integer number = Integer.valueOf(s);
    	for (int i = 0, j = n - 1 ; i <= j; i++, j--) {
    		
    		if (s.charAt(i) < s.charAt(j)) {
    		       
    		}
    	}
    	return s;
    }
}