package com.Algorithm.recurs;

public class MatchWildcardDP {

	public static void main(String[] args) {

		// This takes forever
//		String str = "aaaabaaaabbbbaabbbaabbaababbabbaaaababaaabbbbbbaabbbabababbaaabaabaaaaaabbaabbbbaababbababaabbbaababbbba";
//		String ptr = "*****b*aba***babaa*bbaba***a*aaba*b*aa**a*b**ba***a*a*";
//
//		String str2 = "adceb";
//		String ptr2 = "*a*b";

		String str3 = "abcabczzzde";
		String ptr3 = "*abc???de*";

		MatchWildcardDP match = new MatchWildcardDP();

		System.out.println(match.isMatch(str3, ptr3));

	}

	// Using Dp
	//This runs in 55ms
	public boolean isMatch(String s, String p) {

		int slen = s.length();
		int plen = p.length();

		if (s.equals(p))
			return true;

		if (plen > 0 && p.chars().allMatch(c -> c == '*'))
			return true;

		if (s.isEmpty() || p.isEmpty())
			return false;

		boolean dp[][] = new boolean[plen + 1][slen + 1];
		dp[0][0] = true;

		return isMatch(s, p, dp);
	}

	// if s(i) == p(j) || p(j) = ? , then true if dp[i -1][j - 1]
	// if p(j) == '*' then we need check dp[i -1][j - 1],
	public boolean isMatch(String s, String p, boolean[][] dp) {

		// we started with i and j = 1 because we don't need to handle boundaries less
		// than 0
		int plen = p.length();
		int slen = s.length();

		for (int i = 1; i < plen + 1; i++) {
			if (p.charAt(i - 1) == '*') {
				dp[i][0] = dp[i - 1][0];
			}
		}

		for (int i = 1; i < plen + 1; i++) {
			for (int j = 1; j < slen + 1; j++) {

				if (p.charAt(i - 1) == s.charAt(j - 1) || p.charAt(i - 1) == '?') {
					dp[i][j] = dp[i - 1][j - 1];
				} else if (p.charAt(i - 1) == '*') {
					// dp[i - 1][j - 1] when we add chars both p ans str
					// dp[i - 1][j] when we add char for s only
					if (dp[i - 1][j - 1] || dp[i - 1][j]) {
						dp[i][j] = true;

						for (int k = j; k < slen + 1; k++) {
							dp[i][k] = true;
						}
						break;
					}
				}
			}
		}

		return dp[plen][slen];
	}
}
