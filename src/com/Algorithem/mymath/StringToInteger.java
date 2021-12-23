package com.Algorithem.mymath;

public class StringToInteger {

	public static void main(String[] args) {
		
		String x = "abcrd";
		
		System.out.println(x.replaceAll("[^1-9]",""));
		System.out.println(x.replaceAll("[^1-9]","").length());
		
		System.out.println(x);
		
		String s = "21474836460";

		//System.out.println(Integer.MAX_VALUE);
		//System.out.println(Integer.MIN_VALUE);
		StringToInteger strInt = new StringToInteger();
		
	    System.out.println(strInt.myAtoi(s));
	}
	
	
	 public int myAtoi(String s) {
	        s = s.trim();
	        
	        if (s.isBlank() || s.replaceAll("[^1-9]", "").length() == 0){
	            return 0;
	        }
	        
	        int i = 0;
	        if ((s.charAt(0) == '+' || s.charAt(0) == '-') && s.length() > 1) {
	            i++; 
	        }
	        
//	        if (!Character.isDigit(s.charAt(i))) {
//	        	return 0;
//	        }
	        
	        int j = i;
	        while(j < s.length() && Character.isDigit(s.charAt(j))) {
	            j++;
	        }
	      	       
	  
	        Long longNum;
	        
	        try {
	        	 longNum = Long.parseLong(s.substring(i, j));
	        	 System.out.println(longNum);
	        	 if (s.charAt(0) == '-') {
	        		 longNum = -1 * longNum;	        	 
	        		 if (longNum < Integer.MIN_VALUE) {
		        		 longNum = (long) Integer.MIN_VALUE;
		        	 }
	        	 }
	        	 
	        	 if (longNum > Integer.MAX_VALUE) {
	        		 longNum = (long) Integer.MAX_VALUE;
	        	 }
	        } catch (Exception e) {
	        	 return (s.charAt(0) == '-') ? Integer.MIN_VALUE : Integer.MAX_VALUE;
	        }
	      
	        return longNum.intValue();
	    }

}
