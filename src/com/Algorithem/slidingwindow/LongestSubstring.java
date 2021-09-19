package com.Algorithem.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LongestSubstring longSub = new LongestSubstring();
		String str = "abcbdbdbbdcdabd";
		int k = 5;
		String substr = longSub.longestSubstring(str, k);
		System.out.println(substr);
	}

	public String longestSubstring(String str, int k) {

		if (str == null || str.length() == 0) {
			return str;
		}

		int count = 0;
		int left = 0;
		int right = 0;

		Map<Character, Integer> mp = new HashMap<Character, Integer>();

		for (int j = 0, i = 0; j < str.length(); j++) {
			if (!mp.containsKey(str.charAt(j))) {
				count++;
			}

			mp.merge(str.charAt(j), 1, Integer::sum);

			while (count > k) {

				int value = mp.get(str.charAt(i));

				if (value == 1) {
					mp.remove(str.charAt(i));
					count--;
				} else {
					value--;
					mp.put(str.charAt(i), value);
				}

				i++;
			}

			if (count <= k && j - i > right - left) {
				right = j;
				left = i;
			}

		}

		return str.substring(left, right + 1);
	}

}
