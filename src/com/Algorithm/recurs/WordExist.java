package com.Algorithm.recurs;
//https://leetcode.com/problems/word-search/
public class WordExist {

	public static void main(String[] args) {
		WordExist ex = new WordExist();

		char[][] board = { {'A'} };

		String word = "A";
		System.out.println(ex.exist(board, word));
	}

	public boolean exist(char[][] board, String word) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == word.charAt(0)) {
					if (helper(board, i, j, 0, word)) {
						return true;
					}
				}
			}
		}

		return false;
	}

	public boolean helper(char[][] board, int i, int j, int k, String word) {
		if (k >= word.length()) {
			return true;
		}

		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(k))
			return false;


		board[i][j] = '#';   // board[i][j] ^= "256"  and also board[i][j] ^= "256" at the end

		boolean result = helper(board, i - 1, j, k + 1, word)
				       || helper(board, i, j - 1, k + 1, word)
				       || helper(board, i + 1, j, k + 1, word)
				       || helper(board, i, j + 1, k + 1, word);

		board[i][j] = word.charAt(k);
		return result;
	}
}
