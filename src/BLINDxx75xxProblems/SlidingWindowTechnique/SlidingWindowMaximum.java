package BLINDxx75xxProblems.SlidingWindowTechnique;
import java.util.Deque;
import java.util.LinkedList;

// https://chat.openai.com/share/07d505e6-505e-4c87-9167-63256c75cfdf
// https://www.youtube.com/watch?v=5VDQxLAlfu0
// deque explanation

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];

        int[] result = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            // Remove indices that are out of the current window
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // Remove indices whose corresponding values are less than current value
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // Add current index to the Deque
            deque.offerLast(i);

            // The front of the Deque is the maximum of the current window
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        SlidingWindowMaximum sol = new SlidingWindowMaximum();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] result = sol.maxSlidingWindow(nums, k);
        for (int val : result) {
            System.out.print(val + " ");
        }
    }
}
