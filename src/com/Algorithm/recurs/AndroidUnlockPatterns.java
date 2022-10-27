package com.Algorithm.recurs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javafx.util.Pair;

public class AndroidUnlockPatterns {
	
	class count {
		int count;
	}
	
	private static Map<Pair<Integer, Integer>, Integer> skip =
			new HashMap<Pair<Integer, Integer>, Integer>();

	public static void main(String[] args) {
		AndroidUnlockPatterns lockPattern = new AndroidUnlockPatterns();
		int result = lockPattern.numberOfPatterns(1, 3);
		System.out.println(result);
	}
	
	public static void initilaizSkip() {
		skip.put(new Pair<>(1, 3), 2);
		skip.put(new Pair<>(1, 7), 4);
		skip.put(new Pair<>(3, 9), 6);
		skip.put(new Pair<>(7, 9), 8);
		skip.put(new Pair<>(1, 9), 5);
		skip.put(new Pair<>(2, 8), 5);
		skip.put(new Pair<>(3, 7), 5);
		skip.put(new Pair<>(4, 6), 5);
		
	}

    public int numberOfPatterns(int m, int n) {
        
    	initilaizSkip();
    	//int count = 0; 
    	count count = new count();
    	Set<Integer> visited = new HashSet<Integer>();
    	//we take each digit at starting point and count the number of patterns we can make from 
    	//each starting point
    	for (int i = 1; i < 10 ; i++) {
    		 visited.add(i);
    		 backTracking(i, visited, count, m, n);
    		 visited.remove(i);
    	}
    	
    	return count.count;
    }
    
    public int backTracking(int current, Set<Integer> visited , count count, int m , int n) {
    	
    	  if (visited.size() >= m) {
    		  count.count = count.count + 1;
    	  }
    	  
    	  if (visited.size() >= n) {
    		    return count.count;
    	  }
    	  
    	  for (int next = 1; next < 10; next ++) {
    		  
    		  if (visited.contains(next)) {
    			  continue;
    		  }
    		  Pair<Integer, Integer> edge =  new Pair<>(Math.min(current, next), Math.max(current, next));
    		  if (skip.get(edge) == null || visited.contains(skip.get(edge))) {
    			  visited.add(next);
    			  backTracking(next, visited, count, m, n);
    			  visited.remove(next);
    		  }
    		 
    	  }
    	  
    	  return count.count;
    }
}
