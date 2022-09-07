package com.Algorithm.trees;

// Diameter of a tree
public class DiameterOfTree {
    
	class Node {
		Node left;
		Node right; 
		Node val;
	}
	class Height {
		int height;
	}
	
	public int diameter(Node node, Height height) {
		
		if(node == null) {
			height.height = 0;
			return 0;
		}
		
		Height lh = new Height();
		Height rh = new Height();
		
		int ld = diameter(node.left, lh);
		int rd = diameter(node.right, rh);
	  	
		height.height = Math.max(lh.height, rh.height) + 1; 
		
		return Math.max((lh.height + rh.height), Math.max(ld, rd));
	}
	
	public static void main(String[] args) {
		
	}
}



