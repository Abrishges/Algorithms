package com.Algorithem.divideandconquer;

import java.util.Stack;

//https://leetcode.com/explore/learn/card/recursion-ii/507/beyond-recursion/2901/
public class LargestRectangleArea {

	public static void main(String[] args) {
		int [] heights = {6, 7, 5, 2, 4, 5, 8, 3};
		
		LargestRectangleArea area = new LargestRectangleArea();
		System.out.println(area.largestRectangleArea(heights));
	}
	
	
    public int largestRectangleArea(int[] heights) {
    	
    	Stack<Integer> stack = new Stack<Integer>();
    	stack.push(-1);
    	stack.push(0);
    	
    	int area = 0;

    	for (int i = 1 ; i < heights.length; i++) {
    		
    		int peek = stack.peek();
    		    		
    		while (peek != -1 && heights[i] <= heights[peek]) {
    					
    			int curHeight = heights[stack.pop()];
        		int llimit = stack.peek();
      		
        	    int width = i - llimit - 1;
        		
    			area = Math.max(area, curHeight * width);
    			peek = stack.peek();
    		}
    		
    		stack.push(i);
    	}
    	
    	while (!stack.isEmpty() && stack.peek() != -1) {
    		int curHeight = heights[stack.pop()];
    		int llimit = stack.peek();
    		
    		int width = heights.length - llimit - 1;		
    		area = Math.max(area, curHeight * width);
    	}
    	
    	return area;
    }
}
