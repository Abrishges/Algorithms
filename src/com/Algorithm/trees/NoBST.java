package com.Algorithm.trees;

//Count the Number of Binary Search Trees present in a Binary Tree

public class NoBST {
    static int count = 0;
	static class Node {
		int data;
		Node left, right;
		Boolean isBST;
		
		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
			this.isBST = false;
		}
	}
	
	public static void levelBSTinOrder(Node node) {
		
		if (node != null) {
			
			levelBSTinOrder(node.left);
			levelBSTinOrder(node.right);
			
			if (node.left == null && node.right == null) {
				node.isBST = true;
				System.out.println(node.data);
			} else if (node.left != null && node.right != null) {
				if (node.left.isBST && node.right.isBST) {
					if(node.left.data < node.data && node.right.data > node.data){
						node.isBST = true;
						System.out.println(node.data);
					}
				}
			} else if (node.left == null){
				if(node.right.data > node.data && node.right.isBST) {
					node.isBST = true;
					System.out.println(node.data);
				}
			} else if (node.right == null) {
				if(node.left.data < node.data && node.left.isBST) {
					node.isBST = true;
					System.out.println(node.data);
				}
			}
		}
	}
	
	public static void inOrderCount(Node node) {
		
			if (node == null) {
				return ;
			}
			
		    inOrderCount(node.left);
		    if(node.isBST) {
			   count++;
		    }
			inOrderCount(node.right);
	}
	
	//Count nodes, we can also use stack to count nodes  	
	public static int count(Node node) {
		if(node == null) {
			return 0;
		}	
		
		return count(node.left) + count(node.right);
	}
		
	
	public static void main(final String args[]) {
		    Node root = new Node(5);
	        root.left = new Node(9);
	        root.right = new Node(3);
	        root.right.right = new Node(4);
	        root.right.right.right = new Node(10);
	        root.left.left = new Node(6); 
	        root.left.left.left = new Node(8);
	        root.left.left.right = new Node(7);
	        
	        levelBSTinOrder(root);
	        System.out.println("********");
	        inOrderCount(root);

	        System.out.printf("\nnumber of BSTs: %d", count(root));
	}
}
