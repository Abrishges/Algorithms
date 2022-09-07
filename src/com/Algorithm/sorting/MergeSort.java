package com.Algorithm.sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		
		ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(5, 8, 3, 9, 4, 1, 7));
		System.out.println("Before sorting: " + list);
		mergeSort(list);
		System.out.println("After sorting: " + list);
	}

	
	 static ArrayList<Integer> mergeSort(ArrayList<Integer> arr) {
		 
	        if (arr.size() <= 1) return arr;
	        
	        mergeSort(arr, 0, arr.size() - 1);
	        
	        return arr;
	    }
	    
	    
	 static void mergeSort(ArrayList<Integer> list, int l, int r) {
	        
	        if (l < r) {
	            int m = (l + (r - l)/2);
	            mergeSort(list, l, m);
	            mergeSort(list, m+1, r);
	            merge(list, l, m, r);
	        }
	    }
	    
	  static void merge(ArrayList<Integer> arr,int start, int mid, int end){
	        
	        int aux[]=new int[end-start+1];
	        int i = start,j = mid+1, k=0;
	        
	        while(i <= mid && j <= end){
	            if(arr.get(i) <= arr.get(j)){
	                aux[k]=arr.get(i);
	                i++;
	            }else{
	                aux[k]=arr.get(j);
	                j++;
	            }
	            k++;
	        }
	        
	        while(i<=mid){
	                aux[k]=arr.get(i);
	                i++;
	                k++;
	        }
	        
	        while(j<=end){
	            aux[k]=arr.get(j);
	            j++;
	            k++;
	        }
	        
	        k=0;
	        for(int l = start; l <= end; l++){
	            arr.set(l,aux[k++]);
	        }      
	  }
}
