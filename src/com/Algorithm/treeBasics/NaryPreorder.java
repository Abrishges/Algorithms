package com.Algorithm.treeBasics;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class NaryPreorder {

	public static void main(String[] args) {

	}

	//This can be done using recursion
	public static List<Integer> preorder(NaryNode root) {
		Stack<NaryNode> stack = new Stack<NaryNode>();
		List<Integer> result = new ArrayList<Integer>();
		if (root == null)
			return result;
		stack.push(root);

		while (!stack.isEmpty()) {
			NaryNode cur = stack.pop();
			result.add(cur.val);
			List<NaryNode> childs = cur.children;
			for (int i = childs.size() - 1; i >= 0; i--) {
				stack.push(childs.get(i));
			}

		}
		return result;
	}

	final List<Integer> l = new ArrayList<>();

	// use recursive
	public List<Integer> preorderRec(NaryNode root) {
		if (root == null)
			return l;
		l.add(root.val);
		for (NaryNode c : root.children)
			preorderRec(c);
		return l;
	}

	
	List<Integer> result2 = new LinkedList<Integer>();
	//post order,  this can also be done using stack
	public List<Integer> postorder(NaryNode root) {
		if (root == null)
			return result2;
		for (NaryNode child : root.children) {
			postorder(child);
		}
		result2.add(root.val);

		return result2;
	}
}
