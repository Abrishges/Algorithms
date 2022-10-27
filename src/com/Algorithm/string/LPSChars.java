package com.Algorithm.string;

//Give a string How many character are to be added at the beginning to make it a palindrome
// abcbade   ans = 2  de 
// abaceaf  and = 4 ceaf 
public class LPSChars {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// may be concatenate 
	/*
	 *  abbaacd $dcaabba then find the LPS for the whole string and take the lps of last index and 
	 *  subtract from length of given string abbaacd to find the solution 
	 *  it means we will create new string  str + $ + rev(str)
	 */
	public int numberOfChars(String str) {
		
	}
	
	//Give a text and pattern , check if a pattern exist or not.  we can use 
	/*
	 *  we can use pattern + $ + text and build lps and if there is lps value with same 
	 *  size with pattern, pattern exist in text
	 */
}
