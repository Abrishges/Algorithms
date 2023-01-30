package com.Algorithm.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigzagLevelOrder {

	class Node {

		int val;
		Node left;
		Node right;

		public Node(final int val) {
			this.val = val;
		}
	}
	
	 // we can also do zigzag level traversal using DFS
	public List<List<Integer>> zigzagLevelOrder(Node root) {

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null)
			return result;
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		int level = -1;
		LinkedList<Integer> levelList;

		while (!q.isEmpty()) {

			int n = q.size();
			level++;
			levelList = new LinkedList<Integer>();
			// To remove for loop we can also use null node
			for (int i = 0; i < n; i++) {
				Node node = q.poll();
				if (level % 2 != 0) {
					levelList.addFirst(node.val);
				} else {
					levelList.addLast(node.val);
				}
				if (node.left != null)
					q.add(node.left);
				if (node.right != null)
					q.add(node.right);
			}

			result.add(levelList);
		}

		return result;
	}
}
