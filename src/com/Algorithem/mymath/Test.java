package com.Algorithem.mymath;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         String str = "abc";
         System.out.println(str.charAt(0) + str.charAt(1));
         System.out.println(str.charAt(0) + str.charAt(1) + str.charAt(2));
                  
         Map<Integer, List<String>> mp = new HashMap<>();    
         mp.values().stream().collect(Collectors.toList());
         
         Map<Integer, List<String>> mps = new HashMap<>();
         mps.values().stream().collect(Collectors.toList());
         
         System.out.println(str.charAt(0));
         
         
         String test = "2.5.33";
         
         String [] array = test.split("\\.");
         System.out.println(Arrays.toString(array));
         
	}
}
