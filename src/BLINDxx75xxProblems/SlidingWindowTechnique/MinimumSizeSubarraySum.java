package BLINDxx75xxProblems.SlidingWindowTechnique;

public class MinimumSizeSubarraySum {
    public static int minSubarrayLen(int target, int[] nums) {
        int minLen = Integer.MAX_VALUE;
        int left = 0;
        int currentSum = 0;

        for (int right = 0; right < nums.length; right++) {
            currentSum += nums[right];

            while (currentSum >= target) {
                minLen = Math.min(minLen, right - left + 1);
                currentSum -= nums[left];
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    public static void main(String[] args) {
        int target1 = 7;
        int[] nums1 = {2, 3, 1, 2, 4, 3};
        int result1 = minSubarrayLen(target1, nums1);
        System.out.println("Example 1: " + result1);  // Output: 2

        int target2 = 4;
        int[] nums2 = {1, 4, 4};
        int result2 = minSubarrayLen(target2, nums2);
        System.out.println("Example 2: " + result2);  // Output: 1

        int target3 = 11;
        int[] nums3 = {1, 1, 1, 1, 1, 1, 1, 1};
        int result3 = minSubarrayLen(target3, nums3);
        System.out.println("Example 3: " + result3);  // Output: 0
    }
}
