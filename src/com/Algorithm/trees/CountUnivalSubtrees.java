package com.Algorithm.trees;

//https://leetcode.com/problems/count-univalue-subtrees/description/
public class CountUnivalSubtrees {

	class Node {

		int val;
		Node left;
		Node right;

		public Node(final int val) {
			this.val = val;
		}
	}

	public int countUnivalSubtrees(Node root) {
		int[] count = new int[1];
		helper(root, count);
		return count[0];
	}

	private boolean helper(Node node, int[] count) {
		if (node == null) {
			return true;
		}
		boolean left = helper(node.left, count);
		boolean right = helper(node.right, count);
		if (left && right) {
			if (node.left != null && node.val != node.left.val) {
				return false;
			}
			if (node.right != null && node.val != node.right.val) {
				return false;
			}
			count[0]++;
			return true;
		}
		return false;
	}
}
