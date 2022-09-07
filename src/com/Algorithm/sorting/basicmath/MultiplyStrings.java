package com.Algorithm.sorting.basicmath;

//https://leetcode.com/problems/multiply-strings/
public class MultiplyStrings {

	public static void main(String arg[]) {
		MultiplyStrings ms = new MultiplyStrings();
		String num1 = "123";
		String num2 = "456";
		//System.out.println(ms.multiply(num1, num2));
		System.out.println(ms.multiply2("123", "456"));
	}

	  //Time complexity O(n(nm))
	  public String multiply(String num1, String num2) {
		  
		  if (num1.equals("0") || num2.equals("0")) return "0";
          int j = num1.length() - 1;
          String sum = null;
          for (int i = 0; i < num1.length(); i++) {
               String result = helper(num1.charAt(i), num2, j);        
               if (i == 0) {
                   sum = result; 
               } else {
                   sum = sumHelper(sum, result);
               }    
               j--;
          }
        return sum;
    }
    
    public String sumHelper(String num1, String num2) {
        
        int i = num1.length() - 1; int j = num2.length() - 1; 
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0) {
            
            int x = i >= 0 ? num1.charAt(i) - '0': 0;
            int y = j >= 0 ? num2.charAt(j) - '0': 0;
            int sum = x + y + carry;
            sb.append(sum % 10);
            carry = sum / 10;   
            j--;
            i--;
        }
        
        if (carry != 0) {
            sb.append(carry);
        }
        
        return sb.reverse().toString();
    }
    
    
    public String helper(char ch, String num, int zeros) {
        
        StringBuilder sb = new StringBuilder();
        while (zeros > 0) {
            sb.append(0);
            zeros--;
        }
        
        int y = ch - '0';
        int result = 0; 
        for (int i = num.length() - 1 ; i >= 0; i--) {
              int x = num.charAt(i) - '0';
              result += x * y;
              sb.append(result % 10);
              result = result/10;    
        }
        
        if (result != 0) {
        	sb.append(result);
        }
        
        return sb.reverse().toString();
    }
    
    //This one is my easiest implementation, time complexity O(NM)
    public String multiply2 (String num1, String num2) {
    	
    	if(num1.equals("0") || num2.equals("0")) return "0";
    	int n = num1.length() + num2.length();
    	int [] ans = new int [n];
    	
    	for (int i = num1.length() - 1; i >= 0 ; i--) {
    		
    		for (int j = num2.length() - 1; j >= 0; j--) {
    			int pos = i + j + 1;
    			int x =  num1.charAt(i) - '0';
    			int y = num2.charAt(j) - '0';
    			int result = x * y + ans[pos];
    			ans[pos] = result % 10;
    			ans[pos - 1] += result/10;
    		}
    	}
    	
    	int i = 0; 
    	//we can use string trim or StringUtils.stripStart(sb.toString(), "0")
    	while (ans[i] == 0) i++;
    	
        StringBuilder sb = new StringBuilder();
        while(i < ans.length) {
        	sb.append(ans[i]);
        	i++;
        }
    	
        return sb.toString();
    } 
}
