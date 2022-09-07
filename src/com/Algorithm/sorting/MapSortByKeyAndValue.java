package com.Algorithm.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapSortByKeyAndValue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	 //Generic method to sort based value
	 public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
	        List<Entry<K, V>> list = new ArrayList<>(map.entrySet());
	        list.sort(Entry.comparingByValue());

	        Map<K, V> result = new LinkedHashMap<>();
	        for (Entry<K, V> entry : list) {
	            result.put(entry.getKey(), entry.getValue());
	        }

	        return result;
	    }
	 
	 //using java 8 
	 Map<String, Integer> map = new HashMap<String, Integer>();
	 
	 //ascending order
	 public void sortByJava8() {
		 Stream<Map.Entry<String, Integer>> sorted =
				    map.entrySet().stream()
				       .sorted(Map.Entry.comparingByValue()); 
		 
      // descending order
		 Stream<Map.Entry<String,Integer>> sortedDes =
				    map.entrySet().stream()
				       .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()));
	 }
	 
	 
	 
	 class ValueComparator implements Comparator<String> {
		    Map<String, Double> base;

		    public ValueComparator(Map<String, Double> base) {
		        this.base = base;
		    }

		    // Note: this comparator imposes orderings that are inconsistent with
		    // equals.
		    public int compare(String a, String b) {
		        if (base.get(a) >= base.get(b)) {
		            return -1;
		        } else {
		            return 1;
		        } // returning 0 would merge keys
	    }

	 }
	 
	 // Then I can use the above class in TreeMap
	 //HashMap<String, Double> map = new HashMap<String, Double>();
     //ValueComparator bvc = new ValueComparator(map);
     //TreeMap<String, Double> sorted_map = new TreeMap<String, Double>(bvc);
	 
	 
	 Map<String, String> map2 = new HashMap<>();

	// Convert all Map keys to a List
	List<String> result = new ArrayList(map2.keySet());

	// Convert all Map values to a List
	List<String> result2 = new ArrayList(map2.values());
			
	// Java 8, Convert all Map keys to a List
	List<String> result3 = map2.keySet().stream()
		.collect(Collectors.toList());

	// Java 8, Convert all Map values  to a List
	List<String> result4 = map2.values().stream()
		.collect(Collectors.toList());

	// Java 8, seem a bit long, but you can enjoy the Stream features like filter and etc. 
	List<String> result5 = map2.values().stream()
		.filter(x -> !"apple".equalsIgnoreCase(x))
		.collect(Collectors.toList());
}
