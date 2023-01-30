package com.Algorithem.ArraysAndLists;

// https://leetcode.com/explore/interview/card/google/59/array-and-strings/3053/
public class JumIndex {

	public static void main(String[] args) {
		// int [] arr = {2,3,1,1,4};
		int[] arr = { 3, 2, 1, 0, 4 };
		System.out.println(canJumTopDown(arr));
	}

	//greedy approach
	public static boolean canJum(int[] nums) {

		int lastPos = nums.length - 1;

		for (int i = lastPos - 1; i >= 0; i--) {

			if (i + nums[i] >= lastPos) {
				lastPos = i;
			}
		}

		return lastPos == 0;
	}

	// Recursion
	public static boolean canJumRec(int[] nums) {
		return canJumRec(0, nums);
	}

	public static boolean canJumRec(int idx, int[] arr) {

		if (idx > arr.length - 1)
			return false;
		if (idx == arr.length - 1)
			return true;

		int n = arr[idx];
		boolean ans = false;
		for (int i = n; i > 0; i--) {
			ans = ans || canJumRec(idx + i, arr);
		}

		return ans;
	}

	// we can improve this a little bit by using backtracking
	public static boolean canJumBackTrack(int idx, int[] arr) {

		if (idx == arr.length - 1)
			return true;

		int furthestJump = Math.min(idx + arr[idx], arr.length - 1);

		for (int i = furthestJump; i > idx; i--) {
			if (canJumBackTrack(i, arr))
				return true;
		}

		return false;
	}

	// This can be improved using DP(top-down) approach
	public static boolean canJumTopDown(int[] nums) {

		// we can use enum instead of numbers
		int[] memo = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			memo[i] = -1;
		}

		memo[nums.length - 1] = 1;
		return canJumTopDown(0, nums, memo);
	}

	public static boolean canJumTopDown(int idx, int[] arr, int[] memo) {

		if (memo[idx] != -1) {
			return memo[idx] == 0 ? false : true;
		}

		int furthestJump = Math.min(idx + arr[idx], arr.length - 1);

		for (int i = furthestJump; i > idx; i--) {
			if (canJumBackTrack(i, arr)) {
				memo[idx] = 1;
				return true;
			}
		}

		memo[idx] = 0;

		return false;
	}

	// How can we solve this problem using dynamic programming bottom-up?
	// bottom-up is done by eliminating recursion

	// This can be improved using DP(top-down) approach
	// we can improve this by using greedy approach
	public static boolean canJumpDP(int[] nums) {

		// we can use enum instead of numbers
		int[] dp = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			dp[i] = -1;
		}

		dp[nums.length - 1] = 1;

		for (int i = nums.length - 2; i >= 0; i--) {
			int furthestJump = Math.min(i + nums[i], nums.length - 1);
			for (int j = furthestJump; j > i; j--) {
				if (dp[j] == 1) {
					dp[i] = 1;
					break;
				}
			}

		}

		return dp[0] == 1;
	}
}
