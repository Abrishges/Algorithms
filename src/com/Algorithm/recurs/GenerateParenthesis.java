package com.Algorithm.recurs;

//https://leetcode.com/explore/interview/card/amazon/84/recursion/2988/
import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

	public static void main(String[] args) {

	   GenerateParenthesis gp = new GenerateParenthesis();
       System.out.println(gp.generateParenthesis(3));
	}

    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        List<String> result = new ArrayList<String>();
        int i = n; int j = n;   
        helper(n, sb, i, j, result);
        
        return result;
    }
    
   public void helper(int n, StringBuilder sb, int i , int j, List<String> result) {
	   
	   if (i == 0 && j == 0) {
		   result.add(sb.toString());
		   return;
	   }
	   
	   if (n - i <= n - j) {
		   sb.append("(");
		   helper(n, sb, i - 1, j, result);
		   sb.deleteCharAt(sb.length() - 1);
	   } 
	   
	   if (n - i > n - j) {
		    
		    if (i != 0) {
			    sb.append("(");
			    helper(n, sb, i - 1, j, result);
			    sb.deleteCharAt(sb.length() - 1);
		    }

		    if ( j != 0) {
			    sb.append(")");
			    helper(n, sb, i, j - 1, result);
			    sb.deleteCharAt(sb.length() - 1);	
		    }
	   } 
   }
}
