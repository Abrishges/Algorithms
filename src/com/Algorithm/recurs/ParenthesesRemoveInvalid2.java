package com.Algorithm.recurs;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/remove-invalid-parentheses/
//This is the most efficient answer
public class ParenthesesRemoveInvalid2 {

	public static void main(String[] args) {
      
		String str = ")(()";
		ParenthesesRemoveInvalid2 pi = new ParenthesesRemoveInvalid2();
		System.out.println(pi.removeInvalidParentheses(str));
	}

	
    public List<String> removeInvalidParentheses(String s) {
        
    	List<String> result = new ArrayList<String>();
    	helper(s, 0, 0, '(', ')', result);
    	
    	return result;
    }
    
    
    public void helper(String str, int istart, int jstart, char openParen, char closedParen, 
    		List<String> result) {
    	
    	int numOfOpen = 0; int numOfClose = 0; 
    	
    	for (int i = 0; i < str.length(); i++) {
    		if(str.charAt(i) == openParen) numOfOpen++;
    		if(str.charAt(i) == closedParen) numOfClose++;
    		
    		if (numOfClose > numOfOpen) {
    			
    		   for (int j = jstart ; j <= i; j++) {
    			   if (str.charAt(j) == closedParen && (j == jstart ||  str.charAt(j - 1) != closedParen))  {
    				   helper(str.substring(0, j) + str.substring(j + 1, str.length()), i, j, openParen, closedParen, result);
    			   }
    		   }
    		  
    		   return;
    		}
    	}
    	
    	String reversed = new StringBuilder(str).reverse().toString();
    	if (openParen == '(') {
    		helper(reversed, 0, 0, closedParen, openParen, result);
    	} else {
    		result.add(reversed);
    	}   
    }
}