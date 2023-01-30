package com.Algorithm.treeBasics;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

//we should do it using Morries theorem too
public class PostOrder {

	public List<Integer> postorderTraversal(Node root) {
		List<Integer> list = new ArrayList<Integer>();
		if (root == null)
			return list;
		dfs(root, list);
		return list;
	}

	public void dfs(Node node, List<Integer> list) {
		if (node == null)
			return;

		dfs(node.left, list);
		dfs(node.right, list);
		list.add(node.data);
	}

	public List<Integer> postorder(Node root) {

		LinkedList<Integer> result = new LinkedList<>();
		if (root == null)
			return result;
		Stack<Node> stack = new Stack<Node>();
		stack.push(root);

		while (!stack.isEmpty()) {
			Node cur = stack.pop();
			result.addFirst(cur.data);
			if (cur.left != null)
				stack.push(cur.left);
			if (cur.right != null)
				stack.push(cur.right);
		}
		return result;
	}

	public List<Integer> postorderIterative(Node root) {
		LinkedList<Integer> result = new LinkedList<>(); //we can use arraylist and we can do list.add(0,curr.val);
		Deque<Node> stack = new ArrayDeque<>();
		Node cur = root;
		while (!stack.isEmpty() || cur != null) {
			if (cur != null) {
				stack.push(cur);
				result.addFirst(cur.data); //Reverse the process of preorder
				cur = cur.right; // Reverse the process of preorder
			} else {
				Node node = stack.pop();
				cur = node.left; //Reverse the process of preorder
			}
		}
		return result;
	}

	//we can also solve this problem using array list
	public List<Integer> postorderIterative2(Node root) {
		List<Integer> result = new ArrayList<Integer>();
		Deque<Node> stack = new ArrayDeque<>();
		Node cur = root;

		while (!stack.isEmpty() || cur != null) {

			while (cur != null) {
				stack.push(cur);
				if (cur.left != null) {
					cur = cur.left;
				} else {
					cur = cur.right;
				}
			}

			Node node = stack.pop();
			result.add(node.data);
			if (!stack.isEmpty() && stack.peek().left == node) {
				cur = stack.peek().right;
			}

		}
		return result;
	}
}
