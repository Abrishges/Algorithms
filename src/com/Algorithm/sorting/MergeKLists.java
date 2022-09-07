package com.Algorithm.sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * https://leetcode.com/problems/merge-k-sorted-lists/
 * 
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 * Merge all the linked-lists into one sorted linked-list and return it.
 * Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6
 */
public class MergeKLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 
   // For your reference:
    class LinkedListNode {
        Integer value;
        LinkedListNode next;

        LinkedListNode(Integer value) {
            this.value = value;
            this.next = null;
        }
    }
    
    static LinkedListNode mergeKLists(ArrayList<LinkedListNode> lists) {
        
          Comparator<LinkedListNode> nodeComparator = new Comparator<LinkedListNode>() {
              
              @Override
              public int compare(LinkedListNode n1, LinkedListNode n2) {
                  return n1.value - n2.value;
              }
          };
              
              
         Queue<LinkedListNode> pq = new PriorityQueue<LinkedListNode>(nodeComparator);
        
         for (LinkedListNode node: lists) {
              if (node != null) {
                   pq.add(node);   
              }
         }
         
         MergeKLists ml = new MergeKLists();
         LinkedListNode head = ml.new LinkedListNode(0);
         LinkedListNode temp = head;
         
         while(!pq.isEmpty()) {
             
             LinkedListNode node = pq.poll();
             temp.next = node;
             temp = temp.next;
              if (node.next != null) {
                  pq.add(node.next);
              }
         }
        
        return head.next;
    }

}
