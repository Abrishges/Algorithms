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
public class BonAppétit {
  static int bonAppetit(final int n, final int k, final int b, final int[] ar) {
    // Complete this function
    int total = 0;
    for (int i = 0; i < n; i++) {
      if (i != k) {
        total += ar[i];
      }
    }
    return (b - (total / 2));
  }

  public static void main(final String[] args) {
    final Scanner in = new Scanner(System.in);
    final int n = in.nextInt();
    final int k = in.nextInt();
    final int[] ar = new int[n];
    for (int ar_i = 0; ar_i < n; ar_i++) {
      ar[ar_i] = in.nextInt();
    }
    final int b = in.nextInt();
    final int result = bonAppetit(n, k, b, ar);
    if (result != 0) {
      System.out.println(result);
    } else {
      System.out.println("Bon Appetit");
    }
  }
}
