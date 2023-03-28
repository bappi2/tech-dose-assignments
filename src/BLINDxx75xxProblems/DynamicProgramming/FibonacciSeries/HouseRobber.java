package BLINDxx75xxProblems.DynamicProgramming.FibonacciSeries;

import java.util.Arrays;

public class HouseRobber {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int [] dp = new int [nums.length];
        Arrays.fill(dp, -1);
        return robHelper(nums, 0, dp);
    }
    int robHelper(int[] nums, int index, int [] dp) {
        if (index >= nums.length) {
            return 0;
        }
        if (dp[index] != -1) {
            return dp[index];
        }
        else {
            int pick = robHelper(nums, index+2, dp) + nums[index];
            int notPick = robHelper(nums, index+1, dp);
            dp[index] = Math.max(pick, notPick);
            return dp[index];
        }
    }

    public int rob2(int[] nums) {
        if(nums.length == 1) return nums[0];

        int[] dp = new int[nums.length];
        dp [0] = nums[0];
        dp [1] = Math.max(nums[0], nums[1]);

        for(int i=2; i<nums.length; i++){
            dp[i] = Math.max(nums[i]+dp[i-2], dp[i-1]);
        }

        return dp[nums.length-1];
    }
}
