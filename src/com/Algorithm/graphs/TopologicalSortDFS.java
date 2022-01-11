package com.Algorithm.graphs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class TopologicalSortDFS {
	
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
	
	 // No. of vertices
    private int V;
 
    // Adjacency List as ArrayList of ArrayList's
    private ArrayList<ArrayList<Integer> > adj;
 
    // Constructor
   public TopologicalSortDFS(int v)
    {
        V = v;
        adj = new ArrayList<ArrayList<Integer> >(v);
        for (int i = 0; i < v; ++i)
            adj.add(new ArrayList<Integer>());
    }
 
    // Function to add an edge into the graph
    public void addEdge(int v, int w) { adj.get(v).add(w); }
 
    // A recursive function used by topologicalSort
    public void topologicalSortUtil(int v, boolean visited[],
                             Stack<Integer> stack)
    {
        // Mark the current node as visited.
        visited[v] = true;
        Integer i;
 
        // Recur for all the vertices adjacent
        // to this vertex
        Iterator<Integer> it = adj.get(v).iterator();
        while (it.hasNext()) {
            i = it.next();
            if (!visited[i])
                topologicalSortUtil(i, visited, stack);
        }
 
        // Push current vertex to stack
        // which stores result
        stack.push(new Integer(v));
    }
 
    // The function to do Topological Sort.
    // It uses recursive topologicalSortUtil()
    public void topologicalSort()
    {
        Stack<Integer> stack = new Stack<Integer>();
 
        // Mark all the vertices as not visited
        boolean visited[] = new boolean[V];
        for (int i = 0; i < V; i++)
            visited[i] = false;
 
        // Call the recursive helper
        // function to store
        // Topological Sort starting
        // from all vertices one by one
        for (int i = 0; i < V; i++)
            if (visited[i] == false)
                topologicalSortUtil(i, visited, stack);
 
        // Print contents of stack
        while (stack.empty() == false)
            System.out.print(stack.pop() + " ");
    }
	

	public static void main(String[] args) {
		// Create a graph given in the above diagram
		TopologicalSortDFS g = new TopologicalSortDFS(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
 
        System.out.println("Following is a Topological "
                           + "sort of the given graph");
        // Function Call
        g.topologicalSort();

	}

}
