/**
 *
 */
package com.Algorithm.collections;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author aberehamwodajie
 *
 *         Jun 18, 2017
 */
public class SortMap {

  public static void main(final String args[]) {
    // Creating dummy unsorted map
    final Map<String, Integer> unsortMap = new HashMap<>();
    unsortMap.put("B", 55);
    unsortMap.put("A", 80);
    unsortMap.put("D", 20);
    unsortMap.put("C", 70);

    System.out.println("printing unsorted values: ");
    printMap(unsortMap);
    final Map<String, Integer> sortedMap = sortByComparator(unsortMap);
    System.out.println("\n printing sorted values: ");
    printMap(sortedMap);

  }

  public static Map<String, Integer> sortByComparator(final Map<String, Integer> unsortedMap) {

    final List<Entry<String, Integer>> list = new LinkedList<>(unsortedMap.entrySet());
    Collections.sort(list, new Comparator<Entry<String, Integer>>() {
      @Override
      public int compare(final Entry<String, Integer> o1, final Entry<String, Integer> o2) {
        return o1.getValue().compareTo(o2.getValue());
      }
    });

    // Maintaining insertion order with the help of LinkedList
    final Map<String, Integer> sortedMap = new LinkedHashMap<>();
    for (final Entry<String, Integer> entry : list) {
      sortedMap.put(entry.getKey(), entry.getValue());
    }

    return sortedMap;
  }

  public static void printMap(final Map<String, Integer> map) {
    map.forEach((k, v) -> System.out.println("key: " + k + ", value: " + v));
  }
}
