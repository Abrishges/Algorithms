package com.Algorithm.treeBasics;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//we should do it using Morries theorem too
public class Inorder {
	public List<Integer> inorderTraversal(Node root) {

		List<Integer> list = new ArrayList<Integer>();
		if (root != null) {
			inorder(root, list);
		}

		return list;
	}

	public void inorder(Node node, List<Integer> list) {

		if (node == null)
			return;
		inorder(node.left, list);
		list.add(node.data);
		inorder(node.right, list);
	}
	
    public List<Integer> inorderIterative(Node root) {
        
        List<Integer> list = new ArrayList<Integer>();
        if (root == null) return list;
        Stack<Node> stack = new Stack<Node>();
        Node cur = root;
        while(!stack.isEmpty() || cur != null) {
             
             while (cur != null) {
                 stack.push(cur);
                 cur = cur.left;
             }
             
            cur = stack.pop(); 
            list.add(cur.data);
            cur = cur.right;
        }
        
       return list; 
    }

	// Iterative approach 2
	public List<Integer> inorder(Node root) {

		List<Integer> list = new ArrayList<Integer>();
		Stack<Node> stack = new Stack<Node>();
		Node cur = root;
		while (!stack.isEmpty() || cur != null) {
			if (cur != null) {
				stack.push(cur);
				cur = cur.left;
			} else {
				cur = stack.pop();
				list.add(cur.data);  //Add after all left children
				cur = cur.right;
			}
		}

		return list;
	}
}
