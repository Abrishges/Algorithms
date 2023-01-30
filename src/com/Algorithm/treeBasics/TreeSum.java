package com.Algorithm.treeBasics;

public class TreeSum {

	public static void main(String[] args) {
		Node root = new Node(5);
		root.left = new Node(2);
		root.right = new Node(6);
		root.right.left = new Node(4);
		root.right.right = new Node(2);
		
		System.out.println(computeSum(root));
		System.out.println(computeSumPostOrder(root));
		System.out.println(computeSumInorder(root));
	}
	
	//In order
	public static int computeSum(Node root) {
		if (root == null) return 0; 
		
		int sum = 0;
		sum += root.data;
		sum += computeSum(root.left);
		sum += computeSum(root.right);
		
		return sum;
	}
	
	//post order
	public static int computeSumPostOrder(Node root) {
		if (root == null) return 0; 
		int leftSum = computeSumPostOrder(root.left);
		int rightSum = computeSumPostOrder(root.right);
		
		return root.data + leftSum + rightSum;
	}

   public static int computeSumInorder(Node node) {
	   if (node == null) return 0;
	   
	   int sum = 0;
	   sum += computeSumInorder(node.left);
	   sum += node.data;
	   sum += computeSumInorder(node.right);
	    
	  return sum;
   }
}
