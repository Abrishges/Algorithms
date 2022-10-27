package com.Algorithm.recurs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/coin-change/
// More efficient way is to use dynamic programming
public class CoinChange {

	public static void main(String[] args) {
		CoinChange coinChange = new CoinChange();
		int sum = 7; 
		int [] nums = {2, 3, 5};
		Set<String> result = coinChange.numerOfWays(sum, nums);
		System.out.println(result);
	}
	
	public Set<String> numerOfWays(int sum, int [] nums) {
		
		Set<String> result = new HashSet<String>();
		StringBuilder sb = new StringBuilder();
		backtrack(sum, nums, sb, result);
		
	 return result;
	}
	
	public void backtrack(int sum, int [] nums, StringBuilder sb, Set<String> result) {
		
		if (sum == 0) {
			
			char [] charArray = sb.toString().toCharArray();
			Arrays.sort(charArray);
			
			result.add(new String(charArray));
			return;
		}
		
		for (int i = 0 ; i < nums.length; i++) {
			if (sum >= nums[i]) {
				backtrack(sum - nums[i], nums, sb.append(nums[i]), result);
				sb.deleteCharAt(sb.length() - 1);
			}
		}
	}
	
}
