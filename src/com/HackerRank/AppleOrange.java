/**
 *
 */
package com.HackerRank;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * @author aberehamwodajie
 *
 *         Jul 1, 2017
 */
public class AppleOrange {
  public static void main(final String[] args) {
    final Scanner in = new Scanner(System.in);
    final int s = in.nextInt();
    final int t = in.nextInt();
    final int a = in.nextInt();
    final int b = in.nextInt();
    final int m = in.nextInt();
    final int n = in.nextInt();
    final int[] apple = new int[m];
    for (int apple_i = 0; apple_i < m; apple_i++) {
      apple[apple_i] = in.nextInt();
    }
    final int[] orange = new int[n];
    for (int orange_i = 0; orange_i < n; orange_i++) {
      orange[orange_i] = in.nextInt();
    }

    final IntStream array1 = Arrays.stream(apple);
    System.out.println(array1.filter(j -> (j + a >= s && j + a <= t)).count());
    final IntStream array2 = Arrays.stream(orange);
    System.out.println(array2.filter(i -> (i + b >= s && i + b <= t)).count());
    in.close();
  }
}
