package com.Algorithm.Basic;

import java.util.HashMap;

// find the distance between two nodes node1 and node2

import java.util.Map;

public class Solution {
  // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
  final static Map<Integer, Node> tree = new HashMap<>();

  public static void main(final String[] args) {
    // constructing tree

    final int[] values = new int[] {5, 6, 3, 1, 2, 4};

    final int n = 6;
    final int node1 = 2;
    final int node2 = 4;
    final BST bst = new BST();
    for (int i = 0; i < n; i++) {
      bst.insert(values[i]);
    }

    // finding list common anccestore
    final Node lcaNode = bst.lca(tree.get(0), node1, node2);
    // count the nodes starting from list common anccestore then -1
    final int count = bst.nodeCount(lcaNode);
    System.out.println(count);
    System.out.println((count - 1));
  }
}


// METHOD SIGNATURE ENDS

class Node {
  public int value;
  public Node left;
  public Node right;

  public Node(final int value) {
    this.value = value;
  }
}


class BST {
  public Node root;

  public void insert(final int value) {
    final Node node = new Node(value);
    if (this.root == null) {
      this.root = node;
      Solution.tree.put(value, node);
      return;
    }
    this.insertRec(this.root, node);
  }

  public void insertRec(final Node root, final Node node) {
    if (root.value > node.value) {
      if (root.left == null) {
        root.left = node;
        return;
      } else {
        this.insertRec(root.left, node);
      }
    } else {
      if (root.right == null) {
        root.right = node;
        return;
      } else {
        this.insertRec(root.right, node);
      }
    }

  }

  public Node lca(final Node root, final int n1, final int n2) {
    if (root == null) {
      return null;
    }

    if (root.value == n1 || root.value == n2) {
      return null;
    }
    final Node left = this.lca(root.left, n1, n2);
    final Node right = this.lca(root.right, n1, n2);

    if (left != null && right != null) {
      return root;
    }
    if (left == null && right == null) {
      return null;
    }

    return left != null ? left : right;
  }

  public int nodeCount(final Node lcaNode) {
    if (lcaNode == null) {
      return 0;
    }

    if (lcaNode.left == null && lcaNode.right == null) {
      return 1;
    } else {
      return this.nodeCount(lcaNode.left) + this.nodeCount(lcaNode.right);
    }

  }
}


