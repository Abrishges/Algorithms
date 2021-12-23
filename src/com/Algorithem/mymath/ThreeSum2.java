package com.Algorithem.mymath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ThreeSum2 {

	public static void main(String[] args) {
		int[] nums = { -1, 0, 1, 2, -1, -4 };
		ThreeSum threeSum = new ThreeSum();
		System.out.println(threeSum.threeSum(nums));
	}

	public List<List<Integer>> threeSum(int[] nums) {

		Map<Integer, Integer> mp = new HashMap<Integer, Integer>();
		
		//I don't think we need to care about this
		Set<Integer> dup = new HashSet<Integer>();

		for (int i = 0; i < nums.length; i++) {
			mp.put(nums[i], i);
		}

		List<List<Integer>> list = new ArrayList<>();

		for (int i = 0; i < nums.length; i++) {
			if (dup.add(nums[i])) {
				for (int j = i + 1; j < nums.length; j++) {
					int dif = 0 - (nums[i] + nums[j]);

					if (mp.containsKey(dif)) {
						int value = mp.get(dif);

						if (value != i && value != j && value > j) {

							list.add(Arrays.asList(nums[i], nums[j], nums[value]));
						}
					}
				}
			}
		}

		return list;
	}
}
