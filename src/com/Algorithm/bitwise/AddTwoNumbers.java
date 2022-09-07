package com.Algorithm.bitwise;

//Add two number without using arithmetic operation (+, -) etc 
public class AddTwoNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int Add(int x, int y) {
		// Iterate till there is no carry
		while (y != 0) {
			// carry now contains common
			// set bits of x and y
			int carry = x & y;

			// Sum of bits of x and
			// y where at least one
			// of the bits is not set
			x = x ^ y;

			// Carry is shifted by
			// one so that adding it
			// to x gives the required sum
			y = carry << 1;
		}
		return x;
	}
   
	 //Recursive
	public int AddRecursive(int x, int y) {
		if (y == 0)
			return x;
		else
			return Add(x ^ y, (x & y) << 1);
	}
}
