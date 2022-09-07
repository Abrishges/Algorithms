package com.Algorithm.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such 
//that adding up all the values along the path equals targetSum.

public class PathSum {
	
 public class Node {
	 
	 int val;
	 Node left;
	 Node right;
	 
	 Node() {}

	 Node (int val) {
		 this.val = val;
	 }
	 
	 Node (int val, Node left, Node right) {
		 this.val = val;
		 this.left = left;
		 this.right = right;
	 }
 }

 class Solution {
	    
	    boolean result = false;
	    
	    public boolean hasPathSum(Node root, int targetSum) {
	        
	        if (root == null) return result;
	        
	        dfs(root, targetSum);
	        
	        return result;
	    }
	    
	    public void dfs(Node node , int target) {
	            
	        target = target - node.val;
	        
	        if (node.left == null & node.right == null && target == 0) {
	            result = true;
	            return;
	        }
	        
	        if (node.left != null) dfs(node.left, target);
	        if (node.right != null) dfs(node.right, target);
	        
	    }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(2);
		
		Stack<Integer> stack = new Stack<Integer> ();
		stack.push(5);
		
		list.addAll(stack);
		
		System.out.println(list);
		System.out.println(stack);
		stack.add(6);
		System.out.print(stack);
		
	}
}
