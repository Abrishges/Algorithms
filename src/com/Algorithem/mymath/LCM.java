package com.Algorithem.mymath;

/*
 * The Least Common Multiple ( LCM ) is also referred to as the Lowest Common Multiple ( LCM ) 
 * and Least Common Divisor ( LCD) . For two integers a and b, denoted LCM(a,b), the LCM is the
 * smallest positive integer that is evenly divisible by both a and b. For example, LCM(2,3) = 6 
 * and LCM(6,10) = 30.
 */

public class LCM {
	
	public static void main(String arg[]) {
		
		System.out.println(leastCommonMultiple(6, 10));
		System.out.println(leastCommonMultiple(5, 7));
		
		System.out.println(leastCommonMultiple1(6, 10));
		System.out.println(leastCommonMultiple1(5, 7));
	}
	
	// For loop method to find lcm
	public static int leastCommonMultiple(int n, int m) {
		
		 int max = Math.max(n, m);
		 
		 int lcm = m * n;
		 for (int i = max; i <= (m * n); i++) {
			  
			 if (i % n == 0 && i % m == 0) {
				 lcm = i;
				 return lcm;
			 }
		 }
		 
		 return lcm;
	}
	
	 /*
	 * 	LCM (Least Common Multiple) of two numbers is the smallest number which can be divided by 
	 * both numbers we can also find the solution using,  LCM(a, b) = (a x b) / GCD(a, b)
	 */
	public static int leastCommonMultiple1(int n, int m) {
		
		int gcf = 1;
        for (int i = 1; i <= n && i <= m ; i++) {	
        	if (n % i == 0 && m % i ==0) {
        	     gcf = i;
        	}
        }
		  		  
		  int lcm = (n * m )/gcf;
		  
	  return lcm;
	}
}
