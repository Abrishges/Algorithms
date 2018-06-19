package com.Algorithm.Basic;

import java.util.HashMap;
import java.util.Map;

public class Test2 {
  public static void main(final String args[]) {

    final Map<String, String> map = new HashMap<>();
    map.put("1", "hello");
    map.put("2", "java");
    map.put("3", "I love google");
    map.put("4", "I love facebook");
    map.put("5", "I love ticketmaster");


    map.replace("2016", "2018");

    map.put("1", "second");

    map.forEach((key, value) -> System.out.println("key: " + key + ", value: " + value));

  }
}
