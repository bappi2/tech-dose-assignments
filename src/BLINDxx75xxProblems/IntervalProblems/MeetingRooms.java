package BLINDxx75xxProblems.IntervalProblems;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRooms {
    /*
https://leetcode.com/problems/non-overlapping-intervals/
Given an array of intervals intervals where intervals[i] = [starti, endi],
return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
 */
    public boolean canAttendMeetings(int[][] intervals) {
        if(intervals == null || intervals.length == 0){
            return true;
        }
        if(intervals.length == 1){
            return true;
        }
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] < intervals[i-1][1]){
                return false;
            }
        }
        return true;
    }
    public boolean canAttendMeetings(Interval[] intervals) {
        if (intervals == null || intervals.length ==0) {
            return true;
        }

        // Sort according to the start time
        Arrays.sort(intervals, new IntervalComparator());

        Interval prev = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            Interval curr = intervals[i];
            if (isOverlapped(prev, curr)) {
                return false;
            }
            prev = curr;
        }

        return true;
    }

    public class IntervalComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval a, Interval b) {
            return a.start - b.start;
        }
    }

    private boolean isOverlapped(Interval a, Interval b) {
        return a.end > b.start;
    }


}
