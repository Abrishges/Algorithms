/**
 * 
 */
package com.HackerRank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static Map<Integer, Node> map = new HashMap<Integer, Node>();
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
         Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int p = in.nextInt();
        Solution ds = new Solution();
        //make set, each astronauts
         for(int i = 0; i < n ; i++) {
             ds.makeSet(i);
         }
        //iterate through edges and union 
        for (int j = 0 ; j < p ; j++){
            int p1 = in.nextInt();
            int p2 = in.nextInt();
            ds.union(p1, p2);
        } 
        
        Map<Integer, Integer> mp = new HashMap<Integer, Integer>();
        for (int i = 0 ; i < n; i++){
               Node node = map.get(i);
               Node set = ds.findSet(node);
            if(mp.containsKey(set.data)){     
                mp.put(set.data, mp.get(set.data)+1);
            }else{
                mp.put(set.data, 1);
            }   
        }
        
        Map<Integer, List<Integer>> astroMap = new HashMap<Integer, List<Integer>>();
        List<Integer> astroList;
        
        for(int k = 0; k < n ; k++ ) {
        	Node node = map.get(k);
        	Node parent = ds.findSet(node);
        	int parentData = parent.data;
        	if(astroMap.containsKey(parentData)){
        		astroList = astroMap.get(parentData);
        		astroList.add(k);
        		astroMap.put(parentData, astroList);
        	} else {
        		astroList = new ArrayList<Integer>();
        		astroList.add(k);
        		astroMap.put(parentData, astroList);
        	}
        }
        
        for (Map.Entry<Integer, List<Integer>>entry : astroMap.entrySet()){
        	System.out.println("Keys: " + entry.getKey() + ", values: " + entry.getValue());
        }
        
        Map.Entry<Integer,Integer> entry1 = mp.entrySet().iterator().next();
        Integer sum = entry1.getValue();
        Integer firstkey = entry1.getKey();
        System.out.println("sum, Frist element: " + sum);
        int total = 0;
        for (Map.Entry<Integer, Integer > entry : mp.entrySet()){
        	if(firstkey != entry.getKey()) {
        	System.out.println(entry.getValue());
              total += sum * entry.getValue();
              System.out.println("total: " + total);
              sum += entry.getValue();
              System.out.println("sum: " + sum);
        	}
        }
        System.out.println(total);
        in.close();
     }
    
    class Node {
        int data;
        int rank;
        Node parent;
      }
    public void makeSet(int data){
        Node node = new Node();
        node.data = data;
        node.parent = node;
        node.rank = 0;
        map.put(data, node);
       }
    
    public Node findSet(Node node){
        Node parent = node.parent;
        if(parent == node)
            return node;
        node.parent = findSet(node.parent);      
        return node.parent;
       }
    
    public boolean union(int data1, int data2) {
        Node node1 = map.get(data1);
        Node node2 = map.get(data2);
        
        Node parent1 = findSet(node1);
        Node parent2 = findSet(node2);
        
        if (parent1.data == parent2.data)
            return false;
        
        if(parent1.rank >= parent2.rank) {
        	parent1.rank = (parent1.rank == parent2.rank) ? (parent1.rank +1) : parent1.rank;
        	parent2.parent = parent1;
        }else {
        	parent1.parent = parent2;
        }
        
        return true;
    }
}