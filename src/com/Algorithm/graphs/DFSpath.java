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
 * @author Abereham wodajie
 *
 *         May 24, 2017
 */
public class DFSpath {

  public static void main(final String args[]) {

    final Map<Integer, ArrayList<Integer>> map = new ConcurrentHashMap<>();
    final Scanner input = new Scanner(System.in);
    System.out.println("Enter number of vertices: ");
    final int n = input.nextInt();
    System.out.println("Enter number of edges: ");
    final int m = input.nextInt();
    for (int j = 1; j <= n; j++) {
      map.put(j, new ArrayList<Integer>());
    }
    System.out.println("Enter edges: ");
    for (int i = 1; i <= m; i++) {
      final int x = input.nextInt();
      final int y = input.nextInt();

      map.get(x).add(y);
      map.get(y).add(x);
    }
    System.out.println("Enter start vertices: ");
    final int startVertics = input.nextInt();
    System.out.println("Enter end vertices: ");
    final int endVertics = input.nextInt();

    final Stack<Integer> path = DFSpathFinding(map, startVertics, endVertics);
    if (path != null) {
      System.out.println("we found path, check it out : " + path);
    } else {
      System.out.println("Sorry, we don't have path between the two vertics : " + path);
    }
    input.close();
  }

  public static Stack<Integer> DFSpathFinding(
      final Map<Integer, ArrayList<Integer>> adjMap,
      final int start,
      final int end) {
    final boolean[] visited = new boolean[adjMap.size() + 1];
    for (int i = 1; i <= adjMap.size(); i++) {
      visited[i] = false;
    }
    final Stack<Integer> stack = new Stack<>();
    stack.push(start);
    System.out.println(start);
    while (!stack.isEmpty()) {
      final Integer head = stack.peek();
      visited[head] = true;
      Integer child = null;
      for (final Integer adj : adjMap.get(head)) {
        if (!visited[adj]) {
          System.out.println("This vertics is not visited");
          child = adj;
          break;
        }
      }

      if (child != null && child == end) {
        stack.push(child);
        System.out.println("They are equal here: " + child + "," + end);
        return stack;
      } else if (child != null) {
        stack.push(child);
        System.out.println("They are not equal and we are pushing : " + child + "," + end);
        visited[child] = true;
      } else {
        stack.pop();
      }
    }
    return null;
  }
}
