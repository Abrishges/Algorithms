package com.Algorithm.string;

import java.util.Stack;

public class Parentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Parentheses par = new Parentheses();
		String str = "}}";
		System.out.println(par.valid(str));
	}
	
	public boolean valid(String str) {
		Stack<Character> stack = new Stack<Character>();
		
		int length = str.length();
		if (length % 2 != 0 || length == 0) {
			return false;
		}
		
		for (int i = 0; i < str.length(); i++) {
			
			char ch = str.charAt(i);
			if (stack.isEmpty() && (ch == ')' || ch == ']' || ch == '}')) {
				return false;
			}
			
			switch (ch) {
			  
			case '(':
				 stack.push(ch);
				 break; 
			case ')' : {	
                 if (stack.pop().charValue() != '(') {
					 return false;
				 }
				 break;
			}
			case '[':
				 stack.push(ch);
				 break;
			case ']': {
                   if (stack.pop().charValue() != '[') {
					  return false;
				  }
				  break;
			 }	
			case '{' :
				stack.push(ch);
				break;
			case '}':
                if (stack.pop().charValue() != '{') {
				  return false;
			     }
			    break;
			}
		}
		
		if (!stack.isEmpty()) {
			return false;
		}
		
		return true;
	}
}
