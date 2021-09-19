package com.Algorithem.mymath;


//Two numbers A and B are said to be Co-Prime or mutually prime if the Greatest Common Divisor of them is 1.
//You have been given two numbers A and B, find if they are Co-prime or not.
public class CoPrime {
   public static void main(String args[]) {
	   
	   int a = 5, b = 6;
	   coPrime(a, b);
        
       a = 8; b = 16;
       coPrime(a, b);
	   
   }
   
  
   public static void coPrime(int a, int b) {
	   if ( greatestCD2(a, b) == 1)
           System.out.println("Co-Prime");
       else
           System.out.println("Not Co-Prime");    
   }
   
   
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
}
