package com.java8.practise;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapByGroup {

  public static void main(final String args[]) {
    final Item item = new Item("1", 2, "item1");
    final Item item2 = new Item("2", 8, "item2");
    final Item item3 = new Item("3", 10, "item3");
    final Item item4 = new Item("3", 10, "item3");
    final Item item5 = new Item("3", 10, "item3");

    final List<Item> items = new ArrayList<>();
    items.add(item);
    items.add(item2);
    items.add(item3);
    items.add(item4);
    items.add(item5);

    final Map<String, List<Item>> map = items.stream().collect(Collectors.groupingBy(Item::getName));

    System.out.println(map);

    //summing qt with the same groupId

    System.out.println("Great way of doing grouping ");

    final Map<String, List<String>> idToNameMapping = items.stream().collect(
        Collectors.groupingBy(Item::getId, Collectors.mapping(Item::getName, Collectors.toList())));
    
    System.out.println(idToNameMapping);
  }
}
