package DynamicProgramming.KnapSackProblems;

import java.util.Arrays;

public class test {

    public static boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        if (totalSum % 2 != 0) {
            return false;
        }

        int targetSum = totalSum / 2;
        int n = nums.length;
        Boolean[][] memo = new Boolean[n + 1][targetSum + 1];

        return canPartitionHelper(nums, n, targetSum, memo);
    }

    private static boolean canPartitionHelper(int[] nums, int currentIndex, int remainingSum, Boolean[][] memo) {
        if (remainingSum == 0) {
            return true;
        }

        if (currentIndex <= 0 || remainingSum < 0) {
            return false;
        }

        if (memo[currentIndex][remainingSum] != null) {
            return memo[currentIndex][remainingSum];
        }

        // Include the current element in the subset
        boolean include = canPartitionHelper(nums, currentIndex - 1, remainingSum - nums[currentIndex - 1], memo);

        // Exclude the current element from the subset
        boolean exclude = canPartitionHelper(nums, currentIndex - 1, remainingSum, memo);

        memo[currentIndex][remainingSum] = include || exclude;
        return memo[currentIndex][remainingSum];
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};
        boolean result = canPartition(nums);
        System.out.println(result); // Output: true
    }
}
