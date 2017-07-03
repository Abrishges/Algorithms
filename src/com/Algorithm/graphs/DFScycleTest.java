/**
 *
 */
package com.Algorithm.graphs;

import java.util.Scanner;

import com.Algorithm.test.Graph;

/**
 * @author Abereham Wodajie
 *
 *         Jun 4, 2017
 */
public class DFScycleTest {

  public static void main(final String[] args) {
    final Scanner in = new Scanner(System.in);
    System.out.println("Enter the number of vertics: ");
    final Integer size = in.nextInt();

    final Graph g = new Graph(size);

    System.out.println("Enter number of edges ");

    final Integer edges = in.nextInt();
    for (int i = 0; i < edges; i++) {
      final Integer u = in.nextInt();
      final Integer v = in.nextInt();
      g.getAdjacentNodes(u).add(v);
      g.getAdjacentNodes(v).add(u);
    }
    System.out.println("Enter starting vertics ");
    final Integer start = in.nextInt();
    final DFSCycle dfsCycle = new DFSCycle(g, start);
    System.out.println("Has cycle: " + dfsCycle.hasCycle());

    in.close();
  }
}
