package com.Algorithm.sorting;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class KClosest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [][] points = new int[2][2];
		points[0][0] = 1;
		points[0][1] = 3;
		points[1][0] = -2;
		points[1][1] = 2;
		
		KClosest kc = new KClosest();
		
		int [][] ans = kc.KClosest2(points, 1);
		System.out.println(ans);
	}
	
	// Solution one, nlogn
    public int[][] kClosest(int[][] points, int k) {
        
        Arrays.sort(points, (a, b) -> distance(a) - distance(b));
        
        int [][] ans = new int[k][2];
        
        for (int i = 0 ; i < k; i++) {
            ans[i][0] = points[i][0];
            ans[i][1] = points[i][1];            
        }
      return ans;  
    }
    
    public int distance(int [] point) {
        return (int) (Math.pow(point[0], 2) + Math.pow(point[1], 2));
    }
    
    // we can also use max head and keep only k in queue, in case we have some many elements 
    public int [][] KClosest2(int [][] points, int k) {
    	
    	Queue<int[]> pq = new PriorityQueue<int[]>((a, b) -> distance(a) - distance(b));
    	
    	for (int[] point : points) { 		
    		pq.add(point);
    	}
    	
       int [][] ans = new int[k][2];
        
        for (int i = 0 ; i < k; i++) {
        	int [] point = pq.poll();
            ans[i][0] = point[0]; 
            ans[i][1] = point[1];
        }
    	
    	return ans;
    } 
}
