package com.Algorithem.ArraysAndLists;

//https://leetcode.com/problems/reorder-list/
public class ReorderList {

	public static void main(String[] args) {

		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		
		ReorderList reorder = new ReorderList();
		reorder.reorderList(head);
	}
	
	  public void reorderList(ListNode head) {
	         
		  
	        ListNode fast = head;
	        ListNode mid = head; 
	        ListNode slow = null;
	        
	        while (fast != null && fast.next != null) {
	             slow = mid;
	             mid = mid.next;
	             fast = fast.next.next;
	        }
	        
	        ListNode head2 = null;
	        if (slow != null) {
	        	slow.next = null;
	        	head2 = revers(mid);
	        }
	       
	        ListNode temp1 = head;
	        ListNode temp2 = head2;
	        
	        while(temp1 != null && temp2 != null) {
	            
	            ListNode cur1 = temp1.next;
	            ListNode cur2 = temp2.next;
	            
	            temp1.next = temp2;
	            
	            if (cur1 != null) {
	               temp2.next = cur1;
	            }
	            
	            
	            temp2 = cur2;
	            temp1 = cur1;            
	        }
	        
	    }
	    
	    public ListNode revers(ListNode head) {
	        
	        ListNode temp = head.next;
	        head.next = null;
	        
	        while (temp != null) {
	            ListNode prev = head;
	            head = temp; 
	            temp = temp.next; 
	            head.next = prev;
	        }

	        return head;
	    }

}
