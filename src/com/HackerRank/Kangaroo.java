/**
 *
 */
package com.HackerRank;

import java.util.Scanner;

/**
 * @author aberehamwodajie
 *
 *         Jul 1, 2017
 */
public class Kangaroo {

  public static void main(final String[] args) {
    final Scanner in = new Scanner(System.in);
    final int x1 = in.nextInt();
    final int v1 = in.nextInt();
    final int x2 = in.nextInt();
    final int v2 = in.nextInt();
    final String result = kangaroo(x1, v1, x2, v2);
    System.out.println(result);
    in.close();
  }

  static String kangaroo(int x1, final int v1, int x2, final int v2) {
    while (true) {
      if (x2 > x1 && v2 > v1 || x1 > x2 && v1 > v2 || v1 == v2 && x1 != x2) {
        return "NO";
      }
      if (x1 == x2) {
        return "YES";
      }
      x1 = x1 + v1;
      x2 = x2 + v2;
    }
  }
}
