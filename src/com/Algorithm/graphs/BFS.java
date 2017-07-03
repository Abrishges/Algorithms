/**
 *
 */
package com.Algorithm.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author aberehamwodajie
 *
 *         Jun 11, 2017
 */
public class BFS {

  public static void main(final String args[]) {

    final Map<Integer, ArrayList<Integer>> map = new ConcurrentHashMap<>();

    System.out.println("Enter number of vertics: ");
    final Scanner in = new Scanner(System.in);
    final int n = in.nextInt();
    for (int i = 1; i <= n; i++) {
      map.put(i, new ArrayList<Integer>());
    }

    System.out.println("Enter number of edges: ");
    final int edges = in.nextInt();
    for (int i = 1; i <= edges; i++) {
      final int u = in.nextInt();
      final int v = in.nextInt();
      map.get(u).add(v);
      map.get(v).add(u);
    }
    System.out.println("Enter starting vertics ");
    final int start = in.nextInt();
    System.out.println("Traversal BFS");
    BFSTraversale(map, start);
    in.close();
  }

  /**
   * @param map
   * @param start
   */
  private static void BFSTraversale(final Map<Integer, ArrayList<Integer>> map, final int start) {
    // TODO Auto-generated method stub
    // final PriorityQueue<String> queue=new PriorityQueue<>();
    final boolean[] visited = new boolean[map.size() + 1];
    final Queue<Integer> queue = new LinkedList<>();
    queue.offer(start);
    visited[start] = true;
    System.out.println(start);
    while (!queue.isEmpty()) {
      final Integer head = queue.remove();

      for (final Integer adj : map.get(head)) {
        if (!visited[adj]) {
          queue.offer(adj);
          System.out.print(adj + ",");
          visited[adj] = true;
        }

      }

    }

  }

}
