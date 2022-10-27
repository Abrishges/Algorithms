package com.Algorithm.string;

import java.util.Arrays;

//Build longest prefix , suffix of a string
public class LPSString {

	public static void main(String[] args) {

		String str = "mbadm$mdabm";

		LPSString lps = new LPSString();
		System.out.println(Arrays.asList(Arrays.toString(lps.LPSOfString(str))));
		System.out.println(Arrays.asList(Arrays.toString(lps.LPSOfString2(str))));
	}

	public int[] LPSOfString(String str) {
		int slen = str.length();

		int[] lps = new int[slen];
		if (slen <= 1)
			return lps;

		int i = 0;

		for (int j = 1; j < slen; j++) {
			if (str.charAt(j) == str.charAt(i)) {
				lps[j] = lps[j - 1] + 1;
				i++;
			} else {
				i = 0;
			}
		}

		return lps;
	}

	public int[] LPSOfString2(String s) {
		int n = s.length();

		int lps[] = new int[n];
		lps[0] = 0; // lps[0] is always 0
		
		// length of the previous
		// longest prefix suffix
		int len = 0;

		// the loop calculates lps[i]
		// for i = 1 to n-1
		int i = 1;
		while (i < n) {
			if (s.charAt(i) == s.charAt(len)) {
				len++;
				lps[i] = len;
				i++;
			}

			// (pat[i] != pat[len])
			else {
				// This is tricky. Consider
				// the example. AAACAAAA
				// and i = 7. The idea is
				// similar to search step.
				if (len != 0) {
					len = lps[len - 1];

					// Also, note that we do
					// not increment i here
				}

				// if (len == 0)
				else {
					lps[i] = 0;
					i++;
				}
			}
		}
		
		return lps;
	}
}
