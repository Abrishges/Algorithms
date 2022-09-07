package com.Algorithm.sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
/*
 * https://leetcode.com/problems/minimum-cost-to-hire-k-workers/solution/
 * This quetion is not clear
 */
public class MinCost {
	
	public static void main(String[] args) {

      int [] quality = {10,20,5};
      int [] wage = {70,50,30};
      
      MinCost mc = new MinCost();
      
      System.out.println(mc.mincostToHireWorkers(quality, wage, 2));
	}
	
	class Worker implements Comparable<Worker>{
		int quality; 
		int wage; 
		
		public Worker(int quality, int wage) {
			this.quality = quality;
			this.wage = wage;
		}
		
		public double ratio() {
			return (double) wage/quality;
		}

		@Override
		public int compareTo(Worker other) {
			return Double.compare(ratio(), other.ratio());
		}		
	}

    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
    	
    	int n = quality.length;
    	Worker [] workers = new Worker[n];
    	for(int i = 0 ; i < n; i++) {
    		workers[i] = new Worker(quality[i], wage[i]);
    	}
    	
    	Arrays.sort(workers);
    	double answer = Double.MAX_VALUE;
    	int sumQuality = 0;
    	Queue<Integer>heapMax = new PriorityQueue<Integer>(Collections.reverseOrder());
    	
    	for (Worker worker : workers) {
    		heapMax.add(worker.quality);
    		sumQuality += worker.quality;
    		
    		if (heapMax.size() > k) {
    			sumQuality -= heapMax.poll();
    		} 
            
            if (heapMax.size() == k) {
    			answer = Math.min(answer, sumQuality * worker.ratio()); 
    		}
    	}  
    	
    	return answer;
    }
}
