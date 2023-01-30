package com.Algorithem.ArraysAndLists;

public class MultiplyArray {

	public static void main(String[] args) {

		//String num1 = "2", num2 = "3";
		String num1 = "0", num2 = "456";
		//"498828660196"
		//"840477629533"
		System.out.println(multiply(num1, num2));
	}

	// num1 = "123", num2 = "456"
	public static String multiply(String num1, String num2) {
        
		int n = num1.length();
		int m = num2.length();
		
		if (n == 1 && num1.charAt(0) - '0' == 0) return "0";
		if (m == 1 && num2.charAt(0) - '0' == 0) return "0";

		int [] presult = new int[n + m];

		for (int i = num1.length() - 1; i >= 0; i--) {

			int x = num1.charAt(i) - '0';
			for (int j = num2.length() - 1; j >= 0; j--) {
				
				int y = num2.charAt(j) - '0';
				int idx = i + j + 1;
				int temp = x * y + presult[idx];
				presult[idx] = temp % 10;
				presult[idx - 1] += temp / 10;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		if (presult[0] != 0) sb.append(presult[0]);
		
		for (int i = 1; i < n + m ; i++) {
			sb.append(presult[i]);
		}

		return sb.toString();
	}
}
