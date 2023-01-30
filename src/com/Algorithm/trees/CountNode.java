package com.Algorithm.trees;

//Count the number of nodes for complete binary tree in less o(n) time
//https://leetcode.com/explore/featured/card/google/61/trees-and-graphs/3071/
public class CountNode {
	
	//Naive solution 
	public int countNodes(Node root) {
		return root != null ? 1 + countNodes(root.left) + countNodes(root.right):0;
	}
	
	
	
	
	public int countNode(Node node) {
		if(node == null) return 0;
		
		int lefth = heightLeft(node);
		int righth = heightRight(node);
		
		if(lefth == righth) return (int) (Math.pow(2, lefth) - 1);
		
		return (1 + countNode(node.left) + countNode(node.right));
	}
	
	public int heightLeft(Node node) {
		int h = 0;
		while(node != null) {
			h++;
		    node = node.left;	
		}
	  return h;	
	}
	
	public int heightRight(Node node) {
		int h = 0;
		while(node != null) {
			h++;
		    node = node.right;	
		}
	  return h;	
	}
}