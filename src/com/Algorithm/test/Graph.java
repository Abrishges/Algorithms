/**
 *
 */
package com.Algorithm.test;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author aberehamwodajie
 *
 *         Jun 4, 2017
 */
public class Graph {
  // all Node
  final Map<Integer, ArrayList<Integer>> map = new ConcurrentHashMap<>();

  public Graph(final Integer v) {
    for (int i = 0; i < v; i++) {
      this.map.put(i, new ArrayList<Integer>());
    }
  }

  public ArrayList<Integer> getAdjacentNodes(final Integer v) {
    return this.map.get(v);
  }

  // number of vertices in a graph
  public Integer vSize() {
    return this.map.size();
  }
}
