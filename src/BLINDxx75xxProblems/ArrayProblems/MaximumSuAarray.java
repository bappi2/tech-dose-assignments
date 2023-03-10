package BLINDxx75xxProblems.ArrayProblems;

public class MaximumSubarray {

    // Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
    //Output: 6
    //Explanation: [4,-1,2,1] has the largest sum = 6.

    // Time complexity: O(N^2)
    // Space complexity: O(1)
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
    // Calculate the sum of all subarrays, and keep track of the best one.
    // To actually generate all subarrays would take O(N^3)
    // time, but with a little optimization, we can achieve brute force in O(N^2)
    // time. The trick is to recognize that all of the subarrays
    // starting at a particular value will share a common prefix.


    // Time complexity: O(N)
    // Space complexity: O(1)
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
// We need a general way to figure out when a part of the array is worth keeping.
//
//As expected, any subarray whose sum is positive is worth keeping. Let's start
// with an empty array, and iterate through the input, adding numbers to our
// array as we go along. Whenever the sum of the array is negative, we know the
// entire array is not worth keeping, so we'll reset it back to an empty array.

}
