package com.Algorithm.recurs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordSearchII {

	class TrieNode {
		Map<Character, TrieNode> child;
		String word;

		public TrieNode() {
			this.child = new HashMap<Character, TrieNode>();
			this.word = null;
		}
	}

	public static void main(String[] args) {
		
		WordSearchII wordSearch = new WordSearchII();
		
		char[][] board = { {'o','a','a','n'}, {'e','t','a','e'}, {'i','h','k','r'}, {'i','f','l','v'}};				
		String [] word = {"oath","oathk"};
		
		//["oath","oathk","oathf","oathfi","oathfii","oathi","oathii","oate","eat"]
		System.out.println(wordSearch.findWords(board, word));
	}

	public List<String> findWords(char[][] board, String[] words) {

		TrieNode root = new TrieNode();
		// create Trie data structure
		for (String word : words) {
			TrieNode trieNode = root;
			for (Character ch : word.toCharArray()) {

				if (!trieNode.child.containsKey(ch)) {
					TrieNode node = new TrieNode();
					trieNode.child.put(ch, node);
				}

				trieNode = trieNode.child.get(ch);
			}

			trieNode.word = word;
		}

		List<String> list = new ArrayList<String>();
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {
				if (root.child.containsKey(board[row][col])) {
					helper(board, row, col, root, list);

				}
			}
		}
		return list;
	}

	// Backtracking function
	public void helper(char[][] board, int row, int col, TrieNode parent, List<String> list) {
    
    	//base case here
    	if (parent.word != null) {
    		list.add(parent .word);
    		parent .word = null;
    		//we shouldn't have return statement here, in case oath and oathk
    		//return;
    	}
    	
    	if (row >= board.length || row < 0 ||
    			col >= board[0].length || col < 0 || !parent.child.containsKey(board[row][col])) {
    		return;
    	}
    	
		Character ch = board[row][col];
    	TrieNode curNode = parent.child.get(ch);
    
    	board[row][col] = '#';
    	helper(board, row, col + 1, curNode, list);
    	helper(board, row, col - 1, curNode, list);
    	helper(board, row + 1, col, curNode, list);
    	helper(board, row - 1, col, curNode, list);
    	
    	board[row][col] = ch;
    	
    	 // Optimization: incrementally remove the leaf nodes
    	if (curNode.child.isEmpty()) {
    		parent.child.remove(ch);
    	}
    }
}