package com.Algorithm.Basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Facebook question
 * It's important to note that unlike C or C++, the length of the elements of a two-dimensional
 * array in Java need not be equal. int[][] pathList = new int[6][4]. pathList.length gives you
 * six and pathList[0].length gives you 4
 */

public class MergeIntervals {

  public static void main(final String args[]) {

    System.out.println("Basic java array");

    final int array1[] = {1, 3};
    final int array2[] = {9, 0};
    final int array3[] = {5, 6};
    final int array4[] = {-4, -5, -2, -3, -1};

    final int[][] input = {array1, array2, array3, array4};

    for (final int[] array : input) {
      System.out.println(Arrays.toString(array));
    }

    System.out.println(mergeIntervals(input));
  }

  public static List<Integer> mergeIntervals(final int[][] input) {

    int max = 0;
    final List<Integer> temp = new ArrayList<>();

    for (final int[] array : input) {
      if (array.length > max) {
        max = array.length;
      }
    }

    for (int k = 0; k < max; k++) {
      for (int j = 0; j < input.length; j++) {
        if (k < input[j].length) {
          temp.add(input[j][k]);
        }
      }
    }
    return temp;
  }
}
