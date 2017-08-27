/**
 *
 */
package com.HackerRank;

import java.util.Stack;

/**
 * @author Abereham wodajie
 *
 *         Jul 4, 2017
 */
public class TotalScore {

  public static void main(final String args[]) {
    final String[] blocks = {"5", "-2", "4", "Z", "X", "9", "+", "+"};
    System.out.println(totalScore(blocks, 8));
  }

  public static int totalScore(final String[] blocks, final int n) {

    final Stack<Integer> total = new Stack<>();
    final Stack<Integer> lastScores = new Stack<>();

    for (int i = 0; i < n; i++) {
      switch (blocks[i]) {
        case "X": {
          if (!lastScores.isEmpty()) {
            lastScores.push(lastScores.peek() * 2);
            total.push(total.peek() + lastScores.peek());
          } else {
            lastScores.push(0);
            total.push(0);
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
          total.push(total.isEmpty() ? 0 : +total.peek() + lastScores.peek());
          break;
        }

        case "Z": {
          if (!lastScores.isEmpty()) {
            lastScores.pop();
            total.pop();
          }
          break;
        }
        default: {
          lastScores.push(Integer.parseInt(blocks[i]));
          total.push((total.isEmpty() ? 0 : total.peek()) + Integer.parseInt(blocks[i]));
        }

      }

    }
    return total.isEmpty() ? 0 : total.peek();
  }

}
