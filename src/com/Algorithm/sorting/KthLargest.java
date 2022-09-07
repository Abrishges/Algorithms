package com.Algorithm.sorting;

import java.util.PriorityQueue;
import java.util.Queue;

/*
 * https://leetcode.com/problems/kth-largest-element-in-a-stream/
 * Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order,
 * not the kth distinct element.
 * KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of integers nums.
 * int add(int val) Appends the integer val to the stream and returns the element representing the kth largest element in the stream.
 */
public class KthLargest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	 int k;
	    Queue<Integer> pq;

	    public KthLargest(int k, int[] nums) {
	        
	        this.k = k;
	        this.pq = new PriorityQueue<Integer>((n1, n2) -> n1 - n2);
	        
	        for (int num : nums) {
	            pq.add(num);
	            
	            if (pq.size() > k) {
	                pq.poll();
	            }
	        }
	    }
	    
	    public int add(int val) {
	        pq.add(val);
	        if (pq.size() > k) {
	           pq.poll();   
	        }

	        
	        return pq.peek();
	    }
	    
}
