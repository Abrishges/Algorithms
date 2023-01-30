package com.Algorithem.ArraysAndLists;

import java.util.Arrays;
import java.util.TreeSet;

public class NextClosestTime {

	public static void main(String[] args) {
		String time = "19:34";
        char[] result = time.toCharArray();
        System.out.println(result);
        System.out.println(nextClosestTime(time));

	}

	//Can this be done using backtracking or DFS? 
    public static String nextClosestTime(String time) {
    	char[] result = time.toCharArray();
    	Character [] digits = new Character[] {result[0], result[1], result[3], result[4]};
    	TreeSet<Character> set = new TreeSet<Character>(Arrays.asList(digits));
    	
    	result[4] = findNext(result[4], '9', set);
    	if (result[4] > time.charAt(4)) return String.valueOf(result);
    	
    	result[3] = findNext(result[3], '5', set);
    	if (result[3] > time.charAt(3)) return String.valueOf(result);
    	
    	char limit = time.charAt(0) == '2' ? '3' : '9';
    	result[1] = findNext(result[1], limit, set);
    	if (result[1] > time.charAt(1)) return String.valueOf(result);
    	
    	result[0] = findNext(result[0], '2', set);
    	
    	return String.valueOf(result);
    }
	
	public static Character findNext(char current, char limit, TreeSet<Character> set) {
		
		Character ch = set.higher(current);
		
		return (ch == null || ch > limit) ? set.first() : ch;
	}
	
}
