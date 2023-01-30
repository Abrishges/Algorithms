package com.Algorithm.treeBasics;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

//we should do it using Morries theorem too
public class Preorder {

	public List<Integer> preorderTraversal(Node root) {

		List<Integer> result = new ArrayList<Integer>();
		if (root == null)
			return result;

		preOrder(root, result);

		return result;
	}

	public void preOrder(Node node, List<Integer> result) {
		
		 if(node == null) return;

		result.add(node.data);
		preOrder(node.left, result);
		preOrder(node.right, result);
	}
	
	 public List<Integer> preorderIterative(Node root) {
	        
	        List<Integer>result = new ArrayList<Integer>();
	        if (root == null) return result;
	        Stack<Node> stack = new Stack<Node>();
	        stack.push(root);

	        while(!stack.isEmpty()) {
	           Node cur = stack.pop();
	           result.add(cur.data);  
	           if(cur.right != null) stack.push(cur.right);
	           if(cur.left != null) stack.push(cur.left);

	        }
	     return result;
	    }
	 
	 //another Iterative method
	 public List<Integer> preorderIterative2(Node root) {
		    List<Integer> result = new ArrayList<>();
		    Deque<Node> stack = new ArrayDeque<>();
		    Node cur = root;
		    while(!stack.isEmpty() || cur != null) {
		        if(cur != null) {
		            stack.push(cur);
		            result.add(cur.data);  //Add before going to children
		            cur = cur.left;
		        } else {
		            Node node = stack.pop();
		            cur = node.right;   
		        }
		    }
		    return result;
		}
}
