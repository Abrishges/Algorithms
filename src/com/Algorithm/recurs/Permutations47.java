package com.Algorithm.recurs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


// this is wrong, need to be done again
public class Permutations47 {

	public static void main(String[] args) {
		int [] nums = {1, 2, 2};

		Permutations47 pm = new Permutations47();
		System.out.println(pm.permuteUnique(nums));

	}

	// This is mutch faster than the other method
    public List<List<Integer>> permuteUnique(int[] nums) {
        
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	//List<Integer>list = new ArrayList<Integer>();

    	List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
    	Collections.sort(list);
    	
        int i = 0;
    	helper(list , result, i);
    	
    	return result;
    }
    
    public void helper(List<Integer> list, List<List<Integer>> result, int i) {
    	
    	if (i == list.size()) {
    		result.add(new ArrayList<Integer>(list));	
    		return;
    	}
    	
    	//Set<Integer> set = new HashSet();    	
    	for (int j = i; j < list.size(); j++) {
    		
    		if (i != j && list.get(i) == list.get(j)) {
    			continue;
    		}
    		
    		Collections.swap(list, i, j);
    		i++;
    		helper(list, result, i);
    		i--;
    		Collections.swap(list, j, i);

    	}	
    }
}
