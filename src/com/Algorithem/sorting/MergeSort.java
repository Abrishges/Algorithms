package com.Algorithem.sorting;

import java.util.ArrayList;

public class MergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//[5, 8, 3, 9, 4, 1, 7]
		
		ArrayList<Integer> list = new ArrayList<Integer>();
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
    
    static void merge(ArrayList<Integer> list, int l, int m, int r) {
        
        int n1 = m - l + 1;
        int n2 = r - m; 
        int [] arr1 = new int[n1];
        int [] arr2 = new int[n2];
        
        for (int i = 0 ; i < n1 ; i++) {
            arr1[i] = list.get(i); 
        }
        
        for (int i = 0 ; i < n2 ; i++) {
            arr2[i] = list.get(i); 
        }
        
        int i = 0;
        int j = 0; 
        int k = 0;
        
        while ( i < arr1.length && j < arr2.length) {
            
            if (arr1[i] >= arr2[j]) {
                list.set(k, arr1[i]);
                i++;
            } else {
                list.set(k, arr2[j]);
                j++;
            }
            k++;
        }
        
        while (i < arr1.length) {
             list.set(k, arr1[i]);
             i++;
             k++;
        }
        
        while (j  < arr2.length) {
           list.set(k, arr2[j]);
                j++;  
                k++;
        }
    }
}
