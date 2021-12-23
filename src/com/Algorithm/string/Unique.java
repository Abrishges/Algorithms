package com.Algorithm.string;

import java.util.HashMap;
import java.util.Map;

public class Unique {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       String str = "aabb";
       
       Unique unique = new Unique();
       System.out.println(unique.UniqueChar(str));
	}

	public int UniqueChar(String str) {
		  
		Map<Character, Integer> mp = new HashMap<Character, Integer>();
		for (int i = 0; i < str.length(); i++) {
			int count = mp.getOrDefault(str.charAt(i), 0);
			mp.put(str.charAt(i), count + 1);
		}

		for (int j = 0 ; j < str.length(); j++) {
		    if(mp.get(str.charAt(j)).intValue() == 1) {
		    	return j;
		    }
		}
		
		return -1;
	}
}
