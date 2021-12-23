package com.Algorithm.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class WordLadder {

    class Node {
        int len; 
        String str;
        public Node (String str, int len) {
            this.str = str;
            this.len = len;
        }
    }
    
    public boolean isAdjacent(String str1, String str2) {
           
         int count = 0; 
        for (int i = 0; i < str1.length(); i++) {
             if (str1.charAt(i) != str2.charAt(i)) {
                 count++;
             }
        }
        
        if (count == 1) return true;
        
        return false;
    }
    
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
          if (!wordList.contains(endWord)) {
              return 0;
          }
          
          if (beginWord.length() == 1) {
        	  return 2;
          }
        
          Queue<Node> q1 = new LinkedList<Node>();
          Queue<Node> q2 = new LinkedList<Node>();
        
          Map<String, Integer> visited1 = new HashMap<String, Integer>();
          Map<String, Integer> visited2 = new HashMap<String, Integer>();
        
          Node start = new Node(beginWord, 1);
          Node end = new Node(endWord, 1);
        
          q1.add(start);
          q2.add(end);
          visited1.put(start.str, 1);
          visited2.put(end.str, 1);
        
          while(!q1.isEmpty() && !q2.isEmpty()) {
              
                             
              Node cure1 = q1.remove();
              Node cure2 = q2.remove();
              
             for (int i = 0; i < wordList.size(); i++) {
                   
                  String ele =  wordList.get(i);
                 if(isAdjacent(cure1.str, ele) && !visited1.containsKey(ele)) {
                     
                      Node temp = new Node(ele, cure1.len + 1);
                      visited1.put(ele, temp.len);
                      q1.add(temp);
                     
                      if (temp.str.equals(end.str)){
                          return temp.len;
                      }
                     
                      if (visited2.containsKey(ele)) {
                          return visited2.get(ele) + temp.len - 1;
                      }   
                 }
                 
              
               }
              
             for (int i = 0; i < wordList.size(); i++) {
                   
                  String ele =  wordList.get(i);
                 if(isAdjacent(cure2.str, ele) && !visited2.containsKey(ele)) {
                     
                      Node temp = new Node(ele, cure2.len + 1);
                       
                      visited2.put(ele, temp.len);
                      q2.add(temp);
                      
                     
                      if (temp.str.equals(end.str)){
                          return temp.len;
                      }
                     
                      if (visited1.containsKey(ele)) {  
                          return visited1.get(ele) + temp.len - 1;
                      }   
                 }

               }
          }
      return 0;    
    }
    

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> list = new ArrayList<String>();
		
//		list.add("a");
//		list.add("b");
//		list.add("c");
		list.add("hot");
		list.add("dot");
		list.add("dog");
		
		//["hot","dot","dog"]
		
		WordLadder ladder = new WordLadder();
		
		int length = ladder.ladderLength("hot", "dot", list);
		System.out.println(length);
	}

}
