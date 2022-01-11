package com.Algorithm.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Graph2 {
	
	class Node {
		String label;
		public Node(String label) {
			this.label = label;
		}
		
		@Override
		public boolean equals(Object o) {
			
			if (o == this) return true;
			
			if (o == null || !(o instanceof Node)) {
				// we can also use o.getClass() != this.getClass();
				return false;
			}
			
			Node node = (Node) o;
			
			return node.label.equals(label);	
		}
		
		@Override
		public int hashCode() {
			return Objects.hash(label);
		}
	}
	
	private Map<Node, List<Node>> adjList = new HashMap<Node, List<Node>>();
	
	public List<Node> getAdjList(String label) {
		return adjList.get(new Node(label));
	}

	public void setAdjList(Map<Node, List<Node>> adjList) {
		this.adjList = adjList;
	}
	
	//Add nodes
	public void addNode(String label) {
		adjList.putIfAbsent(new Node(label), new ArrayList<>());
	}
	
	public Set<Node> getAllVertex() {
		return adjList.keySet();
	}
	
	//Remove nodes
	public void removeNode(String label) {
		Node node = new Node(label);
	    adjList.values().stream().forEach(e -> e.remove(node));
	    adjList.remove(new Node(label));
	}
	
	public void addEdge(String label1, String label2) {
	    Node node1 = new Node(label1);
	    Node node2 = new Node(label2);
	    //we can also modify this to add nodes

	    adjList.get(node1).add(node2);
	    //uncomment this for undirected graph
	    adjList.get(node2).add(node1);
	}
	
	public void removeEdge (String label1, String label2) {
		
	    Node node1 = new Node(label1);
	    Node node2 = new Node(label2);
	    
	    List<Node> eNode1 = adjList.get(node1);
	    List<Node> eNode2 = adjList.get(node2);
	    
	    if (eNode1 != null)
	    	eNode1.remove(node2);
	    
	    if (eNode2 != null)
	    	eNode2.remove(node1);
	}
	
	public List<Node> getAdjNode(String label) {
		return adjList.get(new Node(label));
	}
	
	//depth first search
	public Set<String> depthFirstTraversal (Graph2 graph, String root) {
		Set<String> visited = new LinkedHashSet<String>();
	    Stack<String> stack = new Stack<String>();
	     stack.push(root);
	     
	     while (!stack.isEmpty()) {
	    	
	    	 String label = stack.pop();
	    	 
	    	 if (!visited.contains(label)) {
	    		 
	    		 visited.add(label);    		 
	    		 for ( Node node: graph.getAdjList(label)) {
	    			  stack.push(node.label);
	    		 } 
	    	 }
	    	 
	     }
	   return visited;  
	}
	
	//Breadth first search 
	public Set<String> breadthFirstTraversal(Graph2 graph, String root) {
		
		Set<String> visited = new LinkedHashSet<String>();
	    Queue<String> queue = new LinkedList<String>();
	       queue.add(root);
	       visited.add(root);
	       
	       while (!queue.isEmpty()) {
	    	    
	    	   String label = queue.poll();
	    	   
	    	   for (Node node : graph.getAdjList(label)) {
	    		   if(!visited.contains(node.label)) {
		    		     visited.add(node.label);
		    		     queue.add(node.label);  
	    		   }
	    	   }
	       }
	       
	    return visited;
	}
	
	// Detect cycle in undirected graph using dfs
	public boolean isCyclicDfs(Graph2 graph, String root) {
		
		//Set<String> visited = new HashSet<String>();
		Map<String, String> visited = new HashMap<String, String>();
		Stack<String> stack = new Stack<String>();
		
		stack.push(root);
		//store current node and parent
		visited.put(root, null);
		
		while (!stack.isEmpty()) {
			 
			String cur = stack.pop();
			     
				 for (Node node:  graph.getAdjNode(cur)) {
					 if (visited.containsKey(node.label) && !node.label.equals(visited.get(cur))) {
						 return true;
					 } else if (!visited.containsKey(node.label)) {						 
						 visited.put(node.label, cur);
					     stack.push(node.label);
					 }

				 }
			 }
		
		return false;
	}
	
	//Detect a cycle of undirected graph using bfs
	public boolean isCyclicBfs(Graph2 graph, String root) {
		
		Map<String, String> visited = new HashMap<String, String>();
		Queue<String> queue = new LinkedList<String>();
		
		//store current node and parent node
		visited.put(root, null);
		queue.add(root);
		
		while (!queue.isEmpty()) {
			
			String cur = queue.remove();
			
			for (Node node : graph.getAdjList(cur)) {
				 if(visited.containsKey(node.label) && !node.label.equals(visited.get(cur))) {
					 return true;
				 } else if (!visited.containsKey(node.label)) {
					 visited.put(node.label, cur);
					 queue.add(node.label);
				 }
			}
		}
		
		return false;
	}
	
	public static void main(String args[]) {
		
		Graph2 graph = new Graph2();
		graph.addNode("0");
		graph.addNode("1");
		graph.addNode("2");
		graph.addNode("3");
		graph.addNode("4");
		graph.addNode("5");
		graph.addNode("6");
		graph.addNode("7");
		
		// add edges		
        graph.addEdge("0", "1");
        graph.addEdge("0", "2");
        graph.addEdge("1", "2");
        //graph.addEdge("2", "0");
        graph.addEdge("2", "3");
        //graph.addEdge("3", "3");
        graph.addEdge("0", "4");
        graph.addEdge("4", "5");
        graph.addEdge("5", "6");
        graph.addEdge("6", "7");
        graph.addEdge("7", "4");

        Set<String> bfs = graph.breadthFirstTraversal(graph, "0");
        System.out.printf("bfs: %s \n", bfs);
        
        Set<String> dfs = graph.depthFirstTraversal(graph, "0");
        System.out.printf("dfs: %s \n", dfs);
        
        if(graph.isCyclicDfs(graph, "0"))
            System.out.println("dfs: Graph contains cycle");
        else
            System.out.println("dfs: Graph doesn't "
                                    + "contain cycle");
 
        if(graph.isCyclicBfs(graph, "0"))
            System.out.println("dfs: Graph contains cycle");
        else
            System.out.println("dfs: Graph doesn't "
                                    + "contain cycle");
	}
}
