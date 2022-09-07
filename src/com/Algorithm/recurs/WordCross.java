package com.Algorithm.recurs;

public class WordCross {

	public static void main(String[] args) {
		

	}
	
    public boolean placeWordInCrossword(char[][] board, String word) {
        
    	for (int i = 0; i < board.length; i++) {
    		for (int j = 0; j< board[0].length; j++) {
    			if (board[i][i] == word.charAt(0)) {
    				if (helper(board, i, j , word, 0)) {
    					return true;
    				}
    			}
    		}
    	}
    	
    	return false;
    }
    
    //backtracking method
    public boolean helper(char[][] board, int i , int j, String word, int k) {
    	int n = board.length;
    	int m = board[0].length;
    	
    	//true base case 
    	
    	//false base here, here we need to check also if n - i != word lenght & 
    	if (i < 0 || i >= n|| j < 0 || j >= m || board[i][j] != word.charAt(k)) {
    		return false;
    	}
    	
    	 // mark visited cell
    	boolean result = helper(board, i, j + 1, word, k + 1) || helper(board, i + 1, j, word, k + 1);
    	//unmark visited cell
    	return result; 
    }

}