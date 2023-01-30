package com.Algorithem.ArraysAndLists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class EmployeeFreeTime {

	public static void main(String[] args) {
		// [[[1,2],[5,6]],[[1,3]],[[4,10]]]

		List<List<Interval>> list = new ArrayList<List<Interval>>();

		EmployeeFreeTime ep = new EmployeeFreeTime();

		ArrayList<Interval> emp1 = new ArrayList<Interval>();
		emp1.add(ep.new Interval(1, 2));
		emp1.add(ep.new Interval(5, 6));

		ArrayList<Interval> emp2 = new ArrayList<Interval>();
		emp2.add(ep.new Interval(1, 3));

		ArrayList<Interval> emp3 = new ArrayList<Interval>();
		emp3.add(ep.new Interval(4, 10));

		list.add(emp1);
		list.add(emp2);
		list.add(emp3);

		List<Interval> free = ep.employeeFreeTime(list);
	}

	class Interval {
		public int start;
		public int end;

		public Interval() {
		}

		public Interval(int _start, int _end) {
			start = _start;
			end = _end;
		}
	}

	public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
		// merge and sort intervals
		List<Interval> intervals = merge(schedule);
		List<Interval> freeInterval = new ArrayList<Interval>();

		if (intervals.size() <= 1)
			return freeInterval;

		for (int i = 1; i < intervals.size(); i++) {

			Interval interval = new Interval(intervals.get(i - 1).end, intervals.get(i).start);
			freeInterval.add(interval);

		}
		return freeInterval;
	}

	public List<Interval> merge(List<List<Interval>> schedule) {

		List<Interval> sortedList = new ArrayList<Interval>();

		for (List<Interval> list : schedule) {
			for (Interval interval : list) {
				sortedList.add(interval);
			}
		}

		Collections.sort(sortedList, new Comparator<Interval>() {

			public int compare(Interval interval1, Interval interval2) {

				return interval1.start < interval2.start ? -1 : 1;
			}
		});

		LinkedList<Interval> merge = new LinkedList<Interval>();

		for (Interval interval : sortedList) {

			if (merge.isEmpty() || merge.getLast().end < interval.start) {
				merge.add(interval);
			} else {
				merge.getLast().end = Math.max(merge.getLast().end, interval.end);
			}

		}

		return merge;
	}

}
