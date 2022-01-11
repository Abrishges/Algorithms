package com.Algorithm.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseSchedule {

    class Pair {
		int first, second; 
		public Pair (int first, int second) {
			this.first = first;
			this.second = second;
		}
	}
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        if (prerequisites.length == 0 || numCourses == 0) return true;
        
         ArrayList<Pair> list = new ArrayList<Pair>();
         
         for (int [] ele : prerequisites) {
              list.add(new Pair(ele[0], ele[1]));
         } 
          
	    ArrayList<ArrayList<Integer>> graph = this.makeGraph(numCourses, list);
	        
	    if (this.isDAG(numCourses, graph)) return true;
	        
	        return false;
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
	    	    
	
   public int[] indegree(int noNodes, ArrayList<ArrayList<Integer>> graph) {
	   
	  int [] indegree = new int[noNodes];
	  
	  for (int i = 0; i < noNodes; i++) {
		   for (int nodes: graph.get(i)) {
			   indegree[nodes]++;
		   }
	  }
	   
	  return indegree;
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
	    
	    
	public static void main(String[] args) {
		
		//[[0,10],[3,18],[5,5],[6,11],[11,14],[13,1],[15,1],[17,4]]
	   
		int [][] prerequisites = {
				{0, 1},
//				{3, 18},
//				{5, 5},
//				{6, 11},
//				{11, 14},
//				{13, 1},
//				{15, 1},
//				{17, 4}
		};
		
		CourseSchedule course = new CourseSchedule();
		
		 System.out.println(course.canFinish(2, prerequisites));
		
	}

}
