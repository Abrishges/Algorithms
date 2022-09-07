package com.Algorithm.recurs;

//https://leetcode.com/problems/permutations/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Permutations2 {

	public static void main(String[] args) {
		int [] nums = {1,2,3};

		Permutations2 pm = new Permutations2();
		System.out.println(pm.permute(nums));

	}
	
	// This is mutch faster than the other method
    public List<List<Integer>> permute(int[] nums) {
        
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	//List<Integer>list = new ArrayList<Integer>();

    	List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        int i = 0;
  	
    	helper(list , result, i);
    	
    	return result;
    }
    
    public void helper(List<Integer> list, List<List<Integer>> result, int i) {
    	
    	if (i == list.size()) {
    		List<Integer> temp  = new ArrayList<Integer>();
    		temp.addAll(list);
    		result.add(temp);	
    		return;
    	}
    	
    	for (int j = i; j < list.size(); j++) {
    		
    		
    		Collections.swap(list, i, j);
    		i++;
    		helper(list, result, i);
    		i--;
    		Collections.swap(list, j, i);
    	}
    	
    }
}
