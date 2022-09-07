package com.Algorithm.recurs;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/letter-case-permutation/
public class LetterCasePermutation {

	public static void main(String[] args) {
		
		LetterCasePermutation lp = new LetterCasePermutation();
		String str = "3z4";
		List <String> result = lp.letterCasePermutation(str);
		System.out.println(result);
	}

	
    public List<String> letterCasePermutation(String s) {
        
    	StringBuilder ps = new StringBuilder();  //partial solution
    	int i = 0;   // sub problem
    	List<String> result = new ArrayList<String>();
    	
    	helper(s, ps, i, result);
    	
    	return result;
    }
    
    public void helper(String s, StringBuilder ps, int i, List<String> result) {
    	
    	 if (i == s.length()) {
    		 result.add(ps.toString());
    		 return;
    	 } else {  		   
    		     //Digit 	
    		  char ch = s.charAt(i);
    		  if (Character.isDigit(ch)) {
    			  helper(s, ps.append(ch), i+1, result);
    			  ps.deleteCharAt(ps.length() - 1);
    		  } else {
        		 //Characters
				  helper(s, ps.append(Character.toLowerCase(ch)), i+1, result);
				  ps.deleteCharAt(ps.length() - 1);

				  helper(s, ps.append(Character.toUpperCase(ch)), i+1, result);   
				  ps.deleteCharAt(ps.length() - 1);
    		  }
    	 }
    } 
}
