package com.HackerRank;

import java.util.ArrayList;
import java.util.List;

//https://www.hackerrank.com/challenges/absolute-permutation/problem
//Also check geeks for geeks https://www.geeksforgeeks.org/k-difference-permutation/
public class AbsolutePermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      System.out.println(absolutePermutation(100,2));
	}
	
    public static List<Integer> absolutePermutation(int n, int k) {
    	
    	List<Integer> list = new ArrayList<Integer>();
    	if( k == 0) {
    		for (int i = 0; i < n; i++) {
    			list.add(i + 1); 
    		}	
    	} else if (n % (2 * k)!= 0) {
    		list.add(-1);
    	} else { 	
        	for (int i = 0; i < n; i++) {
        		
        		if((i/k) % 2 == 0) {
        			list.add(i + k + 1);
        		} else {
        			list.add(i-k + 1);
        		}
        	}
    	}
    	
    	return list;
    }
}
