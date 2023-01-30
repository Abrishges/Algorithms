package com.Algorithm.graphBasic;

public class Edge {
	private final Node vertex1;
	private final Node vertex2;
	private boolean isDirected;

	public Edge(final Node vertex1, final Node vertex2, final boolean isDirected) {
		super();
		this.vertex1 = vertex1;
		this.vertex2 = vertex2;
		this.isDirected = isDirected;
	}

	public Edge(final Node vertex1, final Node vertex2) {
		super();
		this.vertex1 = vertex1;
		this.vertex2 = vertex2;
	}

	public boolean isDirected() {
		return this.isDirected;
	}

	public void setDirected(final boolean isDirected) {
		this.isDirected = isDirected;
	}

	public Node getVertex1() {
		return this.vertex1;
	}

	public Node getVertex2() {
		return this.vertex2;
	}
}
