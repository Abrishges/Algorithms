package com.HackerRank;

import java.util.ArrayList;
import java.util.List;

public class MagicSquare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> list = new ArrayList<List<Integer>>();
          //add data to list
		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(5);
		list1.add(3);
		list1.add(4);
		list.add(list1);
		List<Integer> list2 = new ArrayList<Integer>();
		list2.add(1);
		list2.add(5);
		list2.add(8);
		list.add(list2);
		List<Integer> list3 = new ArrayList<Integer>();
		list3.add(6);
		list3.add(4);
		list3.add(2);
		list.add(list3);
        
		System.out.println(magicSquare(list));
	}
	
	// Magic square code here
	//We define a magic square to be an  matrix of distinct positive integers from  to  where the sum of any row, column, 
	//or diagonal of length  is always equal to the same number: the magic constant.
	// https://www.hackerrank.com/challenges/magic-square-forming/problem
	//store precompiled possible values first
	
	public static Integer magicSquare(List<List<Integer>> s) {

		//I think it is best to covert it to array list
		int [][] m = {
				
                {4,9,2,3,5,7,8,1,6},
                {4,3,8,9,5,1,2,7,6},
                {2,9,4,7,5,3,6,1,8},
                {2,7,6,9,5,1,4,3,8},
                {8,1,6,3,5,7,4,9,2},
                {8,3,4,1,5,9,6,7,2},
                {6,7,2,1,5,9,8,3,4},
                {6,1,8,7,5,3,2,9,4},
		         
		};
		
		 int cost = Integer.MAX_VALUE;	 
		for (int i=0 ; i < 8; i++) {
			 int temp = Math.abs(s.get(0).get(0) - m[i][0]) + 
					Math.abs(s.get(0).get(1) - m[i][1]) +
					Math.abs(s.get(0).get(2) - m[i][2]) +
					Math.abs(s.get(1).get(0) - m[i][3]) + 
					Math.abs(s.get(1).get(1)- m[i][4]) +
					Math.abs(s.get(1).get(2) - m[i][5]) +
					Math.abs(s.get(2).get(0) - m[i][6]) + 
					Math.abs(s.get(2).get(1) - m[i][7]) +
			 		Math.abs(s.get(2).get(2) - m[i][8]);
			 
			 cost = temp < cost ? temp : cost;
		}
		
		return cost;
		     
	} 
}
