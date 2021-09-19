package com.HackerRank;

public class Test {

     static int MAX_CHAR = 26;
     static int MAX_LENGHT = 10;
     
     static	int [][] count = new int[MAX_LENGHT][MAX_CHAR];
	   
	public static void main(String[] args) {
		
		 String str = "hello";
		 
		 //System.out.println(str.charAt(0) - 'a');
		
		for (int i = 0; i < str.length(); i++) {
			count[i][str.charAt(i) - 'a']++;
		}
		
		
		 for (int i = 1; i < str.length(); i++)
		    {
		        for (int j = 0; j < 26; j++)
		        	count[i][j] += count[i - 1][j];
		    }
		 
			for (int i = 0; i < MAX_LENGHT; i ++) {
				for (int j = 0; j < MAX_CHAR; j++) {
					System.out.println(count[i][j]);
				}
			}
  
	}
	
	public static void preProcess(String str) {
		
		for (int i = 0; i < str.length(); i++) {
			count[i][str.charAt(i) - 'a']++;
		}
	}
}
