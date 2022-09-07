package com.Algorithm.trees;

//Print Ancestors of a given node in Binary Tree
/*
 * If give key is 7, then my function should return 4, 2, 1
 *            1
            /   \
          2      3
        /  \
      4     5
     /
    7
 */
public class Ancestors {
	
	class Node {
		Node left;
		Node right;
		int data;
		
		public Node (int data) {
			this.data = data;
			this.left = this.right = null;
		}
	}
   
	public boolean printAncestor(Node node, int target) {
		
		if (node == null) return false;
		
		if (node.data == target) return true;
		
		if (printAncestor(node.left, target) || printAncestor(node.right, target)) {		
			System.out.println(node.data);
			
			return true;
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
