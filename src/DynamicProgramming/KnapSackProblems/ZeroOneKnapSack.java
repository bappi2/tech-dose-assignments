package DynamicProgramming.KnapSackProblems;

public class ZeroOneKnapSack {
    /*
    Given weights and values of n items, put these items in a
    knapsack of capacity W to get the maximum total value in
    the knapsack. In other words, given two integer arrays
    val[0..n-1] and wt[0..n-1] which represent values and weights
    associated with n items respectively. Also given an integer W
    which represents knapsack capacity, find out the maximum value
    subset of val[] such that sum of the weights of this subset is
    smaller than or equal to W. You cannot break an item, either
    pick the complete item or don’t pick it (0-1 property).
     */

    // Method 1: Recursion by Brute-Force algorithm OR Exhaustive Search.

    // A utility function that returns
    // maximum of two integers
    static int max(int a, int b)
    {
        return (a > b) ? a : b;
    }
/*
    // Returns the maximum value that
    // can be put in a knapsack of
    // capacity W
    static int knapSack(int W, int wt[], int val[], int n)
    {
        // Base Case
        if (n == 0 || W == 0)
            return 0;

        // If weight of the nth item is
        // more than Knapsack capacity W,
        // then this item cannot be included
        // in the optimal solution
        if (wt[n - 1] > W)
            return knapSack(W, wt, val, n - 1);

            // Return the maximum of two cases:
            // (1) nth item included
            // (2) not included
        else
            return max(val[n - 1]
                            + knapSack(W - wt[n - 1], wt, val, n - 1),
                    knapSack(W, wt, val, n - 1));
    }
    // Time Complexity: O(2 power n).

    // Here is the top-down approach of
    static int knapSackRec(int W, int wt[],
                           int val[], int n,
                           int [][]dp)
    {

        // Base condition
        if (n == 0 || W == 0)
            return 0;

        if (dp[n][W] != -1)
            return dp[n][W];

        if (wt[n - 1] > W)

            // Store the value of function call
            // stack in table before return
            return dp[n][W] = knapSackRec(W, wt, val,
                    n - 1, dp);

        else

            // Return value of table after storing
            return dp[n][W] = max((val[n - 1] +
                            knapSackRec(W - wt[n - 1], wt,
                                    val, n - 1, dp)),
                    knapSackRec(W, wt, val,
                            n - 1, dp));
    }

    static int knapSack(int W, int wt[], int val[], int N)
    {

        // Declare the table dynamically
        int dp[][] = new int[N + 1][W + 1];

        // Loop to initially filled the
        // table with -1
        for(int i = 0; i < N + 1; i++)
            for(int j = 0; j < W + 1; j++)
                dp[i][j] = -1;

        return knapSackRec(W, wt, val, N, dp);
    }
/*
Let weight elements = {1, 2, 3}
Let weight values = {10, 15, 40}
Capacity=6

   0   1   2   3   4   5   6

0  0   0   0   0   0   0   0

1  0  10  10  10  10  10  10

2  0  10  15  25  25  25  25

3  0  10  15  40  50  55  65
 */
    /*
    // DP tabulation
    static int knapSack(int W, int wt[], int val[], int n)
    {
        int i, w;
        int K[][] = new int[n + 1][W + 1];

        // Build table K[][] in bottom up manner
        for (i = 0; i <= n; i++)
        {
            for (w = 0; w <= W; w++)
            {
                if (i == 0 || w == 0)
                    K[i][w] = 0;
                else if (wt[i - 1] <= w)
                    K[i][w]
                            = max(val[i - 1]
                                    + K[i - 1][w - wt[i - 1]],
                            K[i - 1][w]);
                else
                    K[i][w] = K[i - 1][w];
            }
        }

        return K[n][W];
    }

    // Driver code
    public static void main(String args[])
    {
        int val[] = new int[] { 60, 100, 120 };
        int wt[] = new int[] { 10, 20, 30 };
        int W = 50;
        int n = val.length;
        System.out.println(knapSack(W, wt, val, n));
    }
*/
}
