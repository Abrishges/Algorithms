package com.Algorithem.random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Skyline2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<List<Integer>> getSkyline(int[][] buildings) {

		List<List<Integer>> edges = new ArrayList<List<Integer>>();

		for (int i = 0; i < buildings.length; i++) {
			int xLeft = buildings[i][0];
			int xRight = buildings[i][1];
			edges.add(Arrays.asList(xLeft, i));
			edges.add(Arrays.asList(xRight, i));
		}

		Collections.sort(edges, (a, b) -> {
			return a.get(0) - b.get(0);
		});

		Queue<List<Integer>> pq = new PriorityQueue<List<Integer>>((a, b) -> {
			return b.get(0) - a.get(0);
		});

		List<List<Integer>> ans = new ArrayList<List<Integer>>();

		int index = 0;

		while (index < edges.size()) {

			int curx = edges.get(index).get(0);

			// check if there are multiple edges at this location
			while (index < edges.size() && edges.get(index).get(0) == curx) {
				// building index
				int b_index = edges.get(index).get(1);

				if (buildings[b_index][0] == curx) {

					int right = buildings[b_index][1];
					int height = buildings[b_index][2];
					pq.add(Arrays.asList(height, right));
				}

				index += 1;
			}

			// If the tallest live building has been passed
			// remove it from priority queue
			while (!pq.isEmpty() && pq.peek().get(1) <= curx) {
				pq.poll();
			}

			int maxHeight = pq.isEmpty() ? 0 : pq.peek().get(0);

			if (ans.isEmpty() || ans.get(ans.size() - 1).get(1) != maxHeight) {
				ans.add(Arrays.asList(curx, maxHeight));
			}

		}

		return ans;
	}
}