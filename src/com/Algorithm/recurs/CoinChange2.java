package com.Algorithm.recurs;

public class CoinChange2 {

	public static void main(String[] args) {

		CoinChange2 coinChange = new CoinChange2();
		int sum = 7;
		int[] nums = { 2, 3, 5 };
		int result = coinChange.coinChange(nums, sum);
		System.out.println(result);
	}

	// using backtracking
	public int coinChange(int[] coins, int amount) {

		return backtrack(coins, amount);
	}

	public int backtrack(int[] coins, int amount) {
		if (amount < 0)
			return -1;
		if (amount == 0)
			return 0;

		int min = Integer.MAX_VALUE;
		for (int coin : coins) {
			int count = backtrack(coins, amount - coin);
			if (count == -1) {
				continue;
			}

			min = Math.min(min, count + 1);
		}

		// In some cases we min value might not change in cases where all numbers
		// doesn't give us zero.
		// That is why we are doing min == Integer.MAX_VALUE
		return min == Integer.MAX_VALUE ? -1 : min;
	}

	// using memoization(top down approach)
	public int coinChangeDp(int[] coins, int amount) {

		Integer[] dp = new Integer[amount + 1];
		return backtrackDp(coins, amount, dp);
	}

	public int backtrackDp(int[] coins, int amount, Integer[] dp) {
		if (amount < 0)
			return -1;
		if (amount == 0)
			return 0;

		if (dp[amount] != null)
			return dp[amount];
		int minCount = Integer.MAX_VALUE;
		for (int coin : coins) {
			int count = backtrack(coins, amount - coin);
			if (count == -1) {
				continue;
			}

			minCount = Math.min(minCount, count + 1);
		}

		// In some cases we min value might not change in cases where all numbers
		// doesn't give us zero.
		// That is why we are doing min == Integer.MAX_VALUE
		// for example sum = 11 and nums = [5]
		return dp[amount] = minCount == Integer.MAX_VALUE ? -1 : minCount;
	}

	// This can also be done using bottom up dp
	// using memoization(top down approach)
	public int coinChangeDpBottomup(int[] coins, int amount) {

		return coinChangeDpBottomup(coins, amount);
	}

	public int backtrackDp(int[] coins, int amount) {

		int[] dp = new int[amount + 1];

		for (int i = 0; i <= amount; i++) {

			int minCount = Integer.MAX_VALUE;
			for (int coin : coins) {
				if (i - coin < 0) {
					continue;
				}

				minCount = Math.min(minCount, dp[i - coin] + 1);
			}
			dp[i] = minCount == Integer.MAX_VALUE ? -1 : minCount;
		}
		// In some cases we min value might not change in cases where all numbers
		// doesn't give us zero.
		// That is why we are doing min == Integer.MAX_VALUE
		// for example sum = 11 and nums = [5]
		return dp[amount];
	}
}
