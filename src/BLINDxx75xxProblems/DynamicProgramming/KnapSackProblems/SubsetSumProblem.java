package BLINDxx75xxProblems.DynamicProgramming.KnapSackProblems;

public class SubsetSumProblem {
    // https://www.techiedelight.com/subset-sum-problem/

    // A naive solution would be to cycle through all subsets of
    // n numbers and, for every one of them, check if the subset
    // sums to the right number. The running time is of order
    // O(2n.n) since there are 2n subsets, and to check each
    // subset, we need to sum at most n elements.
    //
    //
    //A better exponential-time algorithm uses recursion. Subset sum
    // can also be thought of as a special case of the 0–1 Knapsack problem.
    // For each item, there are two possibilities:
    //
    //Include the current item in the subset and recur for the remaining
    // items with the remaining total.
    //Exclude the current item from the subset and recur for the remaining items.
    //Finally, return true if we get a subset by including or excluding
    // the current item; otherwise, return false. The recursion’s base
    // case would be when no items are left, or the sum becomes negative.
    // Return true when the sum becomes 0, i.e., the subset is found.

        // Returns true if there exists a subsequence of `A[0…n]` with the given sum
        public static boolean subsetSum(int[] A, int n, int k)
        {
            // return true if the sum becomes 0 (subset found)
            if (k == 0) {
                return true;
            }

            // base case: no items left, or sum becomes negative
            if (n < 0 || k < 0) {
                return false;
            }

            // Case 1. Include the current item `A[n]` in the subset and recur
            // for the remaining items `n-1` with the remaining total `k-A[n]`
            boolean include = subsetSum(A, n - 1, k - A[n]);

            // Case 2. Exclude the current item `A[n]` from the subset and recur for
            // the remaining items `n-1`
            boolean exclude = subsetSum(A, n - 1, k);

            // return true if we can get subset by including or excluding the
            // current item
            return include || exclude;
        }

    public static boolean subsetSum(int[] A, int k)
    {
        int n = A.length;

        // `T[i][j]` stores true if subset with sum `j` can be attained
        // using items up to first `i` items
        boolean[][] T = new boolean[n + 1][k + 1];

        // if the sum is zero
        for (int i = 0; i <= n; i++) {
            T[i][0] = true;
        }

        // do for i'th item
        for (int i = 1; i <= n; i++)
        {
            // consider all sum from 1 to sum
            for (int j = 1; j <= k; j++)
            {
                // don't include the i'th element if `j-A[i-1]` is negative
                if (A[i - 1] > j) {
                    T[i][j] = T[i - 1][j];
                }
                else {
                    // find the subset with sum `j` by excluding or including
                    // the i'th item
                    T[i][j] = T[i - 1][j] || T[i - 1][j - A[i - 1]];
                }
            }
        }

        // return maximum value
        return T[n][k];
    }

        // Subset Sum Problem
        public static void main(String[] args)
        {
            // Input: a set of items and a sum
            int[] A = { 7, 3, 2, 5, 8 };
            int k = 14;

            if (subsetSum(A, A.length - 1, k)) {
                System.out.print("Subsequence with the given sum exists");
            }
            else {
                System.out.print("Subsequence with the given sum does not exist");
            }
        }
}

