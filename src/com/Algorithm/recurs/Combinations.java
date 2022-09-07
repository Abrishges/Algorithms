package com.Algorithm.recurs;
//https://leetcode.com/problems/combinations/

// Order is not important, like 4,2 and 2,4 are the same(combinations).  For permutations order matters
//This problem is subset with added constraint 
// subset question is now changed to combinations
import java.util.ArrayList;
import java.util.List;

public class Combinations {

	public static void main(String[] args) {
		int n = 1, k = 1;
		Combinations cm = new Combinations();
		System.out.println(cm.combine(4, 2));

	}
	
    public List<List<Integer>> combine(int n, int k) {
        
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	List<Integer> list = new ArrayList<Integer>();
    	int i = 1;
    	
        helper(n, k, i, list, result);
        
        return result;
    }
    
    public void helper(int n, int k, int i, List<Integer> list, List<List<Integer>> result) {
    	
    	if (list.size() == k) {
    		List<Integer> temp = new ArrayList<Integer>();
    		temp.addAll(list);
    		result.add(temp);
    		return;
    	}
    	
    	if (i > n) {
    		return;
    	}
    	
    	helper(n, k, i+1, list, result);
    	
    	list.add(i);
    	helper(n, k, i+1, list, result);	
    	list.remove(list.size() - 1);
    }

}
