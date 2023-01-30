/**
 *
 */
package com.Algorithm.graphs;

import com.Algorithm.test.Graph;

public class DFSCycle {

	private final boolean visted[];
	private final Integer s;
	private final Graph g;
	private boolean hasCycle;

	// s - starting node
	public DFSCycle(final Graph g, final Integer s) {
		this.g = g;
		this.s = s;
		this.visted = new boolean[g.vSize()];
		this.findCycle(g, s, s);
	}

	public boolean hasCycle() {
		return this.hasCycle;
	}

	public void findCycle(final Graph g, final Integer v, final Integer u) {

		this.visted[v] = true;

		for (final int w : g.getAdjacentNodes(v)) {
			if (!this.visted[w]) {
				this.visted[w] = true;
				this.findCycle(g, w, v);
			} else if (v != u) {
				this.hasCycle = true;
				return;
			}
		}

	}

}
