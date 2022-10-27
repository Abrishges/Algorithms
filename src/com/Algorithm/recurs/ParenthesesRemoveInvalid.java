package com.Algorithm.recurs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

//https://leetcode.com/explore/interview/card/facebook/53/recursion-3/324/
//This fails for [] and [""]
public class ParenthesesRemoveInvalid {

	public static void main(String[] args) {

	 ParenthesesRemoveInvalid pr = new ParenthesesRemoveInvalid();
		
     String str =  ")("; 
     List<String> result =   pr.removeInvalidParentheses(str);
     
     System.out.println(result);
	}
	
    public List<String> removeInvalidParentheses(String s) {
    
    	 int count = 0; 
    	 
         for (int i = 0; i < s.length(); i++) {
        	 if (s.charAt(i) == '(') {
        		 count++;
        	 } else if (s.charAt(i) == ')') {
        		 count--;
        	 }
         }
        
    	 Set<String> result = new HashSet<String>();
    	 StringBuilder sb = new StringBuilder();
    	 int index = 0;
    	 backtracking( s, result, sb, index, s.length() - Math.abs(count));
    	 
    	 if(result.size() == 0) {
    		 result.add("");
    	 }
    	 
    	 return new ArrayList<String>(result);
    }
    
    public void backtracking(String str, Set<String> result, StringBuilder sb, int index, int length) {
    	
    	if (index == str.length() && sb.length() == length) {
    		//validate and add it to the lists
    		boolean isValid = validateParentheses(sb.toString());
    		
    		if(isValid) {
        		result.add(sb.toString());
    		}	
    	}
    	
    	if (index < str.length()) {
    		
    		if(str.charAt(index) != '(' && str.charAt(index) != ')') {
            	backtracking(str, result, sb.append(str.charAt(index)), index + 1, length);
            	sb.deleteCharAt(sb.length() - 1);
    		} else {
            	backtracking(str, result, sb.append(str.charAt(index)), index + 1, length);
            	sb.deleteCharAt(sb.length() - 1);
            	backtracking(str, result, sb, index + 1, length);		
    		}	
    	}
    }
    
    public boolean validateParentheses(String str) {
    	//use switch statement and stack to validate
    	Stack<Character> stack = new Stack<Character>();
    	
    	if (str.length() == 0 || str.charAt(0) == ')') {
    		return false;
    	}
    	
    	int i = 0; 
    	
    	if (str.charAt(i) == ')' || str.charAt(i) == '(') {
    	  	stack.push(str.charAt(i));
    	}
  
    	i++;
    	while (i < str.length()) {
    		
    		if (str.charAt(i) == ')' && !stack.isEmpty() && stack.peek() == '(') {
    			stack.pop();
    		} else if (str.charAt(i) == ')' || str.charAt(i) == '('){
    			stack.push(str.charAt(i));
    		}
    		
    		i++;
    	}	
    	
    	return stack.isEmpty();
    }
}
