/**
 * 
 */
package com.Algorithm.trees;

/**
 * @author abereham wodajie
 *
 *         Nov 26, 2016
 */
public class BST {

	private Node root;

	  //inserting node
	public void insertNode(int value) {

		Node node = new Node(value);

		if (root == null) {
			root = node;
			return;
		}

		insertRec(root, node);
	}
 
	public void insertRec(Node root, Node newNode) {

		if (newNode.value > root.value) {
			if (root.right == null) {
				root.right = newNode;

				return;
			}
			insertRec(root.right, newNode);
		}

		if (newNode.value < root.value) {
			if (root.left == null) {
				root.left = newNode;
				return;
			}
			insertRec(root.left, newNode);
		}
	}
   //finding minimum
	public int findMinimum() {

		if (root == null) {
			return 0;
		}

		Node currentNode = root;

		while (currentNode.left != null) {
			currentNode = currentNode.left;
		}

		return currentNode.value;
	}
	 //finding maximum
	public int findMaximum(){
		
		if (root == null){
			return 0;
		}
		
		Node currentNode = root.right;
		
	  while(currentNode.right != null){			 
			currentNode.right = currentNode;
	 }
	  
	  return currentNode.value;
	}
	//inOrder traversal
	public void printInorder(){
		printInorderRec(root);
		System.out.print("");
	}
	
	public void printInorderRec(Node currentRoot){
		
		if (currentRoot == null ){
			return;
		}
		
		printInorderRec(currentRoot.left);
		System.out.println(currentRoot.value + ",");
		printInorderRec(currentRoot.right);
	}
	
	//preOrder traversal
	public void printPreorder(){
		printPreorderRec(root);
		System.out.println("");
	}
	
	public void printPreorderRec(Node currentNode){
		if (currentNode == null ){
			return;
		}
		System.out.println(currentNode.value);
		printPreorderRec(currentNode.left);
		printPreorderRec(currentNode.right);
	}
	//postOrder traversal
	public void printPostorder(){
		printPostorderRec(root);
		System.out.println("");
	}
	
	public void printPostorderRec(Node currentNode){
		if (currentNode == null ){
			return;
		}
		
		printPostorderRec(currentNode.left);
		printPostorderRec(currentNode.right);
		System.out.println(currentNode.value + ",");
		
	}
	
	//finding max depth 
	 /* Compute the "maxDepth" of a tree -- the number of 
    nodes along the longest path from the root node 
    down to the farthest leaf node.*/	
	public int maxDepth(){
		return maxDepth(root);
	}
	public int maxDepth(Node node){
		if (node == null)
            return 0;
        else
        {
            /* compute the depth of each subtree */
            int lDepth = maxDepth(node.left);
            int rDepth = maxDepth(node.right);
  
            /* use the larger one */
            if (lDepth > rDepth)
                return (lDepth + 1);
             else
                return (rDepth + 1);
        }
		
	}
	public  boolean isBalanced(Node node){
		 int lh; /* for height of left subtree */
		  
	        int rh; /* for height of right subtree */
	  
	        /* If tree is empty then return true */
	        if (node == null)
	            return true;
	  
	        /* Get the height of left and right sub trees */
	        lh = height(node.left);
	        rh = height(node.right);
	  
	        if (Math.abs(lh - rh) <= 1
	                && isBalanced(node.left)
	                && isBalanced(node.right)) 
	            return true;
	  
	        /* If we reach here then tree is not height-balanced */
	        return false;
	    }
	  
	    /* UTILITY FUNCTIONS TO TEST isBalanced() FUNCTION */
	    /*  The function Compute the "height" of a tree. Height is the
	        number of nodes along the longest path from the root node
	        down to the farthest leaf node.*/
	    int height(Node node) 
	    {
	        /* base case tree is empty */
	        if (node == null)
	            return 0;
	  
	        /* If tree is not empty then height = 1 + max of left
	         height and right heights */
	        return 1 + Math.max(height(node.left), height(node.right));
	    }
	
}
