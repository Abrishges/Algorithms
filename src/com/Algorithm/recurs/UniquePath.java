package com.Algorithm.recurs;

//https://leetcode.com/problems/unique-paths/
public class UniquePath {

	public static void main(String[] args) {

	}

	public static int uniquePaths(int n, int m) {
		if (n == 1 && m == 1)
			return 1;

		return uniquePaths(n, m, 0, 0);
	}

	// naive approach
	public static int uniquePaths(int n, int m, int i, int j) {

		if (i == n - 1 && j == m - 1)
			return 1;

		int ans = 0;
		if (i < n) {
			ans += uniquePaths(n, m, i + 1, j);
		}

		if (j < m) {
			ans += uniquePaths(n, m, i, j + 1);
		}

		return ans;
	}

	// How can we do it in memorization and Dp
	public static int uniquePathsDp(int n, int m) {
		if (n == 1 && m == 1)
			return 1;

		int[][] dp = new int[n][m];
		return uniquePathsDp(n, m, dp);
	}

	public static int uniquePathsDp(int n, int m, int[][] dp) {

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {

				if (i == 0 || j == 0) {
					dp[i][j] = 1;
				} else {
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
				}
			}
		}

		return dp[n - 1][m - 1];
	}

	// other option of recursion
	public int uniquePathsRec(int m, int n) {
		if (m == 1 || n == 1) {
			return 1;
		}
		return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
	}

}
