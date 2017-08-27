package com.Algorithm.graphBasic;

class Node {
  String data;
  boolean visited;

  public Node() {
    super();
  }

  public Node(final String data) {
    super();
    this.data = data;
  }

  public String getData() {
    return this.data;
  }

  public void setData(final String data) {
    this.data = data;
  }

  public boolean isVisited() {
    return this.visited;
  }

  public void setVisited(final boolean visited) {
    this.visited = visited;
  }

  @Override
  public String toString() {
    return "Node [data=" + this.data + ", visited=" + this.visited + "]";
  }
}
