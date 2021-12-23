package com.Algorithm.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Graph2 {
	
	class Node {
		String label;
		public Node(String label) {
			this.label = label;
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
	
	//Remove nodes
	public void removeNode(String label) {
		Node node = new Node(label);
	    adjList.values().stream().forEach(e -> e.remove(node));
	    adjList.remove(new Node(label));
	}
	
	public void addEdge(String label1, String label2) {
	    Node node1 = new Node(label1);
	    Node node2 = new Node(label2);
	    adjList.get(node1).add(node2);
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
	
	public Set<String> breadthFirstTraversal(Graph2 graph, String root) {
		
		Set<String> visited = new LinkedHashSet<String>();
	    Queue<String> queue = new LinkedList<String>();
	       queue.add(root);
	       visited.add(root);
	       
	       while (!queue.isEmpty()) {
	    	    
	    	   String label = queue.poll();
	    	   
	    	   for (Node node : graph.getAdjList(label)) {
	    		     visited.add(node.label);
	    		     queue.add(label);
	    	   }
	       }
	       
	    return visited;
	}
}
