package com.HackerRank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leaderboard2 {

	public static void main(String[] args) {
		
		List<Integer> ranked = new ArrayList<Integer>();
		             ranked.add(100);
		             ranked.add(100);
		             ranked.add(50);
		             ranked.add(40);
		             ranked.add(40);
		             ranked.add(20);
		             ranked.add(10);
		             
		List<Integer> player = new ArrayList<Integer>();
		
		player.add(5);
		player.add(25);
		player.add(50);
		player.add(120);
		
		System.out.println(leaderBoard(ranked, player));
	}

	public static List<Integer> leaderBoard(List<Integer> ranked, List<Integer> player) {
		
		Map<Integer, Integer> ranks = new HashMap<Integer, Integer>();	
		int rank = 1;
		for (int i = 0; i < ranked.size(); i++) {
            if (!ranks.containsKey(ranked.get(i))) {
            	ranks.put(ranked.get(i), rank++);
            }
		}
		
		List<Integer> aliceRank = new ArrayList<Integer>();
		int index = ranked.size() - 1;	
		
		for (Integer score : player) {
			for ( int j = index ; j >= 0 ; j--) {
				if (score >= ranked.get(j)) {
					 rank = ranks.get(ranked.get(j));
					 index = j - 1;
				} else {
					break;
				}
			}
			
			aliceRank.add(rank);
		}
		
	 return aliceRank;	
	}
}
