package com.Algorithm.treeBasics;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/n-ary-tree-level-order-traversal/solutions/422916/n-ary-tree-level-order-traversal/
// Level order traversal
public class LevelOrder {

	private List<List<Integer>> result = new ArrayList<>();

	public List<List<Integer>> levelOrder(NaryNode root) {
		if (root != null)
			traverseNode(root, 0);
		return result;
	}

	private void traverseNode(NaryNode node, int level) {
		if (result.size() <= level) {
			result.add(new ArrayList<>());
		}
		result.get(level).add(node.val);
		for (NaryNode child : node.children) {
			traverseNode(child, level + 1);
		}
	}

	public List<List<Integer>> levelOrder2(NaryNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null)
			return result;
		Queue<NaryNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			List<Integer> level = new ArrayList<>();
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				NaryNode node = queue.poll();
				level.add(node.val);
				queue.addAll(node.children);
			}
			result.add(level);
		}
		return result;
	}

}
