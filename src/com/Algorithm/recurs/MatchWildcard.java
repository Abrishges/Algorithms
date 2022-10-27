package com.Algorithm.recurs;

import java.util.HashMap;
import java.util.Map;

import javafx.util.Pair;

//https://leetcode.com/problems/wildcard-matching/
//what is the difference b/n wild card and regex 
//https://reqchecker.eu/manual/extract_syntax.html
public class MatchWildcard {

	public static void main(String[] args) {

		// This takes forever
		String str = "aaaabaaaabbbbaabbbaabbaababbabbaaaababaaabbbbbbaabbbabababbaaabaabaaaaaabbaabbbbaababbababaabbbaababbbba";
		String ptr = "*****b*aba***babaa*bbaba***a*aaba*b*aa**a*b**ba***a*a*";

		String str2 = "adceb";
		String ptr2 = "*a*b";

		MatchWildcard match = new MatchWildcard();

		System.out.println(match.isMatchMemo(str2, ptr2));

		//This will take forever to finish
		//System.out.println(match.isMatch(str2, ptr2));
	}

	public boolean isMatch(String s, String p) {
		
		if (s.equals(p)) return true;

		if (p.isEmpty())
			return s.isEmpty();

		String ptr = removeDuplicate(p);
        
		if (ptr.equals("*")) return true;
		
		return  !s.isEmpty() && isMatch(s, ptr, 0, 0);
	}

	// Recursion, this is very slow
	public boolean isMatch(String s, String p, int i, int j) {

		if (i == s.length() && j == p.length())
			return true;

		if (i == s.length() && p.length() == i + 1 && p.charAt(j) == '*') return true;
			
		if (i == s.length() || j == p.length()) 
			return false;

		if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')
			return isMatch(s, p, i + 1, j + 1);

		if (p.charAt(j) == '*') {
			return isMatch(s, p, i + 1, j) || isMatch(s, p, i, j + 1);
		}
			
		return false;	
	}

	public String removeDuplicate(String str) {

		StringBuilder sb = new StringBuilder();
		sb.append(str.charAt(0));
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == '*' && str.charAt(i - 1) == '*')
				continue;
			sb.append(str.charAt(i));
		}

		return sb.toString();
	}

	// Memorization recursion
	public boolean isMatchMemo(String s, String p) {

		if (p.isEmpty()) return s.isEmpty();

		String ptr = removeDuplicate(p);

		if (ptr.equals("*")) return true;	
				
		Map<Pair<String, String>, Boolean> dp = new HashMap<Pair<String, String>, Boolean>();

		return !s.isEmpty() &&  isMatchMemo(s, ptr, dp);
	}

	// we should do backtracking here
	// Instead of passing substring we can using index to improve effiecenty 
	public boolean isMatchMemo(String s, String p, Map<Pair<String, String>, Boolean> dp) {

		if (dp.containsKey(new Pair<String, String>(s, p)))
			return dp.get(new Pair<String, String>(s, p));
		

         if (s == p || p.equals("*")) {
        	 dp.put(new Pair<String, String>(s,p), true);
         } else if (p.isEmpty() || s.isEmpty()){
        	 dp.put(new Pair<String, String>(s,p), false);
         } else if (s.charAt(0) == p.charAt(0) || p.charAt(0) == '?') {
        	 dp.put(new Pair<String, String>(s,p), isMatchMemo(s.substring(1), p.substring(1), dp));
         } else if (p.charAt(0) == '*') {
        	 dp.put(new Pair<String, String>(s,p), isMatchMemo(s, p.substring(1), dp) ||
        			                               isMatchMemo(s.substring(1), p, dp));
         } else {
        	 dp.put(new Pair<String, String>(s,p), false);
         }
         
         return dp.get(new Pair<String, String>(s,p));
	}
}
