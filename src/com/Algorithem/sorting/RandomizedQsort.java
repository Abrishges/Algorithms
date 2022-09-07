package com.Algorithem.sorting;

import java.util.ArrayList;

public class RandomizedQsort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		// [5, 8, 3, 9, 4, 1, 7]
		list.add(5);
		list.add(8);
		list.add(3);
		list.add(9);
		list.add(4);
		list.add(1);
		list.add(7);
		
		merge_sort(list);
		
		System.out.println(list);
	}

	static ArrayList<Integer> merge_sort(ArrayList<Integer> arr) {
	    // Write your code here.
	       
		 if (arr.size() <= 1) return arr;
		 
	     mergeSort(arr, 0, arr.size());
	    
	    return arr;
	}


	public static void mergeSort(ArrayList<Integer> arr, int l, int r) {
	      
	     if (l < r && r - l >= 1) {
	        int m = (l + r)/2 ;
	        mergeSort(arr, l , m);
	        mergeSort(arr, m + 1, r);
	        merge(arr, l, m, r);
	     }
	}

	public static void  merge(ArrayList<Integer> arr, int l, int m, int r) {
	    
		
	    ArrayList<Integer>list1 = new ArrayList<Integer>();
	    ArrayList<Integer>list2 = new ArrayList<Integer>();
	    
	    for (int i = l ; i <= m ; i++) {
	        list1.add(arr.get(i));
	    }
	    
	    for (int k = m + 1; k < r; k++) {
	        list2.add(arr.get(k));
	    }
	    
	    //System.out.println(arr);
	    //System.out.println(list1);
	   // System.out.println(list2);
	    
	    int i = 0; 
	    int j = 0; 
	    
	   // int k = 0;
	    
	    ArrayList<Integer> sortedList = new ArrayList<Integer>();
	     
	    while( i < list1.size() && j < list2.size()) {
	        
	         if (list1.get(i) <= list2.get(j)) {
	        	 sortedList.add(list1.get(i));
	             i++;
	         } else if (list2.get(j) < list1.get(i)) {
	        	 sortedList.add(list2.get(j));
	             j++;
	         }
	     }
	    
	    while (i < list1.size()) {
	    	sortedList.add(list1.get(i));
	        i++;
	    }
	    
	    while (j < list2.size()) {
	    	sortedList.add(list2.get(j));
	    	j++;
	    }
	    
	    int index = 0;
        int k = l;
        //Setting sorted array to original one
        while(index<sortedList.size()){
            arr.set(k, sortedList.get(index++));
            k++;
        }
        
        System.out.println(sortedList);
	}	
}



