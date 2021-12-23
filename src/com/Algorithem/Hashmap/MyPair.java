package com.Algorithem.Hashmap;

import java.util.HashSet;
import java.util.Set;

class Pairs {
	
	public int x; 
	public int y;
	
	public Pairs(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class MyPair {
	
	//Give an array of pairs of integers, find all symmetric pairs, i.e, pairs that mirror each other. For 
	//instance, pairs (x,y) and (y,x) are mirrors of each other.
	public void findSymmmetricPairs(Pairs [] pairs) {
		
		Set<String> set = new HashSet<String>();
		
		for (Pairs pair : pairs) {
			
			String p = "{" + pair.x + " , " + pair.y + "}";			
			String revPair = "{" + pair.y + " , " + pair.x + "}";
			
			if (set.contains(revPair)) {
				 System.out.println(p + "|" + revPair);
			} else {
				set.add(p);
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		
		Pairs [] pairs = {
				new Pairs(3, 4), new Pairs(1,2), new Pairs(5,2),
				new Pairs(7,10), new Pairs(4,3), new Pairs(2,5)
				};

		MyPair mypair = new MyPair();
		mypair.findSymmmetricPairs(pairs);
	}

}
