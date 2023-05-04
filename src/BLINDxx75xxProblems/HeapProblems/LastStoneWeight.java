package BLINDxx75xxProblems.HeapProblems;

import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight {
    // https://leetcode.com/problems/last-stone-weight/
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int stone: stones) {
            maxHeap.offer(stone);
        }
        while(maxHeap.size() > 1) {
            int st1 = maxHeap.poll();
            int st2 = maxHeap.poll();
            if (st1 !=  st2) {
                maxHeap.offer(st1 - st2);
            }
        }
        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }
}
