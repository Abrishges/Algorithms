package com.Algorithm.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MeetingRooms2 {
		
	public static void main(String args[]) {
		//[[9,10],[4,9],[4,17]]
		
		int [][] intervals = new int [3][3];
		intervals[0][0] = 11;
		intervals[0][1] = 20;
		
		intervals[1][0] = 4;
        intervals[1][1] = 19;
        		
		intervals[2][0] = 13;
		intervals[2][1] = 17;
		
		intervals[2][0] = 6;
		intervals[2][1] = 13;
		
		MeetingRooms2 mr = new MeetingRooms2();
		System.out.println(mr.minMeetingRooms2(intervals));
	}
    
    public int minMeetingRooms2(int[][] intervals) {
        
        Arrays.sort(intervals, (a, b)->Integer.compare(a[0],b[0]));
        Queue<Integer> minHeap = new PriorityQueue<Integer>();
         
        int count = 1;   
        minHeap.add(intervals[0][1]);
        
        for (int i = 1; i < intervals.length; i++) {
            
            if (minHeap.peek() <= intervals[i][0]) {
            	minHeap.poll();
            } else {
            	count++;
            }
            
        	minHeap.add(intervals[i][1]);
        }
        
        return count; 
    }
}
