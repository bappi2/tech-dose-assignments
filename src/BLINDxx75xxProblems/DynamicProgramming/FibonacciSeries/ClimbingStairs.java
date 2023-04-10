package BLINDxx75xxProblems.DynamicProgramming.FibonacciSeries;

import java.util.Arrays;

public class ClimbingStairs {

    public int climbStairs2(int n) {
        if (n < 3)
            return n;
        int dp[] = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    // Recursion

    // Java program to count number of
// ways to reach Nth stair
    class GFG {

        public int climbStairs(int n) {
            int [] dp = new int [n+1];
            Arrays.fill(dp, -1);

            if (n <= 2) {
                return n;
            }
            return climbStairsDP(n, dp);
        }
        int climbStairsDP(int n, int [] dp) {
            if (n <= 2) {
                return n;
            }
            if (dp[n] != -1) {
                return dp[n];
            }
            else {
                dp[n] = climbStairsDP(n-1, dp) + climbStairsDP(n-2, dp);
                return dp[n];
            }
        }

    }
}
