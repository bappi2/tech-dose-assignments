package ArrayProblems.Sorting;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> q = new PriorityQueue<>();
        for (int n: nums) {
            q.offer(n);
            if (q.size() > k) {
                q.poll();
            }
        }
        return q.peek();
    }

    public int findKthLargestSort(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
