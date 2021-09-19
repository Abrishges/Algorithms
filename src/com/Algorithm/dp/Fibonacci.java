package com.Algorithm.dp;

import java.util.HashMap;
import java.util.Map;
//https://www.geeksforgeeks.org/overlapping-subproblems-property-in-dynamic-programming-dp-1/
//which one is the most efficient? 
public class Fibonacci {

	public static void main(String[] args) {
		
		Fibonacci fib = new Fibonacci();
		
		int n = 20;
		System.out.println(fib.fib(n));
		System.out.println(fib.fibMemoization(n));
		System.out.println(fib.fibTabulation(n));
	}
	
	//Recursive solution
	public int fib(int n) {
		
		if (n <= 1) {
			return n;
		}
		
		return fib(n-1) + fib(n-2);
	}
	
	//memoization (top to bottom), it is closer to recursion 
	Map<Integer, Integer> mp = new HashMap<Integer, Integer>();
	public int fibMemoization(int n) {
		
		if (n <= 1) {
			return n;
		}
		
		if (mp.containsKey(n)) {
			return mp.get(n);
		} 
			
		int result = fibMemoization(n - 1) + fibMemoization(n - 2);
	    mp.put(n, result);
		
	 return mp.get(n);	
	}

	// Tabulation(bottom up),  a little more efficent
	public int fibTabulation(int n) {
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(1, 1);
		map.put(0, 0);
		
		for(int i = 2; i <= n; i++ ) {
			int result = map.get(i - 1) + map.get(i - 2);
			map.put(i, result);
		}
		
		return map.get(n);
	}
}
