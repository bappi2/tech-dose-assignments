package BLINDxx75xxProblems.Backtracking;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;

        boolean [][] visited = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (exisitHelper(board, word, 0, i, j, visited)) {
                    return true;
                }
            }
        }
        return false;

    }
    boolean exisitHelper(char[][] board, String word, int index, int row, int col,
                         boolean [][] visited) {
        // we found a Solution
        if (index == word.length()) {
            return true;
        }
        // boundary check
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length
                || visited[row][col] == true) {
            return false;
        }
        if (board[row][col] != word.charAt(index)) {
            return false;
        }
        visited[row][col] = true;
        boolean result =    exisitHelper(board, word, index + 1, row + 1, col, visited) ||
                exisitHelper(board, word, index + 1, row - 1, col, visited) ||
                exisitHelper(board, word, index + 1, row, col + 1, visited) ||
                exisitHelper(board, word, index + 1, row, col -1, visited);
        visited[row][col] = false;
        return result;



    }
}
