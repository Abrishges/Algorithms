package com.Algorithm.string;

public class ShortestPalindrome {

	public static void main(String[] args) {
		String str = "abcd";
		ShortestPalindrome sp = new ShortestPalindrome();
		System.out.println(sp.shortestPalindrome(str));
	}

	//It means first we have to calculate the longest prefix palindrome
	public String shortestPalindrome(String s) {

		if (s.isBlank()) return s;
		
		StringBuilder sb = new StringBuilder();
		sb.append(s).append("$").append(new StringBuilder(s).reverse());

		int[] lps = LPSOfString2(sb.toString());
		int len = lps[sb.length() - 1];

		if (len == 0)
			return s;

		sb.setLength(0);
		sb.append(new StringBuilder(s.substring(len)).reverse()).append(s);

		return sb.toString();
	}

	public int[] LPSOfString2(String s) {
		int n = s.length();

		int lps[] = new int[n];
		lps[0] = 0; // lps[0] is always 0

		int len = 0;

		int i = 1;
		while (i < n) {
			if (s.charAt(i) == s.charAt(len)) {
				len++;
				lps[i] = len;
				i++;
			} else {
				if (len != 0) {
					len = lps[len - 1];
				} else {
					lps[i] = 0;
					i++;
				}
			}
		}

		return lps;
	}
}
