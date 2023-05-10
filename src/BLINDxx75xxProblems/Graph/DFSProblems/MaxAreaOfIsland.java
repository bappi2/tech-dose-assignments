package BLINDxx75xxProblems.Graph.DFSProblems;

import java.util.Arrays;

public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i =0; i < m; i++) {
            Arrays.fill(visited[i], false);
        }

        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    max = Math.max(max, dfs(grid, i, j, visited));
                }
            }
        }
        return max;
    }
    int dfs(int[][] grid, int row, int col, boolean[][] visited) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
            return 0;
        }
        else if (grid[row][col] == 0) {
            return 0;
        }
        else if (visited[row][col] == true) {
            return 0;
        }
        else {
            visited[row][col] = true;

            int result = 1 +
                    dfs(grid, row+1, col, visited)
                    +  dfs(grid, row-1, col, visited)
                    + dfs(grid, row, col + 1, visited)
                    + dfs(grid, row, col - 1, visited);
            return result;
        }
    }
}
