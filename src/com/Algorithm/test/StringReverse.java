/**
 * 
 */
package com.Algorithm.test;

import java.util.Stack;

/**
 * @author aberehamwodajie
 *
 * Dec 30, 2016
 */
public class StringReverse {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String test = "Amazone web service";
		//System.out.println("Org: " + test);
		stackReverse(test);

	}
	
	public static void reverse(String  str){
		StringBuilder strBuilder = new StringBuilder();
		
		for (int i = str.length()-1 ; i >= 0; i--){
			strBuilder.append(str.charAt(i));
		}
		
		System.out.println("reversed: " + strBuilder.toString());
	}
	
 public static void stackReverse(String str) { 
	 
	 Stack stack = new Stack();
	 
	 StringBuilder strBuilder = new StringBuilder();
	 

		for (int i = 0 ; i < str.length(); i++){
			stack.push(str.charAt(i));
		}
	 
		for (int i = 0 ; i < str.length(); i++){
			strBuilder.append(stack.pop());
			//System.out.print(stack.pop());
			
		}
		System.out.println(strBuilder);
	 
 }

}
