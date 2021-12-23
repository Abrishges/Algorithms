package com.Algorithm.graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DisJointSet2 {

	Map<Integer, Node> mp = new HashMap<Integer, Node>();
	
    class Node {
        int data;
        Node parent;
        int rank;
    }
	
    public void makeSet(int data) {
    	Node node = new Node();
    	node.data = data;
    	node.rank = 0;
    	node.parent = node;
    	mp.put(data, node);
    }
    
    public int findSet(int data) {
    	Node parent = findSet(mp.get(data));
    	
    	return parent.data;
    }
    
    public Node findSet(Node node) {
    	 if(node.parent == node) return node;
             	
    	  node.parent = findSet(node.parent);  
    	  return node.parent;
    }
    
    public boolean union(int data1, int data2) {
    	
    	 Node node1 = mp.get(data1);
    	 Node node2 = mp.get(data2);
    	 
    	 Node parent1 = findSet(node1);
    	 Node parent2 = findSet(node2);
    	 
    	 if (parent1 == parent2) return false;
    	 
    	 if (parent1.rank >= parent2.rank) {
    		 
    		  if(parent1.rank == parent2.rank) {
    			  node1.rank++;
    		  }
    		  
    		  parent2.parent = parent1.parent;
    	 } else {
    		 parent1.parent = parent2.parent;
    	 } 
    	
    	 return true;
    }
    
	
	  public int countIslands(char[][] grid) {
		  
		    int n = grid.length;
		    int m = grid[0].length;
		    
		    for (int i = 0; i < n ; i++) {
		    	for (int j = 0 ; j < m ; j++) {
		    		
		    		  if (grid[i][j] == '0') continue;
		    		  
		    		  if (j+1 < m && grid[i][j+1] == '1') {			  
		    			  union(i * m + j, i * m + j+1);
		    		  }
		    		  
		    		  if (j-1 > 0 && grid[i][j-1] == '1') {
		    			  union(i * m + j, i * m + j-1);
		    		  }
		    		  
		    		  if (i + 1 < n && grid[i + 1][j] == '1') {
		    			  //System.out.printf("%d, %d \n", i * m + j, i + 1 * m + j);
		    			  union(i * m + j, (i + 1) * m + j);
		    		  }
		    		  
		    		  if (i - 1 > 0 && grid[i - 1][j] == '1') {
		    			  union(i * m + j, (i - 1) * m + j);
		    		  }	  
		    	}
		    }
		  
	        
	        int noOfIslands = 0;
	        Set<Integer> set = new HashSet<Integer>();
	        
	        for (int i = 0 ; i < n; i++) {
	        	for (int j = 0; j < m; j++) {
	        		
	        		if (grid[i][j] == '1') {
	        			Integer parent = findSet(i*m + j);
	        			//System.out.println(parent);
	        			if(!set.contains(parent)) {
	        				noOfIslands++;
	        				set.add(parent);
	        			}
	        		}
	        	}
	        }
	        
	        return noOfIslands;
	    }
	  
	public static void main(String[] args) {
          
		//This grid make it fail on [2][0]
		char [][] grid = {{'1', '1', '1','1', '0'}, {'1', '1', '0','1', '0'}, {'1', '1', '0','0', '0'}, {'0', '0', '0', '0', '0'}};
		DisJointSet2 ds = new DisJointSet2();
		int n = grid.length;
		int m = grid[0].length;
		
        for (int i = 0 ; i < n; i++) {
        	for (int j = 0; j < m; j++) {
        		if (grid[i][j] == '1') {
        			ds.makeSet(i * m + j);
        		}
        	}
        }	
        
		System.out.println(ds.countIslands(grid));
	}

}
