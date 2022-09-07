package com.Algorithem.ArraysAndLists;

public class PlusOne {

	  public class ListNode {
	      int val;
	      ListNode next;
	      ListNode() {}
	      ListNode(int val) { this.val = val; }
	      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	 }

	public static void main(String[] args) {
		PlusOne po = new PlusOne();
		ListNode head = po.new ListNode(1);
		head.next = po.new ListNode(2);
		head.next.next = po.new ListNode(3);
		ListNode temp = po.plusOne2(head);
		while (temp != null) {
			System.out.println(temp.val);
			temp = temp.next;
		}
	}
	
	 public ListNode plusOne(ListNode head) {
	        
	        ListNode list = revers(head);
	        if (list.val != 9) {
	            list.val = list.val + 1; 
	            ListNode newHead = revers(list);
	            
	            return newHead;
	        } else {
	            
	            ListNode temp = list;
	        
	            while(temp != null && temp.val == 9) {
	                temp.val = 0;
	                temp = temp.next;
	            }
	            
	            if (temp == null) {
	              ListNode node = new ListNode(1);
	                node.next = list;
	                return node;
	            } else {
	                  temp.val = temp.val + 1;                
	            }
	            
	        }
	        
	       return revers(list);
	    }
	    
	    public ListNode revers(ListNode head) {
	        ListNode temp = null;
	        ListNode cur = head.next;
	        
	        while (cur != null) {
	            head.next = temp;
	            temp = head;
	            head = cur; 
	            cur = cur.next;
	        }
	        
	        head.next = temp;
	       
	        return head;
	    }
	    
	    //Other simples way to solve this problem 
	    
	    public ListNode plusOne2(ListNode head) {
	    	ListNode temp = head;
	    	ListNode noneNine = null;
	    	
	    	while(temp != null) {
	    		if(temp.val != 9) {
	    			noneNine = temp;
	    		}
	    		temp = temp.next;
	    	}
	    	
	    	if (noneNine == null) {
	    		ListNode newHead = new ListNode(1);
	    		newHead.next = head;
	    		while(head != null) {
	    			head.val = 0; 
	    			head = head.next;
	    		}
	    		
	    		return newHead;
	    	}
	    	
	    	noneNine.val = noneNine.val + 1; 
	    	while(noneNine.next != null) {
	    		noneNine = noneNine.next;
	    		noneNine.val = 0;
	    	}
	      return head;
	    }
}
