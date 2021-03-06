/**
 *
 */
package com.HackerRank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Abereham wodajie
 *
 *         May 20, 2017
 */
public class RoadsAndLibraries {

  public static void main(final String[] args) {
    final Scanner scan = new Scanner(System.in);
    final HashMap<Integer, ArrayList<Integer>> cityMap = new HashMap<>();
    final int n = scan.nextInt();
    final int m = scan.nextInt();
    final int libraryCost = scan.nextInt();
    final int roadCost = scan.nextInt();
    for (int i = 1; i <= n; i++) {
      final ArrayList<Integer> list = new ArrayList<>();
      list.add(i);
      cityMap.put(i, list);
    }
    cityMap.forEach((k, v) -> System.out.println("keys:" + k + " values: " + v));
    System.out.println("enter edges: ");
    for (int a1 = 0; a1 < m; a1++) {
      final int x = scan.nextInt();
      final int y = scan.nextInt();
      final ArrayList<Integer> list1 = cityMap.get(x);
      System.out.println("list1: " + list1);
      final ArrayList<Integer> list2 = cityMap.get(y);
      System.out.println("list2:" + list2);
      if (list1 != list2) {
        list1.addAll(list2);
        System.out.println("after adding to list1: " + list1);
        System.out.println("map before: " + cityMap);
        list2.forEach(i -> cityMap.put(i, list1));
        System.out.println("Containt of the map after adding to list2: " + list2);
        System.out.println("map after: " + cityMap);
      }
    }

    cityMap.forEach((k, v) -> System.out.println("keys:" + k + "  values:" + v));

    scan.close();
    if (libraryCost < roadCost) {
      System.out.println((long) n * libraryCost);
    } else {
      long cost = 0;
      System.out.println("Content of the map: " + cityMap.values());
      for (final ArrayList<Integer> list : cityMap.values()) {
        System.out.println("Content: " + list);
        final int size = list.size();
        if (size > 0) {
          cost += libraryCost;
          cost += (size - 1) * roadCost;
          list.removeIf(i -> true); // removes duplicate elements

          System.out.println("list after removal: " + list);
        }
      }
      System.out.println(cost);
    }
  }
}
