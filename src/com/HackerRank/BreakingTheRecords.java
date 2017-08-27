/**
 *
 */
package com.HackerRank;

import java.util.Scanner;

/**
 * @author aberehamwodajie
 *
 *         Jul 3, 2017
 */
public class BreakingTheRecords {
  static int[] getRecord(final int[] s) {
    final int[] result = {0, 0};
    int max = s[0];
    int min = s[0];

    for (int k = 1; k < s.length; k++) {
      if (s[k] > max) {
        result[0]++;
        max = s[k];
      }

      if (s[k] < min) {
        result[1]++;
        min = s[k];
      }
    }
    return result;
  }

  public static void main(final String[] args) {
    final Scanner in = new Scanner(System.in);
    final int n = in.nextInt();
    final int[] s = new int[n];
    for (int s_i = 0; s_i < n; s_i++) {
      s[s_i] = in.nextInt();
    }
    final int[] result = getRecord(s);

    System.out.println(result[0]);
    String separator = "";
    final String delimiter = " ";
    for (final Integer val : result) {
      System.out.print(separator + val);
      separator = delimiter;
    }
    System.out.println("");
    in.close();
  }
}
