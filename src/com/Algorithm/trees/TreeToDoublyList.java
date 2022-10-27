package com.Algorithm.trees;

//https://leetcode.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/
//This can be done with recursion also
public class TreeToDoublyList {

	class Node {
		public int val;
		public Node left;
		public Node right;

		public Node() {
		}

		public Node(int val) {
			this.val = val;
		}

		public Node(int val, Node left, Node right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public static void main(String[] args) {

	}

	private Node first = null;
	private Node last = null;

	public Node treeToDoublyList(Node root) {

		helper(root);

		last.right = first;
		first.left = last;

		return first;
	}

	public void helper(Node node) {

		if (node.left != null)
			helper(node.left);

		if (first == null) {
			first = node;
		} else {
			last.right = node;
			node.left = last;
		}

		last = node;

		if (node.right != null)
			helper(node.right);
	}

}