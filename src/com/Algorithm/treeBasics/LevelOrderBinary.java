package com.Algorithm.treeBasics;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LevelOrderBinary {

   public List<List<Integer>> levelOrder(Node root) {
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) return result ;
        Deque<Node> q = new ArrayDeque<Node>();
        q.add(root);
        
        while (!q.isEmpty()) {
            
            List<Integer>levelList = new ArrayList<Integer>();
            int n = q.size();       
            for (int i = 0; i < n ; i++) {
            	Node node = q.remove();
                levelList.add(node.data);           
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);  
            }
            result.add(levelList);      
        }         
        return result;
    }
    
   //using DFS approach we can. 
    public List<List<Integer>> levelOrderDfs(Node root) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	if(root == null) return result;
    	
    	levelOrderDfs(root, result, 0);
    	return result;
    }
    
    public void levelOrderDfs(Node node, List<List<Integer>> result, int level) {
    	if(node == null) return; 
    	if(result.size() <= level) {
    		result.add(new ArrayList<Integer>());
    	}
    	
    	result.get(level).add(node.data);
    	level++;
    	levelOrderDfs(node.left, result, level);
    	levelOrderDfs(node.right, result, level);
    }
}
