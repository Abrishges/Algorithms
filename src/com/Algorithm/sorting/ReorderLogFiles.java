package com.Algorithm.sorting;

import java.util.Arrays;
import java.util.Comparator;

/*
 * https://leetcode.com/problems/reorder-data-in-log-files/
 * Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
There are two types of logs:

Letter-logs: All words (except the identifier) consist of lowercase English letters.
Digit-logs: All words (except the identifier) consist of digits.
Reorder these logs so that:

The letter-logs come before all digit-logs.
The letter-logs are sorted lexicographically by their contents. If their contents are the same, then sort them lexicographically by their identifiers.
The digit-logs maintain their relative ordering.
 */
public class ReorderLogFiles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public String[] reorderLogFiles(String[] logs) {
        
    	
        Comparator<String> logComparator = new Comparator<String> (){

			@Override
			public int compare(String logs1, String logs2) {
				
				 String [] str1 = logs1.split(" ", 2);
				 String [] str2 = logs2.split(" ", 2);
				 
				 boolean isDigit1 = Character.isDigit(str1[1].charAt(0));
				 boolean isDigit2 = Character.isDigit(str2[1].charAt(0));
				 
				 // both of the logs are not digits
				 if (!isDigit1 && !isDigit2) {
					 
					 int result = str1[1].compareTo(str2[1]);
					 if (result == 0) {
						  return str1[0].compareTo(str2[0]);
					 } 
					
					 return result;
				 }
				 
				 //one of logs is digit-log
				 if (!isDigit1 && isDigit2) {
					 return -1;
				 } else if (isDigit1 && !isDigit2){
					 return 1;
				 } else {
					 //if number
					 return 0;
				 }
			}
        };
        
	   Arrays.sort(logs, logComparator);
		 
	   return logs;
    }
}
