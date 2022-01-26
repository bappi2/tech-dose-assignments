package ArrayProblems;

public class MaximumSubarray {
    // Approach 1: Optimized Brute Force
    /*
    Calculate the sum of all subarrays, and keep track of the best one.
    To actually generate all subarrays would take O(N^3)O(N 3) time,
    but with a little optimization, we can achieve brute force in O(N^2)O(N 2)
     time. The trick is to recognize that all of the subarrays starting at a
 particular value will share a common prefix.


     */

    public int maxSubArray(int[] nums) {
        int maxSubarray = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int currentSubarray = 0;
            for (int j = i; j < nums.length; j++) {
                currentSubarray += nums[j];
                maxSubarray = Math.max(maxSubarray, currentSubarray);
            }
        }

        return maxSubarray;
    }

    // Approach 2: Dynamic Programming, Kadane's Algorithm

    public int maxSubArray2(int[] nums) {
        // Initialize our variables using the first element.
        int currentSubarray = nums[0];
        int maxSubarray = nums[0];

        // Start with the 2nd element since we already used the first one.
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            // If current_subarray is negative, throw it away. Otherwise, keep adding to it.
            currentSubarray = Math.max(num, currentSubarray + num);
            maxSubarray = Math.max(maxSubarray, currentSubarray);
        }

        return maxSubarray;
    }
}
