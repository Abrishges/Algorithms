package com.Algorithm.trees;

import java.util.ArrayDeque;
import java.util.Deque;

//https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/
public class SerializeBinaryTree {

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.right.left = new Node(4);
		root.right.right = new Node(5);
        System.out.println(serializeBinaryTree(root));
	}
	
	public static String serializeBinaryTree(Node root) {
	
	 return null;
	}
}
