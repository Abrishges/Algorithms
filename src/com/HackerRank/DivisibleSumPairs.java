/**
 *
 */
package com.HackerRank;

import java.util.Scanner;

/**
 * @author aberehamwodajie
 *
 *         Jul 5, 2017
 */
public class DivisibleSumPairs {
  static int divisibleSumPairs(final int n, final int k, final int[] ar) {
    // Complete this function
    int count = 0;
    for (int j = 1; j < n; j++) {
      for (int i = 0; i < j; i++) {
        if ((ar[i] + ar[j]) % k == 0) {
          count++;
        }
      }
    }
    return count;
  }

  public static void main(final String[] args) {
    final Scanner in = new Scanner(System.in);
    final int n = in.nextInt();
    final int k = in.nextInt();
    final int[] ar = new int[n];
    for (int ar_i = 0; ar_i < n; ar_i++) {
      ar[ar_i] = in.nextInt();
    }
    final int result = divisibleSumPairs(n, k, ar);
    System.out.println(result);
  }
}
