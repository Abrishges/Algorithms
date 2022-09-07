package com.Algorithm.recurs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Permutations {

	public static void main(String[] args) {
		int [] nums = {1,2,3};

		Permutations pm = new Permutations();
		System.out.println(pm.permute(nums));
	}
	
	// This approach is very slow
    public List<List<Integer>> permute(int[] nums) {
        
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	List<Integer>list = new ArrayList<Integer>();

    	List<Integer> listNums = Arrays.stream(nums).boxed().collect(Collectors.toList());

  	
    	helper(listNums , list, result);
    	
    	return result;
    }
    
    public void helper(List<Integer> nums, List<Integer> list, List<List<Integer>> result) {
    	
    if (nums.size() == 0) {
        List<Integer> temp = new ArrayList<Integer>();
        temp.addAll(list);
        result.add(temp);
        return;  
    }
    
    for (int i = 0; i < nums.size(); i++) {
    	 list.add(nums.get(i));
    	 // copying each array will make it very slow
    	 List<Integer> temp = new ArrayList<Integer>(nums);
    	 
    	 temp.remove(i);
    	 helper(temp, list, result);
    	 list.remove(list.size() - 1);
    }

   }
}
