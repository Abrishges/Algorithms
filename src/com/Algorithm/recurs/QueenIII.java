package com.Algorithm.recurs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
//https://leetcode.com/problems/n-queens/solution/
// what is the time and memory complexity ? 
public class QueenIII {
	
	public static void main(String[] args) {

		int n = 4;
		QueenIII queen = new QueenIII();
		System.out.println(queen.solveNQueens(n));

	}

	public List<List<String>> solveNQueens(int n) {

		char[][] marray = new char[n][n];
		
		for (char [] array : marray) {
			Arrays.fill(array, '.');
		}

		Set<Integer> cset = new HashSet<Integer>();
		Set<Integer> adset = new HashSet<Integer>();
		Set<Integer> dset = new HashSet<Integer>();

		List<List<String>> result = new ArrayList<List<String>>();

		backTrackQueens(marray, 0, cset, adset, dset, result);

		return result;
	}

	public void backTrackQueens(char[][] mArray, int row, Set<Integer> cset, Set<Integer> dset, Set<Integer> adset,
			List<List<String>> result) {
		
		
		if (row == mArray.length) {
			// we reach the bottom, i.e. we find a solution!
			List<String> list = twoDArrayToList(mArray);
			result.add(list);
		   return;
		}

		for (int col = 0; col < mArray.length; col++) {
			int dia = row - col;
			int adia = row + col;
			if (!cset.contains(col) && !dset.contains(dia) && !adset.contains(adia)) {

				mArray[row][col] = 'Q';
				cset.add(col);
				dset.add(dia);
				adset.add(adia);

				backTrackQueens(mArray, row + 1, cset, dset, adset, result);
				
				// undo
				mArray[row][col] = '.';
				cset.remove(col);
				dset.remove(dia);
				adset.remove(adia);
			}
		}

		return;
	}
	

	public List<String> twoDArrayToList(char[][] mArray) {

		List<String> list = new ArrayList<String>();
		for (int i = 0; i < mArray.length; i++) {
	        String str = new String(mArray[i]);
			list.add(str);

		}
		return list;
	}
}
