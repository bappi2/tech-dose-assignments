package DynamicProgramming.FibonacciSeries;

public class ClimbStairs {
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