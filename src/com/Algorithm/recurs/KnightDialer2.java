package com.Algorithm.recurs;

import java.util.Arrays;

// https://leetcode.com/problems/knight-dialer/
public class KnightDialer2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		KnightDialer2 nd = new KnightDialer2();
		int result = nd.KnightDialer(2);
		
       System.out.println(result);
	}

	
	public int KnightDialer(int n) {
		int [] arr = new int[10];
	    
		int mod = (int) Math.pow(10, 9) + 7;
		//for one digit, 
		Arrays.fill(arr, 1);
		
		//for anything above one, we can add of previous value
		int [] oldArry = new int[10];
		
		//i is for number of digits until n
		//This method will give us the number of  distinct phone numbers we can dial
		//when the starting point is from number 2 to n
		for (int i = 2; i <= n; i++) {
			
			for (int j = 0; j <= 9 ; j++ ) {
				 oldArry[j] = arr[j];
			}
        			
			arr[0] = (oldArry[4] + oldArry[6]) % mod;
			arr[1] = (oldArry[6] + oldArry[8]) % mod;
			arr[2] = (oldArry[7] + oldArry[9]) % mod;
			arr[3] = (oldArry[4] + oldArry[8]) % mod;
			arr[4] = (oldArry[3] + oldArry[9] + oldArry[0]) % mod;
			arr[5] = 0;
			arr[6] = (oldArry[1] + oldArry[7] + oldArry[0]) % mod;
			arr[7] = (oldArry[6] + oldArry[2]) % mod;
			arr[8] = (oldArry[1] + oldArry[3]) % mod;
			arr[9] = (oldArry[4] + oldArry[2]) % mod;
		}
		
		int sum = 0;
		
		for (int i = 0; i <= 9; i++) {
			sum = (sum + arr[i]) % mod;
		}
		
		return sum;
	}
}
