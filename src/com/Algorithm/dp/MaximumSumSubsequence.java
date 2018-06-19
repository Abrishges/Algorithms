package com.Algorithm.dp;

public class MaximumSumSubsequence {

  public static void main(final String args[]) {
    final int[] arr = {4, 6, 1, 3, 8, 4, 6};
    System.out.println(maxSubSubsequence(arr));
    final int[] arr2 = {4, 6, 3, 4, 8, 6, 7};
    System.out.println(maxSubSubsequence(arr2));
  }

  public static int maxSubSubsequence(final int arr[]) {
    final int temp[] = new int[arr.length];
    final int previousIndex[] = new int[arr.length];

    for (int i = 0; i < arr.length; i++) {
      temp[i] = arr[i];
      previousIndex[i] = i;
    }

    for (int j = 1; j < arr.length; j++) {
      for (int i = 0; i < j; i++) {
        if (arr[i] < arr[j]) {
          final int newValue = temp[i] + arr[j];
          if (newValue > temp[j]) {
            temp[j] = newValue;
            previousIndex[j] = i;
          }
        }
      }
    }
    // Searching for the max value and index of the max value
    int max = 0;
    int index = 0;
    for (int k = 0; k < arr.length; k++) {
      if (temp[k] > max) {
        max = temp[k];
        index = k;
      }
    }
    // subsequence numbers
    int tempMax = max;
    while (tempMax != 0) {
      System.out.print(arr[index] + ",");
      tempMax -= arr[index];
      index = previousIndex[index];
    }
    System.out.println();
    return max;
  }
}
