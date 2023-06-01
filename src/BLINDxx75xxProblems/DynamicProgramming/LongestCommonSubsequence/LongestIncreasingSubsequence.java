package BLINDxx75xxProblems.DynamicProgramming.LongestCommonSubsequence;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    // Time complexity: O(N^2)
    // Space complexity: O(N)
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int longest = 0;
        for (int c: dp) {
            longest = Math.max(longest, c);
        }

        return longest;
    }

    public int lengthOfLISRecursive(int[] nums) {
        return LISHelper(-1, 0, nums);
    }

    private static int LISHelper(int prev, int curr, int nums[]){
        if(curr == nums.length) return 0;

        int take = 0;
        if(prev == -1 || nums[prev] < nums[curr]){
            take =  1 + LISHelper(curr, curr+1,nums);
        }
        int notTake = LISHelper(prev, curr+1,nums);

        return Math.max(take, notTake);
    }

    public int lengthOfLISRecursiveDP(int[] nums) {
        int[][] dp = new int[nums.length][nums.length+1];
        for (int [] rows : dp) {
            Arrays.fill(rows, -1);
        }
        return LISHelperDP(-1, 0, nums, dp);
    }

    private int LISHelperDP(int prev, int curr, int[] nums, int[][] dp) {
        if (curr == nums.length) {
            return 0;
        }
        if (dp[curr][prev + 1] != -1) {
            return dp[curr][prev+1];
        }
        int take = 0;
        if (prev == -1 || nums[prev] < nums[curr]) {
            take = 1 + LISHelperDP(curr, curr +1, nums, dp);
        }
        int notTake = LISHelperDP(prev, curr+1, nums, dp);
        return dp[curr][prev+1] = Math.max(take, notTake);
    }

}
