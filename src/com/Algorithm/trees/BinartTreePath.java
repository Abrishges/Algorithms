package com.Algorithm.trees;

import java.util.ArrayList;
import java.util.List;

public class BinartTreePath {
  public static void main(final String args[]) {
    final Node2 root = new Node2("A");
    root.left = new Node2("B");
    root.right = new Node2("C");
    root.left.left = new Node2("D");
    root.left.right = new Node2("E");

    root.right.left = new Node2("F");
    root.right.right = new Node2("G");

    System.out.println(printPaths(root));

    final List<String> answer = new ArrayList<>();
    printPath2(root, answer);

  }

  public static List<String> printPaths(final Node2 root) {
    final List<String> answer = new ArrayList<>();
    printPathHelper(root, "", answer);
    return answer;
  }

  public static void printPathHelper(final Node2 root, final String path, final List<String> answer) {
    if (root.left == null && root.right == null) {
      answer.add(path + root.value + ",");
    }

    if (root.left != null) {
      printPathHelper(root.left, path + root.value + "->", answer);
    }

    if (root.right != null) {
      printPathHelper(root.right, path + root.value + "->", answer);
    }
  }

  public static void printPath2(final Node2 root, final List<String> answer) {
    if (root.left == null && root.right == null) {
      answer.add(root.value);

      System.out.println(answer);
    }

    if (root.left != null) {
      answer.add(root.value);
      printPath2(root.left, answer);
    }

    if (root.right != null) {
      answer.add(root.value);
      printPath2(root.right, answer);
    }

  }

}


class Node2 {
  String value;
  Node2 left;
  Node2 right;

  public Node2(final String value) {
    this.value = value;
  }
}
