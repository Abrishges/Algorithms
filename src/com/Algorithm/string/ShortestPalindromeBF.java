package com.Algorithm.string;

public class ShortestPalindromeBF {

	public static void main(String[] args) {

		String str = "abcd";
		ShortestPalindromeBF sp = new ShortestPalindromeBF();
		System.out.println(sp.shortestPalindrome(str));

	}
	
	
	public String shortestPalindrome(String str) {
		
		int n = str.length();
		String rev = new StringBuilder(str).reverse().toString();
		
		String sbstr = null;
		for (int i = 0; i < n; i++) {
		
			if (str.substring(0, n - i).equals(rev.substring(i))) {
				sbstr = str.substring(n - i);
				System.out.println(sbstr);
				break;
			}
		}
		
		return new StringBuilder(sbstr).reverse().append(str).toString();
	}
}
