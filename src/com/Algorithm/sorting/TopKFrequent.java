package com.Algorithm.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * https://leetcode.com/problems/top-k-frequent-elements/
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 */
public class TopKFrequent {

	public static void main(String[] args) {
		
		String str = "hello";
		
		List<Integer> list = new ArrayList<>(Arrays.asList(5, 4, 1, 3, 2, 7, 6));

		System.out.println(topKFrequent(list, 7));
		
		List<Integer> list2 = new ArrayList<>(Arrays.asList(1, 1, 1, 4, 3, 3, 2));
		System.out.println(topKFrequent(list2, 2));
	}


	public static List<Integer> topKFrequent(List<Integer> lists, int k) {
		
		Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
		
		for (Integer ele : lists) {
			//freq.compute(ele, (key, v) -> value == null ? 0 : v + 1);
			 freq.put(ele, freq.getOrDefault(ele, 0) + 1);
		}
		
		Queue<Integer> pq = new PriorityQueue<Integer>((n1, n2) -> freq.get(n1) - freq.get(n2));
		
		for (Integer count : freq.keySet()) {
			pq.add(count);
			
			if (pq.size() > k) {
				pq.poll();
			}
		}
		
		ArrayList<Integer> ans = new ArrayList<Integer>(k);
		
		for (int i = k - 1; i >= 0; i--) {
			// using zero is a hack
			ans.add(0, pq.poll());
		}
				
    return ans;
	}
}
