package com.Algorithem.mymath;

public class GCD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(greatestCD(8, 16));
		System.out.println(greatestCD2(8, 16));
		System.out.println(greatestCD3(8, 16));
	}
	
	//The GCD (Greatest Common Divisor) of two numbers is the largest positive integer
	// number that divides both the numbers without leaving any remainder
	// it is also called greatest common factor
	
	public static int greatestCD(int n , int m) {
		
		 if (n == m) {
			 return n;
		 }
		 
		 if (n == 0 || m == 0) {
			 return 1;
		 }
		 
		 int gcd = 1;
		 for (int i = 1; i <= n && i <= m ; i++) {
			 		 
			  if (n % i == 0 && m % i == 0) {
				   gcd = i;
			  }
		 }
		 
		 return gcd;
	}
	
	// Here we are subtracting the smaller number from the larger number until they both become same
	
	public static int greatestCD2(int n, int m) {
		
		  while(n != m) {
			  
			  if(n > m) {
				  n = n - m;
			  } else {
				  m = m - n; 
			  }
		  }
		  
		  return m;
	}
	

	// Recursive, Here we are subtracting the smaller number 
	//from the larger number until they both become same
	public static int greatestCD3(int n, int m) {
		
		//Everything divides zero
		if (n == 0 || m == 0) {
			return 0;
		}
		
		//base case
		if (n == m) {
			 return n;
		}
		
		if (n > m) {
			greatestCD3(n - m, m);
		}
		
		return greatestCD3(n, m-n);
	}
	
	//Euclidean algorithms, if we divide the smaller number, 
	//the algorithm stops when we find remainder 0.
	public static int greatestCD4(int n, int m) {
		if (n == 0)
            return m;
         
        return greatestCD4(m % n, n);
	}
	
	// extended Euclidean Algorithm
	//O(Log min(a, b))  
    public static int gcdExtended(int a, int b, int x, int y)
    {
        // Base Case
        if (a == 0)
        {
            x = 0;
            y = 1;
            return b;
        }
 
        int x1=1, y1=1; // To store results of recursive call
        int gcd = gcdExtended(b%a, a, x1, y1);
 
        // Update x and y using results of recursive
        // call
        x = y1 - (b/a) * x1;
        y = x1;
 
        return gcd;
    }
}
