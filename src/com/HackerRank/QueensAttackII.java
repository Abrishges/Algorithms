package com.HackerRank;

import java.util.ArrayList;
import java.util.List;

//You will be given a square chess board with one queen and a number of obstacles placed on it. 
//Determine how many squares the queen can attack.
//https://www.hackerrank.com/challenges/queens-attack-2/problem
public class QueensAttackII {
	
	public static void main(String[] args) {
		
		List<List<Integer>> list =  new ArrayList<>();
		int n = 5;
		int k = 3;
		int r_q = 4; 
		int c_q = 3; 
		
		List<Integer> obstacle1 = new ArrayList<Integer>();
		obstacle1.add(5);
		obstacle1.add(5);
		List<Integer> obstacle2 = new ArrayList<Integer>();
		obstacle2.add(4);
		obstacle2.add(2);
		List<Integer> obstacle3 = new ArrayList<Integer>();
		obstacle3.add(2);
		obstacle3.add(3);
		
		list.add(obstacle1);
		list.add(obstacle2);
		list.add(obstacle3);
		
		System.out.println(queensAttack(n, k, r_q, c_q, list));
		
		
		List<List<Integer>> list2 =  new ArrayList<>();
		
		System.out.println(queensAttack(1, 0, 1, 1, list2));
		
		System.out.println(queensAttack(4, 0, 4, 4, list2));
	}

	
	 public static int queensAttack(int n, int k, int r_q, int c_q, List<List<Integer>> obstacles) {
		    // Write your code here
		 
		 //horizontal
		 int hL = c_q - 1;  
		 int hR = n - c_q;  
		 
		 //vertical
		 int vu = n - r_q; 
		 int vl = r_q - 1;
		 
		 
		 //diagonal left to right (top to bottom), ( +, -) and (-, +)
		 // L= left , r= right , u = upper , l = lower
		 int dLu = Math.min(Math.abs(n - r_q), Math.abs(c_q - 1));
		 int dRl = Math.min(Math.abs(r_q - 1), Math.abs(n - c_q));
		 
		 //diagonal left to right (bottom to top), (+, +) and (-, -)
		 int dLl = Math.min(Math.abs(r_q - 1), Math.abs(c_q - 1));
		 int dRu = Math.min(Math.abs(n - r_q), Math.abs(n - c_q));
		 
		 int dist = 0 ;
		 
		 for (List<Integer> list : obstacles) {
			 
			 int x = list.get(0).intValue() - r_q;
			 int y = list.get(1).intValue() - c_q;
			 
			 
			 if (Math.abs(y) ==  Math.abs(x) || y == 0 || x == 0) {
				 		 			 
			 //Left
			 if ( y == 0 && x < 0) {
				 
				 int temp = (Math.abs(x) - 1);
				 if (temp < hL) {
					 hL = temp;
				 }
			 }
			 
			 //Right 
			 if ( y == 0 && x > 0) {
				 int temp = x - 1;
				 
				 if (temp < hR) {
					 hR = temp;
				 }
			 }
			 
			 //up 
			 if (x == 0 && y > 0) {
				 int temp = y - 1;
				 
				 if (temp < vu) {
					 vu = temp;
				 }
			 }
			 
			 //down
			 if (x == 0 && y < 0) {
				 int temp = (Math.abs(y) - 1);
				 
				 if (temp < vl) {
					 vl = temp;
				 }
			 }
			 
			//diagonal left upper
			 if (x < 0 && y > 0 && y == Math.abs(x)) {
				 if (y < dLu) {
					 dLu = y - 1;
				 }  
			 }
		     
			//diagonal right lower
			 if (x > 0 && y < 0 && x == Math.abs(y)) {
				 if (x < dRl) {
					 dRl = x - 1;
				 }  
			 }	 
			 
			// diagonal left lower
			 if (x < 0 && y < 0  && y == x) {
				 int temp = (Math.abs(x) - 1);
				 if (temp < dLl) {
					 dLl = temp;
				 }
			 }
			 
			 //diagonal right upper	 
			 if (x > 0 && y > 0  && y == x) {
				 if (x < dRu) {
					 dRu = x - 1;
				 } 
			 }
			     
		 }
	    }
		 
		 dist = hL + hR + vu + vl + dLu + dRl + dRu + dLl;
     
		return dist;
    }
}
