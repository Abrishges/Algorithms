package com.Algorithm.recurs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/word-squares/solution/
//This problem can also be solved using Trie 
public class WordSquares {

	private static Map<String, List<String>> prefixMap;

	public static void main(String[] args) {

		String[] words = { "area", "lead", "wall", "lady", "ball" };

		WordSquares ws = new WordSquares();
		List<List<String>> result = ws.wordSquares(words);
		System.out.println(result);
	}

	public List<List<String>> wordSquares(String[] words) {

		// result
		List<List<String>> result = new ArrayList<List<String>>();
		int wordLength = words[0].length();
		buildPrefix(words);
		// build prefix hashMap

		for (String word : words) {

			List<String> wordSquares = new ArrayList<String>();
			wordSquares.add(word);
			backTracking(1, wordLength, wordSquares, result);
		}

		return result;
	}

	public void backTracking(int index, int wordLength, List<String> wordSquares, List<List<String>> result) {

		// base case
		if (index == wordLength) {
			// we found word square list
			List<String> temp = new ArrayList<String>(wordSquares);
			result.add(temp);
			// What if we don't have return
			return;
		}

		// build prefix for each recursive call
		StringBuilder prefix = new StringBuilder();
		for (String strWord : wordSquares) {
			prefix.append(strWord.charAt(index));
		}

		// Get List of words for prefix
		// This can be null and it might cause error
		List<String> listOfWords = prefixMap.get(prefix.toString());

		listOfWords = listOfWords != null ? listOfWords : new ArrayList<String>();
		// for each word make recursive call
		for (String word : listOfWords) {
			wordSquares.add(word);
			backTracking(index + 1, wordLength, wordSquares, result);
			wordSquares.remove(wordSquares.size() - 1);
		}
	}

	public static void buildPrefix(String[] words) {

		prefixMap = new HashMap<String, List<String>>();
		int n = words[0].length();

		List<String> list;
		for (String word : words) {
			for (int i = 1; i < n; i++) {

				String substr = word.substring(0, i);

				if (!prefixMap.containsKey(substr)) {
					list = new ArrayList<String>();
					prefixMap.put(substr, list);
				}

				list = prefixMap.get(substr);
				list.add(word);
			}
		}
	}
}
