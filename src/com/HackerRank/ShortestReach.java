/**
 * 
 */
package com.HackerRank;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author aberehamwodajie
 *
 *         May 2, 2017
 */
public class ShortestReach {

	static final int EDGE_DISTANCE = 6;
	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		
		Scanner in = new Scanner(System.in);
		int queries = in.nextInt();
	for(int k = 0; k < queries ; k++)	{
		List<Node> list = new ArrayList<Node>();
		int n = in.nextInt();
		for (int i = 0; i < n; i++) {
			Node node = new Node(i);
			list.add(node);
		}
		int edges = in.nextInt();

		for (int i = 0; i < edges; i++) {
			int u = in.nextInt() - 1;
			int v = in.nextInt() - 1;

			list.get(u).adjList.add(v);
			list.get(v).adjList.add(u);

		}
		
		int startNode = in.nextInt() - 1;
		
		bfs(list, startNode);
		
		System.out.println(String.join(" ", IntStream.range(0, list.size()).filter(data -> data != startNode).mapToObj(data -> String.valueOf(list.get(data).distance)).collect(Collectors.toList())));
		
	}
		in.close();
		
	}

	  static void bfs(List<Node> list, Integer startNode) {
		Queue<Node> queue = new LinkedList<Node>();
		Node start = list.get(startNode);
		start.distance = 0;
		queue.offer(start);
		while (!queue.isEmpty()) {
			Node currentNode = queue.poll();		 
			for (Integer adj : currentNode.adjList) { 
				if (list.get(adj).distance == -1) {
					list.get(adj).distance = currentNode.distance + EDGE_DISTANCE;	
					queue.offer(list.get(adj));
				}
			}
		}
	}
	 
	 
}
class Node {
	int data;
	int distance = -1;
	List<Integer> adjList = new ArrayList<Integer>();

	public Node(int data) {
		this.data = data;
	}
}