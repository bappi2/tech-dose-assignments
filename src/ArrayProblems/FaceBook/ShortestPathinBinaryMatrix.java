package ArrayProblems.FaceBook;

import java.util.LinkedList;
import java.util.Queue;

class ShortestPathinBinaryMatrix {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (grid[0][0] == 1 || grid[rows - 1][cols - 1] == 1) {
            // The start or end cell is blocked, no valid path
            return -1;
        }

        int[][] directions = { { -1, 0 }, { -1, -1 }, { 0, -1 }, { 1, -1 }, { 1, 0 }, { 1, 1 }, { 0, 1 }, { -1, 1 } };

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { 0, 0, 1 }); // {row, col, steps}

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentRow = current[0];
            int currentCol = current[1];
            int currentSteps = current[2];

            if (currentRow == rows - 1 && currentCol == cols - 1) {
                // Reached the bottom-right cell
                return currentSteps;
            }

            for (int[] direction : directions) {
                int newRow = currentRow + direction[0];
                int newCol = currentCol + direction[1];

                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol] == 0) {
                    // Valid move to an unvisited cell
                    grid[newRow][newCol] = 1; // Mark as visited
                    queue.offer(new int[] { newRow, newCol, currentSteps + 1 });
                }
            }
        }

        // No valid path found
        return -1;
    }
}
