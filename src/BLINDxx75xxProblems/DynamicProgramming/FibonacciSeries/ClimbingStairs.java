package BLINDxx75xxProblems.DynamicProgramming.FibonacciSeries;

import java.util.Arrays;

public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        else if (n == 2) {
            return 2;
        }
        else {
            return climbStairs(n-1) + climbStairs(n-2);
        }

    }

    public int climbStairs2(int n) {
        if (n == 1) {
            return 1;
        }
        else if (n == 2) {
            return 2;
        }
        int [] dp = new int[n+1];
        Arrays.fill(dp, -1);

        return  climbStairsDP(n, dp);
    }

    int climbStairsDP(int n, int [] dp) {
        if (n == 1) {
            return 1;
        }
        else if (n ==2) {
            return 2;
        }
        else if (dp[n] != -1) {
            return dp[n];
        }
        else {
            dp[n] = climbStairsDP(n-1, dp) + climbStairsDP(n-2, dp);
            return dp[n];
        }
    }

    public int climbStairs3(int n) {
        int [] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }


}
