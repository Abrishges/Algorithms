package com.Algorithm.trees;

import java.util.HashMap;
import java.util.Map;

/*
 *  TrieNode basic CRUD operations, it is simple
 */
public class Trie {
	
   private final TrieNode root;
   
	private class TrieNode {
		private Map<Character, TrieNode> child;
		private Boolean isLeaf;
		
		public TrieNode() {
			child = new HashMap<>();
			isLeaf = false;
		}
		
		public Map<Character, TrieNode> getChild() {
			return child;
		}
	}
	
	public Trie() {
		this.root = new TrieNode();
	}
	
	//Iterative method of insertion
	public void insert(String word) {
		
		TrieNode current = root;
				
		for (int i = 0; i < word.length(); i++) {
			
			Character ch = word.charAt(i);
			
			if (!current.getChild().containsKey(ch)) {
				TrieNode newNode = new TrieNode();
				current.getChild().put(ch, newNode);
			}
			
			current = current.getChild().get(ch);	
		}
		
		current.isLeaf = true;	 
	}
	
	public void insertRecursive(String word) {
		insertRecursive(root, word, 0 );
	}
	
	//Recursive method of insertion
	private void insertRecursive(TrieNode current, String word, int index) {
		
		if(index == word.length()) {
			current.isLeaf = true;
			return;
		}
		    Character ch = word.charAt(index);	     
			if (!current.getChild().containsKey(ch)) {
				TrieNode newNode = new TrieNode();
				current.getChild().put(ch, newNode);
			}
			
			current = current.getChild().get(ch);
			
       insertRecursive(current, word, index++);
	}
	
	//search
	public Boolean search(String word) {
		 
		TrieNode current = root;
		
		for (int i = 0; i < word.length(); i++) {
			
			 Character ch = word.charAt(i);
			 
			 if (current.getChild().containsKey(ch)) {
				 current = current.getChild().get(ch);	 
			 } else {
				 return false;
			 }
		}
		
		return current.isLeaf;
	}
	
	//Recursive search
	public Boolean searchRecursive(String word) {
		return searchRecursive(root, word, 0);
	}
	
	private Boolean searchRecursive(TrieNode current, String word, int index) {
		
		 if (index == word.length()) {
			 return current.isLeaf;
		 }
		
		 Character ch = word.charAt(index);
		 
		 if (current.getChild().containsKey(ch)) {
			 current = current.getChild().get(ch);	 
		 } else {
			 return false;
		 }
		 
	    return searchRecursive(current, word, index++);  
	}
	
	// prefix search method 
	
	// Delete word from Trie 
	// Also write a method that deletes all words that start with some prefix 
	// Sorting
	
	public Boolean delete(String word) {
		return delete(root, word, 0);
	}
	
	private Boolean delete(TrieNode current, String word, int index) {
		   if (index == word.length()) {
	            //when end of word is reached only delete if currrent.endOfWord is true.
	            if (!current.isLeaf) {
	                return false;
	            }
	            current.isLeaf = false;
	            //if current has no other mapping then return true
	            // I am confused here, should it be 1? 
	            return current.child.size() == 0;
	        }

	        TrieNode node = current.child.get(word.charAt(index));
	        if (node == null) {
	            return false;
	        }
	        
	        boolean shouldDeleteCurrentNode = delete(node, word, index + 1);

	        //if true is returned then delete the mapping of character and trienode reference from map.
	        if (shouldDeleteCurrentNode) {
	            current.child.remove(word.charAt(index));
	            //return true if no mappings are left in the map.
	            return current.child.size() == 0;
	        }
	        
	        return false;
	}
}