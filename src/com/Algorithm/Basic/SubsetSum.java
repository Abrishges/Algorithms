package com.Algorithm.Basic;

public class SubsetSum {

  public boolean subsetSum(final int input[], final int total) {

    final boolean T[][] = new boolean[input.length + 1][total + 1];
    for (int i = 0; i <= input.length; i++) {
      T[i][0] = true;
    }

    for (int i = 1; i <= input.length; i++) {
      for (int j = 1; j <= total; j++) {
        if (j - input[i - 1] >= 0) {
          T[i][j] = T[i - 1][j] || T[i - 1][j - input[i - 1]];
        } else {
          T[i][j] = T[i - 1][j];
        }
      }
    }

    // This part of the code prints the numbers
    if (T[input.length][total]) {
      for (int i = input.length, j = total; i > 0 || j > 0; i--) {
        if (!T[i - 1][j]) {
          System.out.print(input[i - 1] + ",");
          j = j - input[i - 1];
        }
      }
    }

    return T[input.length][total];
  }

  public boolean partition(final int arr[]) {
    int sum = 0;
    for (int i = 0; i < arr.length; i++) {
      sum += arr[i];
    }

    if (sum % 2 != 0) {
      return false;
    }
    sum = sum / 2;
    final boolean[][] T = new boolean[arr.length + 1][sum + 1];

    for (int i = 0; i <= arr.length; i++) {
      T[i][0] = true;
    }

    for (int i = 1; i <= arr.length; i++) {
      for (int j = 1; j <= sum; j++) {
        if (j - arr[i - 1] >= 0) {
          T[i][j] = T[i - 1][j - arr[i - 1]] || T[i - 1][j];
        } else {
          T[i][j] = T[i - 1][j];
        }
      }
    }
    return T[arr.length][sum];
  }

  public static void main(final String args[]) {
    final SubsetSum ss = new SubsetSum();
    final int arr[] = {1, 3, 5, 5, 2, 1, 1, 6};
    System.out.println(ss.partition(arr));

    final int arr1[] = {2, 3, 7, 8};
    System.out.print(ss.subsetSum(arr1, 11));

  }
}
