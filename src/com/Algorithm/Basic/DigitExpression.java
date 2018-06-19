package com.Algorithm.Basic;

// given a string of digits like "123"
// keeping the digits in that order
// print out all possible math expressions
// using the "+" operator as strings
// "123" -> "123", "1+2+3", "1+23", "12+3" 2^2
// "1234" -> 2^3
// n -> 2^(n-1) -> O(2^n)
//
// "1_2_3_"
// / \
// 12_3 1+2_3
// / \ . / \
// 123 12+3 1+23 1+2+3
public class DigitExpression {

  public static void main(final String[] args) {

    mathExpressions("123", 0, "");
  }

  public static void mathExpressions(final String str, final int i, final String output) {

    if (i == str.length()) {
      System.out.println(output + "=");
      return;
    }

    // explore left child
    System.out.println("frist: " + output);
    mathExpressions(str, i + 1, output + str.charAt(i));

    // explore right child
    if (i < str.length() - 1) {

      System.out.println("output: " + output);
      mathExpressions(str, i + 1, output + str.charAt(i) + "+");
    }
  }
}
