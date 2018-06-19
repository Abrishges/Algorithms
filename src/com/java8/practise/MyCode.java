package com.java8.practise;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class MyCode {

  public static void main(final String args[]) {
    final List<Integer> list = Arrays.asList(20, 30, 40, 50);

    System.out.println(list);

    final IntSummaryStatistics sum = list.stream().collect(Collectors.summarizingInt(i -> i));
    System.out.println(sum);

    final Double result = list.stream().collect(Collectors.averagingInt(i -> i));
    System.out.println("result: " + result);

    final Long count = list.stream().filter(i -> i >= 40).collect(Collectors.counting());

    System.out.println(count);
  }

}
