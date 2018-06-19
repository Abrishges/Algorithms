/**
 *
 */
package com.Algorithm.Basic;

import java.util.HashMap;
import java.util.Map;

/**
 * @author aberehamwodajie
 *
 *         Jul 13, 2017
 */
public class Test {

  static Map<String, String> map = new HashMap<>();

  public static void main(final String args[]) {

    final String str = "a, b, m , Abereham";
    final String delimiters = "\\s+ |, \\s* | \\.\\ s*";
    final String[] tokenValue = str.split(delimiters);
    for (final String s : tokenValue) {
      System.out.println(s);
    }

    // array length
    final int[][] x = new int[4][3];
    System.out.println(x.length);
    System.out.println(x[0].length);
    System.out.println(x[1].length);

    map.put("0", "0");
    map.put("1", "1");
    map.put("6", "9");
    map.put("8", "8");
    map.put("9", "6");

    final String[] string = {"1", "6", "0", "8", "1"};

    System.out.println(merge180(string));

  }

  public static boolean merge180(final String[] str) {
    final int len = str.length;
    for (int i = 0; i < str.length / 2; i++) {
      if (map.get(str[i]) != str[len - 1 - i]) {
        return false;
      }
    }
    return true;
  }
}
