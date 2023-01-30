package com.Algorithem.ArraysAndLists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ThreeSum {

	public static void main(String[] args) {
		int[] nums = { -1, 0, 1, 2, -1, -4 };
		System.out.println(threeSum(nums));
	}

	public static List<List<Integer>> threeSum(int[] nums) {
		Set<List<Integer>> result = new HashSet<>();
		Set<Integer> dups = new HashSet<>();
		Map<Integer, Integer> seen = new HashMap<>();
		
		for (int i = 0; i < nums.length; i++) {
			seen.put(nums[i], i);
		}
		
		for (int i = 0; i < nums.length; ++i) {
			//If we can't add it, it means it is duplicate
			if (dups.add(nums[i])) {
				for (int j = i + 1; j < nums.length; ++j) {
					int complement = -nums[i] - nums[j];
					if (seen.containsKey(complement) && seen.get(complement) != i && seen.get(complement) != j) {
						List<Integer> triplet = Arrays.asList(nums[i], nums[j], complement);
						Collections.sort(triplet);
						result.add(triplet);
					}
					//seen.put(nums[j], i);
				}
			}
		}
		return new ArrayList(result);
	}
}
