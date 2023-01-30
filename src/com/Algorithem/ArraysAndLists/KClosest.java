package com.Algorithem.ArraysAndLists;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

//https://leetcode.com/explore/interview/card/google/59/array-and-strings/3062/
public class KClosest {

	public static void main(String[] args) {

		int [][] points = {{3,3},{5,-1},{-2,4}};

	
	    System.out.println(Arrays.deepToString(KClosestPoints(points, 2)));
	}
	
	public static int [][] KClosestPoints(int [][]points, int k) {
		
		//min priority queue
		Queue<int[]> pq = new PriorityQueue<int[]>((a, b) -> distance(a) - distance(b));
		for (int []point : points) {
			pq.add(point);
		}
		
		int [][] ans = new int[k][2];
		
		for(int i = 0; i < k ; i++) {
			int [] point = pq.poll();
			ans[i][0] = point[0];
			ans[i][1] = point[1];
		}
		
		return ans;
	}
	
	public static int distance(int[] point) {
		int x = point[0];
		int y = point[1];
		
		//Since the other end is zero, we can ignore it
		
	 return (x*x + y*y); 
	}
}
