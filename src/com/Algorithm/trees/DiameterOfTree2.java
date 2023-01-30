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
        
        bottomUpDFS(root);
    
       return result;
    }

    //This is post order
    //information follows from leaf to root
   public int bottomUpDFS(Node node) {
       
      if (node == null) return 0;
       
      //result of left and right
      int left =  bottomUpDFS(node.left);
      int right =  bottomUpDFS(node.right);
      // then Process information sent back by child nodes (Post-Order)
      // and then return to the parent
      result = Math.max(result, left + right);
          
     return Math.max(left, right) + 1;
   }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
