package com.Algorithm.trees;

import java.util.ArrayList;
import java.util.List;

//print diameter of the tree
public class DiameterOfTreePath {
	
	int diameter = 0;
	List<TreeNode> nodeList = new ArrayList<>();
	
	class TreeNode {
		 TreeNode left;
		 TreeNode right; 
		 int val;
	}
	
	class Result{
	    int diameter = 0;
	    List<TreeNode> list = new ArrayList<>();
	}

	public int diameterOfBinaryTree(TreeNode root) {
	    longestPath(root);
	    printList(nodeList);
	    return diameter;
	}

	private void printList(List<TreeNode> list){
	    for(TreeNode node : list){
	        System.out.print(node.val+"->");
	    }
	    System.out.println();
	}

	private Result longestPath(TreeNode node){
	    if(node == null) {
	        Result result = new Result();
	        result.diameter = 0;
	        return result;
	    }
	    
	    Result left = longestPath(node.left);
	    Result right = longestPath(node.right);
	    
	    if(diameter < left.diameter + right.diameter){
	        diameter = left.diameter + right.diameter;
	        nodeList = new ArrayList<>();
	        nodeList.addAll(left.list);
	        nodeList.add(node);
	        nodeList.addAll(right.list);
	    }
	    
	    if(left.diameter >= right.diameter){
	        left.list.add(node);
	        left.diameter = left.diameter + 1;
	        return left;
	    }else{
	        right.list.add(node);
	        right.diameter = right.diameter + 1;
	        return right;
	    }
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
