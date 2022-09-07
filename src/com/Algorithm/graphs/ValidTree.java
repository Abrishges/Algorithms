package com.Algorithm.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

//https://leetcode.com/problems/graph-valid-tree/submissions/
public class ValidTree {

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
	        
	        if (hasCycle(0, visited, adjList)) {
	            return false;
	        }
	        
	        if (visited.size() == n) {
	            return true;
	        } else {
	            return false;
	        }  
	    }
	    
	    public boolean hasCycle(Integer node, Set<Integer> visited,  List<List<Integer>> adjList) {

	        Stack<Integer> stack = new Stack<Integer>();
	        Map<Integer, Integer> parent = new HashMap<Integer, Integer>();
	        stack.add(node);
	        parent.put(node, null);
	        
	        while(!stack.isEmpty()) {
	            int v = stack.pop();
	            visited.add(v);
	            
	            for (int adj : adjList.get(v)) {
	                if(!visited.contains(adj)){
	                    stack.push(adj);
	                    parent.put(adj, v);
	                } else {
	                    if(parent.get(v) != adj) {
	                        return true;
	                   }
	                }
	            }  
	        }
	    
	    return false;
	}
	    
	    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
