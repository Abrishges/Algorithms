package com.Algorithm.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
 * Given an array of numbers, rearrange them in-place so that even numbers appear before odd ones.
 * 4, 9, 5, 2, 9, 5, 7, 10   ----> [4, 2, 10, 9, 9, 5, 7, 5]
 *  [1, 2, 3, 4] ---> [4, 2, 3, 1]
 */
public class EvensAndOdd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(4, 9, 5, 2, 9, 5, 7, 10));
		System.out.print(list);
		List<Integer> test = segregate_evens_and_odds(list);
		System.out.println(test);

	}
	
	
	static ArrayList<Integer> segregate_evens_and_odds(ArrayList<Integer> numbers) {
        // Write your code here.
        int indexL = 0;
        int indexR = numbers.size()-1;
        Integer temp;
      
        while( indexL < indexR ) {
            if(numbers.get(indexL) %2 == 0){ //if Even
                indexL ++;
            }else if (numbers.get(indexR) %2 !=0){
                indexR --;
            } else {
                //Swap
                temp = numbers.get(indexL); 
                numbers.set(indexL , numbers.get(indexR)); 
                numbers.set(indexR, temp);
                indexL ++;
                indexR --;
            }
        }
        
        return numbers;
    }
}
