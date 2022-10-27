package com.Algorithm.recurs;

public class MatchWildcardBT {

	public static void main(String[] args) {

	}

	// Using backtracking. This is the best method
	// it runs in 2ms
	public boolean isMatchBT(String s, String p) {

		int slen = s.length();
		int plen = p.length();
		int i = 0, j = 0;
		int ib = -1, jb = -1; // For backtracking

		while (i < slen) {

			// if both chars at i and j match, increase both
			if (j < plen && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
				i++;
				j++;
			} else if (j < plen && p.charAt(j) == '*') {
				// Two options, * doesn't match any char or it match
				jb = j;
				ib = i;
				j++;

			} else if (jb == -1) {
				return false;
			} else {
				// backtrack and increment one char assuming that it match one char
				j = jb + 1;
				i = ib + 1;

				ib = i;
			}

		}

		for (int k = j; k < plen; k++) {
			if (p.charAt(k) != '*')
				return false;
		}

		return true;
	}
}
