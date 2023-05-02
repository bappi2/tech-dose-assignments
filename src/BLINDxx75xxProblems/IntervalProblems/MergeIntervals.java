package BLINDxx75xxProblems.IntervalProblems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        LinkedList<int[]> result = new LinkedList<>();
        Arrays.sort(intervals, (a, b) -> Integer.valueOf(a[0] - b[0]));
        int [] prev = intervals[0];
        for (int i=1; i < intervals.length; i++) {
            int [] curr = intervals[i];
            if (isOverlapping(curr, prev)) {
                prev[0] = prev[0];
                prev[1] = Math.max(curr[1], prev[1]);

            }
            else {
                result.add(prev);
                prev = curr;
            }
        }
        result.add(prev);
        int[][] finalResult = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            finalResult[i][0] = result.get(i)[0];
            finalResult[i][1] = result.get(i)[1];
        }

        return finalResult;
    }
    boolean isOverlapping(int[] a, int [] b) {
        if (Math.min(a[1], b[1]) - Math.max(a[0], b[0]) >= 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public static int[][] merge2(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        LinkedList<int[]> result = new LinkedList<>();

        for(int[] interval : intervals){
            if (result.isEmpty() || result.getLast()[1] < interval[0]){
                result.add(interval);
            }else {
                result.getLast()[1] = Math.max(result.getLast()[1], interval[1]);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
