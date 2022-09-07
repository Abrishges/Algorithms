package com.Algorithm.bitwise;

public class DecToBinary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String decToBinary(int N) {
		StringBuilder sb = new StringBuilder();

		while (N != 0) {

			int x = N % 2;
			N = N / 2;
			sb.append(x);
		}

		return sb.reverse().toString();
	}

	public int decimalToBinary(int N) {

		//To store the binary number
		int B_Number = 0;
		int cnt = 0;
		while (N != 0) {
			int rem = N % 2;
			double c = Math.pow(10, cnt);
			B_Number += rem * c;
			N /= 2;

			//Count used to store exponent value
			cnt++;
		}

		return B_Number;
	}
}
