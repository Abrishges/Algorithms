package com.Algorithem.ArraysAndLists;

public class ReplaceString {

	public static void main(String[] args) {
		
		String s = "vmokgggqzp";
		int [] indices = {3, 5, 1};
		String [] sources = {"kg","ggq","mo"};
		String [] targets = {"s","so","bfr"};
		
		//"abcd", indices = [0, 2], sources = ["a", "cd"], targets = ["eee", "ffff"]
		
		System.out.println(findReplaceString(s, indices, sources, targets));

	}

	public static String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {

		StringBuilder sb = new StringBuilder();
		int i = 0;
		int idx = 0;

		for (String str : sources) {

			int len = str.length();
			int j = indices[idx];
			if (i != j) {
				sb.append(s.substring(i, j));
				i = i + j;
			}

			if (str.equals(s.substring(j, j + len))) {
				sb.append(targets[idx]);
				i = i + len;
			}
			idx++;
		}

		if (i < s.length() - 1) {
			sb.append(s.substring(i));
		}
		
		return sb.toString();
	}

}
