/**
 * 
 */
package com.Algorithm.Basic;

/**
 * @author aberehamwodajie
 *
 * Apr 11, 2017
 */
public class exam {
	
	
	
	import java.util.Stack;

	public class Solution {

	    public static int totalScore(String[] blocks, int n) {
	        Stack<Integer> lastScores = new Stack<>();
	        Stack<Integer> totals = new Stack<>();
	        for (int i = 0; i < n; i++) {
	            switch (blocks[i]) {
	                case "X": {

	                    if (!lastScores.isEmpty()) {
	                        lastScores.push(lastScores.peek() * 2);
	                        totals.push(lastScores.peek() + totals.peek());
	                    } else {
	                        lastScores.push(0);
	                        totals.push(0);
	                    }
	                    break;
	                }
	                case "+": {
	                    int lastScore = 0;
	                    int scoreBeforeLast = 0;
	                    if (!lastScores.isEmpty()) {
	                        lastScore = lastScores.pop();
	                        if (!lastScores.isEmpty()) {
	                            scoreBeforeLast = lastScores.peek();
	                        }
	                        lastScores.push(lastScore);
	                    }
	                    lastScores.push(lastScore + scoreBeforeLast);
	                    totals.push((totals.isEmpty() ? 0 : totals.peek()) + lastScores.peek());
	                    break;
	                }
	                case "Z": {
	                    if (!lastScores.isEmpty()) {
	                        lastScores.pop();
	                        totals.pop();
	                    }
	                    break;
	                }
	                default: {
	                    lastScores.push(Integer.parseInt(blocks[i]));
	                    totals.push((totals.isEmpty() ? 0 : totals.peek()) + lastScores.peek());
	                }
	            }
	        }
	        return totals.isEmpty() ? 0 : totals.peek();
	    }
	}

}
