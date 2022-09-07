package com.Algorithm.sorting.basicmath;

public class StringSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       String str1 = "11";
       String str2 = "123";
       StringSum sm = new StringSum();
       System.out.println(sm.stringSum(str1, str2));
	}

	public String stringSum(String str1, String str2) {
		
		char [] ch1 = str1.toCharArray();
		char [] ch2 = str2.toCharArray();
		int i = ch1.length - 1; int j = ch2.length - 1;
		StringBuilder sb = new StringBuilder();
		int rem = 0; 
		while(i >= 0 && j >= 0) {
			int ch = ch1[i] - '0' + ch2[j] - '0' + rem;
			sb.append(ch % 10);
			rem = ch/10;
			i--; j--;
		}
		
		while (i >= 0) {
			
			int ch = ch1[i] - '0' + rem;
			sb.append(ch % 10);
			rem = ch/10;
			i--;
		}
		
		while (j >= 0) {
			
			int ch = ch2[j] - '0' + rem;
			sb.append(ch % 10);
			rem = ch/10;
			j--;
		}
		
		if (rem != 0) {
			sb.append(rem);
		}
		
		String result = sb.reverse().toString();
		
      return result; 
	}
	
	public String addStrings(String num1, String num2) {
		
		int i = num1.length() - 1; int j = num2.length() - 1;
		StringBuilder sb = new StringBuilder();
		int carry = 0; 
		
		while (i >= 0 || j >= 0) {
			int x = i >= 0 ? num1.charAt(i) - '0' : 0;
			int y = j >= 0 ? num2.charAt(j) - '0' : 0;
			int result = x + y + carry;
			sb.append(result % 10);
			carry = result / 10;
			i--; j--;
		}

		 if (carry != 0) {
			 sb.append(carry);
		 }
		return  sb.reverse().toString();
	}
}
