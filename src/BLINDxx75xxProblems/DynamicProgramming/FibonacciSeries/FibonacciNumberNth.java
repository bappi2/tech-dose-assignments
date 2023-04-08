package BLINDxx75xxProblems.DynamicProgramming.FibonacciSeries;

import java.util.Arrays;

public class FibonacciNumberNth {
    static int fib(int n) {
        if (n <= 1)
            return n;
        return fib(n - 1) + fib(n - 2);
    }

    // Dynamic Programming
    static int fib2(int n)
    {
        /* Declare an array to store Fibonacci numbers. */
        int f[] = new int[n+2]; // 1 extra to handle case, n = 0
        int i;

        /* 0th and 1st number of the series are 0 and 1*/
        f[0] = 0;
        f[1] = 1;

        for (i = 2; i <= n; i++)
        {
       /* Add the previous 2 numbers in the series
         and store it */
            f[i] = f[i-1] + f[i-2];
        }

        return f[n];
    }

    // Space optimized
    int fib3(int n)
    {
        int a = 0, b = 1, c, i;
        if( n == 0)
            return a;
        for(i = 2; i <= n; i++)
        {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    // DP Top down
    static int[] dp = new int[10];

    static int fib4(int n)
    {
        if (n <= 1) {
            return n;
        }

        if (dp[n] != -1)
            return dp[n];
        else {
            dp[n] = fib4(n - 1) + fib4(n - 2);
        }

        return dp[n];
    }

    // Driver Code
    public static void main(String[] args)
    {
        int n = 9;

        Arrays.fill(dp, -1);

        System.out.print(fib(n));
    }
}
