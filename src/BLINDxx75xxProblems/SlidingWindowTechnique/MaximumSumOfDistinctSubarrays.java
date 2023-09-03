package BLINDxx75xxProblems.SlidingWindowTechnique;
import java.util.HashSet;

public class MaximumSumOfDistinctSubarrays {
    public static int maxSumDistinctSubarrays(int[] nums, int k) {
        int maxSum = 0;
        int currentSum = 0;
        HashSet<Integer> seen = new HashSet<>();

        for (int i = 0, j = 0; i < nums.length; i++) {
            while (seen.contains(nums[i])) {
                seen.remove(nums[j]);
                currentSum -= nums[j];
                j++;
            }

            seen.add(nums[i]);
            currentSum += nums[i];

            if (i - j + 1 == k) {
                maxSum = Math.max(maxSum, currentSum);
                seen.remove(nums[j]);
                currentSum -= nums[j];
                j++;
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 5, 4, 2, 9, 9, 9};
        int k1 = 3;
        int result1 = maxSumDistinctSubarrays(nums1, k1);
        System.out.println("Example 1: " + result1);  // Output: 15

        int[] nums2 = {4, 4, 4};
        int k2 = 3;
        int result2 = maxSumDistinctSubarrays(nums2, k2);
        System.out.println("Example 2: " + result2);  // Output: 0
    }
}

