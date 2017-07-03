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
 * @author aberehamwodajie
 *
 *         Jun 11, 2017
 */
public class ConnectedComponentsDFS {
  public static void main(final String args[]) {

    final Map<Integer, ArrayList<Integer>> map = new ConcurrentHashMap<>();
    final Scanner in = new Scanner(System.in);
    System.out.println("Enter number of nodes: ");
    final int n = in.nextInt();
    System.out.println("Enter number of edges: ");
    final int edges = in.nextInt();

    for (int i = 1; i <= n; i++) {
      map.put(i, new ArrayList<Integer>());
    }
    System.out.println("Enter edges: ");
    for (int i = 1; i <= edges; i++) {
      final int u = in.nextInt();
      final int v = in.nextInt();
      map.get(u).add(v);
      map.get(v).add(u);
    }

    final boolean[] visited = new boolean[map.size() + 1];
    int components = 0;
    for (int i = 1; i <= n; i++) {
      if (!visited[i]) {
        visited[i] = true;
        components++;
        dfs(map, i, visited);
      }
    }
    System.out.println("Number of components: " + components);
    in.close();
  }

  /**
   * @param map
   * @param visited
   */
  private static void dfs(final Map<Integer, ArrayList<Integer>> map, final int i, final boolean[] visited) {
    // TODO Auto-generated method stub

    final Stack<Integer> stack = new Stack<>();
    stack.push(i);
    while (!stack.isEmpty()) {
      final Integer head = stack.peek();
      Integer child = null;
      for (final Integer adj : map.get(head)) {

        if (!visited[adj] && adj != null) {
          child = adj;
          visited[adj] = true;
          stack.push(adj);
          break;
        }
      }

      if (child == null) {
        stack.pop();
      }

    }
  }
}
