package com.Algorithm.Basic;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

public class MultiSet {
	
public static void main(String args[])  {
	
	// Multiset of String
	Multiset<String> multiset = HashMultiset.create();

	// Adding elements to the set
	multiset.add("contry");
	multiset.add("contry");
	  
	System.out.println(multiset);
	
	}

}
