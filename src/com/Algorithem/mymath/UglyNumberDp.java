package com.Algorithem.mymath;

public class UglyNumberDp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int n = 150;
        
        // Function call
        UglyNumberDp obj = new UglyNumberDp();
        System.out.println(obj.getNthUglyNo(n));
	}

	//Here is a time efficient solution with O(n) extra space
	public int getNthUglyNo(int n) {
		
		int [] dp = new int[n];
		
		int i2 = 0; 
		int i3 = 0; 
		int i5 = 0;
		
		int nextMultipleOf2 = 2; 
		int nextMultipleOf3 = 3; 
		int nextMultipleOf5 = 5; 
		
		dp[0] = 1;
		int nextUglyNo = 1;
		for (int i = 1; i < n; i++) {
			
		    nextUglyNo = Math.min(nextMultipleOf2, Math.min(nextMultipleOf3,nextMultipleOf5));
			dp[i] = nextUglyNo;
			
			if (nextUglyNo == nextMultipleOf2) {
				i2 = i2 + 1;				
				nextMultipleOf2 = dp[i2] * 2;
			}
			
			if (nextUglyNo == nextMultipleOf3) {
				i3 = i3 + 1;				
				nextMultipleOf3 = dp[i3] * 3;
			}
			
			if (nextUglyNo == nextMultipleOf5) {
				i5 = i5 + 1;				
				nextMultipleOf5 = dp[i5] * 5;
			}
		}
		
		return nextUglyNo;
	}
}
