package com.Algorithm.treeBasics;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {

	public static void main(final String args[]) {
		final Node root = new Node(5);
		root.left = new Node(7);
		root.right = new Node(8);
		root.left.left = new Node(9);
		root.left.right = new Node(10);
		root.right.left = new Node(11);
		root.right.right = new Node(12);

		System.out.println(countNodes(root));
		System.out.println(countNodes2(root));
		System.out.println(countNodes3(root));
		System.out.println(countNodes4(root));
	}

	// recursive method
	private static int countNodes(final Node root) {
		int count = 1;
		if (root.left != null) {
			count += countNodes(root.left);
		}
		if (root.right != null) {
			count += countNodes(root.right);
		}
		return count;
	}

	// we can modify this methods to count non-lefts , just return zero if node is
	// null
	// To count lefts , just return replace the return by countNodes2(root.left) +
	// countNodes2(root.right);
	private static int countNodes2(final Node root) {
		if (root.left == null && root.right == null) {
			return 1;
		}
		return 1 + countNodes2(root.left) + countNodes2(root.right);
	}

	// we can also use iterative program to count the nodes(leaf nodes can also be
	// easily counted)
	// we can use either stack or queue to count nodes
	private static int countNodes3(final Node root) {

		final Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		int count = 0;
		while (!queue.isEmpty()) {

			final Node curr = queue.poll();
			if (curr != null) {
				count++;
				queue.add(curr.left);
				queue.add(curr.right);
			}
		}
		return count;
	}

	// using stacks
	private static int countNodes4(final Node root) {
		final Stack<Node> stack = new Stack<>();
		if (root != null) {
			stack.push(root);
		}
		int count = 0;
		while (!stack.isEmpty()) {
			final Node top = stack.pop();
			count++;

			if (top.left != null) {
				stack.push(top.left);
			}
			if (top.right != null) {
				stack.push(top.right);
			}
		}
		return count;
	}
}
