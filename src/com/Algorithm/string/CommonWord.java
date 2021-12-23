package com.Algorithm.string;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//Given a string paragraph and a string array of the banned words banned, 
//return the most frequent word that is not banned.
public class CommonWord {

	public static void main(String[] args) {
	
		
//		String str2 = " hell 1 1 2, hello 3! ";
//		
//		String [] arr = str2.trim().split("\\s+");
//		
//		String [] arr2 = str2.trim().split("[^\\w]");
//		
//		String [] arr3 = str2.trim().split("\\,|\\s+|\\!|\\_|\\-");
//		System.out.println(Arrays.toString(arr3));
		
		String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
		String par = "Bob. hIt, baLl";
		String [] arr = {"bob", "hit"};
		
		CommonWord cw = new CommonWord();
		String common = cw.mostCommonWord(par, arr);
		System.out.println(common);
	}

	public String mostCommonWord(String paragraph, String[] arr) {
		
		  // 1). replace the punctuations with spaces,
        // and put all letters in lower case
        String normalizedStr = paragraph.replaceAll("[^a-zA-Z0-9 ]", " ").toLowerCase();

        // 2). split the string into words
        String[] words = normalizedStr.split("\\s+");

        Set<String> bannedWords = new HashSet<String>();
        for (String word : arr)
            bannedWords.add(word);

        Map<String, Integer> wordCount = new HashMap<String, Integer>();
        // 3). count the appearance of each word, excluding the banned words
        for (String word : words) {
            if (!bannedWords.contains(word))
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // 4). return the word with the highest frequency
        return Collections.max(wordCount.entrySet(), Map.Entry.comparingByValue()).getKey();
	}
}
