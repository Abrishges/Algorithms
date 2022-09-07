package com.Algorithm.recurs;

// https://leetcode.com/problems/subsets-ii/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets90 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      int [] nums = {1,2,2};
      Arrays.sort(nums);
      Subsets90 subset = new Subsets90();
      System.out.println(subset.subsetsWithDup(nums));
	}

	 public List<List<Integer>> subsetsWithDup(int[] nums) {
	        Arrays.sort(nums);
	        List<List<Integer>> subsets = new ArrayList<>();
	        List<Integer> currentSubset = new ArrayList<>();

	        subsetsWithDupHelper(subsets, currentSubset, nums, 0);
	        return subsets;
	    }

	    private void subsetsWithDupHelper(List<List<Integer>> subsets, List<Integer> currentSubset, int[] nums, int index) {
	        // Add the subset formed so far to the subsets list.
	        subsets.add(new ArrayList<>(currentSubset));

	        for (int i = index; i < nums.length; i++) {
	            // If the current element is a duplicate, ignore.
	            if (i != index && nums[i] == nums[i - 1]) {
	                continue;
	            }
	            currentSubset.add(nums[i]);
	            subsetsWithDupHelper(subsets, currentSubset, nums, i + 1);
	            currentSubset.remove(currentSubset.size() - 1);
	        }
	    }
}
