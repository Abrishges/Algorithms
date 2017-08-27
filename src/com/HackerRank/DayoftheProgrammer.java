/**
 *
 */
package com.HackerRank;

/**
 * @author aberehamwodajie
 *
 *         Jul 6, 2017
 */
public class DayoftheProgrammer {

  static String solve(final int year) {
    // Complete this function
    int february = 28;
    if (year >= 1700 && year <= 1917) {
      if (year % 4 == 0) {
        february = 29;
      }
    } else if (year >= 1919) {
      if (year % 400 == 0 || year % 4 == 0 && year % 100 != 0) {
        february = 29;
      }
    } else {
      february = 15;
    }
    final int days = 31 + february + 31 + 30 + 31 + 30 + 31 + 31;
    final int dd = 256 - days;

    final String result = dd + "." + "09." + year;

    return result;
  }

  public static void main(final String[] args) {
    // final Scanner in = new Scanner(System.in);
    // final int year = in.nextInt();
    final String result = solve(1918);
    System.out.println(result);
  }

}
