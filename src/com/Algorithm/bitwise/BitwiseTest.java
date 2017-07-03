/**
 *
 */
package com.Algorithm.bitwise;

/**
 * @author aberehamwodajie
 *
 *         Jun 8, 2017
 */
public class BitwiseTest {
  public static void main(final String args[]) {
    System.out.println(4 & 5);
    System.out.println(4 | 5);
    System.out.println(4 ^ 5);
    System.out.println(~4); // 4 repsent by 32 bits

    // Shift signed
    System.out.println(00000001 << 3);
    /* 11111111 11111111 11111111 11110000 >> 4 = 11111111 11111111 11111111 11111111 */
    // 0xFFFFFFF0 >> 4 == 0xFFFFFFFF

    /* 00001111 11111111 11111111 11111111 >> 4 = 00000000 11111111 11111111 11111111 */
    // 0x0FFFFFFF >> 4 == 0x00FFFFFF

    // unsigned shift right" operator: >>> for always shifting in a "0" regardless of the sign.

    /* 10000000 00000000 00000000 00000000 >>> 1 = 01000000 00000000 00000000 00000000 */
    // 0x80000000 >>> 1 == 0x40000000

    /* 10000000 00000000 00000000 00000000 >> 1 = 11000000 00000000 00000000 00000000 */
    // 0x80000000 >> 1 == 0xC0000000

    System.out.println(10000001 | 00100000); /* turned on bit 5 */
    System.out.println(10000001 | 1 << 5); /* did the same thing */
    System.out.println(00000000 | 1 << 2 | 1 << 5);
    System.out.println(00000000 | 1 << 2 | 1 << 5);
    // You can turn off a bit by anding with a binary number of all 1's, except for the bit to be
    // set.
    System.out.println(01010101 & ~(1 << 2));
    System.out.println(01010101 & 11111011);

    System.out.println(Integer.parseInt("101", 2)); // creates an integer with the binary value of
                                                    // 101 (decimal 5).

    /* loops from 5 up to and including 15 */
    System.out.println("printing for loop in java: ");
    for (int b = Integer.parseInt("0101", 2); b <= Integer.parseInt("1111", 2); b++) {

      System.out.println(b);
      /* do stuff here */
    }
  }
}
