package com.Algorithm.treeBasics;

import java.util.ArrayDeque;
import java.util.Deque;

//https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
//Build Bst from preorder
public class BstFromPreorder {

	int idx = 0; // Make sure this is global value

	public Node buildBst(int[] preorder) {
		if (preorder.length == 0)
			return null;
		return buildBst(preorder, preorder.length, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public Node buildBst(int[] preorder, int length, int lower, int upper) {

		if (idx == length)
			return null;
		int val = preorder[idx];
		if (val < lower || val > upper)
			return null;
		Node root = new Node(val);
		idx++;
		root.left = buildBst(preorder, length, lower, val);
		root.right = buildBst(preorder, length, val, upper);

		return root;
	}

	/*
	 * I don't understand it's 2018 now, and Java 11 is already on its way. Why
	 * people still using Stack class? As an interviewer at one of FANG, I've seen
	 * lots of candidates that keep using Stacks, and this is a very negative point
	 * for the interview. When they were asked why use Stack, which is a deprecated
	 * thing, they said online solution use it.
	 */
	public Node bstFromPreorder2(int[] preorder) {
		int n = preorder.length;
		if (n == 0)
			return null;

		Node root = new Node(preorder[0]);
		Deque<Node> deque = new ArrayDeque<Node>();
		deque.push(root);

		for (int i = 1; i < n; i++) {
			// take the last element of the deque as a parent
			// and create a child from the next preorder element
			Node node = deque.peek();
			Node child = new Node(preorder[i]);
			// adjust the parent
			while (!deque.isEmpty() && deque.peek().data < child.data)
				node = deque.pop();

			// follow BST logic to create a parent-child link
			if (node.data < child.data)
				node.right = child;
			else
				node.left = child;
			// add the child into deque
			deque.push(child);
		}
		return root;
	}

	// another slow method
	public Node bstFromPreorder(int[] preorder) {

		Node root = new Node(preorder[0]);
		for (int i = 1; i < preorder.length; i++) {
			makeTree(root, preorder[i]);
		}

		return root;
	}

	public void makeTree(Node root, int val) {

		if (val < root.data) {
			if (root.left == null) {
				root.left = new Node(val);
			} else {
				makeTree(root.left, val);
			}
		} else {
			if (root.right == null) {
				root.right = new Node(val);
			} else {
				makeTree(root.right, val);
			}
		}
	}
}