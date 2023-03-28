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

        // A simple recursive program to
        // find N'th fibonacci number
        static int fib(int n, int dp[]) {
            if (n <= 1)
                return dp[n] = 1;

            if (dp[n] != -1) {
                return dp[n];
            }
            dp[n] = fib(n - 1, dp) + fib(n - 2, dp);
            return dp[n];
        }

        // Returns number of ways to
        // reach s'th stair
        static int countWays(int n) {
            int[] dp = new int[n + 1];
            Arrays.fill(dp, -1);

            fib(n, dp);
            return dp[n];
        }
    }
}
