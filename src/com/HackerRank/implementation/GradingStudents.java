/**
 *
 */
package com.HackerRank.implementation;

import java.util.Scanner;

/**
 * @author aberehamwodajie
 *
 *         Jun 21, 2017
 */
public class GradingStudents {

  static int[] solve(final int[] grades) {
    // Complete this function
    for (int i = 0; i < grades.length; i++) {
      if (grades[i] >= 38 && grades[i] % 5 != 0 && (grades[i] / 5 + 1) * 5 - grades[i] < 3) {
        grades[i] = (grades[i] / 5 + 1) * 5;
      }
    }
    return grades;
  }

  public static void main(final String[] args) {
    final Scanner in = new Scanner(System.in);
    final int n = in.nextInt();
    final int[] grades = new int[n];
    for (int grades_i = 0; grades_i < n; grades_i++) {
      grades[grades_i] = in.nextInt();
    }
    final int[] result = solve(grades);
    for (int i = 0; i < result.length; i++) {
      System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
    }
    System.out.println("");
    in.close();
  }

}
