package com.Algorithm.trees;

public class DiameterOfTree2 {
	
	class Node {
		Node left;
		Node right; 
		Node val;
	}
	
    int result = 0;
    public int diameterOfBinaryTree(Node root) {
        
        if (root == null) return result;
        
        dfs(root);
    
       return result;
    }

    //This is post order
   public int dfs(Node node) {
       
      if (node == null) return 0;
       
      int l =  dfs(node.left);
      int r =  dfs(node.right);
       
      result = Math.max(result, l + r);
          
     return Math.max(l, r) + 1;
   }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
