package com.Algorithm.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class GraphDirected {
	
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
	
	public boolean isCyclic(GraphDirected graph) {
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
	
	public boolean isCyclicDfs(GraphDirected graph, Node current,  Set<Node> whiteSet, 
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
	
	
	public static void main(String[] args) {


		GraphDirected graph = new GraphDirected();
		graph.addNode("0");
		graph.addNode("1");
		graph.addNode("2");
		graph.addNode("3");
		
		// add edges		
        graph.addEdge("0", "1");
        graph.addEdge("0", "2");
        graph.addEdge("1", "2");
        //cycle
        graph.addEdge("2", "0");
        graph.addEdge("2", "3");
        //cycle
        graph.addEdge("3", "3");
        
        
        if(graph.isCyclic(graph))
            System.out.println("dfs: Graph contains cycle");
        else
            System.out.println("dfs: Graph doesn't "
                                    + "contain cycle");

	}
}
