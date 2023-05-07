package BLINDxx75xxProblems.DynamicProgramming.DPONGrid;

import java.util.Arrays;

public class MinimumPathSum {
    // https://leetcode.com/problems/minimum-path-sum/solutions/3345712/complete-intuition-explained-recursion-memoization-tabulation-dp/
    public int minPathSum(int[][] grid) {
        // f(i, j ) = a[i][j]
        // f(i, j) = a[i][j] + f(i, j+1) // i == n
        // f(i, j) = a[i][j] + f(i+1, j) // j == m
        // f(i,j) = a[i][j] + min (f(i-1, j), f(i, j+1))

        return minPathSumHelper(grid, 0, 0);
    }
    int minPathSumHelper(int[][] grid, int i, int j) {
        if (i == (grid.length -1) && j == (grid[0].length -1)) {
            return grid[i][j];
        }
        else if (i == (grid.length -1)) {
            return grid[i][j] + minPathSumHelper(grid, i, j+1);
        }
        else if (j == (grid[0].length -1) ) {
            return grid[i][j] + minPathSumHelper(grid, i +1 , j);
        }
        else {
            return grid[i][j] + Math.min( minPathSumHelper(grid, i +1 , j),
                    minPathSumHelper(grid, i, j +1));
        }
    }

    // DP
    public int minPathSum2(int[][] grid) {
        // f(i, j ) = a[i][j]
        // f(i, j) = a[i][j] + f(i, j+1) // i == n
        // f(i, j) = a[i][j] + f(i+1, j) // j == m
        // f(i,j) = a[i][j] + min (f(i-1, j), f(i, j+1))
        int row = grid.length;
        int col = grid[0].length;
        int [][] dp = new int[row][col];
        for (int i =0; i < row; i++) {
            Arrays.fill(dp[i], -1);
        }
        return minPathSumHelper(grid, 0, 0, dp);
    }
    int minPathSumHelper(int[][] grid, int i, int j, int[][] dp) {
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (i == (grid.length -1) && j == (grid[0].length -1)) {
            dp[i][j] =  grid[i][j];
        }
        else if (i == (grid.length -1)) {
            dp[i][j] =  grid[i][j] + minPathSumHelper(grid, i, j+1, dp);
        }
        else if (j == (grid[0].length -1) ) {
            dp[i][j] =  grid[i][j] + minPathSumHelper(grid, i +1 , j, dp);
        }
        else {
            dp[i][j] = grid[i][j] + Math.min( minPathSumHelper(grid, i +1 , j, dp),
                    minPathSumHelper(grid, i, j +1, dp));
        }
        return dp[i][j];
    }

    public int minPathSum3(int[][] grid) {
        // f(i, j ) = a[i][j]
        // f(i, j) = a[i][j] + f(i, j+1) // i == n
        // f(i, j) = a[i][j] + f(i+1, j) // j == m
        // f(i,j) = a[i][j] + min (f(i-1, j), f(i, j+1))

        int row = grid.length;
        int col = grid[0].length;

        int [][] dp = new int[row][col];

        for (int i = row -1; i >= 0; i--) {
            for (int j = col-1; j >= 0; j--) {
                if ( i == row -1 && j == col -1) {
                    dp[i][j] = grid[i][j];
                }
                else if (i == row -1) {
                    dp[i][j] = grid[i][j] + dp[i][j+1];
                }
                else if (j == col -1) {
                    dp[i][j] = grid[i][j] + dp[i+1][j];
                }
                else {
                    dp[i][j] = grid[i][j] + Math.min(dp[i+1][j], dp[i][j+1]);
                }
            }
        }
        return dp[0][0];
    }
}
