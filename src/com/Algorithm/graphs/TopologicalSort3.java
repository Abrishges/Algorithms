package com.Algorithm.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopologicalSort3 {

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
	
	public Map<Integer, ArrayList<Integer>> makeGraph( List<Pair> list) {
		
		Map<Integer, ArrayList<Integer>> graph = new HashMap<Integer, ArrayList<Integer>>();
		
		for (Pair  pair : list) {
			if (graph.containsKey(pair.second)) {
				graph.get(pair.second).add(pair.first);
			} else {
				graph.put(pair.second, new ArrayList<Integer>());
				graph.get(pair.second).add(pair.first);
			}
			
			if (!graph.containsKey(pair.first)) {
				graph.put(pair.first, new ArrayList<Integer>());
			}
		}
		
		return graph;
	}
	
	public boolean canFinish(List<Pair> list) {
		Map<Integer, ArrayList<Integer>> graph = makeGraph(list);
		
		//This should be the size of nodes
		boolean dfsVisited[] = new boolean[graph.keySet().size()];
        boolean visited[] = new boolean[graph.keySet().size()];
        
        // we should iterate map keys instead
        for (int node : graph.keySet()) {
        	
        	if (!visited[node] && dfsCycle(graph, node, dfsVisited, visited)) {
        		return false;
        	}
        	
        }
        return true;
	}
	
	public boolean dfsCycle(Map<Integer, ArrayList<Integer>> graph, int node, boolean [] dfsVisited, boolean [] visited) {
		
		if (visited[node]) return false;
		
		dfsVisited[node] = visited[node] = true;
		
		for (int neigh : graph.get(node)) {
			
			if (dfsVisited[neigh] && dfsCycle(graph, neigh, dfsVisited, visited)) {
				return true;
			}
			
		}
		return dfsVisited[node] = false; 
	}
	
	public static void main(String[] args) {

        ArrayList<Pair> prerequisites = new ArrayList<Pair>();;
     
        // for prerequisites: [[1, 0], [2, 1], [3, 2]]
        TopologicalSort3 graph = new TopologicalSort3();
        prerequisites.add(graph.new Pair(1, 0));
        prerequisites.add(graph.new Pair(2, 1));
        prerequisites.add(graph.new Pair(3, 2));
         

        if (graph.canFinish(prerequisites)) {
            System.out.println("Possible to finish all tasks");
        }
        else {
            System.out.println("Impossible to finish all tasks");
        }

	}
}
