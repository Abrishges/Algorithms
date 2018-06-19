package com.Algorithm.Basic;

import java.util.StringJoiner;

public class StringJoinerTest {
  public static void main(final String args[]) {

    final StringJoiner sj = new StringJoiner(",");

    final String result = sj.toString();

    final StringJoiner holdClass = new StringJoiner("~");

    System.out.println(holdClass.toString());
    // holdClass.add("hello");
    holdClass.setEmptyValue("empty value");

    System.out.println(holdClass);
    if (holdClass.toString().equals("empty value")) {
      System.out.println("printing correctly ");
    }
  }
}
