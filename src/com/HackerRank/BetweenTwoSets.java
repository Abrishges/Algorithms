/**
 *
 */
package com.HackerRank;

import java.util.Scanner;

/**
 * @author aberehamwodajie
 *
 *         Consider two sets of positive integers, and . We say that a positive integer, , is
 *         between sets and if the following conditions are satisfied:
 * 
 *         All elements in are factors of .
 *         is a factor of all elements in .
 *         Jul 2, 2017
 */
public class BetweenTwoSets {
  public static void main(final String[] args) {
    final Scanner in = new Scanner(System.in);
    final int n = in.nextInt();
    final int m = in.nextInt();
    final int[] a = new int[n];
    for (int a_i = 0; a_i < n; a_i++) {
      a[a_i] = in.nextInt();
    }
    final int[] b = new int[m];
    for (int b_i = 0; b_i < m; b_i++) {
      b[b_i] = in.nextInt();
    }
    final int f = lcm(a);
    final int l = gcd(b);
    int count = 0;
    for (int i = f, j = 2; i <= l; i = f * j, j++) {
      if (l % i == 0) {
        count++;
      }
    }
    System.out.println(count);
  }


  private static int gcd(int a, int b) {
    while (b > 0) {
      final int temp = b;
      b = a % b;
      a = temp;
    }
    return a;
  }

  private static int gcd(final int[] input) {
    int result = input[0];
    for (int i = 1; i < input.length; i++) {
      result = gcd(result, input[i]);
    }
    return result;
  }

  private static int lcm(final int a, final int b) {
    return a * (b / gcd(a, b));
  }

  private static int lcm(final int[] input) {
    int result = input[0];
    for (int i = 1; i < input.length; i++) {
      result = lcm(result, input[i]);
    }
    return result;
  }
}
