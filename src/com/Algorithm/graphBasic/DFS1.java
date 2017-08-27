package com.Algorithm.graphBasic;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Abereham Wodajie
 *         DFS using iteration
 *         Aug 27, 2017
 */
public class DFS1 {
  // final Graph graph = new Graph();

  // For disconnected graphs, node is for starting node
  public void DFS(final Graph graph) {
    final List<Node> nodes = graph.getAllNodes().values().stream().collect(Collectors.toList());
    for (int i = 0; i < nodes.size(); i++) {
      if (!nodes.get(i).visited) {
        this.dfsUtil(graph, nodes.get(i));
      }
    }
  }

  // connected graph
  public void dfsUtil(final Graph graph, final Node node) {
    final List<Node> adjList = graph.getAdjacencyList(node.data);
    node.visited = true;
    System.out.print(node.data + " ");
    final Iterator<Node> it = adjList.iterator();
    while (it.hasNext()) {
      final Node current = it.next();
      if (!current.visited) {
        this.dfsUtil(graph, current);

      }
    }
  }
}
