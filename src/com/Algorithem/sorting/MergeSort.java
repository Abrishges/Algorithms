package com.Algorithem.sorting;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// [5, 8, 3, 9, 4, 1, 7]
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(5);
		list.add(8);
		list.add(3);
		list.add(9);
		list.add(4);
		list.add(1);
		list.add(7);

		System.out.println(list);
		 merge_sort(list);
		System.out.println(list); 
	}

	//This is top-down approach using divide and conquer 
	static void merge_sort(ArrayList<Integer> arr) {

//		if (arr.size() <= 1)
//			return arr;

		mergeSort(arr, 0, arr.size() - 1);

		//return arr;
	}

	static void mergeSort(ArrayList<Integer> list, int l, int r) {

		if (l < r) {
			int m = (l + (r - l) / 2);
			mergeSort(list, l, m);
			mergeSort(list, m + 1, r);
			merge(list, l, m, r);
		}
	}
	
	static void merge(ArrayList<Integer> list, int l, int m, int r) {

		int n1 = m - l + 1;
		int n2 = r - m;
		int[] arr1 = new int[n1];
		int[] arr2 = new int[n2];

		for (int i = 0; i < arr1.length; i++) {
			arr1[i] = list.get(l + i);
		}

		for (int j = 0; j < arr2.length; j++) {
			arr2[j] = list.get(m + 1 + j);
		}

		int i = 0;
		int j = 0;
		int k = l; //This is very important

		while (i < arr1.length && j < arr2.length) {

			if (arr1[i] <= arr2[j]) {
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

		while (j < arr2.length) {
			list.set(k, arr2[j]);
			j++;
			k++;
		}
	}
	
	
	public static void mergeSortIterative(int[] array)
    {
        if(array == null)
        {
            return;
        }
 
        if(array.length > 1)
        {
            int mid = array.length / 2;
 
            // Split left part
            int[] left = new int[mid];
            for(int i = 0; i < mid; i++)
            {
                left[i] = array[i];
            }
             
            // Split right part
            int[] right = new int[array.length - mid];
            for(int i = mid; i < array.length; i++)
            {
                right[i - mid] = array[i];
            }
            mergeSortIterative(left);
            mergeSortIterative(right);
            mergeIterative(array, left, right);
      
        }
    }
	
     static void mergeIterative(int[] array, int[] left, int[] right) {
	      int i = 0;
          int j = 0;
          int k = 0;

          // Merge left and right arrays
          while(i < left.length && j < right.length)
          {
              if(left[i] < right[j])
              {
                  array[k] = left[i];
                  i++;
              }
              else
              {
                  array[k] = right[j];
                  j++;
              }
              k++;
          }
          // Collect remaining elements
          while(i < left.length)
          {
              array[k] = left[i];
              i++;
              k++;
          }
          while(j < right.length)
          {
              array[k] = right[j];
              j++;
              k++;
          }
	}
}
