package com.Algorithem.ArraysAndLists;

//https://leetcode.com/problems/search-a-2d-matrix-ii/
// what are the options we can do this? 
public class SearchMatrix2D {

	public static void main(String[] args) {
		
		SearchMatrix2D matrix = new SearchMatrix2D();
		
		//[[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]]
		
		int [][] arr = {
				{1,4,7,11,15},
				{2,5,8,12,19},
				{3,6,9,16,22},
				{10,13,14,17,24},
				{18,21,23,26,30}
		               };
		
		System.out.println(matrix.searchMatrix(arr, 5));
	}
	
	public boolean searchMatrix(int [][] arr, int target) {
		
		for (int i = 0; i < arr.length; i++) {
			 if (search(arr, i, 0, arr[0].length - 1, target)) return true;
		}
		
		return false;
	}
	
	//using Binary search
	public boolean search(int[][]arr, int i , int l, int r, int target) {
		
		 if (l <= r) {
			 int m = l + (r - l)/2;
			 
			 if (target == arr[i][m]) {
				 
				 return true;
			 }
			 
			 if (target < arr[i][m]) {
				 return search(arr, i, l, m - 1, target);
			 } else if (target > arr[i][m]){
				 return search (arr, i, m + 1, r, target);
			 }
		 }
		 
		 return false;
	}	
}
