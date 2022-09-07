package com.Algorithm.recurs;

import java.util.ArrayList;
import java.util.List;

public class WordSearch {

	public static void main(String[] args) {

		//[["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
		
		WordSearch ex = new WordSearch();

//		char[][] board = { {'o','a','a','n'}, {'e','t','a','e'}, {'i','h','k','r'}, {'i','f','l','v'}};
//		String [] word = { "oath","pea","eat","rain" };
		
		//[["a","b"],["c","d"]], words = ["abcb"]
//		char[][] board = { {'a','b'}, {'c','d'}};
//		String [] word = { "abcb"};
		
//		[["o","a","b","n"],["o","t","a","e"],["a","h","k","r"],["a","f","l","v"]]
//				["oa","oaa"]
		
		char[][] board = { {'o','a','b','n'}, {'o','t','a','e'}, {'a','h','k','r'}, {'a','f','l','v'}};
		String [] word = {"oa","oaa"};
		
		
		System.out.println(ex.exist(board, word));
	}

	public List<String> exist(char[][] board, String[] words) {
		
	  List<String> result = new ArrayList<String>();
		
	  for(String word : words) {
		  //we can move this to another method and use return statement
		  loop2: for (int i = 0; i < board.length; i++) {
			 for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == word.charAt(0)) {
					if (helper(board, i, j, 0, word)) {
						result.add(word);
						break loop2;
					}
				}
			}
		}
	  }

		return result;
	}
	

	public boolean helper(char[][] board, int i, int j, int k, String word) {
		if (k >= word.length()) {
			return true;
		}

		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(k))
			return false;

		board[i][j] = '#';

		boolean result = helper(board, i - 1, j, k + 1, word)
				       || helper(board, i, j - 1, k + 1, word)
				       || helper(board, i + 1, j, k + 1, word)
				       || helper(board, i, j + 1, k + 1, word);

		board[i][j] = word.charAt(k);
		return result;
	}
}
