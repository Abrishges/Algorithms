package com.Algorithm.recurs;

// what is the difference between regex and wild card matching
//https://leetcode.com/problems/regular-expression-matching/
//This very interesting question to solve
public class Match {

	public static void main(String[] args) {
		Match match = new Match();
		String str = "aab";
		String ptr = "c*a*b";
		
		System.out.println(match.isMatch(str, ptr));
		
		System.out.println(match.isMatchWithIndex(str, ptr, 0, 0));

	}

	//This can be improved using index. substring costs more time and resource
    public boolean isMatch(String str, String ptr) {
    	
    	if (ptr.isEmpty()) return str.isEmpty();
        
    	boolean firstMatch = !str.isEmpty() && 
    			(str.charAt(0) == ptr.charAt(0) || ptr.charAt(0) == '.');
    	
    	if (ptr.length() >= 2 && ptr.charAt(1) == '*') {
    		return (firstMatch && isMatch(str.substring(1), ptr) ||
    				isMatch(str, ptr.substring(2))); 
    	} else {
    		return firstMatch && isMatch(str.substring(1), ptr.substring(1));
    	}
    }
    
    //Using index
    public boolean isMatchWithIndex(String str, String ptr, int i , int j) {
                  
    	 if (j == ptr.length()) return i == str.length();
    	 
    	 boolean firstMatch = !str.isEmpty() && (str.charAt(i) == ptr.charAt(j) || ptr.charAt(j) == '.');
    	 
    	 if (j + 1 < ptr.length() && ptr.charAt(j + 1) == '*') {
    		 return (firstMatch && isMatchWithIndex(str, ptr, i + 1, j) ||
    				 isMatchWithIndex(str, ptr, i, j + 2));
    	 } else {
    		 return firstMatch && isMatchWithIndex(str, ptr, i + 1, j + 1);
    	 } 	 
    }  
}