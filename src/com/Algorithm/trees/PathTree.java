package com.Algorithm.trees;

import java.util.ArrayList;
import java.util.List;

//Print path from root to a given node in a binary tree
/*
 * Given a binary tree with distinct nodes(no two nodes have the same data values). The problem is to print the path from 
 * root to a given node x. If node x is not present then print “No Path”.
 *   Input :     1
               /   \
              2     3
             / \   /  \
            4   5  6   7

     x = 5

        Output : 1->2->5
 * 
 */

//another good exmaple 
// https://www.geeksforgeeks.org/print-path-from-root-to-all-nodes-in-a-complete-binary-tree/?ref=rp
public class PathTree {
	
	class Node {
		Node left;
		Node right; 
		int data; 
		
		public Node(int data) {
			this.data = data;
			left = right = null;
		}
	}
	
	public void printPath(Node root, int target) {
		List<Node> list = new ArrayList<Node>();
		
		if(this.printPath(root, list, target)) {
			  for (int i = 0 ; i < list.size() - 1; i++) {
				  System.out.printf(list.get(i).data + "->");
			  }
			  
			  System.out.println(list.get(list.size() - 1).data);
		} else {
			System.out.println("No Path");
		}
	     
	}
	
	public boolean printPath(Node node, List<Node> list , int target) {
		
		if (node == null) return false;
		
		list.add(node);
		
		if (node.data == target) return true;
		
		if (printPath(node.left, list, target) ||
		    printPath(node.right, list, target)) {
			 return true;	
		}

		list.remove(list.size() - 1);
		

		return false;
	}

	public static void main(String[] args) {
		
		    PathTree path = new PathTree(); 
		    Node root = path.new Node(1);
	        root.left = path.new Node(2);
	        root.right = path.new Node(3);
	        root.left.left = path.new Node(4);
	        root.left.right = path.new Node(5);
	        root.right.left = path.new Node(6);
	        root.right.right = path.new Node(7);
	        int target = 5;
	        
	        path.printPath(root, target);
	}
}
