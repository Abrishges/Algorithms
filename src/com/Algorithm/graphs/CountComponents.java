package com.Algorithm.graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CountComponents {

public int countComponents(int n, int[][] edges) {
        
        List<List<Integer>> adjList = new ArrayList<List<Integer>>();
        
        //create arraylist 
        for (int i = 0; i < n ;i++) {
          adjList.add(new ArrayList<Integer>());
        }
        
        //build adjList
        for (int [] edge : edges) {
              adjList.get(edge[0]).add(edge[1]);
              adjList.get(edge[1]).add(edge[0]);
        }
        
        int count = 0;
        Set<Integer> visited = new HashSet<Integer>();
        
        for (int i = 0; i < n; i++) {
            
            if (!visited.contains(i)) {
                 count++;
                 dfs(i, visited, adjList);
            }
        }
       
        
        return count;
    }
    
    public void dfs(int node, Set<Integer> visited, List<List<Integer>>list) {
        
        visited.add(node);
        
        for (int adj : list.get(node)) {
            if(!visited.contains(adj)){
                dfs(adj, visited, list);
            }
       }
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
