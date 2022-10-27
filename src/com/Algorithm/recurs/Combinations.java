package com.Algorithm.recurs;
//https://leetcode.com/problems/combinations/

// Order is not important, like 4,2 and 2,4 are the same(combinations).  For permutations order matters
//This problem is subset with added constraint 
// subset question is now changed to combinations
import java.util.ArrayList;
import java.util.List;

public class Combinations {
	
	 private int n;
	 private int k;

	public static void main(String[] args) {
		Combinations cm = new Combinations();
		System.out.println(cm.combine(4, 2));

	}
	
    public List<List<Integer>> combine(int n, int k) {
        this.n = n; 
        this.k = k;
        
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	List<Integer> list = new ArrayList<Integer>();
    	int i = 1;
        backtrack(i, list, result);
        
        return result;
    }
    
    public void backtrack(int start, List<Integer> list, List<List<Integer>> result) {
    	
    	if (list.size() == k) {
    		result.add(new ArrayList<Integer>(list));
    		return;
    	}
    	
    	for (int i = start; i <= n; i++) {
    		list.add(i);
    		backtrack(i+1, list, result);
    		list.remove(list.size() - 1);
    	}
    }
}
