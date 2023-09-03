package BLINDxx75xxProblems.SlidingWindowTechnique;

public class MaxSumSubarrayOfSizeK {
    public static int maxSubarraySum(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k <= 0 || k > arr.length) {
            return 0;
        }

        int maxSum = 0;
        int currentSum = 0;

        // Calculate the sum of the first k elements
        for (int i = 0; i < k; i++) {
            currentSum += arr[i];
        }

        maxSum = currentSum;

        // Slide the window and update the maximum sum
        for (int i = k; i < arr.length; i++) {
            currentSum += arr[i] - arr[i - k];
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static int maxSubarraySumBtureForce(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k <= 0 || k > arr.length) {
            return 0;
        }

        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i <= arr.length - k; i++) {
            int currentSum = 0;

            // Calculate the sum of the current subarray of size k
            for (int j = i; j < i + k; j++) {
                currentSum += arr[j];
            }

            // Update maxSum if the current subarray's sum is greater
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }


    public static void main(String[] args) {
        int[] arr1 = {3, 5, 2, 1, 7};
        int k1 = 2;
        int result1 = maxSubarraySum(arr1, k1);
        System.out.println(result1);  // Output: 8

        int[] arr2 = {4, 2, 3, 5, 1, 2};
        int k2 = 3;
        int result2 = maxSubarraySum(arr2, k2);
        System.out.println(result2);  // Output: 10
    }
}
