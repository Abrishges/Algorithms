package com.Algorithm.recurs;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/n-queens-ii/
//what is time and memory complexity
public class Queen {

	public static void main(String[] args) {

		int n = 4;
		Queen queen = new Queen();
		System.out.println(queen.totalNQueens(n));

	}

	public int totalNQueens(int n) {

		//String[][] array = new String[n][n];

		Set<Integer> cset = new HashSet<Integer>();
		Set<Integer> adset = new HashSet<Integer>();
		Set<Integer> dset = new HashSet<Integer>();

		return backTrackQueens(n, 0, cset, dset, adset);
	}

	public int backTrackQueens(int size, int row, Set<Integer> cset, Set<Integer> dset, Set<Integer> adset) {
		
		if (row == size) {
			return 1;
		}

		int result = 0;
		for (int col = 0; col < size; col++) {
			int dia = row - col;
			int adia = row + col;
			if (!cset.contains(col) && !dset.contains(dia) && !adset.contains(adia)) {

				//arry[row][col] = "q";
				cset.add(col);
				dset.add(dia);
				adset.add(adia);


			    result += backTrackQueens(size, row + 1, cset, dset, adset);

				// undo
				//arry[row][col] = null;
				cset.remove(col);
				dset.remove(dia);
				adset.remove(adia);
			}
		}

		return result;
	}
}
