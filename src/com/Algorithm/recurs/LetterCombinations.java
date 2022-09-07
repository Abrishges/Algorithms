package com.Algorithm.recurs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations {

	public static void main(String[] args) {
		LetterCombinations lcm = new LetterCombinations();
		String digits = "";
		System.out.println(lcm.letterCombinations(digits));

	}
	
   public List<String> letterCombinations(String digits) {
    	
    	Map<Character, String> mp  = new HashMap<Character, String>();
    	mp.put('2', "abc");
    	mp.put('3', "def");
    	mp.put('4', "ghi");
    	mp.put('5', "jkl");
    	mp.put('6', "mno");
    	mp.put('7', "pqrs");
    	mp.put('8', "tuv");
    	mp.put('9', "wxyz");
        
    	StringBuilder slate = new StringBuilder();
    	List<String> result = new ArrayList<String>();
    	int index = 0;
    	if (digits.isBlank()) return result;
    	
    	helper(digits, slate, index, result, mp);
    	
    	return result;
    }
    
   //Can we do this using BFS
    public void helper(String digits, StringBuilder slate, int index, List<String> result, Map<Character, String> mp) {
    	 
    	 if (index == digits.length()) {
    		 result.add(slate.toString());
    		 return;
    	 }
    	 
    	 String str = mp.get(digits.charAt(index));
    	 
    	 for (int i = 0; i < str.length(); i++) {
    		   slate.append(str.charAt(i));
    		   helper(digits, slate, index + 1, result, mp);
    		   slate.deleteCharAt(slate.length() - 1);
    	 }
    }
}
