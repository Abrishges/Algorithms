package com.Algorithm.trees;

import java.util.ArrayList;
import java.util.List;

//Print the longest path from root to leaf in a Binary tree
public class LongestPath {
	
	class Node {
		Node left;
		Node right; 
		int data;
		
		public Node(int data) {
			this.data = data;
			this.left = this.right = null;
		}
	}

	public List<Integer> longestPath(Node node) {
		
		if (node == null) {	
			List<Integer> list = new ArrayList<Integer>();
			return list;
		}
		
		List<Integer> leftPath = longestPath(node.left);
		List<Integer> rightPath = longestPath(node.right);
		
		if (leftPath.size() > rightPath.size()) {
			 leftPath.add(node.data);
		} else {
			rightPath.add(node.data);
		}
		
		return leftPath.size() > rightPath.size() ? leftPath : rightPath;
	}
	
	public static void main(String[] args) {
		
		LongestPath longPath = new LongestPath();
		
		Node root = longPath.new Node(1);
	    root.left = longPath.new Node(2);
	    root.right = longPath.new Node(3);
	    root.left.left = longPath.new Node(4);
	    root.left.right = longPath.new Node(5);
	    root.left.right.right = longPath.new Node(6);
	     
	    List<Integer> output = longPath.longestPath(root);
	    int n = output.size();
	     
	    System.out.print(output.get(n - 1));
	    for(int i = n - 2; i >= 0; i--)
	    {
	        System.out.print(" -> " + output.get(i));
	    }

	}

}
