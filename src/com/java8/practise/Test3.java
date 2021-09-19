package com.java8.practise;

public class Test3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//1 5 4 3 2 6
		int arr[] = {1 ,5, 4 ,3 ,2 ,6};
		int l, r = 0;
		for (int i = 0 ; i < arr.length-1 ; i++) {
			
			if(arr[i] > arr[i+1]) {
				l = i;	
				while(i < arr.length-1 && arr[i] > arr[i+1]) {	
					r = i+1;
					i++;
				}
			} else {
				r = arr[i+1];
			}
		}
	}
}
