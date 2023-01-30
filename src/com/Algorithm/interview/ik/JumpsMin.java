package com.Algorithm.interview.ik;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*

There are n elements in an array
From a given index i, you can jump either backward or forward arr[i]
Return the min number of jumps needed to reach the last index for each index
If it's not possible to reach the last index, return -1

Example
arr    = [1, 3, 1, 3, 4]
output = [2, 1, 2, 3, 0]

index 0: 1
index 1: 4
index 2: 1, 3
index 3 : 1
index 4 : 1
... 


[1, 1, 2, 1, 1]


//other similar examples 
 * https://leetcode.com/problems/jump-game-ii/
 * https://leetcode.com/problems/jump-game-iii/
 * https://leetcode.com/problems/jump-game-vii/
 * https://leetcode.com/problems/jump-game-viii/
*/
public class JumpsMin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] minJumps(int[] arr) {

		Map<Integer, List<Integer>> mp = new HashMap<Integer, List<Integer>>();

		for (int i = 0; i < arr.length; i++) {
			int forward = i + arr[i];
			int backward = i - arr[i];

			List<Integer> list = new ArrayList<Integer>();
			if (forward < arr.length) {
				list.add(forward);
			}

			if (backward >= 0) {
				list.add(forward);
			}

			mp.put(i, list);
		}

		int[] ans = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {
			int x = recursive(i, mp);
			ans[i] = x;
		}

	}

	public int recursive(int idx, Map<Integer, List<Integer>> mp) {

		if (idx == 4)
			return 0;

		List<Integer> list = mp.get(idx);

		for (int x : list) {

			recursive(x, mp);
		}

	}
	
	
	
	
	

}
