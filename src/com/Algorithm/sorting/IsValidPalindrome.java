package com.Algorithm.sorting;

/*
 * Given a string s, return true if the s can be palindrome after deleting at most one character from it.
 */
public class IsValidPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean validPalindrome(String s) {

		int n = s.length();
		int i = 0, j = n - 1;

		while (i <= j) {
			if (s.charAt(i) != s.charAt(j)) {

				if (isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1)) {
					return true;
				} else {
					return false;
				}
			}
			i++;
			j--;
		}

		return true;
	}

	public boolean isPalindrome(String s, int i, int j) {

		while (i <= j) {
			if (s.charAt(i) != s.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}
}
