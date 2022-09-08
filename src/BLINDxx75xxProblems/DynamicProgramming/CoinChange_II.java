package BLINDxx75xxProblems.DynamicProgramming;

public class CoinChange_II {
    // https://www.techiedelight.com/coin-change-problem-find-total-number-ways-get-denomination-coins/

    // The idea is somewhat similar to the Knapsack problem. We can recursively define the problem as:
    //
    //count(S, n, total) = count(S, n, total-S[n]) + count(S, n-1, total);
    //That is, for each coin.
    //
    //Include current coin S[n] in solution and recur with remaining change total-S[n] with the same number of coins.
    //Exclude current coin S[n] from solution and recur for remaining coins n-1.

    // Function to find the total number of distinct ways to get
    // a change of `target` from an unlimited supply of coins in set `S`
    public static int count(int[] S, int n, int target)
    {
        // if the total is 0, return 1 (solution found)
        if (target == 0) {
            return 1;
        }

        // return 0 (solution does not exist) if total becomes negative,
        // no elements are left
        if (target < 0 || n < 0) {
            return 0;
        }

        // Case 1. Include current coin `S[n]` in solution and recur
        // with remaining change `target-S[n]` with the same number of coins
        int incl = count(S, n, target - S[n]);

        // Case 2. Exclude current coin `S[n]` from solution and recur
        // for remaining coins `n-1`
        int excl = count(S, n - 1, target);

        // return total ways by including or excluding current coin
        return incl + excl;
    }

    // Coin Change Problem
    public static void main(String[] args)
    {
        // `n` coins of given denominations
        int[] S = { 1, 2, 3 };

        // total change required
        int target = 4;

        System.out.print("The total number of ways to get the desired change is "
                + count(S, S.length - 1, target));
    }

    // Function to find the total number of distinct ways to get a change of `target`
    // from an unlimited supply of coins in set `S`
    public static int count(int[] S, int target)
    {
        int n = S.length;

        int T[][] = new int[n + 1][target + 1];

        for (int i = 0; i <= n; i++) {
            T[i][0] = 1;
        }

        for (int i = 1; i <= n; i++)
        {
            for (int j = 1; j <= target; j++)
            {
                if (S[i - 1] > j) {
                    T[i][j] = T[i - 1][j];
                }
                else {
                    T[i][j] = T[i - 1][j] + T[i][j - S[i - 1]];
                }
            }
        }

        return T[n][target];
    }

    //1-D DP TABLE METHOD
    // Function to find the total number of distinct ways to get a change of `target`
    // from an unlimited supply of coins in set `S`
    public static int count(int[] S, int target)
    {
        int T[] = new int[target+1];
        T[0] = 1;

        for (int i = 0; i < S.length; i++)
        {
            for (int j = S[i]; j <= target; j++) {
                T[j] += T[j - S[i]];
            }
        }

        return T[target];
    }
}

