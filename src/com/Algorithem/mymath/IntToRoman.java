package com.Algorithem.mymath;

public class IntToRoman {
	
	public static void main(String args[]) {
		int num = 671;
		
		IntToRoman roman = new IntToRoman();
		System.out.println(roman.intToRoman(num));
	}
	
	
	public String intToRoman(int num) {
		
		 String [] symbols = {"M","CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
		 int [] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
		 
		 StringBuilder str = new StringBuilder();
		 
        for (int i = 0; i < values.length; i++) {
        	
        	while (values[i] <= num) {
        		str.append(symbols[i]);
        		num -= values[i];
        	}
        }
		  
		return str.toString();
	}

}
