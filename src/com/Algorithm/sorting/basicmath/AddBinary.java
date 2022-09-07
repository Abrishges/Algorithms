package com.Algorithm.sorting.basicmath;

public class AddBinary {
	
	public static void main(String [] arg) {
		
	}
	
    public String addBinary(String a, String b) {
        
        int i = a.length() - 1;  int j = b.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0) {
            
            int x = i >= 0 ? a.charAt(i) - '0' : 0; 
            int y = j >= 0 ? b.charAt(j) - '0' : 0;
            int sum = x + y + carry;
            sb.append(sum % 2);
            carry = sum/2; 
            i--;
            j--;
        }
        
        if (carry != 0) {
            sb.append(carry);
        }
        
        return sb.reverse().toString();  
    }
}
