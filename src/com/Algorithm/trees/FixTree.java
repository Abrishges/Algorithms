package com.Algorithm.trees;

import java.util.LinkedList;
import java.util.Queue;

// Given a binary tree that complies to the following rule:
// The parent node value is always the the result of the AND operator of its children values.

// You modify one of the LEAF nodes value (e.g. if it was 1 it is now 0). Write a function that
// fixes the tree
// so it complies with the above rule.
// The parent node value is always children value's LOGICAL AND
// &
//



public class FixTree {
  public static void main(final String args[]) {

    final Node1 node = new Node1(false);
    // node.value = false;
    node.left = new Node1(true);
    node.right = new Node1(false);
    node.left.left = new Node1(true);
    node.left.right = new Node1(true);
    // node.right.left = new Node1(false);
    node.right.left = new Node1(true);
    node.right.right = new Node1(true);
    System.out.println(fixTree(node));
    // levelTraversal(node);

  }

  public static boolean fixTree(final Node1 root) {
    if (root.left == null || root.right == null) {
      System.out.println(root.value);
      return root.value;
    }
    final boolean value = fixTree(root.left) && fixTree(root.right);
    System.out.println(value);
    return value;
  }

  public static void levelTraversal(final Node1 root) {
    final Queue<Node1> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      final Node1 curr = queue.poll();
      System.out.println(curr.value);
      if (curr.left != null) {
        queue.add(curr.left);
      }
      if (curr.right != null) {
        queue.add(curr.right);
      }
    }

  }
}


class Node1 {
  boolean value;
  Node1 left;
  Node1 right;

  public Node1(final boolean value) {
    this.value = value;
  }
}
