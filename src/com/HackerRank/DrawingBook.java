/**
 *
 */
package com.HackerRank;

import java.util.Scanner;

/**
 * @author aberehamwodajie
 *
 *         Jul 8, 2017
 */
public class DrawingBook {
  static int solve(final int n, final int p) {
    int min = p / 2;
    int back = 0;
    if (p % 2 != 0) {
      back = (n - (p - 1)) / 2;
    } else {
      back = (n - p) / 2;
    }

    if (back < min) {
      min = back;
    }

    return min;
  }

  public static void main(final String[] args) {
    final Scanner in = new Scanner(System.in);
    final int n = in.nextInt();
    final int p = in.nextInt();
    final int result = solve(n, p);
    System.out.println(result);
    in.close();
  }
}
