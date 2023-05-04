package BLINDxx75xxProblems.HeapProblems;

import java.util.PriorityQueue;

/*
Input
["KthLargest", "add", "add", "add", "add", "add"]
[[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
Output
[null, 4, 5, 5, 8, 8]
 */
public class KthLargestElementInStream {
    // https://leetcode.com/problems/kth-largest-element-in-a-stream/
    PriorityQueue<Integer> minHeap;
    int k;

    public KthLargestElementInStream(int k, int[] nums) {
        minHeap = new PriorityQueue<>();
        this.k = k;
        for (int num: nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.remove();
            }
        }

    }

    public int add(int val) {
        minHeap.offer(val);
        if (minHeap.size() > k) {
            minHeap.remove();
        }
        return minHeap.peek();
    }
}
