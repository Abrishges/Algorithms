package com.Algorithm.sorting;

import java.util.ArrayList;
import java.util.Collections;

/*
 * Given an array of meeting time intervals where intervals[i] = [starti, endi], determine if a person could attend all meetings.
 *  Input: intervals = [[0,30],[5,10],[15,20]]
 *  Output: false
 *  Input: intervals = [[7,10],[2,4]]
 *  Output: true
 */

public class MeetingRooms {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean canAttendAllmeetings(ArrayList<ArrayList<Integer>> intervals) {
		
		 Collections.sort(intervals, (a, b) ->  Integer.compare(a.get(0), b.get(0)));
	        
	        for(int i = 0; i < intervals.size() - 1; i++) {
	            
	            if (intervals.get(i).get(1) > intervals.get(i + 1).get(0)) {
	                return false;
	            }
	        }
		
		return true;
	}
}
