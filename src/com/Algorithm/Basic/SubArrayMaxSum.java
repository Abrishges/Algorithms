package com.Algorithm.Basic;

public class SubArrayMaxSum {

  public static void main(final String args[]) {
    final int arr[] = {-2, 2, 4, 1, 7, 5, 3, 1};
    System.out.println(maxSumArray(arr));
    final int arr2[] = {-2, -3, 4, -1, -2, 1, 5, -3};
    System.out.println(maxSumArray(arr2));
    final int arr3[] = {-2, -3, -4, -1, -2, -1, -5, -3};
    System.out.println(maxSumArray(arr3));
  }

  public static int maxSumArray(final int[] arr) {
    int maxSoFar = arr[0];
    int subArrayMaxSum = arr[0];
    int startIndex = 0;
    int finalIndex = 0;

    for (int i = 0; i < arr.length; i++) {
      maxSoFar = Math.max(arr[i], maxSoFar + arr[i]);
      if (arr[i] > (maxSoFar + arr[i])) {
        startIndex = i;
      }
      if (maxSoFar > subArrayMaxSum) {
        subArrayMaxSum = maxSoFar;
        finalIndex = i;
      }
    }

    System.out.println(startIndex + "," + finalIndex);
    return subArrayMaxSum;
  }
}
