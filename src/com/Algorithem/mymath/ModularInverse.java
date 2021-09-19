package com.Algorithem.mymath;

/*
 * Give a positive integer n, find modular multiplicative inverse of all integer from 1 
 * to n with respect to a big prime number, say, ‘prime’.
 * The modular multiplicative inverse of a is an integer ‘x’ such that. 
 *  a x = 1 (mod prime) (it should be three equals )
 *  Input : n = 10, prime = 17
 *  For 1, modular inverse is 1 as (1 * 1)%17 is 1
 */
public class ModularInverse {
		
	public static void main(String args[]) {
		int n = 10, prime = 17;
        printModIverses(n, prime);		
	}

	public static int modInverse(int a, int prime)
    {
        a = a % prime;
        for (int x = 1; x  <prime; x++)
        if ((a * x) % prime == 1)
            return x;
         
        return -1;
    }
	
	public static void printModIverses(int n, int prime)
    {
        for (int i = 1; i <= n; i++)
        System.out.print(modInverse(i, prime) + " ");
    }
	
	
	  // Function to calculate modular
    // inverse using D.P
	//An efficient solution is based on extended Euclid algorithm.
	//https://www.geeksforgeeks.org/modular-multiplicative-inverse-1-n/
    static void modularInverse(int n, int prime)
    {
        int dp[]=new int[n + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n; i++)
            dp[i] = dp[prime % i] *
                (prime - prime / i) % prime;
     
        for (int i = 1; i <= n; i++)
            System.out.print(dp[i] + " ");
    }
}
