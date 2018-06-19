package com.java8.practise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MapToList {

  public static void main(final String args[]) {
    final List<String> list = Arrays.asList("apple", "orange", "apple", "orange", "apple", "mango");

    System.out.println(list);

    final Map<String, Long> map =
        list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    System.out.println(map);

    // keys as list
    final List<String> keys = new ArrayList<>(map.keySet());
    System.out.println(keys);

    // we can also do it using stream
    final List<String> keyStream = map.keySet().stream().collect(Collectors.toList());
    System.out.println("using stream: " + keyStream);


    // values as list
    final List<Long> values = new ArrayList<>(map.values());
    System.out.println(values);

    // we can also do other way

    final List<Long> valueStream = map.values().stream().collect(Collectors.toList());
    System.out.println("using stream: " + valueStream);

    // sorting by value
    final Map<String, Long> finalMapSortedByValue = new LinkedHashMap<>();
    map.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue()).forEachOrdered(
        e -> finalMapSortedByValue.put(e.getKey(), e.getValue()));

    System.out.println("sorted by values: " + finalMapSortedByValue);

    // sorting by key
    final Map<String, Long> finalMapSortedByKey = new LinkedHashMap<>();
    map.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByKey()).forEachOrdered(
        e -> finalMapSortedByKey.put(e.getKey(), e.getValue()));

    System.out.println("sorted by key: " + finalMapSortedByKey);
  }
}
