package com.HackerRank;

import java.util.ArrayList;
import java.util.List;

public class AlmostSorted {

	//https://www.hackerrank.com/challenges/almost-sorted/problem
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> list = new ArrayList<Integer>();
		//1 5 4 3 2 6
		list.add(4104);
		list.add(8529);
		list.add(49984);
		
		list.add(54956);
		list.add(95929);
		list.add(108831); 
		
		list.add(894947);  //7
		list.add(125082);
		list.add(137123);
		
		list.add(116375);  //10
		//list.add(116375);
		list.add(911042);
		list.add(912042);
		
		almostSorted(list);
	}
	
    public static void almostSorted(List<Integer> arr) {
    
    	int p1, p2, p3, v1, v2;
    	p1 = p2 = p3 = v1 = v2 = -1;
    	
    	for (int i = 0 ; i < arr.size() - 1; i++) {
    		
    		if (arr.get(i +1) < arr.get(i) && p1 == -1) {
    			p1 = i;
    			v1 = i +1;
    		} else if (v1 != -1 && arr.get(i +1) <= arr.get(v1) && arr.get(v1) == arr.get(i)) {
    			v1 = i + 1;
    		} else if (arr.get(i +1) <= arr.get(i) && p1 != -1 && p2 == -1) {
    			
				p2 = i;
				v2 = i + 1;
    		} else if (arr.get(i + 1) < arr.get(i) && p1 != -1 && p2 != -1) {
    		    p3 = i;
    		}
    	}
    	
    	
    	//Check conditions
    	if (p3 != -1) {
    		System.out.println("no");
    	} else if (p1 == -1 && p2 == -1 && v1 == -1 && v2 == -1) {
    		// it mean sorted
    		System.out.println("yes");
    	}
    	else if (p1 != -1 && p2 != -1 && v1 != -1 && v2 != -1 && p3 == -1) {
    		//Check for swap conditions
    		if (arr.get(p1) < arr.get(p2) || p1 != v1 - 1 ||
    				p1 != 0 && arr.get(p1 - 1) > arr.get(v2) ||
    				arr.get(v1) < arr.get(v2) ||
    				arr.size() > v2 + 1 && arr.get(v2 + 1) < arr.get(p1) ||
    				arr.size() > v2 + 1 && arr.get(v2 + 1) < arr.get(v2)
    				) {
    			System.out.println("no");
    		} else {
    			swap(p1, v2);
    		}
    	} else if (p1 != -1 && v1 != -1 && p2 == -1) {    
    		
    		if (arr.size() == 2) {
    			swap(p1, v1);
    		} else if (p1 != 0 && arr.get(p1 - 1) > arr.get(v1) ||
    				arr.size() > v1 + 1 && arr.get(v1 + 1) < arr.get(p1)
    			) {
 			   System.out.println("no");
 			} else if (p1 == v1 - 1) {
 				swap(p1, v1);
 			} else {
 				reverse(p1, v1);	
 			}
    	}
    }
    
    public static void swap(int p1, int v1) {
		  System.out.println("yes");
		  p1 = p1+1;
		  v1 = v1+1;
		  System.out.println("swap "+ p1 +" "+v1);
    }
    
    public static void reverse(int p1, int v1) {
		System.out.println("yes");	
		p1 = p1+1;
		v1 = v1+1;
		System.out.println("reverse " + p1 +" "+v1);
    }
}