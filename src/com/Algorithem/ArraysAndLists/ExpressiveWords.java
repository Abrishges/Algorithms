package com.Algorithem.ArraysAndLists;

public class ExpressiveWords {

	public static void main(String[] args) {

		String s = "dddiiiinnssssssoooo";
		String[] t = { "dinnssoo", "ddinso", "ddiinnso", "ddiinnssoo", "ddiinso", "dinsoo", "ddiinsso", "dinssoo",
				"dinso" };

		System.out.println(expressiveWords(s, t));
	}

	public static int expressiveWords(String s, String[] words) {

		if (s == null || words == null)
			return 0;

		int result = 0;

		for (String word : words) {
			result += validate(s, word);
		}

		return result;
	}

	public static int validate(String s, String t) {

		if (s.length() <= t.length() || t == null)
			return 0;

		int i = 0, j = 0;

		while (i < s.length() && j < t.length()) {

			if (s.charAt(i) == t.charAt(j)) {

				int len1 = findLength(s, i);
				int len2 = findLength(t, j);

				if (len1 < 3 && len1 != len2 || len1 >= 3 && len1 < len2) {
					return 0;
				}

				i = i + len1;
				j = j + len2;
			} else {
				return 0;
			}
		}

		return i == s.length() && j == t.length() ? 1 : 0;
	}

	public static int findLength(String str, int idx) {
		int i = idx;
		int len = 0;
		while (i < str.length() && str.charAt(i) == str.charAt(idx)) {
			len++;
			i++;
		}

		return len;
	}
}
