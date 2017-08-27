/**
 *
 */
package com.HackerRank;

import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author aberehamwodajie
 *
 *         Jul 5, 2017
 */
public class MigratoryBirds {

  static int migratoryBirds(final int n, final int[] ar) {
    // Complete this function
    final Map<Integer, Integer> map = new ConcurrentHashMap<>();
    for (int i = 1; i <= 5; i++) {
      map.put(i, 0);
    }

    for (final int item : ar) {
      int count = map.get(item);
      count++;
      map.put(item, count);
    }
    System.out.println(map);

    final Entry<Integer, Integer> maxEntery = map.entrySet().stream().max(Entry.comparingByValue()).get();

    /*
     * int max = 1;
     * for (int i = 2; i <= 5; i++) {
     * if (map.get(max) < map.get(i)) {
     * max = i;
     * }
     * }
     */
    return maxEntery.getKey();
  }

  public static void main(final String[] args) {
    final int[] ar = {1, 4, 4, 4, 5, 3};
    final int result = migratoryBirds(6, ar);
    System.out.println(result);
  }
}
