package com.CareerCup.com;

import java.util.ArrayList;
import java.util.List;

/*
 * Intersection of sorted Interval Lists
 * IntervalA = [1,2], [5,7]
 * IntervalB = [2,6]
 * Answer [5, 6]
 */
public class Interaval {

  public static void main(final String args[]) {
    // test one
    final List<Interval> intervalA = new ArrayList<>();
    intervalA.add(new Interval(1, 2));
    intervalA.add(new Interval(5, 7));
    final List<Interval> intervalB = new ArrayList<>();
    intervalB.add(new Interval(2, 6));
    final List<Interval> intersaction = Intersactions(intervalA, intervalB);
    System.out.println(intersaction);
    // test two
    final List<Interval> intervalc = new ArrayList<>();
    intervalc.add(new Interval(0, 10));
    intervalc.add(new Interval(11, 13));
    final List<Interval> intervald = new ArrayList<>();
    intervald.add(new Interval(2, 12));
    System.out.println(Intersactions(intervalc, intervald));
  }

  public static List<Interval> Intersactions(final List<Interval> intervalA, final List<Interval> intervalB) {
    int i = 0, j = 0;
    final List<Interval> intersaction = new ArrayList<>();
    while (i < intervalA.size() && j < intervalB.size()) {
      final int start = Math.max(intervalA.get(i).getStart(), intervalB.get(j).getStart());
      final int end = Math.min(intervalA.get(i).getEnd(), intervalB.get(j).getEnd());

      if (end > start) {
        intersaction.add(new Interval(start, end));
      }
      if (intervalA.get(i).getEnd() < intervalB.get(j).getEnd()) {
        i++;
      } else {
        j++;
      }
    }
    return intersaction;
  }
}


class Interval {
  private int start;
  private int end;

  public Interval(final int start, final int end) {
    this.start = start;
    this.end = end;
  }

  public int getStart() {
    return this.start;
  }

  public void setStart(final int start) {
    this.start = start;
  }

  public int getEnd() {
    return this.end;
  }

  public void setEnd(final int end) {
    this.end = end;
  }

  @Override
  public String toString() {
    return "Interval [start=" + this.start + ", end=" + this.end + "]";
  }
}
