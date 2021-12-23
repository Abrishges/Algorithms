package com.Algorithm.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupAnagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String [] strs = {"eat","tea","tan","ate","nat","bat"};
		
		String [] strs2 = {"cab","tin","pew","duh","may","ill","buy","bar","max","doc"};
		
		GroupAnagrams angrams = new GroupAnagrams();
		System.out.println(angrams.groupAnagrams(strs));

	}

	 public List<List<String>> groupAnagrams(String[] strs) {
	        
	        Map<String, List<String>> mp = new HashMap<String, List<String>>();
	        int [] count = new int[26];
	        
	        for (String str: strs) {
	            
	            Arrays.fill(count, 0);
                for (int i = 0; i < str.length(); i++) {
                	 count[str.charAt(i) - 'a']++;
                }
                
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < count.length; i++) {
                	 sb.append("#");
                	 sb.append(count[i]);
                }
                
                // Key will be  #2#3#0#0...
                String key = sb.toString();
                
                if (!mp.containsKey(key)) {
                	mp.put(key, new ArrayList<String>());
                }
                
                mp.get(key).add(str);
                
	        }
	        
	      return (mp.values().stream().collect(Collectors.toList()));  
	    }
}
