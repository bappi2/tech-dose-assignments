package BLINDxx75xxProblems.IntervalProblems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
https://leetcode.com/problems/meeting-rooms-ii/
Given an array of meeting time intervals intervals where intervals[i] = [starti, endi],
return the minimum number of conference rooms required.
 */
public class MeetingRoomII {
    // [2,3],[4,6],[8,10],[7,9]
    // 10,9
    /*
    2---3
          4---6
                  8-----10
                7----9
      Priority Queue stores elements for some "priority condition". Here the priority is the # of conf rooms available.
      If you need a conf room, add end time to PQ.
      If there is a conf room in use, and the new meeting is only after the prev me
     */
    public static int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0){
            return 0;
        }
        Arrays.sort(intervals, Comparator.comparingInt(a->a[0]));
        // Have a min heap. THink of PQ to hold rooms. Each time a room is available, you use it.
        // When you
        PriorityQueue<Integer> endTimes = new PriorityQueue<>();
        endTimes.add(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++){
            // if the incoming meeting can start after the meeting that is going to end soon (min heap peak),
            // poll and reuse the room. Else, add yourself and wait for the room. So, the pq size at the end will
            // indicate # of rooms needed.
            if (intervals[i][0] >= endTimes.peek()){
                endTimes.poll();
            }
            endTimes.add(intervals[i][1]);
        }
        return endTimes.size();
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][] {{2,3},{4,6},{8,10},{7,9}};
        System.out.println(minMeetingRooms(intervals));
    }
}
