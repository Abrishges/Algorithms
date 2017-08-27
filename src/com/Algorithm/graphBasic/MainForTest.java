package com.Algorithm.graphBasic;

import java.util.ArrayList;
import java.util.Map;


public class MainForTest {

  public static void main(final String[] args) {
    final Graph graph = new Graph();
    // Neighbors of A
    graph.insertAdj("A", "B");
    graph.insertAdj("A", "D");
    graph.insertAdj("A", "F");
    // Neighbors of B
    graph.insertAdj("B", "C");
    graph.insertAdj("B", "A");
    // Neighbors of C
    graph.insertAdj("C", "B");
    graph.insertAdj("C", "D");
    // Neighbors of D
    graph.insertAdj("D", "C");
    graph.insertAdj("D", "A");
    graph.insertAdj("D", "E");
    // Neighbors of E
    graph.insertAdj("E", "D");
    graph.insertAdj("E", "F");
    // Neighbors of F
    graph.insertAdj("F", "A");
    graph.insertAdj("F", "E");

    final Map<String, ArrayList<Node>> adjMap = graph.getMap();
    adjMap.forEach((k, v) -> System.out.println(k + ": " + v));


    // DFS1 test
    System.out.println();
    System.out.println("DFS1 test:");
    final DFS1 dfs1 = new DFS1();
    dfs1.DFS(graph);

    // clear Nodes
    graph.clearNodes();
    // DFS2 test
    System.out.println();
    System.out.println("DFS2 test:");

    final DFS2 dfs2 = new DFS2();
    final Node start = graph.getAllNodes().get("A");
    dfs2.DFS(graph, start);
  }
}
