package com.Algorithm.dp;

import java.util.ArrayList;
import java.util.List;

public class Knapsack01 {

  public static void main(final String args[]) {
    final Item item6 = new Item(0, 0);
    final Item item1 = new Item(1, 1);
    final Item item2 = new Item(6, 2);
    final Item item3 = new Item(18, 5);
    final Item item4 = new Item(22, 6);
    final Item item5 = new Item(28, 7);
    final List<Item> items = new ArrayList<>();
    items.add(item6); // For empty item
    items.add(item1);
    items.add(item2);
    items.add(item3);
    items.add(item4);
    items.add(item5);
    final Integer limit = 11;

    System.out.println("Max value: " + knapSack01(items, limit));
  }

  public static int knapSack01(final List<Item> items, final Integer limit) {

    final int[][] values = new int[items.size()][limit + 1];

    for (int k = 0; k < items.size(); k++) {
      for (int w = 0; w <= limit; w++) {
        if (k == 0) {
          values[0][w] = 0;
        } else if (items.get(k).weight > w) {
          values[k][w] = values[k - 1][w];
        } else {
          final int case1 = values[k - 1][w];
          final int case2 = items.get(k).value + values[k - 1][w - items.get(k).weight];
          values[k][w] = Math.max(case1, case2);
        }
      }
    }

    for (int k = 0; k < items.size(); k++) {
      System.out.print(k + " :");
      for (int w = 0; w <= limit; w++) {
        System.out.print(values[k][w] + ", ");
      }
      System.out.println();
    }

    return values[items.size() - 1][limit];
  }
}


class Item {
  int value;
  int weight;

  public Item(final int value, final int weight) {
    this.value = value;
    this.weight = weight;
  }
}
