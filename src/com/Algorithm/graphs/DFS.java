/**
 *
 */
package com.Algorithm.graphs;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Abereham Wodajie
 *
 *         May 22, 2017
 */
public class DFS {

  public static void main(final String arg[]) {
    final Map<Integer, ArrayList<Integer>> map = new ConcurrentHashMap<>();
    final Scanner scan = new Scanner(System.in);
    System.out.println("Enter number of vertices: ");
    final int n = scan.nextInt();
    // stored vertices, visited
    // final boolean[] visted = new boolean[n + 1];

    for (int i = 1; i <= n; i++) {
      // visted[i] = false;
      map.put(i, new ArrayList<Integer>());
    }
    map.forEach((k, v) -> System.out.println("key: " + k + " values: " + v));
    System.out.println("Enter number of edges: ");
    final int m = scan.nextInt();
    System.out.println("Enter edges: ");
    for (int j = 1; j <= m; j++) {
      final int x = scan.nextInt();
      final int y = scan.nextInt();
      map.get(x).add(y);
      map.get(y).add(x);

    }

    map.forEach((k, v) -> System.out.println("key: " + k + " values: " + v));
    final int start = scan.nextInt();
    DFStraversal(map, start);

    scan.close();
  }

  private static void DFStraversal(final Map<Integer, ArrayList<Integer>> adjMap, final int start) {
    final boolean[] visited = new boolean[adjMap.size() + 1];
    for (int i = 1; i <= adjMap.size(); i++) {
      visited[i] = false;
    }
    final Stack<Integer> stack = new Stack<>();
    stack.push(start);
    System.out.println(start);
    while (!stack.isEmpty()) {
      final int head = stack.peek();
      visited[head] = true;
      // check for non visited node
      Integer child = null;
      for (final int node : adjMap.get(head)) {

        if (!visited[node] && child != null) {
          child = node;
          stack.push(child);
          visited[child] = true;
          System.out.println(child);
          break;
        }
      }
      if (child == null) {
        stack.pop();
      }

    }

  }

}
