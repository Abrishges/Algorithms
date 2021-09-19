package com.Algorithem.slidingwindow;

import java.util.HashMap;
import java.util.Map;
/*
 * Fast/Slow
 * https://leetcode.com/problems/minimum-window-substring/
 */

public class MinWindSubstring {
	
	class Tuble {
		int min;
		int max;
		
		public Tuble() {
			this.min = Integer.MIN_VALUE;
			this.max = Integer.MAX_VALUE;
		}
	}
	
	public static void main(String []args) {
		//min window substring
		String str = "ADOBECODEBANC";
		String sub = "ABC";
		
		MinWindSubstring mw = new MinWindSubstring();
			
		System.out.println(mw.minWindowSubstring(str, sub).min);
		System.out.println(mw.minWindowSubstring(str, sub).max);
	}

	
	public Tuble minWindowSubstring(String str, String sub) {
		Map<String, Integer> mp = new HashMap<String, Integer>();
		int lenght = sub.length();
		Tuble tuble = new Tuble();
		
		for (int i = 0; i < sub.length(); i++) {
			 String ch = String.valueOf(sub.charAt(i));
			 mp.put(ch, 0);
		}
		
		int k = 0;
		for (int j = 0; j < str.length(); j++) {
			   
			
			  String ch = String.valueOf(str.charAt(j));
			  if(mp.containsKey(ch)) {
				   int value = mp.get(ch);		
				   if(value == 0) {
					   lenght--;
				   }
				   value++;
				   mp.put(ch, value);
			  }
			  
		   	  if(lenght == 0) {
				 tuble.min = k;
				 tuble.max = j;
			  }
		   	  
		//we also need to compare min and max when ever it is zero
			while(lenght == 0) {
				
				if (j - k < tuble.max - tuble.min) {				
					tuble.min = k;
					tuble.max = j;
				}
					
				String chK = String.valueOf(str.charAt(k));		
				if(mp.containsKey(chK)) {
					int value = mp.get(chK) - 1;	
					if(value == 0) {
						 lenght++;
					}
					mp.put(chK, value);
				  }
				k++;
			}
		}
		
		return tuble;
	}
}
