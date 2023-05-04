package BLINDxx75xxProblems.HeapProblems;

import java.util.PriorityQueue;

public class KthLargestElementInAnArray {
    // https://leetcode.com/problems/kth-largest-element-in-an-array/
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq  = new PriorityQueue<>();
        for (int n: nums) {
            pq.offer(n);
            if (pq.size() > k) {
                pq.remove();
            }
        }
        return pq.peek();
    }
}
