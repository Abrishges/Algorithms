package com.Algorithem.mymath;

import java.util.ArrayList;
import java.util.List;

//Given a number n, write an efficient function to print all prime factors of n.
//if given number is 12, then output should be “2 2 3”. 
public class PrimeNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int num = 12;
		PrimeNumbers pm = new PrimeNumbers();
		List<Integer> list = pm.getPrimeFactors(num);
		System.out.println(list);
		
		int test2 = 315;
		List<Integer> list2 = pm.getPrimeFactors(test2);
		System.out.println(list2);

	}

	public List<Integer> getPrimeFactors(int num) {
		
		List<Integer> list = new ArrayList<Integer>();
		
		while (num % 2 == 0) {
			num = num/2; 
			list.add(2);
		}
		
		for (int i = 3; i <= Math.sqrt(num); i+=2) {
			
			while (num % i == 0 ) {
				num = num / i;
				list.add(i);
			}
			
		}
		
		//if number is greater than 2 and  prime by itself, ex 11
		if ( num > 2) {
			list.add(num);
		}
		
	 return list;	
	}
}
