package com.Algorithm.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PathSumII {
	
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
	
	 public List<List<Integer>> pathSum(Node root, int targetSum) {
	        
	        List<List<Integer>> result = new ArrayList<List<Integer>>();
	        if (root == null) return result;
	        
	        Stack<Integer> pathSum = new Stack<Integer>();
	        
	        dfs(root, pathSum, targetSum, result);
	        
	        return result;
	    }
	    
	    public void dfs(Node node, Stack<Integer> pathSum, int target, List<List<Integer>> result) {
	        
	        target = target - node.val;
	        pathSum.push(node.val);
	        
	        if (node.left == null && node.right == null && target == 0) {
	            List<Integer>path = new ArrayList<Integer>();
	            path.addAll(pathSum);
	            result.add(path);
	        }
	        
	        if (node.left != null) dfs(node.left, pathSum, target, result);
	        if (node.right != null) dfs(node.right, pathSum , target, result);
	        pathSum.pop();
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
