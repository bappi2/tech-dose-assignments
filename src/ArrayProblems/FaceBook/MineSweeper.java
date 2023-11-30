package ArrayProblems.FaceBook;

class MineSweeper {
    public char[][] updateBoard(char[][] board, int[] click) {
        int row = click[0], col = click[1];

        if (board[row][col] == 'M') {
            // Mine is clicked, mark it as 'X' and end the game
            board[row][col] = 'X';
        } else {
            // Empty cell is clicked, perform DFS to reveal the cells
            dfs(board, row, col);
        }

        return board;
    }

    private void dfs(char[][] board, int row, int col) {
        // Base cases
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != 'E') {
            return;
        }

        // Count mines in adjacent cells
        int mines = countMines(board, row, col);

        if (mines == 0) {
            // If no mines, mark as 'B' and continue DFS
            board[row][col] = 'B';

            // Explore adjacent cells
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    dfs(board, row + i, col + j);
                }
            }
        } else {
            // If there are mines, update the cell with the count
            board[row][col] = (char) (mines + '0');
        }
    }

    private int countMines(char[][] board, int row, int col) {
        int count = 0;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int newRow = row + i, newCol = col + j;
                if (newRow >= 0 && newRow < board.length && newCol >= 0 && newCol < board[0].length
                        && board[newRow][newCol] == 'M') {
                    count++;
                }
            }
        }

        return count;
    }
}
