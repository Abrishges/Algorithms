package com.Algorithem.mymath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] 
//such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
//complext is the same with hashset
public class ThreeSum {

	public static void main(String[] args) {
		int [] nums = {-1,0,1,2,-1,-4};
		ThreeSum threeSum = new ThreeSum();
		System.out.println(threeSum.threeSum(nums));
	}
	
	public List<List<Integer>> threeSum(int[] nums) {
		
		Arrays.sort(nums);			
		List<List<Integer>> list  = new ArrayList<>();	
		int lo = 0, hi = nums.length - 1; 
		
		while (lo < hi & nums[lo] <= 0) {
		
			if (lo == 0 || nums[lo - 1] != nums[lo]) {
				 findTwoSum(lo, nums, list);
			}		  
		  lo++;
		}	
		
		return list;
	}
	
	public void findTwoSum(int index, int [] nums, List<List<Integer>> list) {
		
		int i = index, j = nums.length - 1;
	
		while(i < j) {
			
			int sum = nums[index] + nums[i] + nums[j];
			
			if (sum < 0) {
				i++;
			} else if (sum > 0) {
				j--;
			} else {
				list.add(Arrays.asList(nums[index], nums[i], nums[j]));
				i++;
				while(i < j && nums[i] == nums[i - 1]) {
					i++;
				}
			}
		}
	}

}
