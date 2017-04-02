/**
 * 
 */
package com.Algorithm.test;

/**
 * @author aberehamwodajie
 *
 *         Feb 4, 2017
 */
public class StringCheck {

	public static void main(String args[]) {
		System.out.println(stringCheck("barbazfoo", "oobarbazf"));
	}

	public static boolean stringCheck(String s1, String s2) {
		String s = s1 + s1;
		
		//String s6 = "abc" + "bca";
		
		System.out.println("String sum: " + s);
		//System.out.println("String sum: " + s6);
		if (s1.length() == s2.length()) {
			return s.contains(s2);
		} else {
			return false;
		}
	}

}
