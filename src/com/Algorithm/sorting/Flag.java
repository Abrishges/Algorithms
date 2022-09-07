package com.Algorithm.sorting;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * Given some balls of three colors arranged in a line, rearrange them such that all the red balls go first, 
 * then green and then blue ones.Do rearrange the balls in place. A solution that simply counts colors and 
 * overwrites the array is not the one we are looking for.This is an important problem in search algorithms 
 * theory proposed by Dutch computer scientist Edsger Dijkstra. Dutch national flag has three colors
 *  (albeit different from ones used in this problem).
 *   ["G", "B", "G", "G", "R", "B", "R", "G"]  --->  ["R", "R", "G", "G", "G", "G", "B", "B"]
 */
public class Flag {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Character> balls = new ArrayList<Character>(Arrays.asList('G', 'B', 'G', 'G', 'R', 'B', 'R', 'G', 'B', 'B'));
		System.out.println(balls);
		flagSort(balls);
		System.out.println(balls);
	}
	
	// This question should be modified, t
	public static void flagSort(ArrayList<Character> balls) {
		
		int red = 0;
		int blue = balls.size() - 1;

        int i = 0;
		while (i <= blue) {
			
			if (i == red && balls.get(red) == 'R') {
				 red++; i++;
			} else if (balls.get(i) == 'R') {
				 
				Character temp = balls.get(red);
				balls.set(red, balls.get(i));
				balls.set(i, temp);
				red++; 
			} else if (balls.get(i) == 'B') {
				 while (balls.get(blue) == 'B') {
					 blue--;
				 }
				Character temp = balls.get(blue);
				balls.set(blue, balls.get(i));
				balls.set(i, temp);
				blue--;
			} else {
				i++;
			}
		}
	}
}
