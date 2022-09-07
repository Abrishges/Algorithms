package com.Algorithm.sorting.basicmath;

/*
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 * Input: nums = [2,2,1]
 * Output: 1
 */
public class SingleNumber {

	public static void main(String[] args) {

	}
	
    public int singleNumber(int[] nums) {
        
        int bitmask = 0; 
        
        for (int num: nums) {
            bitmask ^= num;
        }
        
        return bitmask;
    }
}
