package com.Algorithm.Basic;

import java.util.Iterator;
import java.util.Set;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

/**
 * 
 * @author abereham
 * 
 * HashMap vs HashMultiSet
 * TreeMap vs TreeMultiSet
 * LinkedHashMap vs LinkedHashMultiSet
 * ConcurrentHashMap vs ConcurrentHashMultiSet
 * ImmutableHashMap vs ImmutableMultiSet
 *
 */

public class Maps {
	
public static void main(String args[])  {
	
	// Multiset of String
	Multiset<String> multiset = HashMultiset.create();

	// Adding elements to the set
	multiset.add("country", 2);
	multiset.add("Hello");
	multiset.add("test", 3);
	
	System.out.printf("multiSet result: %s %n", multiset);
	
	multiset.remove("test", 1);
	
	Set<String> set = multiset.elementSet();
	System.out.printf("Set result: %s %n", set);
	Iterator<String> it = multiset.iterator();
	System.out.println("****** Iterator output *****");
     while(it.hasNext()) {
    	 System.out.println(it.next());
     }     
     
     Iterator<String> it2 = multiset.iterator();
     System.out.println("----- Another way of doing iterator ----- ");
     it2.forEachRemaining(e -> System.out.println(e));
     
     System.out.printf("Total size: %s %n", multiset.size());
     System.out.printf("Test count: %s %n", multiset.count("test"));
	
	}

}
