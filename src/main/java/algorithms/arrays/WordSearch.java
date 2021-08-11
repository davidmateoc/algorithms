package algorithms.arrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * Create by davidmateo
 * Date: 2021-08-08
 * Time: 11:39 PM
 * Algorithm URL: https://leetcode.com/problems/word-search/
 */

public class WordSearch {

    boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if(board[i][j] == word.charAt(0) && searchWord(i, j, 0, word, board)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean searchWord(int i, int j, int index, String word, char[][] board) {
        if(index == word.length()) {
            return true;
        }

        if(i < 0 || j < 0 || i >= board.length || j >= board[i].length || word.charAt(index) != board[i][j] || visited[i][j]) {
            return false;
        }

        visited[i][j] = true;

        if(
            searchWord(i - 1, j, index + 1, word, board) || //up
            searchWord(i + 1, j, index + 1, word, board) || //down
            searchWord(i, j - 1, index + 1, word, board) || //left
            searchWord(i, j + 1, index + 1, word, board)    //right
        ) {
            return true;
        }
        visited[i][j] = false;
        return false;
    }

    @Test
    public void existTest() {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        Assert.assertTrue(exist(board, "ABCCED"));
    }
}