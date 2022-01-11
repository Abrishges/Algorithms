package com.Algorithm.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopologicalSortBFS {
	
	class Node<T> {
		T label;
		public Node(T label) {
			this.label = label;
		}
		
		@Override
		public boolean equals(Object other) {
			
			if (other == this) return true;
			
			
			if (other instanceof Node<?>) {
				if (((Node<?> ) other).label.equals(label)) {
					return true;
				}
			}

		return false;
	}
}
	
	//Find whether it is possible to finish all tasks or not from given dependencies, 
	// [[1, 0], [0, 1]]  false 
    // [[1, 0], [2, 1], [3, 2]]  true		
	class Pair {
		int first, second; 
		public Pair (int first, int second) {
			this.first = first;
			this.second = second;
		}
	}
	
   public int[] indegree(int noNodes, ArrayList<ArrayList<Integer>> graph) {
	   
	  int [] indegree = new int[noNodes];
	  
	  for (int i = 0; i < noNodes; i++) {
		   for (int nodes: graph.get(i)) {
			   indegree[nodes]++;
		   }
	  }
	   
	  return indegree;
   }
   
   public int [] topologicalSort(int noNodes, ArrayList<ArrayList<Integer>> graph) {
	   
	   int [] indegree = indegree(noNodes, graph);
	   int [] topSort = new int[noNodes];
	   Queue<Integer> q = new LinkedList<Integer>();
	   
	   for (int i = 0; i < noNodes; i++) {
		   if (indegree[i] == 0) {
			   q.add(i);
		   }
	   }
	   
	   int ind = 0; 
	   
	   while(!q.isEmpty()) {
		   
		   int node = q.remove();
           topSort[ind] = node; 
		   for (int neighbour : graph.get(node)) {
			    indegree[neighbour]--;
			    
			    if (indegree[neighbour] == 0) {
			    	q.add(neighbour);
			    }
		   }
	   }
	  return topSort; 
   }
	
   // check if graph is directed acyclic graph
   public boolean isDAG(int noNodes, ArrayList<ArrayList<Integer>> graph) {
	   
	   int [] indegree = indegree(noNodes, graph);
	   
	   for (int i = 0 ; i < noNodes; i++) {
		   
		   int j = 0;   
		   for (; j < noNodes; j++) {
			   if (indegree[j] == 0) break;
		   }
		   
		   // if j and noNodes are equal means we don't any zero degree node
		   if (j == noNodes) return false;
		   
		   indegree[j] = -1;
		   for (int neighbour : graph.get(j)) {
			   indegree[neighbour]--;
		   }   
	   }
	    // it means all the in degree are -1
	   return true;
   }
   
   public ArrayList<ArrayList<Integer>> makeGraph(int noNodes, List<Pair> list) {
	   ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>(noNodes);
	   
       for(int i=0; i < noNodes; i++){
           graph.add(new ArrayList<Integer>());
       }

       for (Pair pre : list)
           graph.get(pre.second).add(pre.first);

       return graph;  
   }


	public static void main(String[] args) {

        ArrayList<Pair> prerequisites = new ArrayList<Pair>();;
        
        // for prerequisites: [[1, 0], [2, 1], [3, 2]]
        TopologicalSortBFS graph = new TopologicalSortBFS();
        prerequisites.add(graph.new Pair(1, 0));
        prerequisites.add(graph.new Pair(2, 1));
        prerequisites.add(graph.new Pair(3, 2));
        //prerequisites.add(graph.new Pair(0, 3));
         
        ArrayList<ArrayList<Integer>> list = graph.makeGraph(4, prerequisites);

        if (graph.isDAG(4, list)) {
            System.out.println("Possible to finish all tasks");
        }
        else {
            System.out.println("Impossible to finish all tasks");
        }
	}
}
