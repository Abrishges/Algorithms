package com.Algorithem.divideandconquer;

public class ISBST {

	public static void main(String[] args) {
		
		ISBST bst  = new ISBST();
		Node node = bst.new Node(2147483647);
		node.left = bst.new Node(2);
		node.left.left = bst.new Node(2);
		node.left.right = bst.new Node(3);  // if we replace this by 5, it will be false
		node.right = bst.new Node(6);
		node.right.left = bst.new Node(5);
		node.right.right = bst.new Node(7);
		
		System.out.println(bst.isBST(node));
	}
	
	//is it BST
	class Node {
		Node left;
		Node right; 
		int data;
		
		public Node(int data) {
			this.data = data;
		}
	}
	
	public boolean isBST(Node node) {
		  
		 if (node == null) return true;
	     return isBST(node, Integer.MIN_VALUE, Integer.MAX_VALUE);   	 
	}

	public boolean isBST(Node node, int min, int max) {
		
		 if (node == null) return true;
		 
		 if(node.data < min || node.data > max) return false;
		 
		 return isBST(node.left, min, node.data) && isBST(node.right, node.data, max);
	}
}
