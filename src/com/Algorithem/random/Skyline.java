package com.Algorithem.random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//https://leetcode.com/problems/the-skyline-problem/solution/
/*
 * Input: buildings = [[2,9,10],[3,7,15],[5,12,12],[15,20,10],[19,24,8]]
   Output: [[2,10],[3,15],[7,12],[12,0],[15,10],[20,8],[24,0]]
 */
public class Skyline {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public List<List<Integer>> getSkyline(int[][] buildings) {
		
		//set of unique edges 
		Set<Integer> set = new HashSet<Integer>();
		
		for (int [] building : buildings) {
			 int xLeft = building[0];
			 int xRight = building[1];
			 set.add(xLeft);
			 set.add(xRight);
		}
		
		List<Integer> positions = new ArrayList<Integer>(set);
		Collections.sort(positions);
		
		
	   //Then we iterate each position find out the max height without considering right 
		//position of building 
		
		List<List<Integer>> ans =  new ArrayList<List<Integer>>();
		
		for (int position : positions) {
			
			int maxHeight = 0;
			for (int [] building : buildings) {
				
				int xleft = building[0];
				int xright = building[1];
				int height = building[2];
				
				if (position >= xleft && position < xright) {				
					maxHeight = Math.max(maxHeight, height);
				}	
			}
			
			if (ans.isEmpty() || ans.get(ans.size() - 1).get(1) != maxHeight) {
				ans.add(Arrays.asList(position, maxHeight));
			}
		}
		
		return ans;
	}
}
