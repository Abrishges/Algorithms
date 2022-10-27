package com.Algorithm.recurs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*L shape
The chess knight has a unique movement, it may move two squares vertically and one square horizontally, 
or two squares horizontally and one square vertically
2 moves horizontally, 1 move vertically
2 moves vertically, 1 move horizontally
1 moves horizontally, 2 move vertically
1 moves vertically, 2 move horizontally

//length is number hopes 
distinct_numbers(starting digit -> 1, length -> 1) ->  return 2
*/
public class KnightDialer {
    
	int sum = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		KnightDialer nd = new KnightDialer();
		int result = nd.knightDialer(1, 2);
		
	    System.out.println(result);
	}
	
	public static List<Integer> moves (int digit) {
		
		switch (digit) {
		  case 0: return Arrays.asList(4, 6);
		  case 1: return Arrays.asList(6, 8);
		  case 2: return Arrays.asList(7, 9);
		  case 3: return Arrays.asList(4, 8);
		  case 4: return Arrays.asList(3, 9, 0);
		  case 5: return Arrays.asList();
		  case 6: return Arrays.asList(1, 7, 0);
		  case 7: return Arrays.asList(6, 2);
		  case 8: return Arrays.asList(1, 3);
		  case 9: return Arrays.asList(4, 2); 
		}
		
		return new ArrayList<Integer>();
	}
	
	public int knightDialer(int digit, int length) {
		
		if (length == 0 ) return 1;
		
		//int sum = 0;
		
		List<Integer> list = moves(digit);
		
		for (int num : list) {
		   sum += knightDialer(num, length - 1);
		}
		
		return sum;
	}
}
