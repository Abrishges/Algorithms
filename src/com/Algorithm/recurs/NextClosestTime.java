package com.Algorithm.recurs;

//https://leetcode.com/problems/next-closest-time/
// I think this problem can be solved using recursion and optimized using DP
import java.util.ArrayList;
import java.util.List;

public class NextClosestTime {

	public static void main(String[] args) {
      String time = "19:34";
      System.out.println(nextClosestTime(time));
	}

	public static String nextClosestTime(String time) {

		String[] arr = time.split(":");

		int hh = Integer.valueOf(arr[0]);
		int mm = Integer.valueOf(arr[1]);

		List<Integer> nums = new ArrayList<Integer>();
		
		nums.add(hh / 10);
		nums.add(hh % 10);
		nums.add(mm / 10);
		nums.add(mm % 10);
				
		StringBuilder sb = new StringBuilder();
		Integer min = Integer.MAX_VALUE;
		backtracking(nums, mm, sb, min);
      return String.valueOf(min);
	}

	public static void backtracking(List<Integer> nums, int digit, StringBuilder sb, Integer min) {

		if (sb.length() == 2) {
			// check if number is with in the range
			min = Integer.valueOf(sb.toString());
//			if (value > digit && value <= 60) {
//				min = Math.min(min, value);
//			}
			return;
		}

		for (int i = 0; i < nums.size(); i++) {
			sb.append(nums.get(i));
			backtracking(nums, digit, sb, min);
			sb.deleteCharAt(sb.length() - 1);
			//idx = idx - 1;
		}
		
	}

}
