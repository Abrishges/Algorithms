package com.Algorithem.random;

import java.util.HashSet;
import java.util.Set;

public class NumUniqueEmails {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	 public int numUniqueEmails(String[] emails) {
	        
	        Set<String> set = new HashSet<String>();
	        for (int i = 0 ; i < emails.length; i++) {
	            String str = email(emails[i]);
	            set.add(str);
	        }
	        
	        return set.size();
	    }
	    
	    
	    public String email(String str) {
	        int idx = str.indexOf('@');
	        StringBuilder sb = new StringBuilder();
	        
	        for (int i = 0; i < idx; i++) {
	            
	            if (str.charAt(i) == '+') {
	                break;
	            } else if (str.charAt(i) != '.') {
	                sb.append(Character.toUpperCase(str.charAt(i)));
	            }
	        }
	        
	        sb.append(str.substring(idx));
	        
	     return sb.toString();   
	    }
}
