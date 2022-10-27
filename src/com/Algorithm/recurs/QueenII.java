package com.Algorithm.recurs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//https://leetcode.com/problems/n-queens/
//queens three is better solution
public class QueenII {

	public static void main(String[] args) {

		int n = 5;
		QueenII queen = new QueenII();
		System.out.println(queen.nQueens(n));

	}

	public List<List<String>> nQueens(int n) {

		String[][] array = new String[n][n];

		Set<Integer> cset = new HashSet<Integer>();
		Set<Integer> adset = new HashSet<Integer>();
		Set<Integer> dset = new HashSet<Integer>();

		List<List<String>> result = new ArrayList<List<String>>();

		backTrackQueens(array, 0, cset, adset, dset, result);

		return result;
	}

	public void backTrackQueens(String[][] arry, int row, Set<Integer> cset, Set<Integer> dset, Set<Integer> adset,
			List<List<String>> result) {

		for (int col = 0; col < arry.length; col++) {
			int dia = row - col;
			int adia = row + col;
			if (!cset.contains(col) && !dset.contains(dia) && !adset.contains(adia)) {

				arry[row][col] = "Q";
				cset.add(col);
				dset.add(dia);
				adset.add(adia);

				if (row + 1 == arry.length) {
					// we reach the bottom, i.e. we find a solution!
					List<String> list = twoDArrayToList(arry);
					result.add(list);

				} else {
					backTrackQueens(arry, row + 1, cset, dset, adset, result);
				}
				// undo
				arry[row][col] = null;
				cset.remove(col);
				dset.remove(dia);
				adset.remove(adia);
			}
		}

		return;
	}

	public List<String> twoDArrayToList(String[][] array) {

		StringBuilder sb = new StringBuilder();
		List<String> list = new ArrayList<String>();

		for (String[] arr : array) {
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] == null) {
					sb.append(".");
				} else {
					sb.append(arr[i]);
				}
			}

			list.add(sb.toString());
			sb.setLength(0);
		}

		return list;
	}
}
