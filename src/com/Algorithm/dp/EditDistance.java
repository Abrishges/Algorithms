package com.Algorithm.dp;

public class EditDistance {

	public static void main(String[] args) {

		String word1 = "intention";
		String word2 = "execution";

		EditDistance ed = new EditDistance();
		System.out.println(ed.minDistance(word1, word2));
		
		System.out.println(ed.minDistanceRec(word1, word2, 0, 0));
	}

	//How about using recursion  
	
	public int minDistanceRec(String word1, String word2, int i , int j) {
		
		if (i == word1.length() && j == word2.length()) return 0;
		
		if (i == word1.length()) return word2.length() - j;
		if (j ==  word2.length()) return word1.length() - i;
		
	   //recursion calls here
		int cost = word1.charAt(i) == word2.charAt(j) ? 0 : 1;
		
		return  Math.min(cost + minDistanceRec(word1, word2, i + 1, j + 1),
				   Math.min(1 + minDistanceRec(word1, word2, i + 1, j), 1 + minDistanceRec(word1, word2, i, j + 1)));
		
	}
	
	
	
	//how about using memorization? 
	
	//using Dynamic programming
	public int minDistance(String word1, String word2) {

		int n = word1.length();
		int m = word2.length();

		int[][] dp = new int[n + 1][m + 1];
		dp[n][m] = 0;

		for (int i = n; i >= 0; i--) {
			for (int j = m; j >= 0; j--) {

				if (i == n && j == m) {
					dp[i][j] = 0;
				} else if (i == n) {
					dp[n][j] = m - j;
				} else if (j == m) {
					dp[i][m] = n - i;
				} else {

					int cost = word1.charAt(i) == word2.charAt(j) ? 0 : 1;

					dp[i][j] = Math.min(1 + dp[i + 1][j], Math.min(1 + dp[i][j + 1] , cost + dp[i + 1][j + 1]));

				}

			}
		}

		return dp[0][0];
	}
}