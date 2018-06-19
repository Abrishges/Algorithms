package com.java8.practise;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamToMap {

  public static void main(final String[] args) {
    final Item item = new Item("1", 2, "item1");
    final Item item2 = new Item("2", 8, "item2");
    final Item item3 = new Item("3", 10, "item3");

    final List<Item> items = new ArrayList<>();
    items.add(item);
    items.add(item2);
    items.add(item3);

    // change this to Map

    final Map<String, Item> map =
        items.stream().collect(Collectors.toMap(Item::getId, Function.identity(), (oldValue, newValue) -> newValue));
    System.out.println(map);

    // String joining
    final String str = items.stream().map(Item::getName).collect(Collectors.joining(","));
    System.out.println(str);

    // finding the sum
    final int sum = items.stream().collect(Collectors.summingInt(Item::getQt));
    System.out.println(sum);

    // finding the max by Quantity
    final Optional<Item> itemByQuantity = items.stream().collect(Collectors.maxBy((a, b) -> a.getQt() - b.getQt()));

    System.out.println(itemByQuantity.get());

    // partition
    final Map<Boolean, List<Item>> partitionMap =
        items.stream().collect(Collectors.partitioningBy(a -> a.getQt() < 10));
    System.out.println(partitionMap);
  }
}
