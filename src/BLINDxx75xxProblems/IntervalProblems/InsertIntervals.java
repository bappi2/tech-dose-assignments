package BLINDxx75xxProblems.IntervalProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class InsertIntervals {
    // https://leetcode.com/problems/insert-interval/

    // Returns true if the intervals a and b have a common element.
    boolean doesIntervalsOverlap(int[] a, int[] b) {
        return Math.min(a[1], b[1]) - Math.max(a[0], b[0]) >= 0;
    }

    // Return the interval having all the elements of intervals a and b.
    int[] mergeIntervals(int[] a, int[] b) {
        int[] newInterval = {Math.min(a[0], b[0]), Math.max(a[1], b[1])};
        return newInterval;
    }

    // Insert the interval newInterval, into the list interval keeping the sorting order intact.
    int[][] insertInterval(int[][] intervals, int[] newInterval) {
        boolean isIntervalInserted = false;
        List<int[]> list = new ArrayList<>(Arrays.asList(intervals));

        for (int i = 0; i < intervals.length; i++) {
            if (newInterval[0] < intervals[i][0]) {
                // Found the position, insert the interval and break from the loop.
                list.add(i, newInterval);
                isIntervalInserted = true;
                break;
            }
        }

        // If there is no interval with a greater value of start value,
        // then the interval must be inserted at the end of the list.
        if (!isIntervalInserted) {
            list.add(newInterval);
        }

        return list.toArray(new int[list.size()][2]);
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        // Insert the interval first before merge processing.
        intervals = insertInterval(intervals, newInterval);

        List<int[]> answer = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int[] currInterval = {intervals[i][0], intervals[i][1]};
            // Merge until the list gets exhausted or no overlap is found.
            while (i < intervals.length && doesIntervalsOverlap(currInterval, intervals[i])) {
                currInterval = mergeIntervals(currInterval, intervals[i]);
                i++;
            }
            // Decrement to ensure we don't skip the interval due to outer for-loop incrementing.
            i--;
            answer.add(currInterval);
        }

        return answer.toArray(new int[answer.size()][2]);
    }

    public static int[][] insert2(int[][] intervals, int[] newInterval) {

        ArrayList<int[]> before = new ArrayList<>();
        ArrayList<int[]> after = new ArrayList<>();

        for(int[] interval : intervals){
            if(interval[1] < newInterval[0]){
                before.add(interval);
            }else if(newInterval[1] < interval[0]){
                after.add(interval);
            }else{
                // merge
                newInterval[0] = Math.min(interval[0], newInterval[0]);
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            }
        }
        ArrayList<int[]> result = new ArrayList<>();
        result.addAll(before);
        result.add(newInterval);
        result.addAll(after);
        return result.toArray(new int[result.size()][]);
    }
    public static void main(String[] args) {
        int[][] intervals2 = new int[][]{
                {1,3}, {5,7}, {9,10}
        };
        int[] newInterval = new int[]{2,4};

        Arrays.sort(intervals2, Comparator.comparingInt(a -> a[0]));
        System.out.println(Arrays.deepToString(intervals2));
        System.out.println(Arrays.deepToString(insert2(intervals2, newInterval)));
    }
}
