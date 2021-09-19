package com.HackerRank;

import java.util.ArrayList;
import java.util.List;
// https://www.hackerrank.com/challenges/larrys-array/problem
public class LarrysArray {
	
	public static void main(String arg[]) {
		
		List<Integer> list = new ArrayList<Integer>();
		//[1,6,5,2,4,3]
//		list.add(1);
//		list.add(6);
//		list.add(5);
//		list.add(2);
//		list.add(4);
//		list.add(3);
		
		//1 2 3 5 4
		
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(5);
		list.add(4);
		System.out.println(larrysArray(list));
	}
	
	   public static String larrysArray(List<Integer> A) {
		   int pr = 0;
		   for (int i = 0; i < A.size() - 1; i++) {
			     int a = A.get(i);
			     
			     for (int j = i + 1; j < A.size(); j++) {
			    	 if (A.get(j) < a) {
			    		 pr += 1;
			    	 }
			     }
		   }
		   
		   if (pr % 2 == 0) {
			   return "YES";
		   }
		   return "NO";
		}
}
