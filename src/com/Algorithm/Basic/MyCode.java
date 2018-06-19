package com.Algorithm.Basic;

// package whatever; // don't place package name!

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class MyCode {
  public static void main(final String[] args) {
    final Developer dev1 = new Developer("Abereham", "wodajie", 23);
    final Developer dev2 = new Developer("Dawit", "wodajie", 24);

    final List<Developer> list = new ArrayList<>();
    list.add(dev1);
    list.add(dev2);

    System.out.println("Before sorting");

    for (final Developer dev : list) {
      System.out.println("printing: " + dev);
    }

    // using java 8 lambda
    list.forEach(item -> System.out.println(item));


    // java 7 method
    Collections.sort(list, new Comparator<Developer>() {
      @Override
      public int compare(final Developer dev1, final Developer dev2) {
        return dev1.getFristName().compareToIgnoreCase(dev2.getFristName());
      }

    });
    // using java 8

    list.sort((final Developer dev3, final Developer dev4) -> dev3.getFristName().compareTo(dev4.getFristName()));

    // printing after lambda sorting

    list.forEach(item -> System.out.println(item));
    final Map<String, String> map = new ConcurrentHashMap<>();
    for (final Map.Entry<String, String> entry : map.entrySet()) {
      System.out.println("key: " + entry.getKey() + "value: " + entry.getValue());
    }
  }
}


class Developer {

  private String fristName;
  private String lastName;
  private int age;

  public Developer(final String fristName, final String lastName, final int age) {
    this.fristName = fristName;
    this.lastName = lastName;
    this.age = age;
  }

  public Developer() {

  }

  public void setFristName(final String fristName) {
    this.fristName = fristName;
  }

  public String getFristName() {
    return this.fristName;
  }

  @Override
  public String toString() {
    return "Developer [fristName=" + this.fristName + ", lastName=" + this.lastName + ", age=" + this.age + "]";
  }
}

