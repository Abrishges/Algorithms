package com.Algorithm.recurs;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      int [] nums = {1,2,3};
      Subsets subset = new Subsets();
      System.out.println(subset.subsets(nums));
	}

	
  public List<List<Integer>> subsets(int[] nums) {
        
	  List<List<Integer>> result = new ArrayList<List<Integer>>(); 
	  List<Integer> list = new ArrayList<Integer>();
	  int i = 0; 
	  
	  helper(nums, i, list, result);
	  
	  return result;
    }
  
  public void helper (int [] nums, int i, List<Integer> list, List<List<Integer>> result) {
	  
	  if (i == nums.length) {
		  //we need to create arrayList and copy the value 
		  result.add(new ArrayList<Integer>(list));
		  return;
	  }
	  
	  helper(nums, i + 1, list, result);
	  
	  list.add(nums[i]);
	  helper(nums, i + 1, list, result);  
	  list.remove(list.size() - 1);
  }
}