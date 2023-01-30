package com.Algorithm.trees;

//Serialize and Deserialize a binary tree? 
// Given a binary tree serialize it to string and deserialize it from string to binary tree.
//https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/
public class SerializeBT {
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.right.left = new Node(4);
		root.right.right = new Node(5);
        System.out.println(serialize(root));
	}
		
	public static String serialize(Node root) {
		StringBuilder sb = new StringBuilder();
	
		 if (root == null) return null;
		serialize(root, sb);
		return sb.toString();
	}
	
	public static void serialize (Node node, StringBuilder sb) {
		
		 if (node == null) {
			 sb.append("#").append(" ");
			 return;
		 }
		  
		 sb.append(node.value).append(" ");
		 
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
}
