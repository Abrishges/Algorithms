package com.Algorithm.graphs;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/is-graph-bipartite/
public class IsBipartite {

	public boolean isBipartite(int[][] graph) {

		Map<Integer, Integer> visited = new HashMap<Integer, Integer>();

		for (int i = 0; i < graph.length; i++) {

			if (visited.containsKey(i))
				continue;

			// group 1 : 0
			// group 2 : 1
			if (isNotBipartite(i, graph, visited, 0)) {
				return false;
			}
		}

		return true;
	}

	public boolean isNotBipartite(int i, int[][] graph, Map<Integer, Integer> visited, int color) {

		visited.put(i, color);

		for (int adj : graph[i]) {

			if (visited.containsKey(adj)) {
				if (visited.get(adj) == color) {
					return true;
				}

				continue;
			}

			if (isNotBipartite(adj, graph, visited, 1 - color)) {
				return true;
			}

		}

		return false;
	}

}
