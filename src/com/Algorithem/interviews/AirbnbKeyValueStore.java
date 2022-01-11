package com.Algorithem.interviews;

import java.util.Map;

/**
 * implement an in-memory tree key value store 
 * 
 * Definitions: 
 * path is a / separate string describing the node. Example  /animals/dogs/german_shapard
 * Values are all Strings 
 * 
 * API: 
 * 
 * get(path): string -> returns the values of string at a given path 
 * set(path, value) -> changes the value of a given node to the new value. Should error out if the path 
 * doesn't not currently exit. 
 * create(path, value) - > create a new node and sets it to a given value. Should error out if the node already exists 
 * or if the nodes's parent does not exist. That is level1/level2 can not be created if level1/ has not been already created. 
 * delete(path) -> delete a node, but only if it doesn't have any children. 
 * 
 * example 
 * TreeKV 
 * 
 * treeKV.create("/animals", "foo");
 * treeKV.create("/animals/dogs", "foo2");
 * treeKV.create("/animals/dogs/german_shapard", "foo3");
 * treeKV.get("/animals/dogs/german_shapard") -> foo3
 * treeKV.set("/animals/dogs/german_shapard", "foo4");
 * treeKV.get("/animals/dogs/german_shapard") -> foo4
 * treeKV.delete("/animals/dogs/german_shapard")
 * treeKV.get("/animals/dogs/german_shapard") -> error
 */

public class AirbnbKeyValueStore {
	
	class Node {
		String value;
		Map<String, Node> map; 
	    //Node parent; 
		
		public Node(String value) {
			this.value = value;
		}
	}
	
	/**
	 * Node animals = new Node();
	 * Node doges = new Node();
	 * Node germanshapard = new Node();
	 * animals.map.put("dogs", dogs)
	 * doges.map.put("germanshapard", germanshapard);
	 * root.map.put("animals", animals);
	 */
	
	 Node root = new Node("");
	
	public void create(String path , String value) {
		
		Node current = root;  
		String [] arr = path.split("/");
		
		for (int i = 0 ; i < arr.length - 1; i++) {
			
			if (current.map.containsKey(arr[i])) {
				current = current.map.get(arr[i]);
			} else {
				//throw exception
			}
		}
		
		if (current.map.containsKey(arr[arr.length - 1])) {
			//throw exception
		}
		
		current.map.put(arr[arr.length - 1], new Node(value));
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
