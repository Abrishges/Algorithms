package com.Algorithm.dp;

import java.util.Arrays;

public class KnightDailer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KnightDailer nd = new KnightDailer();
		System.out.println(nd.knightDialer(3131));
	}
	
	 public int knightDialer(int n) {
	        int [] arr = new int [10];
	        Arrays.fill(arr, 1);
	        
	        int mod = (int) Math.pow(10, 9)+ 7;
	        int [] oldArr = new int [10];
	        
	        for (int i = 2; i <= n; i++){
	           // System.arraycopy(arr, 0, oldArr, 0, 10);
	            
	            for (int j = 0; j < 10; j++) {
	            	oldArr[j] = arr[j];
	            }
	            
	            arr[0] = (oldArr[4] + oldArr[6]) % mod;
	            arr[1] = (oldArr[6] + oldArr[8]) % mod;
	            arr[2] = (oldArr[7] + oldArr[9])  % mod;
	            arr[3] = (oldArr[4] + oldArr[8])  % mod;
	            arr[4] = (oldArr[3] + oldArr[9] + oldArr[0]) % mod;
                arr[5] = 0;
	            arr[6] = (oldArr[1] + oldArr[7] + oldArr[0])  % mod;
	            arr[7] = (oldArr[6] + oldArr[2])  % mod;
	            arr[8] = (oldArr[1] + oldArr[3])  % mod;
	            arr[9] = (oldArr[4] + oldArr[2])  % mod;
	            
	        }
	        
	        int sum = 0; 

	        for (int i = 0; i < 10; i++) {
	            sum = (sum + arr[i])  % mod;
	        }
	        
	        System.out.println(sum);
	        
	       // int ans = (int)(sum % mod);
	       
	        return (int)sum;
	    }
}
