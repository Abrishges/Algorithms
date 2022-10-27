package com.Algorithm.recurs;

//https://leetcode.com/problems/regular-expression-matching/
public class MatchDp {

	public static void main(String[] args) {
		MatchDp match = new MatchDp();
		
		//Why is this true
		// c* means we can take c zero or more time. It can be a*b, ca*b, cca*b
		String str = "aab";
		String ptr = "c*a*b";
		System.out.println(match.isMatch(str, ptr));
	}

	//Using memorization(top down) approach
	public boolean isMatch(String str, String ptr) {
		Boolean[][] memo = new Boolean[str.length() + 1][ptr.length() + 1];
		return isMatch(str, ptr, 0, 0, memo);
	}

	public boolean isMatch(String str, String ptr, int i, int j, Boolean[][] memo) {

		if (memo[i][j] != null) {
			return memo[i][j];
		}

		boolean ans;
		if (j == ptr.length()) {
			ans = i == str.length();
		} else {

			boolean fristMatch = (i < str.length() && (str.charAt(i) == ptr.charAt(j) || ptr.charAt(j) == '.'));

			if (j + 1 < ptr.length() && ptr.charAt(j + 1) == '*') {
				ans = fristMatch && isMatch(str, ptr, i + 1, j, memo) || isMatch(str, ptr, i, j + 2, memo);
			} else {
				ans = fristMatch && isMatch(str, ptr, i + 1, j + 1, memo);
			}
		}
		
		memo[i][j] = ans;

		return ans;
	}
}