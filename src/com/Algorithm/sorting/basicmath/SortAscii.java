package com.Algorithm.sorting.basicmath;

public class SortAscii {

	public static void main(String[] args) {
		SortAscii asciiSort = new SortAscii();
		String str =  "Geeks&&ForGeeks*+";
		System.out.println(asciiSort.sortAscii(str));
	}
	
	
	public String sortAscii(String str) {
		
		int [] freq = new int[256];
		
		for (int i = 0 ; i < str.length(); i++) {
			 freq[(int)str.charAt(i)]++;
		}
		
		 StringBuilder strBuilder = new StringBuilder();
		 
		 for (int i = 0; i < 256; i++) {
			 for (int j = 0; j < freq[i]; j++) {
				 strBuilder.append((char)i);
			 }
		 }
		 
		 return strBuilder.toString();
	}

}

