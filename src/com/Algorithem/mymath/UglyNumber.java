package com.Algorithem.mymath;

//Given a number n, find n’th Ugly number
// To check if a number is ugly, divide the number by greatest divisible powers of 2, 3 and 5,
// if the number becomes 1 then it is an ugly number otherwise not.
public class UglyNumber {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		UglyNumber un = new UglyNumber();
		
		int n = 150;
		int nth = un.getNthUglyNo(n);
		System.out.println(nth);
	}
	
	public int getNthUglyNo(int n) {
		
		int i = 1; 	
		// ugly number count
        int count = 1;
        
        while (n > count) {
            i++;
            if (isUgly(i))
                count++;
        }
        
        return i;
	}

	public boolean isUgly(int num) {
		
		 num = greatestDivisible(num, 2);
		 num = greatestDivisible(num, 3);
		 num = greatestDivisible(num, 5);
		 
		 if (num == 1) {
			 return true;
		 }
		 
		return false;
	}
	
	//This function divides num by greatest divisible power of div
	public int greatestDivisible(int num, int div) {
		
		while (num % div == 0) {
			num = num / div;
		}
		
		return num;
	}
}
