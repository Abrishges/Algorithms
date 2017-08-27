/**
 *
 */
package com.HackerRank;

/**
 * @author aberehamwodajie
 *
 *         Jul 4, 2017
 */
public class BirthdayChocolate {

  public static void main(final String args[]) {

    final int[] s = {1, 2, 1, 3, 2};
    System.out.println(solve(5, s, 3, 2));
  }

  static int solve(final int n, final int[] s, final int d, final int m) {
    // Complete this function
    int count = 0;
    for (int j = 0; j < n; j++) {
      int temp = d;
      for (int k = j; k < j + m; k++) {
        if (k >= n) {
          break;
        }
        temp -= s[k];
      }
      if (temp == 0) {
        count++;
      }
    }

    return count;
  }

}
