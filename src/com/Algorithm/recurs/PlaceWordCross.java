package com.Algorithm.recurs;

public class PlaceWordCross {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String word = "abc";

		// String[] words = new String[]{word, new
		// StringBuilder(word).reverse().toString()};

		// System.out.println(words[1]);

		char[][] board = new char[3][3];

		// we need to fill other values with space. In java empty and space are two
		// different things
		board[0][0] = '#';
		board[0][1] = ' ';
		board[0][2] = '#';
		board[1][0] = ' ';
		board[1][1] = ' ';
		board[1][2] = '#';
		board[2][0] = '#';
		board[2][1] = 'c';
		board[2][0] = ' ';

//		 for (char[] row : board) {
//			 //System.out.println(row);
//			 
//			 String [] arr = new String(row).split("#");
//			 
//			 String str = String.join("", arr);
//			 
//			 System.out.println("output:");
//			 System.out.println(str);
//			 System.out.println(str.length());
//		 }

		PlaceWordCross wordCross = new PlaceWordCross();
		System.out.println(wordCross.placeWordInCrossword(board, word));

	}

	public boolean placeWordInCrossword(char[][] board, String word) {
		// we need to get all possible word horizontally and vertically

		char[][] reversedBoard = new char[board[0].length][board.length];

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				reversedBoard[j][i] = board[i][j];
			}
		}

		String[] words = new String[] { word, new StringBuilder(word).reverse().toString() };
		return helper(board, words) || helper(reversedBoard, words);
	}

	public boolean helper(char[][] board, String[] words) {

		for (char[] row : board) {

			String[] strs = new String(row).split("#");

			for (String eachword : words) {
				for (String str : strs) {
					if (str.length() == eachword.length()) {

						int k = 0;
						while (k < str.length() && (str.charAt(k) == ' ' || str.charAt(k) == eachword.charAt(k))) {
							k++;
						}

						if (k == str.length()) {
							return true;
						}
					}
				}
			}
		}

		return false;
	}

}
