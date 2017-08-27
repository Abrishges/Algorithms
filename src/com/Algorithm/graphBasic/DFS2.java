package com.Algorithm.graphBasic;

import java.util.Stack;

/**
 * @author Abereham Wodajie
 *         DFS using stack
 *         May 22, 2017
 */
public class DFS2 {

  public void DFS(final Graph graph, final Node node) {
    final Stack<Node> stack = new Stack<>();
    node.visited = true;
    stack.push(node);
    System.out.print(node.data + " ");
    while (!stack.isEmpty()) {
      final Node current = stack.peek();
      final Node unvistedNode = graph.getUnvisitedAdjNode(current);
      if (unvistedNode != null) {
        unvistedNode.visited = true;
        System.out.print(unvistedNode.data + " ");
        stack.push(unvistedNode);
      } else {
        stack.pop();
      }
    }
  }
}
