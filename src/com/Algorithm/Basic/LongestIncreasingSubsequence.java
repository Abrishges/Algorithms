package com.Algorithm.Basic;

public class LongestIncreasingSubsequence {

  /**
   * DP way of solving LIS
   */
  public int longestSubsequenceWithActualSolution(final int arr[]) {
    final int T[] = new int[arr.length];
    final int actualSolution[] = new int[arr.length];
    for (int i = 0; i < arr.length; i++) {
      T[i] = 1;
      actualSolution[i] = i;
    }

    for (int i = 1; i < arr.length; i++) {
      for (int j = 0; j < i; j++) {
        if (arr[i] > arr[j]) {
          if (T[j] + 1 > T[i]) {
            T[i] = T[j] + 1;
            // set the actualSolution to point to guy before me
            actualSolution[i] = j;
          }
        }
      }
    }

    // find the index of max number in T
    int maxIndex = 0;
    for (int i = 0; i < T.length; i++) {
      if (T[i] > T[maxIndex]) {
        maxIndex = i;
      }
    }

    // lets print the actual solution
    int t = maxIndex;
    int newT = maxIndex;
    do {
      t = newT;
      System.out.print(arr[t] + " ");
      newT = actualSolution[t];
    } while (t != newT);
    System.out.println();

    return T[maxIndex];
  }

  public static void main(final String args[]) {
    final LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
    final int arr[] = {23, 10, 22, 5, 33, 8, 9, 21, 50, 41, 60, 80, 99, 22, 23, 24, 25, 26, 27};
    final int result = lis.longestSubsequenceWithActualSolution(arr);
    System.out.println(result);
  }
}
