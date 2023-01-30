package com.Algorithem.random;

public class Random {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int [] arr = {1,2,3,2,2};
        System.out.println(totalFruit(arr));
	}

	
	 public static int totalFruit(int[] fruits) {
	        
	       if (fruits.length == 0) return 0;
	        
	        int typeA = fruits[0], countA = 0; 
	        int typeB = -1, countB = 0;
	        
	        int i = 0;
	        int max = 0;
	        for (int j = 0; j < fruits.length; j++) {
	            
	            if (typeA == fruits[j]) {
	                countA++;
	            } else if (typeB == fruits[j]) {
	                countB++;
	            } else if (typeB == - 1) {
	                typeB = fruits[j];
	                countB = 1;
	            } else {
	                 //sliding window
	                while(countA != 0 && countB != 0) {
	                   if (typeA == fruits[i]) {
	                       i++;                
	                       countA--;
	                   } else {
	                       i++;
	                       countB--;
	                   }     
	                }
	                
	                if (countA == 0) {
	                    typeA = fruits[j];
	                    countA = 1;
	                } else {
	                     typeB = fruits[j];
	                     countB = 1;
	                }
	            }
	            
	            max = Math.max(max, countA + countB);
	        }
	        
	        return max;
	    }
}
