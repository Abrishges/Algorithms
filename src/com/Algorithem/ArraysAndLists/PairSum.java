package com.Algorithem.ArraysAndLists;

//https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/
public class PairSum {

	public static void main(String[] args) {
		PairSum ps = new PairSum();
		ListNode node = ps.new ListNode(5);
		node.next = ps.new ListNode(4);
		node.next.next = ps.new ListNode(2);
		node.next.next.next = ps.new ListNode(1);

		System.out.println(ps.pairSum(node));

	}

	// Definition for singly-linked list.
	public class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public int pairSum(ListNode head) {

		ListNode fast = head;
		ListNode slow = head;
		ListNode prev = null;

		while (fast != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}

		prev.next = null;
		ListNode head2 = reverse(slow);
		ListNode temp = head;
		int max = Integer.MIN_VALUE;
		while (temp != null) {
			max = Math.max(max, (temp.val + head2.val));
			temp = temp.next;
			head2 = head2.next;
		}

		return max;
	}

	public ListNode reverse(ListNode head) {
		ListNode cur = head;
		ListNode prev = null;

		while (cur != null) {
			head = cur;
			cur = cur.next;
			head.next = prev;
			prev = head;
		}

		return head;
	}
}
