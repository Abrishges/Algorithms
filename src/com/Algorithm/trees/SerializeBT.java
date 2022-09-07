package com.Algorithm.trees;

//Serialize and Deserialize a binary tree? 
// Given a binary tree serialize it to string and deserialize it from string to binary tree.
public class SerializeBT {
	
	class Node {
		Node left; 
		Node right; 
		int data;
		
		public Node(int data) {
			this.data = data;
			this.left = this.right = null;
		}
	}
	
	public String serialize(Node root) {
		StringBuilder sb = new StringBuilder();
	
		 if (root == null) return null;
		serialize(root, sb);
		return sb.toString();
	}
	
	public void serialize (Node node, StringBuilder sb) {
		
		 if (node == null) {
			 sb.append("#").append(" ");
			 return;
		 }
		  
		 sb.append(node.data).append(" ");
		 
		 serialize(node.left, sb);
		 serialize(node.right, sb);
	}
	
	private int index;
	public Node Deserialize(String str) {
	   
		 if (str.isBlank()) return null; 

		 index = 0;
		 String [] data = str.split(" ");
		 
		return Deserialize(data);
	}
	
	public Node Deserialize(String [] data) {
		  
		String value = data[index];
		
		if (value.equals("#")) return null;
		
		Node root = new Node(Integer.parseInt(value));
	    index++; 
	    
	    root.left = Deserialize(data);
	    index++;
	    root.right = Deserialize(data);
		
	    return root;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
