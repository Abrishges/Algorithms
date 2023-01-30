package com.Algorithm.trees;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

//https://leetcode.com/problems/merge-bsts-to-create-single-bst/description/
//Merge BSTs to Create Single BST
public class MergeBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	 public Node canMerge(List<Node> trees) {
		 
		 //First find out the root node for resulting tree 
		 //Also create map from leaf to tree
		 Set<Integer> leaves = new HashSet<Integer>();
		 Map<Integer, Node> mp = new HashMap<Integer, Node>();
		 
		 for (Node node : trees) {
			 mp.put(node.value, node);
			 
			 if(node.left != null) {
				 leaves.add(node.left.value);
			 }
			 
			 if(node.right != null) {
				 leaves.add(node.right.value);
			 }
		 }
		 
		 Node result = null;
		 for(Node node : trees) {
			 if(!leaves.contains(node.value)) {
				 result = node;
				 break;
			 }
		 }
		 
		 if(result == null) return null;
		 
		 //Build BST now
		 if(!buildBST(result, Integer.MIN_VALUE, Integer.MAX_VALUE, mp) || mp.size() != 1) return null;

		 return result;
	  }
	 
	 public Boolean buildBST(Node node, int lower, int upper, Map<Integer, Node> mp) {
		  if(node == null) return null;
		  
		  if(node.value < lower || node.value > upper) return false;
		  
		   if(node.left == null || node.right == null) {			  
			   if(mp.containsKey(node.value) && node != mp.get(node.value)) {
				  node.right = mp.get(node.value).right;
				  node.left = mp.get(node.value).left;
				  mp.remove(node.value);
			   }   
		   }
		  
		   
		   return buildBST(node.left, lower, node.value, mp) && buildBST(node.right, node.value, upper, mp);
	 }

}
