package com.Algorithm.bitwise;

/*
 * Adding two binary numbers
 *
 */

public class BinaryOperation {

  public static void main(final String args[]) {
    System.out.println("Adding two binary numbers");
    final String str1 = "1010";
    final String str2 = "1010";

    System.out.println(addTwoBinary(str1, str2));
  }

  public static String addTwoBinary(final String str1, final String str2) {
    final StringBuilder sb = new StringBuilder();

    if (str1 == null || str1.length() == 0) {
      return str2;
    }

    if (str2 == null || str2.length() == 0) {
      return str1;
    }

    int i = str1.length() - 1;
    int j = str2.length() - 1;
    int carry = 0;

    while (i >= 0 && j >= 0) {
      int sum = 0;
      if (str1.charAt(i) == '1') {
        sum++;
      }
      if (str1.charAt(j) == '1') {
        sum++;
      }

      sum = sum + carry;

      if (sum >= 2) {
        carry = 1;
      } else {
        carry = 0;
      }
      i--;
      j--;
      sb.insert(0, (char) (sum % 2 + '0'));
    }
    sb.insert(0, carry);

    return sb.toString();
  }
}
