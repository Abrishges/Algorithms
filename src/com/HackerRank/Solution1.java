package com.HackerRank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution1 {

  public static void main(final String[] args) {
    final Scanner scan = new Scanner(System.in);
    final HashMap<Integer, List<Integer>> groupByAccess = new HashMap<>();
    System.out.println("Enter number of cities: ");
    final int numCities = scan.nextInt();
    System.out.println("Enter number of edges: ");
    final int numOfEdges = scan.nextInt();
    final int libraryCost = scan.nextInt();
    final int roadCost = scan.nextInt();
    for (int i = 1; i <= numCities; i++) {
      final List<Integer> list = new ArrayList<>();
      list.add(i);
      groupByAccess.put(i, list);
    }
    groupByAccess.forEach((k, v) -> System.out.println("keys:" + k + " values: " + v));

    groupByAccess(groupByAccess, numOfEdges);
    groupByAccess.forEach((k, v) -> System.out.println("keys:" + k + "  values:" + v));

    final Integer totalCost = getTotalCost(libraryCost, roadCost, numCities, groupByAccess);
    System.out.println("Total cost to build library: " + totalCost);
    scan.close();
  }

  // group by access from the each city
  public static Map<Integer, List<Integer>> groupByAccess(
      final Map<Integer, List<Integer>> groupByAccess,
      final Integer numOfEdges) {
    System.out.println("enter edges: ");
    final Scanner scan = new Scanner(System.in);
    for (int a1 = 0; a1 < numOfEdges; a1++) {
      final int x = scan.nextInt();
      final int y = scan.nextInt();
      final List<Integer> list1 = groupByAccess.get(x);
      System.out.println("list " + x + ":" + list1);
      final List<Integer> list2 = groupByAccess.get(y);
      System.out.println("list " + y + ":" + list2);
      if (list1 != list2) {
        list1.addAll(list2);
        System.out.println("after adding to list " + x + ":" + list1);
        System.out.println("map before: " + groupByAccess);
        list2.forEach(i -> groupByAccess.put(i, list1));
        System.out.println("Containt of the map after adding to list " + y + ":" + list2);
        System.out.println("map after: " + groupByAccess);
      }
    }
    scan.close();
    return groupByAccess;
  }

  // calculate total cost
  public static Integer getTotalCost(
      final int libraryCost,
      final int roadCost,
      final int numCities,
      final Map<Integer, List<Integer>> groupByAccess) {
    Integer cost = 0;
    if (libraryCost < roadCost) {
      cost = numCities * libraryCost;
    } else {
      System.out.println("Content of the map: " + groupByAccess.values());
      for (final List<Integer> list : groupByAccess.values()) {
        System.out.println("Content: " + list);
        final int size = list.size();
        if (size > 0) {
          cost += libraryCost;
          cost += (size - 1) * roadCost;
          list.removeIf(i -> true); // removes duplicate elements
          System.out.println("list after removal: " + list);
        }
      }
    }
    return cost;
  }
}
