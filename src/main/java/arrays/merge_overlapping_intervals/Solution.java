package arrays.merge_overlapping_intervals;

import java.util.ArrayList;
import java.util.Comparator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

/**
 * Definition for an interval.
 * public class Interval {
 * int start;
 * int end;
 * Interval() { start = 0; end = 0; }
 * Interval(int s, int e) { start = s; end = e; }
 * }
 */
// https://www.interviewbit.com/problems/merge-overlapping-intervals/
public class Solution {

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        intervals.sort(Comparator.comparingInt(o -> o.start));
        int i = 0;
        while (i <= intervals.size() - 1) {
            for (int j = i + 1; j < intervals.size(); j++) {
                if (intervals.get(i).end < intervals.get(j).start) {
                    break;
                }
                if (isOverlapping(intervals.get(i), intervals.get(j))) {
                    intervals.set(j, merge(intervals.get(i), intervals.get(j)));
                    intervals.set(i, null);
                    break;
                }
            }
            i++;
        }
        ArrayList<Interval> res = new ArrayList<>();
        for (Interval a : intervals) {
            if (a != null) res.add(a);
        }
        res.sort(Comparator.comparingInt(o -> o.start));
        return res;
    }

    private boolean isOverlapping(Interval a, Interval b) {
        if (a == null || b == null) return false;
        return Math.max(a.start, b.start) <= Math.min(a.end, b.end);
    }

    private Interval merge(Interval a, Interval b) {
        return new Interval(Math.min(a.start, b.start),
                Math.max(a.end, b.end));
    }

    public static void main(String[] args) {
        ArrayList<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(80, 93));
        intervals.add(new Interval(6, 41));
        intervals.add(new Interval(73, 95));
        intervals.add(new Interval(14, 95));
        intervals.add(new Interval(13, 78));
        ArrayList<Interval> merged = new Solution().merge(intervals);
        assertThat(merged, contains(new Interval(6, 95)));

        intervals = new ArrayList<>();
        intervals.add(new Interval(92, 98));
        intervals.add(new Interval(10, 86));
        intervals.add(new Interval(61, 91));
        intervals.add(new Interval(8, 71));
        intervals.add(new Interval(53, 65));
        intervals.add(new Interval(19, 79));
        intervals.add(new Interval(20, 50));
        merged = new Solution().merge(intervals);
        assertThat(merged, contains(new Interval(8, 91), new Interval(92, 98)));
    }
}
