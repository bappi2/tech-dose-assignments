package DynamicProgramming.FibonacciSeries;

public class ClimbStairs {
    /*
    Method 1: The first method uses the technique of recursion to solve this problem.
Approach: We can easily find the recursive nature in the above problem. T
he person can reach nth stair from either (n-1)th stair or from (n-2)th stair.
Hence, for each stair n, we try to find out the number of ways to reach n-1th
stair and n-2th stair and add them to give the answer for the nth stair.
Therefore the expression for such an approach comes out to be :

ways(n) = ways(n-1) + ways(n-2)
     */
    static int fib(int n)
    {
        if (n <= 1)
            return n;
        return fib(n - 1) + fib(n - 2);
    }

    // Returns number of ways to reach s'th stair
    static int countWays(int s)
    {
        return fib(s + 1);
    }

    // top down
    static int fib(int n, int dp[])
    {
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
    static int countWays(int n)
    {
        int[] dp = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            dp[i] = -1;
        }
        fib(n, dp);
        return dp[n];
    }


    class Solution {
        public int climbStairs(int n) {
            if(n <= 2)
                return n;
            int dp[] =new int[n+1];
            dp[1]=1;
            dp[2]=2;
            for(int i=3;i<=n;i++){
                dp[i]=dp[i-1]+dp[i-2];
            }
            return dp[n];
        }
    }


    public class Solution2 {
        public int climbStairs(int n) {
            double sqrt5=Math.sqrt(5);
            double fibn=Math.pow((1+sqrt5)/2,n+1)-Math.pow((1-sqrt5)/2,n+1);
            return (int)(fibn/sqrt5);
        }
    }
}
