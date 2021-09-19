package com.Algorithem.mymath;

import java.util.TreeSet;

// time complexty is o(nlogn), and space o(n)
public class uglyNumberTreeSet {
	
	public static void main(String [] args) {
		
		uglyNumberTreeSet unts = new uglyNumberTreeSet();
		int n = 150;
	    System.out.println(unts.nthUglyNumber(n));
	}
   
	public int nthUglyNumber(int n) {
		
	  TreeSet<Integer> ts = new TreeSet<Integer>();
	  ts.add(1);
	  int i = 1;
	  
	  while (i < n) {  
		  Integer x = ts.pollFirst();
		  ts.add(x * 2);
		  ts.add(x * 3);
		  ts.add(x * 5);	 
		  i++;
	  }
	  
	  return ts.pollFirst();	
	}
}
