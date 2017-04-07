package com.Algorithm.Basic;

import static java.lang.StrictMath.sqrt;

/**
 * Created by Abereham wodajie on 4/7/17.
 * This program checks if a number is prime or not in order of sqrt(n)
 * This question is asked in Hacker rank
 */
public class checkPrime {

    public static void main(String[] args) {

        System.out.println("3 is: " + isPrime(3));
        System.out.println("10 is: " +isPrime(10));
        System.out.println("2 is: " + isPrime(2));
        System.out.println("5 is: " + isPrime(5));
    }

    public static boolean isPrime(int n){
        if (n == 3 || n == 2) return true;
       if(n % 2 == 0) return false;
       //if neither of the above is true, check for odds
        for(int i = 3; i <=  sqrt(n); i++){
            if (n % i == 0)
                 return false;
        }

        return true;
    }
}
