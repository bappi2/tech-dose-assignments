package BLINDxx75xxProblems.HeapProblems;

import java.util.*;

public class TaskScheduler {
    // https://leetcode.com/problems/task-scheduler/
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char c: tasks) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.addAll(freq.values());
        int cycle = 0;
        while (!maxHeap.isEmpty()) {
            List<Integer> curr = new ArrayList<>();
            for (int i = 0; i < n + 1; i++) {
                if (!maxHeap.isEmpty()){
                    curr.add(maxHeap.remove());
                }
            }
            for (int c : curr) {
                c--;
                if (c > 0) {
                    maxHeap.add(c);
                }
            }
            cycle += maxHeap.isEmpty() ? curr.size() : n + 1;
        }
        return cycle;
    }
}
