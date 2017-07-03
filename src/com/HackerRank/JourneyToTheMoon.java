/**
 * 
 */
package com.HackerRank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author aberehamwodajie
 *
 * May 21, 2017
 */
public class JourneyToTheMoon {
	
	public static Map<Integer, Node> map = new HashMap<Integer, Node>();
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
         Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int p = in.nextInt();
        JourneyToTheMoon ds = new JourneyToTheMoon();
         for(int i = 0; i < n ; i++) {
             ds.makeSet(i);
         }
        
        for (int j = 0 ; j<p ; j++){
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
        Map.Entry<Integer,Integer> entry1 = mp.entrySet().iterator().next();
        Integer sum = entry1.getValue();
        Integer firstkey = entry1.getKey();
        int total = 0;
        for (Map.Entry<Integer, Integer > entry : mp.entrySet()){
        	if(firstkey != entry.getKey()) {
              total += sum * entry.getValue();
              sum += entry.getValue();
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
