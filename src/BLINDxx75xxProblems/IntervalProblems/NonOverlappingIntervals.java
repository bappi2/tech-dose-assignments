package BLINDxx75xxProblems.IntervalProblems;

import java.util.Arrays;
import java.util.Comparator;

/*
https://leetcode.com/problems/non-overlapping-intervals/
Given an array of intervals intervals where intervals[i] = [starti, endi],
return the MINIMUM number of intervals you need to remove to make the rest of the intervals non-overlapping.
 */
public class NonOverlappingIntervals {

    public static int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length < 2) {
            return 0;
        }

        /*
        Sorting by end times is crucial in this problem because it helps you make a greedy choice at each step, which ultimately leads to an optimal solution.
When you sort the intervals by their end times, you're prioritizing intervals that finish earlier, which leaves more room for accommodating other intervals without overlaps. The key insight is that selecting an interval with the earliest end time maximizes the chance of fitting the next interval without overlapping.
By iterating through the sorted intervals and counting non-overlapping intervals, you ensure that you're always choosing intervals that don't overlap with the current non-overlapping interval set. By sorting by end times, you make the greedy choice that leads to an optimal solution for the problem.
To illustrate this with an example, consider the input intervals [[1,4],[2,3],[3,5],[6,7]]. When sorted by end times, the intervals become [[2,3],[1,4],[3,5],[6,7]]. By choosing the intervals with the earliest end times, you can keep [[2,3],[6,7]], which don't overlap. The minimum number of intervals to remove is 2 (i.e., [1,4] and [3,5]).
         */
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));

        int nonOverlappingCount = 1; // There is always 1 non overlapping count at the least in 2+ intervals
        int lastEndTime = intervals[0][1]; // start from first element's end time
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= lastEndTime) {
                lastEndTime = intervals[i][1];
                nonOverlappingCount++;
            }
        }
        return intervals.length - nonOverlappingCount;
    }

    public static int eraseOverlapIntervalsLeet(int[][] intervals) {
        if (intervals == null || intervals.length < 2) {
            return 0;
        }

        // Sort the intervals by their end times
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));

        // Initialize the end time of the first non-overlapping interval
        int lastEndTime = intervals[0][1];
        // Initialize the count of non-overlapping intervals to 1 (the first interval)
        int nonOverlappingCount = 1;

        // Iterate through the intervals starting from index 1
        for (int i = 1; i < intervals.length; i++) {
            // If the current interval's start time is greater than or equal to the last end time,
            // it doesn't overlap with the previous non-overlapping interval
            if (intervals[i][0] >= lastEndTime) {
                // Update the last end time to the end time of the current interval
                lastEndTime = intervals[i][1];
                // Increment the count of non-overlapping intervals
                nonOverlappingCount++;
            }
        }

        // The minimum number of intervals to remove is the total intervals minus the count of non-overlapping intervals
        return intervals.length - nonOverlappingCount;
    }
    public static void main(String[] args) {
        int[][] intervals = new int[][]{
                {0,2},{1,3},{2,4},{3,5},{4,6}
        };
        Arrays.sort(intervals, Comparator.comparingInt(a->a[0]));
        System.out.println(Arrays.deepToString(intervals));
        System.out.println(eraseOverlapIntervals(intervals));
        System.out.println(eraseOverlapIntervalsLeet(intervals));
    }
}
