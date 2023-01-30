package com.Algorithem.ArraysAndLists;

//This one is a different question
// https://leetcode.com/problems/search-a-2d-matrix/
public class SearchMatrix2D2 {

	public static void main(String[] args) {

		SearchMatrix2D2 matrix = new SearchMatrix2D2();

		int[][] arr = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };

		System.out.println(matrix.searchMatrixBinaryColRaw(arr, 11));
	}

	public boolean searchMatrix(int[][] matrix, int target) {

		int col = matrix[0].length;
		if (matrix == null || (matrix.length == 0 && col == 0))
			return false;

		for (int i = 0; i < matrix.length; i++) {

			if (target == matrix[i][col - 1])
				return true;

			if (target < matrix[i][col - 1]) {
				return search(matrix, i, 0, col - 1, target);
			}
		}

		return false;
	}

	// This can be improved by doing column binary search too
	public boolean search(int[][] arr, int raw, int l, int r, int target) {

		if (l <= r) {

			int mid = l + (r - l) / 2;

			if (target == arr[raw][mid])
				return true;

			if (target < arr[raw][mid]) {
				return search(arr, raw, l, mid - 1, target);
			} else if (target > arr[raw][mid]) {
				return search(arr, raw, mid + 1, r, target);
			}
		}

		return false;
	}

	// The most efficient answer
	public boolean searchMatrixBinary(int[][] arr, int target) {

		int n = arr.length;
		if (n == 0)
			return false;
		int m = arr[0].length;

		int left = 0;
		int right = n * m - 1;

		while (left <= right) {
			int pivot = (right + left) / 2;

			int raw = pivot / m;
			int col = pivot % m;

			if (target == arr[raw][col])
				return true;

			if (target < arr[raw][col]) {
				right = pivot - 1;
			} else {
				left = pivot + 1;
			}
		}

		return false;
	}

	// we can also binary search in raw and column
	public boolean searchMatrixBinaryColRaw(int[][] arr, int target) {

		// Binary search over column first then binary search over raw. The other way
		// round will not work
		int n = arr.length;
		if (n == 0)
			return false;
		int m = arr[0].length;

		int top = 0;
		int bottom = n - 1;

		while (top <= bottom) {
			int mid = top + (bottom - top) / 2;

			if (target == arr[mid][0])
				return true;

			if (target < arr[mid][0]) {
				bottom = mid - 1;
			} else {
				top = mid + 1;
			}
		}

		// if we don't have answer so far, we car search over column
		if (bottom < 0 || bottom > n - 1)
			return false;

		int raw = bottom;
		int left = 0;
		int right = m - 1;

		// raw binary search
		while (left <= right) {
			int mid = left + (right - left) / 2;

			if (target == arr[raw][mid])
				return true;

			if (target < arr[raw][mid]) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

		return false;
	}
}
