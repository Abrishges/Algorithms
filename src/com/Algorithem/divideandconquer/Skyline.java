package com.Algorithem.divideandconquer;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/the-skyline-problem/solution/
//Skyline brute force approach
public class Skyline {

	public static void main(String[] args) {

		int[][] buildings = { { 2, 9, 10 }, { 3, 7, 15 }, { 5, 12, 12 }, { 15, 20, 10 }, { 19, 24, 8 } };

		Skyline skyline = new Skyline();

		System.out.println(skyline.getSkyline(buildings));
	}

	//Let code has better solution
	public List<List<Integer>> getSkyline(int[][] buildings) {

		int max = 0;

		for (int[] xs : buildings) {
			max = Math.max(max, xs[1]);
		}

		int[] heights = new int[max + 2];

		for (int[] xs : buildings) {

			for (int i = xs[0]; i <= xs[1]; i++) {
				heights[i] = Math.max(heights[i], xs[2]);
			}
		}

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> list = null;

		for (int i = 0; i < heights.length; i++) {

			if (i == 0 && heights[i] == 0)
				continue;

			list = new ArrayList<Integer>();

			if (i == 0 || heights[i] > heights[i - 1]) {
				list.add(i);
				list.add(heights[i]);
			} else {
				if (heights[i - 1] == heights[i]) continue;
				list.add(i - 1);
				if (heights[i - 1] != 0 && heights[i] == 0) {
					list.add(0);
				} else {
					list.add(heights[i]);
				}
			}

			result.add(list);
		}

		return result;
	}
}
