package com.Algorithm.interview.ik;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the
sum of all numbers along its path.
Note: You can only move either down or right at any point in time.
Note: Non-negative  = 0 -> infinity, never go negative. Path will never go negative, always increase or stay the same

Only go RIGHT or DOWN. You can't do diagonal, up or left. 

Example:

Starting upper left going to the bottom right. 

[[1,3,1],
[1,5,1],
[4,2,1]]  

= 1 + 3 + 1 + 1 + 1 = 7 
= 1 + 1 + 4 + 2 +1  = 9 
*/

public class GridPathSum {

	public static void main(String[] args) {
		
		GridPathSum pathSum = new GridPathSum();
		int [][] grid = {{1, 3, 1}, 
				         {1, 5, 1},
				         {4, 2, 1}
				         };
		
		int minPathSum = pathSum.minPathSum(grid);
		System.out.println(minPathSum);
		
		//minPathSum2
		List<Integer> list = pathSum.minPathSum2(grid);
		System.out.println(list);
	}
	
	 public int minPathSum(int[][] grid) {
		    
	    int [][] dp = new int[grid.length][grid.length];
	    
	    for (int [] row : dp) {
	    	  Arrays.fill(row, -1);
	    }
	  
	    return backtrack(grid, 0, 0, dp);
	    
	 }

	public int backtrack(int [] [] grid, int row , int colom, int [][] dp) {
	    
	    if (dp[row][colom] != -1 ) return dp[row][colom];
	    
	    if (row == grid.length - 1 && colom == grid[0].length - 1) return grid[row][colom];
	    if (colom == grid[0].length - 1) return dp[row][colom] = grid[row][colom] + backtrack(grid, row + 1, colom, dp);
	    if (row == grid.length - 1) return dp[row][colom] = grid[row][colom] + backtrack(grid, row, colom + 1, dp);
	    
	    return dp[row][colom] = grid[row][colom] + Math.min(backtrack(grid, row, colom + 1, dp), backtrack(grid, row + 1, colom, dp)); 
	}

	/*
	public static int minPathSum(int[][] grid) {

	            int height = grid.length;
	            int width = grid[0].length;
	            return min(grid, height - 1, width - 1);
				
	        }
			
	public static int min(int[][]grid, int row, int col){
	            if(row == 0 && col == 0) return grid[row][col]; 
	            if(row == 0) return grid[row][col] + min(grid, row, col - 1);
	            if(col == 0) return grid[row][col] + min(grid, row - 1, col); 
	            return grid[row][col] + Math.min(min(grid, row - 1, col), min(grid, row, col - 1)); 
				
	}
	*/
	
	//How about if we wan to return the list numbers that will make up the smallest min sum
	//This solution doesn't work, How do want to solve it ? 
	public List<Integer> minPathSum2(int [][] grid) {
		List<Integer> list = new ArrayList<Integer>();
		
	    minPathSum(grid, 0, 0, list);
	    return list;
	}
	
	public int minPathSum(int [][] grid, int row, int col, List<Integer> result) {
		
		if (row == grid.length - 1 && col == grid.length - 1) {
			result.add(grid[row][col]);
			return grid[row][col];
		}
		
		if (row == grid.length - 1) {
			 result.add(grid[row][col]);
			return grid[row][col] + minPathSum(grid, row, col + 1, result);
		}
		
		if (col == grid[0].length - 1) {
			result.add(grid[row][col]);
			return grid[row][col] + minPathSum(grid, row + 1, col, result);
		}
		
		result.add(grid[row][col]);
	    int sum = grid[row][col] + Math.min(minPathSum(grid, row, col + 1, result), minPathSum(grid, row + 1, col, result));
	    result.remove(result.size() - 1);
	   // result.remove(result.size() - 1);
		
		return sum;
	}
}
