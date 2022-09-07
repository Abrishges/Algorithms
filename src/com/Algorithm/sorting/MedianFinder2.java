package com.Algorithm.sorting;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class MedianFinder2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		MedianFinder2 md = new MedianFinder2();
		md.addNum(1);
		md.addNum(2);
		md.addNum(3);
		//md.addNum(-4);	
//		md.addNum(-5);
		System.out.println("max: " + md.maxHeap);
		System.out.println("min: " + md.minHeap);
		System.out.println(md.findMedian());
	}
	
	private Queue<Integer> maxHeap;
	private Queue<Integer> minHeap;
	
	public MedianFinder2() {
        this.minHeap =  new PriorityQueue<Integer>();
        this.maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
	}

	public void addNum(int num) {
       this.maxHeap.add(num);
       this.minHeap.add(maxHeap.poll());   
       
       if (minHeap.size() > maxHeap.size()) {
    	   maxHeap.add(minHeap.poll());
       }
       
	}

	public double findMedian() {

			
		if (maxHeap.size() == minHeap.size()) {
			return (double)(maxHeap.peek() + minHeap.peek())/2;
		} else {
			return maxHeap.peek();
		}
			
	}
}
