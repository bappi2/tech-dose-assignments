package BLINDxx75xxProblems.DynamicProgramming.FibonacciSeries;

import java.util.Arrays;

public class MinCostClimbingStairs {
    /*
    You are given an integer array cost where cost[i] is the cost of ith
    step on a staircase. Once you pay the cost, you can either climb one
    or two steps.

    You can either start from the step with index 0, or the step with
    index 1.

    Return the minimum cost to reach the top of the floor.
     */
    public int minCostClimbingStairs(int[] cost) {
        return Math.min(minCost(cost, cost.length -1), minCost(cost, cost.length -2));
    }
    int minCost(int[] cost, int n) {
        if (n == 0) {
            return cost[n];
        }
        else if (n == 1) {
            return cost[n];
        }
        else {
            return cost[n] + Math.min(minCost(cost, n -1), minCost(cost, n-2));
        }
    }

    public int minCostClimbingStairs2(int[] cost) {
        int [] dp = new int [cost.length];
        Arrays.fill(dp, -1);
        return Math.min(minCostDP(cost, cost.length -1, dp), minCostDP(cost, cost.length -2, dp));
    }
    int minCostDP(int[] cost, int n, int[] dp) {
        if (n == 0) {
            return cost[n];
        }
        else if (n == 1) {
            return cost[n];
        }
        else if (dp[n] != -1) {
            return dp[n];
        }
        else {
            dp[n] = cost[n] + Math.min(minCostDP(cost, n -1, dp), minCostDP(cost, n-2, dp));
            return dp[n];
        }
    }

    public int minCostClimbingStairs3(int[] cost) {
        int [] dp = new int[cost.length];

        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            dp[i] = cost[i]+ Math.min(dp[i-1], dp[i-2]);
        }
        return Math.min(dp[cost.length -1], dp[cost.length -2]);
    }

}