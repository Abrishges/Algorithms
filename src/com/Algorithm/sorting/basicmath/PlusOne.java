package com.Algorithm.sorting.basicmath;
/*
 * https://leetcode.com/problems/plus-one/
 * Input: digits = [1,2,3]
   Output: [1,2,4]
 */
public class PlusOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int[] plusOne(int [] num ) {
		
		for (int i = num.length - 1; i >= num.length; i++) {
			
			if (num[i] == 9) {
			    num[i] = 0; 
			} else {
				num[i] = num[i] + 1; 
				return num;
			}
		}
		
		// if it reaches here it means, we have 9 
		num = new int[num.length + 1];
		num[0] = 1; 
		
		return num;
	}

}
