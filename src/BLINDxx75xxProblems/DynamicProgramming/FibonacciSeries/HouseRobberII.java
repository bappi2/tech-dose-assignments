package BLINDxx75xxProblems.DynamicProgramming.FibonacciSeries;

import java.util.Arrays;

public class HouseRobberII {

    public int robRecurr(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int max1 = f(nums, 0, nums.length -2);
        int max2 = f(nums, 1, nums.length-1);
        return Math.max(max1, max2);
    }
    int f(int [] nums, int start, int i) {
        if (i == start) {
            return nums[i];
        }
        else if (i == start + 1) {
            return Math.max(nums[i], nums[i-1]);
        }
        else{
            return Math.max(nums[i]+ f(nums, start, i -2), f(nums, start, i-1));
        }
    }
    ///
    public int robDP(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int [] dp = new int [nums.length];
        Arrays.fill(dp, -1);
        int max1 = f(nums, 0, nums.length -2, dp);
        Arrays.fill(dp, -1);
        int max2 = f(nums, 1, nums.length-1, dp);
        return Math.max(max1, max2);
    }
    int f(int [] nums, int start, int i, int[] dp) {
        if (i == start) {
            return nums[i];
        }
        else if (i == start + 1) {
            return Math.max(nums[i], nums[i-1]);
        }
        else if (dp[i] != -1) {
            return dp[i];
        }
        else{
            dp[i] = Math.max(nums[i]+ f(nums, start, i -2, dp), f(nums, start, i-1, dp));
            return dp[i];
        }
    }

    public int rob(int[] nums) {
        if (nums.length == 0)
            return 0;

        if (nums.length == 1)
            return nums[0];

        int max1 = rob_simple(nums, 0, nums.length - 2);
        int max2 = rob_simple(nums, 1, nums.length - 1);

        return Math.max(max1, max2);
    }

    public int rob_simple(int[] nums, int start, int end) {
        int t1 = 0;
        int t2 = 0;

        for (int i = start; i <= end; i++) {
            int temp = t1;
            int current = nums[i];
            t1 = Math.max(current + t2, t1);
            t2 = temp;
        }

        return t1;
    }
}
