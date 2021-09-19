package com.Algorithm.trees;


//Count the Number of Binary Search Trees present in a Binary Tree

public class NoBST2 {
	
	static class Node {
		int data;
		Node left, right ;
		
		public Node (int data) {
			this.data = data;
			this.left = this.right = null;
		}
	}
	
    static class Info {
    	int numberOfBST;
    	int max;
        int min;
        Boolean isBST;
        
        public Info() {
        }
        
        public Info(int numberOfBST, int max, int min, Boolean isBST) {
        	this.numberOfBST = numberOfBST;
        	this.max = max;
        	this.min = min;
        	this.isBST = isBST;
        }
    }
    
    public static Info numberOfBST(Node node) {
    	 
    	if (node == null) {
    		return new Info(0, Integer.MAX_VALUE, Integer.MIN_VALUE, false);
    	}
    	
    	if(node.left == null && node.right == null) {
    		return new Info(1, node.data, node.data, true);
    	}
    	
    	Info leftInfo = numberOfBST(node.left);
    	Info rightInfo = numberOfBST(node.right);
    	
    	Info bst = new Info();
    	bst.min = Math.min(node.data, Math.min(leftInfo.min, rightInfo.min));
    	bst.max = Math.max(node.data, Math.max(leftInfo.max, rightInfo.max));
    	
    	if(leftInfo.isBST && rightInfo.isBST  && node.data > node.left.data && node.data < node.right.data) {
            bst.isBST = true;
            bst.numberOfBST  = 1 + leftInfo.numberOfBST + rightInfo.numberOfBST;
    	} else {
    		bst.isBST = false;
    		bst.numberOfBST  = leftInfo.numberOfBST + rightInfo.numberOfBST;
    	}
    	
    	return bst;
    }
	
    public static void main(String arg[]) {
    	
    	 Node root = new Node(5);
         root.left = new Node(9);
         root.right = new Node(3);
         root.left.left = new Node(6);
         root.right.right = new Node(4);
         root.left.left.left = new Node(8);
         root.left.left.right = new Node(7);
  
         System.out.printf("Number of binary trees: %d", numberOfBST(root).numberOfBST);
    }
}
