package com.Algorithm.sorting.basicmath;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*
 * Input: num = [1,2,0,0], k = 34
Output: [1,2,3,4]
 */
public class ArrayForm {

	public static void main(String[] args) {
		ArrayForm arrform = new ArrayForm();
		int [] num = {9,9,9,9,9,9,9,9,9,9};
		int [] num2 = {1,2,6,3,0,7,1,7,1,9,7,5,6,6,4,4,0,0,6,3 };
		int k = 1;
		int k2 = 516;
		int [] num3 = {1, 2, 0, 0};
		int k3 = 34;
		System.out.println(arrform.addToArrayForm(num, k));
		System.out.println(arrform.addToArrayForm(num2, k2));
		System.out.println(arrform.addToArrayForm(num3, k3));
	}
	
	
    public List<Integer> addToArrayForm(int[] num, int k) {
        
      List<Integer> list = new ArrayList<Integer>();
       
      int i = num.length - 1;
      while (i >= 0 || k > 0) {
    	 if (i >= 0) {
    	   	 k = num[i] + k; 
    	 }
    	 
    	 list.add(k % 10);
    	 k = k/10;
    	 i--;
      }
      Collections.reverse(list);
      return list;
    }

}
