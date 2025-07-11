package BLINDxx75xxProblems.DynamicProgramming.KnapSackProblems;

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

}
