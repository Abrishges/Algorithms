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

////Find whether it is possible to finish all tasks or not from given dependencies
public class TopologicalSort2 {
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
	
	class Pair {
		String first, second; 
		
		public Pair (String first, String second) {
			this.first = first; 
			this.second = second;
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
	    //uncomment this for directed graph
	    //adjList.get(node2).add(node1);
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
	
	public boolean isCyclic(TopologicalSort2 graph) {
		// detect a cycle in directed graph
		
		Set<Node> whiteSet =  new HashSet<Node>();
		Set<Node> graySet = new HashSet<Node>();
		Set<Node> blackSet = new HashSet<Node>();
		
		
		for (Node node : graph.getAllVertex()) {
			whiteSet.add(node);
		}
		
		while (whiteSet.size() > 0) {
			 Node node = whiteSet.iterator().next();
			 
			 if (isCyclicDfs(graph, node, whiteSet, graySet, blackSet)) {
				 return true;
			 }
		}
		
		
		return false;	
	}
	
	public boolean isCyclicDfs(TopologicalSort2 graph, Node current,  Set<Node> whiteSet, 
			Set<Node> graySet, Set<Node> blackSet) {
		
		whiteSet.remove(current);
		graySet.add(current);
		
		for (Node adjNode : graph.getAdjList(current.label)) {
			
			if (blackSet.contains(adjNode)) {
				continue;
			}
			
			if (graySet.contains(adjNode)) {
				return true;
			}
			
			
			if (isCyclicDfs(graph, adjNode, whiteSet, graySet, blackSet)) {
				return true;
			}	
		}
		
		graySet.remove(current);
		blackSet.add(current);
		
		
	  return false;	
	}
	
	//Breadth first search 
	public Set<String> breadthFirstTraversal(TopologicalSort2 graph, String root) {
		
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
	
	//Make graph from adjacency list, e.g [[1, 0], [0, 1]] 
	public void makeAdjList(TopologicalSort2 graph, List<Pair> list) {
		
		for (Pair pair : list) {
			//add edge
			graph.addEdge(pair.second, pair.first);
		}
	}
	
	//Find whether it is possible to finish all tasks or not from given dependencies
	public static void main(String args[]) {
		
		TopologicalSort2 graph = new TopologicalSort2();
		graph.addNode("0");
		graph.addNode("1");   //[[1, 0], [2, 1], [3, 2]] 
		graph.addNode("2");
		graph.addNode("3");
		
		List<Pair> list = new ArrayList<Pair>();
		list.add(graph.new Pair("1", "0"));
		list.add(graph.new Pair("2", "1"));
		list.add(graph.new Pair("3", "2"));
		graph.makeAdjList(graph, list);
		
		
		
		System.out.println(graph.breadthFirstTraversal(graph, "0"));
		
	    System.out.println(graph.isCyclic(graph));
	}
}
