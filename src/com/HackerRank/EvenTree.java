/**
 * 
 */
package com.HackerRank;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author aberehamwodajie
 *
 * May 20, 2017
 */
public class EvenTree {
	
	private static Map<Integer, ArrayList<Integer>> map = new ConcurrentHashMap<Integer, ArrayList<Integer>>();
	
	public static void main(String args[]){
		 Scanner in = new Scanner(System.in);
		 System.out.println("Enter no vertics");
		 int noOfVertics = in.nextInt();
		 int noOfEdges = in.nextInt();
		 
		 for(int i = 1 ; i <= noOfVertics; i++){
			 map.put(i, new ArrayList<Integer>());
		 }
		 
		 for(int k= 1; k <= noOfEdges; k++){
			 int chaild = in.nextInt();
			 int parent = in.nextInt();
			 
			 map.get(parent).add(chaild);
		 }
		 in.close();
		 int count = 0;
		 for (int j = 1; j <= map.size(); j++){
			// int noOfChailds = countChailds(1);
			 if((countChailds(j)+1) % 2 == 0)
				 count ++;
		 }
		 
		 System.out.println("Number of evens: " + count);
	}
	
	public static int countChailds(int node){
		int totalChaild = map.get(node).size();
		System.out.println("totalChaild: " + node + ":" + totalChaild);
		for(int chaild: map.get(node)){
			totalChaild += countChailds(chaild);
			System.out.println("totalChaild from inside: " + node + ":" + totalChaild);
		}	
		return totalChaild;
	}

}
