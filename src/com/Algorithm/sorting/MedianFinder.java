package com.Algorithm.sorting;

import java.util.ArrayList;
/*
 * Is it possible to solve this problem using sliding window? 
 */
public class MedianFinder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MedianFinder md = new MedianFinder();
		md.addNum(-1);
		md.addNum(-2);
		md.addNum(-3);
		md.addNum(-4);	
		md.addNum(-5);
		System.out.println("Hello: " + md.list);
		System.out.println(md.findMedian());
	}
	

	   ArrayList<Integer> list; 

	   public MedianFinder() {
	       this.list =  new ArrayList<Integer>(); 
	    }
	    
	    public void addNum(int num) {
          
	    	 int index = this.binarySearch(num);
	    	 this.list.add(index, num);
	   }

      public int binarySearch(int num) {
    	  
    	     int l = 0, r = list.size() - 1;
	         
	         while (l <= r) {
	        	  int m = (l + r)/2;
	        	  
	        	  if (num > list.get(m)) {
	        		  l = m + 1; 
	        	  } else if (num < list.get(m)) {  
	        		  r = m - 1;
	        	  } else {
	        		  return m;
	        	  }
	         }
	          return l;
      }
	    
	    public double findMedian() {
	        double median = 0;

	         int n = list.size()/2;
	         
	        if (list.size() % 2 != 0) {
	        	median = list.get(n);
	        } else {
	        	median = Double.valueOf(list.get(n - 1) + list.get(n))/2;
	        }
	        
	        return median;
	    }
}