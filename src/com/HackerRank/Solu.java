package com.HackerRank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Solu {

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

    for (int a1 = 0; a1 < m; a1++) {
      final int x = scan.nextInt();
      final int y = scan.nextInt();
      final ArrayList<Integer> list1 = cityMap.get(x);
      final ArrayList<Integer> list2 = cityMap.get(y);
      if (list1 != list2) {
        list1.addAll(list2);
        list2.forEach(i -> cityMap.put(i, list1));
      }
    }

    scan.close();
    if (libraryCost < roadCost) {
      System.out.println((long) n * libraryCost);
    } else {
      long cost = 0;
      for (final ArrayList<Integer> list : cityMap.values()) {

        final int size = list.size();
        if (size > 0) {
          cost += libraryCost;
          cost += (size - 1) * roadCost;
          list.removeIf(i -> true); // removes duplicate elements
        }
      }
      System.out.println(cost);
    }
  }

}
