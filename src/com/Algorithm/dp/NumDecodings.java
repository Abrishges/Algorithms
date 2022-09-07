package com.Algorithm.dp;

public class NumDecodings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       
		NumDecodings nd = new NumDecodings();
		String str = "11101";
		Value value = nd.new Value();
		int ans = nd.numDecodings(str, 0, value);
		System.out.println(ans);
	}
	
	class Value {
		int ans;
	}
	
	// Convert this approach to memorization
	public int numDecodings(String s, int i, Value value) {
		
		   if (s.length() == i) return 1;
		   
		   if (s.charAt(i) == '0') return 0;
		   
		   if (i == s.length() - 1) return 1; 


		  // if (i < s.length()) {
			   value.ans += numDecodings(s, i + 1, value);
		   //}
		   int twoDigit = Integer.valueOf(s.substring(i, i+2));
		   if (twoDigit >= 10 && twoDigit <= 26) {
			   value.ans += numDecodings(s, i + 2, value);
		   }
		
		
		return value.ans;
	}
}
