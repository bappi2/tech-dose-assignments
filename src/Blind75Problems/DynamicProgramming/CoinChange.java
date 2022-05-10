package Blind75Problems.DynamicProgramming;

import java.util.Arrays;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+2);
        dp[0] = 0;

        for(int coin : coins) {
            for(int i = coin; i <=amount; i++){
                dp[i] = Math.min(dp[i], dp[i-coin]+1);
            }
        }
        return dp[amount] <= amount ? dp[amount] : -1;
    }

    // https://www.geeksforgeeks.org/coin-change-dp-7/
    /*
    Given a value N, if we want to make change for N cents, and we have
    infinite supply of each of S = { S1, S2, .. , Sm} valued coins,
    how many ways can we make the change? The order of coins doesn’t matter.
For example, for N = 4 and S = {1,2,3}, there are four solutions:
{1,1,1,1},{1,1,2},{2,2},{1,3}. So output should be 4.
For N = 10 and S = {2, 5, 3, 6}, there are five solutions:
{2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}. So the output should be 5.
     */
/*
C() --> count()
                             C({1,2,3}, 5)
                           /             \
                         /                 \
             C({1,2,3}, 2)                 C({1,2}, 5)
            /       \                      /      \
           /         \                    /         \
C({1,2,3}, -1)  C({1,2}, 2)        C({1,2}, 3)    C({1}, 5)
               /    \             /     \           /     \
             /       \           /       \         /        \
    C({1,2},0)  C({1},2)   C({1,2},1) C({1},3)    C({1}, 4)  C({}, 5)
                   / \     / \        /\         /     \
                  /   \   /   \     /   \       /       \
                .      .  .     .   .     .   C({1}, 3) C({}, 4)
                                               / \
                                              /   \
                                             .      .
 */
    // Returns the count of ways we can
// sum S[0...m-1] coins to get sum n
    static int count(int S[], int m, int n)
    {

        // If n is 0 then there is 1 solution
        // (do not include any coin)
        if (n == 0)
            return 1;

        // If n is less than 0 then no
        // solution exists
        if (n < 0)
            return 0;

        // If there are no coins and n
        // is greater than 0, then no
        // solution exist
        if (m <= 0 && n >= 1)
            return 0;

        // count is sum of solutions (i)
        // including S[m-1] (ii) excluding S[m-1]
        return count(S, m - 1, n) +
                count(S, m, n - S[m - 1]);
    }

    public static void  main(String args[])
    {
        int arr[] = { 1, 2, 3 };
        int m = arr.length;

        System.out.println(count(arr, m, 4));
    }
}
