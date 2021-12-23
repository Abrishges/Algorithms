package com.Algorithem.mymath;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {

	 public static void main(String [] args) {
		 
		 RomanToInt roman = new RomanToInt();
		 System.out.println(roman.romanToInt("IIIV"));
	 }
	 
	 public int romanToInt(String roman) {
	        Map<Character, Integer> mp = new HashMap<Character, Integer>();
	         mp.put('M', 1000);
	         mp.put('D', 500);
	         mp.put('C', 100);
	         mp.put('L', 50);
	         mp.put('X', 10);
	         mp.put('V', 5);
	         mp.put('I', 1);
	        
	         int num = mp.get(roman.charAt(0));
	         for (int i = 1; i < roman.length(); i++) {
	             int cur = mp.get(roman.charAt(i));
	             int prev = mp.get(roman.charAt(i - 1));
	             
	             if (cur > prev) {
	                 num += (cur - 2 * prev);
	             } else {
	                 num += cur;
	             }
	         }
	        
	        return num;
	 }
}
