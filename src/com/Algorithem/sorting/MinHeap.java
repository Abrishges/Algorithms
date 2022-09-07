package com.Algorithem.sorting;

public class MinHeap {
	
	private int [] heap;
	private int size; 
	private int maxSize;
	
	public MinHeap(int mixSize) {
		 this.maxSize = mixSize;
		 this.heap = new int[this.maxSize + 1];
		 this.size = 0;
	}
	
	public int getLeftChild(int pos) {
		return 2 * pos;
	}
	
	public int getRightChild(int pos) {
		return 2 * pos + 1;
	}
	
	public int getParent(int pos) {
		return pos/2;
	}
	
    public int getMin() {
    	return heap[1];
    }

   public boolean isLeaf(int pos) {
    	if (pos > size/2 && pos <= maxSize) {
    		return true;
    	}
    	
    	return false;
   }
   
   
   public void inseart(int num) {
	   
	   if (size >= this.maxSize) {
		   return;
	   }
	   
	   int pos = size; 
	   size ++;
	   
	   while (num < heap[pos/2]) {
		   heap[pos] = heap[pos/2];
		   pos = pos/2;
	   }
	   
	   heap[pos] = num;
   }
   
   public int extracMin() {
	   int minValue = heap[1];
	   heap[1] = heap[size - 1];
	   size--;
	   
	   heapify(1);
	 return minValue;  
   }
   
   //we can do heapify recursively or iteratively
   // we can call it heapify down
   public void heapify(int pos) {
	   
	   if (!isLeaf(pos)) {
		   
		   if (heap[pos] > heap[getLeftChild(pos)] || heap[pos] > heap[getRightChild(pos)]) {
			   
			   if (heap[getLeftChild(pos)] < heap[getRightChild(pos)]) {
				   // swap left with pos
				     int temp = heap[pos];
				     heap[pos] = heap[getLeftChild(pos)];
				     heap[getLeftChild(pos)] = temp;
				   // update pos 
				     heapify(2 * pos);
			   } else {
				     //swap right with pos
				     int temp = heap[pos];
				     heap[pos] = heap[getRightChild(pos)];
				     heap[getRightChild(pos)] = temp;
				     //update pos 
				     heapify(2 * pos + 1);
			   }
		   }
	   }   
   }
    
   
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
