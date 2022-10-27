package com.Algorithm.string;

public class MinInsertionsPalindrome {

	public static void main(String[] args) {
		String str = "leetcode";
		MinInsertionsPalindrome mp = new MinInsertionsPalindrome();
		System.out.println(mp.minInsertions(str));
	}

	//Min Inseartion palindrome
	//zzazz
	//mbadm
	
    public int minInsertions(String s) {
    	
    	int i = 0;
    	int j = s.length() - 1;
    	int len = 0; 
    	boolean flag = false;
        
    	while (i < j) {
    		
    		if (s.charAt(i) != s.charAt(j)) {
    			
    			if (!flag) {
    				j--;
    				len++;
    				flag = true;
    			} else {
    				i++;
    				len++;
    				flag = false;
    			}
    		} else {
    			i++;
    			j--;
    		}
    	}
    	
    	return len;
    }
}
