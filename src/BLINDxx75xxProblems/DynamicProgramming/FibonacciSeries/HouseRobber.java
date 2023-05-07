package BLINDxx75xxProblems.DynamicProgramming.FibonacciSeries;

import java.util.Arrays;

public class HouseRobber {
    // f(i) = nums[0] i = 0
    // f(i) = max (nums[0], nums[1]) i == 1
    // f(i) = max (nums[i] + f(i-2), f(i -1))

    public int rob(int[] nums) {
        return f(nums, nums.length-1);
    }
    int f(int[] nums, int i) {
        if (i == 0) {
            return nums[i];
        }
        if (i == 1) {
            return Math.max(nums[i], nums[i-1]);
        }
        else{
            return Math.max(f(nums, i -2) + nums[i], f(nums, i-1));
        }
    }

    public int rob2(int[] nums) {
        int [] dp = new int[nums.length];
        Arrays.fill(dp, -1);

        return f(nums, nums.length-1, dp);
    }
    int f(int[] nums, int i, int [] dp) {
        if (i == 0) {
            return nums[i];
        }
        if (i == 1) {
            return Math.max(nums[i], nums[i-1]);
        }
        else if (dp[i] != -1) {
            return dp[i];
        }
        else{
            dp[i] = Math.max(f(nums, i -2, dp) + nums[i], f(nums, i-1, dp));
            return dp[i];
        }
    }

    public int rob3(int[] nums) {
        int [] dp = new int[nums.length];
        dp[0] = nums[0];
        if (nums.length == 1) {
            return nums[0];
        }
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1]);
        }

        return dp[nums.length-1];
    }
}
