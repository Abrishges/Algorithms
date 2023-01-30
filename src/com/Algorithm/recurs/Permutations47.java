package com.Algorithm.recurs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/permutations-ii/
public class Permutations47 {

	public static void main(String[] args) {
		int[] nums = { 1, 1, 2 };

		Permutations47 pm = new Permutations47();
		System.out.println(pm.permuteUnique(nums));

	}

	// This is much faster than the other method
	public List<List<Integer>> permuteUnique(int[] nums) {

		List<List<Integer>> result = new ArrayList<List<Integer>>();

		List<Integer> list = new LinkedList<Integer>();
		Map<Integer, Integer> mp = new HashMap<Integer, Integer>();

		for (int num : nums) {
			mp.put(num, mp.getOrDefault(num, 0) + 1);
		}

		backtrack(result, mp, list, nums);

		return result;
	}

	public void backtrack(List<List<Integer>> result, Map<Integer, Integer> mp, List<Integer> list, int[] nums) {

		if (list.size() == nums.length) {
			result.add(new ArrayList<Integer>(list));
			return;
		}

		for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {

			int key = entry.getKey();
			int value = entry.getValue();

			if (value == 0) {
				continue;
			}

			list.add(key);
			mp.put(key, value - 1);

			backtrack(result, mp, list, nums);

			list.remove(list.size() - 1);
			mp.put(key, value);
		}
	}
}
