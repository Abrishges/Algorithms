package com.HackerRank;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

//Container sort, https://www.hackerrank.com/challenges/organizing-containers-of-balls/problem
public class OrganizingContainers {
	
	public static void main(String[] args) {
		
		List<List<Integer>> container =  new ArrayList<>();
		
		List<Integer> container0 = new ArrayList<Integer>();
		container0.add(1);
		container0.add(3);
		container0.add(1);
		List<Integer> container1 = new ArrayList<Integer>();
		container1.add(2);
		container1.add(1);
		container1.add(2);
		List<Integer> container2 = new ArrayList<Integer>();
		container2.add(3);
		container2.add(3);
		container2.add(3);
		
		container.add(container0);
		container.add(container1);
		container.add(container2);
        System.out.println(organizingContainers(container));
	}

    public static String organizingContainers(List<List<Integer>> container) {
    // Write your code here
      
    	 int n = container.size();
    	 List<Integer> types = new ArrayList<>();
    	 List<Integer> noOfBallsPerContainer = new ArrayList<>();
    	 
    	for (int i = 0; i < n; i++) {
    		
    		int x = 0;
    		int m = container.get(i).size();
    	     for (int j = 0 ; j < m ; j++) {
    	    	 x += container.get(i).get(j);
    	     }
    	     noOfBallsPerContainer.add(x);
    	     
    	     int y = 0;
    	     for (int k = 0 ; k < n ; k++) {
    	    	 y += container.get(k).get(i);
    	     }
    	     types.add(y);

    	}
    	
    	
    	if(equalLists(types, noOfBallsPerContainer)) {
    		return "Possible";
    	}
    	
    	return "Impossible";
    }
    
    // May be we can improve this using Map
    // Or CollectionUtils.isEqualCollection or Hashmultiset
    public static boolean equalLists(List<Integer> one, List<Integer> two){     
        if (one == null && two == null){
            return true;
        }

        if((one == null && two != null) 
          || one != null && two == null
          || one.size() != two.size()){
            return false;
        }

        one = new ArrayList<Integer>(one); 
        two = new ArrayList<Integer>(two);   

        Collections.sort(one);
        Collections.sort(two);      
        return one.equals(two);
    }
}
