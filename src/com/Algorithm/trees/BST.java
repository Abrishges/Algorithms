/**
 *
 */
package com.Algorithm.trees;

/**
 * @author abereham wodajie
 *
 *         Nov 26, 2016
 */
public class BST {

  private Node root;

  // inserting node
  public void insertNode(final int value) {

    final Node node = new Node(value);

    if (this.root == null) {
      this.root = node;
      return;
    }

    this.insertRec(this.root, node);
  }

  public void insertRec(final Node root, final Node newNode) {

    if (newNode.value > root.value) {
      if (root.right == null) {
        root.right = newNode;

        return;
      }
      this.insertRec(root.right, newNode);
    }

    if (newNode.value < root.value) {
      if (root.left == null) {
        root.left = newNode;
        return;
      }
      this.insertRec(root.left, newNode);
    }
  }

  // finding minimum
  public int findMinimum() {

    if (this.root == null) {
      return 0;
    }

    Node currentNode = this.root;

    while (currentNode.left != null) {
      currentNode = currentNode.left;
    }

    return currentNode.value;
  }

  // finding maximum
  public int findMaximum() {

    if (this.root == null) {
      return 0;
    }

    final Node currentNode = this.root.right;

    while (currentNode.right != null) {
      currentNode.right = currentNode;
    }

    return currentNode.value;
  }

  // inOrder traversal
  public void printInorder() {
    this.printInorderRec(this.root);
    System.out.print("");
  }

  public void printInorderRec(final Node currentRoot) {

    if (currentRoot == null) {
      return;
    }

    this.printInorderRec(currentRoot.left);
    System.out.println(currentRoot.value + ",");
    this.printInorderRec(currentRoot.right);
  }

  // preOrder traversal
  public void printPreorder() {
    this.printPreorderRec(this.root);
    System.out.println("");
  }

  public void printPreorderRec(final Node currentNode) {
    if (currentNode == null) {
      return;
    }
    System.out.println(currentNode.value);
    this.printPreorderRec(currentNode.left);
    this.printPreorderRec(currentNode.right);
  }

  // postOrder traversal
  public void printPostorder() {
    this.printPostorderRec(this.root);
    System.out.println("");
  }

  public void printPostorderRec(final Node currentNode) {
    if (currentNode == null) {
      return;
    }

    this.printPostorderRec(currentNode.left);
    this.printPostorderRec(currentNode.right);
    System.out.println(currentNode.value + ",");

  }

  // finding max depth
  /*
   * Compute the "maxDepth" of a tree -- the number of
   * nodes along the longest path from the root node
   * down to the farthest leaf node.
   */
  public int maxDepth() {
    return this.maxDepth(this.root);
  }

  public int maxDepth(final Node node) {
    if (node == null) {
      return 0;
    } else {
      /* compute the depth of each subtree */
      final int lDepth = this.maxDepth(node.left);
      final int rDepth = this.maxDepth(node.right);

      /* use the larger one */
      if (lDepth > rDepth) {
        return (lDepth + 1);
      } else {
        return (rDepth + 1);
      }
    }

  }

  public boolean isBalanced(final Node node) {
    int lh; /* for height of left subtree */

    int rh; /* for height of right subtree */

    /* If tree is empty then return true */
    if (node == null) {
      return true;
    }

    /* Get the height of left and right sub trees */
    lh = this.height(node.left);
    rh = this.height(node.right);

    if (Math.abs(lh - rh) <= 1 && this.isBalanced(node.left) && this.isBalanced(node.right)) {
      return true;
    }

    /* If we reach here then tree is not height-balanced */
    return false;
  }

  /* UTILITY FUNCTIONS TO TEST isBalanced() FUNCTION */
  /*
   * The function Compute the "height" of a tree. Height is the
   * number of nodes along the longest path from the root node
   * down to the farthest leaf node.
   */
  int height(final Node node) {
    /* base case tree is empty */
    if (node == null) {
      return 0;
    }

    /*
     * If tree is not empty then height = 1 + max of left
     * height and right heights
     */
    return 1 + Math.max(this.height(node.left), this.height(node.right));
  }
}
