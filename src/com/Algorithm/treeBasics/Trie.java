package com.Algorithm.treeBasics;

import java.util.HashMap;
import java.util.Map;

// https://www.techiedelight.com/implement-trie-data-structure-java/
/*
 * Tries used in autocomplete 
 * Spell checker 
 * Ip routing
 */
class Trie {

	public static void main(String arg[]) {
		Trie trie = new Trie();
		String str = "apple";
		trie.insert(str);

		System.out.println(trie.search(str));
		System.out.println(trie.search("app"));
		System.out.println(trie.delete(str));
		System.out.println(trie.startsWith("app"));
		trie.insert("app");
		System.out.println(trie.search("app"));
	}

	class TrieNode {
		Map<Character, TrieNode> child;
		boolean isLeaf;

		public TrieNode() {
			child = new HashMap<Character, TrieNode>();
			isLeaf = false;
		}

	}

	TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	public void insert(String str) {

		insert(str, root, 0);
	}

	public void insert(String str, TrieNode cur, int i) {

		if (i == str.length()) {
			cur.isLeaf = true;
			return;
		}

		Character ch = str.charAt(i);
		if (!cur.child.containsKey(ch)) {
			TrieNode node = new TrieNode();
			cur.child.put(str.charAt(i), node);
		}

		cur = cur.child.get(ch);

		insert(str, cur, i + 1);
	}

	// Iterative approach
	public void insertIterative(String str) {
		insertIterative(str, root);
	}

	public void insertIterative(String str, TrieNode cur) {

		for (int i = 0; i < str.length(); i++) {
			if (!cur.child.containsKey(str.charAt(i))) {
				TrieNode node = new TrieNode();
				cur.child.put(str.charAt(i), node);
			}
			cur = cur.child.get(str.charAt(i));
		}

		cur.isLeaf = true;
	}

	public boolean search(String word) {
		return search(word, root, 0);
	}

	public boolean search(String word, TrieNode cur, int i) {

		if (i == word.length())
			return cur.isLeaf;

		if (!cur.child.containsKey(word.charAt(i))) {
			return false;
		}

		cur = cur.child.get(word.charAt(i));

		return search(word, cur, i + 1);
	}

	//Iterative approach
	public boolean searchIterative(String str) {

		return searchIterative(str, root);
	}
	
	public boolean searchIterative(String str, TrieNode root) {
		
	   for (int i = 0; i < str.length(); i++) {
		   if(!root.child.containsKey(str.charAt(i))) {
			   return false; 
		   }
		   root = root.child.get(str.charAt(i));
	   }
	   
	   return root.isLeaf;
	}

	public boolean startsWith(String prefix) {
		return startsWith(prefix, root, 0);
	}

	public boolean startsWith(String word, TrieNode current, int i) {

		if (i == word.length()) {
			return true;
		}

		if (current.child.containsKey(word.charAt(i))) {
			current = current.child.get(word.charAt(i));
		} else {
			return false;
		}

		return startsWith(word, current, i + 1);
	}

	// TODO
	public boolean delete(String str) {
         
		return delete(str, root, 0);
	}
	
	public boolean delete(String str, TrieNode cur, int i) {
		
		if(i == str.length()) {
			
			if(!cur.isLeaf) {
				return false;
			}
			
			cur.isLeaf = false;
			
			return cur.child.size() == 0;
		}
		
		Character ch = str.charAt(i);
		if (!cur.child.containsKey(ch)) {
			return false;
		}
		
		//Here we need to track current node and next node
		TrieNode node = cur.child.get(ch);

		boolean isOkToDelete = delete(str, node, i + 1);
		
		//Time is flying here
		if(isOkToDelete) {
			cur.child.remove(ch);
			
			return cur.child.size() == 0;
		}
		
		return false;
	}

	// Trie implementation of
	// search prefix
	// search word
	// insert
	// delete
	// Think about recursive vs iterative version
	// what is the difference b/n list vs map implementation

	// For list implementation, try to write iterative function for insert and
	// search implementation
}
