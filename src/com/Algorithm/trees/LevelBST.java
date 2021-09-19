package com.Algorithm.trees;

import com.Algorithm.trees.NoBST.Node;

//Get Level of a node in a Binary Tree
public class LevelBST {
	
	static class Node {
		int data;
		Node left, right;
		
		public Node(int data) {
			this.data = data;
			this.left = this.right = null;
		}
		
		public Node() {
		}
	}
	
	public static int getLevelUtil(Node node, int targetNode, int level) {
		  if (node == null) {
			  return 0;
		  }
		 
		  if (node.data == targetNode) {
			  return level;
		  }

		  
		  int downLevel = getLevelUtil(node.left, targetNode, level++);
		  
		  if(downLevel != 0) {
			  return downLevel;
		  }
  
		  downLevel = getLevelUtil(node.right, targetNode, level++);
		  
		  return downLevel;
	}
	
	   /* Returns level of given data value */
    static int getLevel(Node node, int data)  
    { 
        return getLevelUtil(node, data, 1); 
    } 
    
	public static void main(String arg[]) {
	   
	        /* Constructing tree */
		    Node root = new Node(5);
	        root.left = new Node(2); 
	        root.right = new Node(5); 
	        root.left.left = new Node(1); 
	        root.left.right = new Node(4); 
	        for (int x = 1; x <= 5; x++)  
	        { 
	            int level = getLevel(root, x); 
	            if (level != 0) 
	                System.out.println("Level of " + x + " is "
	                        + getLevel(root, x)); 
	            else
	                System.out.println(x + " is not present in tree"); 
	        }
	}

}
