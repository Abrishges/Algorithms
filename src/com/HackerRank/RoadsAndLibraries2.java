package com.HackerRank;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;


class RoadsAndLibraries2 {
  public static void main(final String[] args) {

    final Map<Integer, Node2> nodeMap = new HashMap<>();
    final DisJointSet ds = new DisJointSet();
    final Scanner in = new Scanner(System.in);

    System.out.println("enter Qentity");
    final int q = in.nextInt();

    for (int a0 = 0; a0 < q; a0++) {
      final int n = in.nextInt();
      final int m = in.nextInt();
      System.out.println("number of cities and edges: " + n + ", edges: " + m);
      final int libCost = in.nextInt();
      final int roadCost = in.nextInt();

      for (int i = 1; i <= n; i++) {
        final Node2 node = ds.makeSet(i);
        nodeMap.put(i, node);
      }

      nodeMap.forEach((key, value) -> System.out.println("key: " + key + ", value: " + value.data));

      System.out.println("Start entering edges: ");
      for (int i = 1; i <= m; i++) {
        final int v1 = in.nextInt();
        final int v2 = in.nextInt();
        final Node2 node1 = ds.findSet(nodeMap.get(v1));
        final Node2 node2 = ds.findSet(nodeMap.get(v2));
        ds.union(node1, node2);
      }

      final Map<Node2, Set<Node2>> sets = groupByParent(nodeMap);
      sets.forEach((key, value) -> System.out.println("key: " + key + ", values: " + value));

      final double totalCost = getTotalCost(sets, n, libCost, roadCost);

      System.out.println("totalCost: " + totalCost);
      in.close();
    }
  }

  // group by parent
  public static Map<Node2, Set<Node2>> groupByParent(final Map<Integer, Node2> nodeMap) {
    final DisJointSet ds = new DisJointSet();
    final Map<Node2, Set<Node2>> sets = new HashMap<>();
    for (int i = 1; i <= nodeMap.size(); i++) {
      final Node2 node = nodeMap.get(i);
      final Node2 parent = ds.findSet(node);
      if (!sets.containsKey(parent)) {
        final Set<Node2> set = new HashSet<>();
        set.add(node);
        sets.put(parent, set);
      } else {
        sets.get(parent).add(node);
      }
    }
    return sets;
  }

  private static double total;

  public static double getTotalCost(
      final Map<Node2, Set<Node2>> sets,
      final Integer numberOfCites,
      final Integer libCost,
      final Integer roadCost) {
    total = 0;
    if (roadCost > libCost) {
      return libCost * numberOfCites;
    } else {
      sets.forEach((key, value) -> {
        total += (value.size() - 1 * roadCost + libCost);
      });
    }
    return total;
  }
}


class Node2 {
  Integer data;
  Node2 parent;
  Integer rank = 0;

  @Override
  public String toString() {
    return "Node2 [data=" + this.data + "]";
  }
}


class DisJointSet {

  public Node2 makeSet(final int data) {
    final Node2 node = new Node2();
    node.data = data;
    node.parent = node;

    return node;
  }

  public Node2 findSet(final Node2 node) {
    if (node.parent == node) {
      return node;
    } else {
      return this.findSet(node.parent);
    }
  }

  public void union(final Node2 node1, final Node2 node2) {
    final Node2 nodeV1 = this.findSet(node1);
    final Node2 nodeV2 = this.findSet(node2);

    if (nodeV1 != nodeV2) {
      if (nodeV1.rank > nodeV2.rank) {
        nodeV2.parent = nodeV1;
      } else {
        if (nodeV1.rank == nodeV2.rank) {
          nodeV2.rank = nodeV2.rank + 1;
        }
        nodeV1.parent = nodeV2;
      }
    }
  }
}
