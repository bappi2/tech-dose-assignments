package BackTracking;

public class WordSearch {
    // Given an m x n grid of characters board and a string word, return true if word exists in the grid.
    //
    // The word can be constructed from letters of sequentially adjacent cells,
    // where adjacent cells are horizontally or vertically neighboring. The same letter
    // cell may not be used more than once.

    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j]==word.charAt(0)  && search(board, word, i, j, 0))
                    return true;
            }
        }
        return false;
    }

    boolean search(char[][] board, String word, int i, int j, int wordIndex) {

        if(i < 0  || j < 0
                || i == board.length || j == board[0].length
                || board[i][j] == '#' || board[i][j] != word.charAt(wordIndex)) {
            return false;
        }

        if(wordIndex == word.length() - 1)
            return true;

        char c = board[i][j];
        board[i][j] = '#';

        if (search(board, word, i, j+1, wordIndex+1) ||
                search(board, word, i, j-1, wordIndex+1) ||
                search(board, word, i-1, j, wordIndex+1) ||
                search(board, word, i+1, j, wordIndex+1))
            return true;

        board[i][j] = c;
        return false;
    }
}
