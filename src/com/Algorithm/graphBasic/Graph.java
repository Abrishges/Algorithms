package com.Algorithm.graphBasic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class Graph {
	Map<String, ArrayList<Node>> adjListMap = new ConcurrentHashMap<>();
	Map<String, Node> allNodes = new ConcurrentHashMap<>();
	Set<Edge> allEdges = new HashSet<>();

	public void insertAdj(final String key, final String neighbour) {

		Node node1 = null;
		if (this.allNodes.containsKey(key)) {
			node1 = this.allNodes.get(key);
		} else {
			node1 = new Node(key);
			this.allNodes.put(key, node1);
		}

		Node node2 = null;
		if (this.allNodes.containsKey(neighbour)) {
			node2 = this.allNodes.get(neighbour);
		} else {
			node2 = new Node(neighbour);
			this.allNodes.put(neighbour, node2);
		}
		// adding to the adjacency list
		if (this.adjListMap.containsKey(key)) {
			this.adjListMap.get(key).add(node2);
		} else {
			final ArrayList<Node> list = new ArrayList<>();
			list.add(node2);
			this.adjListMap.put(key, list);
		}
		this.addEdge(node1, node2);
	}

	public void addEdge(final Node node1, final Node node2) {
		this.allEdges.add(new Edge(node1, node2));
	}

	public void remove(final String key, final String neighbour) {
		if (this.adjListMap.containsKey(key)) {
			final List<Node> list = this.adjListMap.get(key);
			for (final Node node : list) {
				if (node.getData().equals(neighbour)) {
					list.remove(node);
				}
			}
		}
	}

	public List<Node> unVisitedAdjacnyList(final String key) {
		List<Node> unvistedAdjList = null;
		if (this.adjListMap.containsKey(key)) {
			final List<Node> list = this.adjListMap.get(key);
			unvistedAdjList = list.stream().filter(Node -> !Node.visited).collect(Collectors.toList());
		}
		return unvistedAdjList;
	}

	public Node getUnvisitedAdjNode(final Node node) {
		final List<Node> unvistedAdjList = this.unVisitedAdjacnyList(node.data);
		final Iterator<Node> it = unvistedAdjList.iterator();
		while (it.hasNext()) {
			final Node current = it.next();
			if (!current.visited) {
				return current;
			}
		}
		return null;
	}

	public List<Node> getAdjacencyList(final String key) {
		return this.adjListMap.get(key);
	}

	public Map<String, ArrayList<Node>> getMap() {
		return this.adjListMap;
	}

	public List<String> getAllVertics() {
		return this.adjListMap.entrySet().stream().map(Map.Entry::getKey).collect(Collectors.toList());
	}

	public Set<Edge> getAllEdges() {
		return this.allEdges;
	}

	public Map<String, Node> getAllNodes() {
		return this.allNodes;
	}

	public void clearNodes() {
		final List<Node> nodes = this.allNodes.values().stream().collect(Collectors.toList());
		for (final Node node : nodes) {
			node.visited = false;
		}
	}
}
