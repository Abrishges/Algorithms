package com.Algorithm.graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidTree2 {

	 public boolean validTree(int n, int[][] edges) {
	        
	        List<List<Integer>> adjList = new ArrayList<List<Integer>>();
	        
	        for (int i = 0; i < n; i++) {
	            adjList.add(new ArrayList<Integer>());
	        }
	        
	        //build adjList   
	        for (int [] edge : edges) {
	            adjList.get(edge[0]).add(edge[1]);
	            adjList.get(edge[1]).add(edge[0]);
	        }
	        
	        
	        Set<Integer> visited = new HashSet<Integer>();
	        
	        if (hasCycle(0, visited, adjList, null)) {
	            return false;
	        }
	        
	        if (visited.size() == n) {
	            return true;
	        } else {
	            return false;
	        }  
   }
	 

public boolean hasCycle(int node, Set<Integer> visited, List<List<Integer>> adjList, Integer parnet ) {
	
	visited.add(node);
	
	for (int adj : adjList.get(node)) {
		if (visited.contains(adj)) {
			if(adj != parnet) {
				return true;
			}
		} else {
			if(hasCycle(node, visited, adjList, node)) return true;
		}
	}
	
	return false;
}
}

