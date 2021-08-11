package algorithms.integers;

/**
 * Create by davidmateo
 * Date: 2021-08-09
 * Time: 12:51 PM
 * Algorithm URL: https://leetcode.com/problems/design-tic-tac-toe/
 */

public class TicTacToe {

    private int[] rows;
    private int[] columns;
    private int diagonalSum;
    private int antiDiagonalSum;

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        rows = new int[n];
        columns = new int[n];
    }


    /** Player {player} makes a move at ({row}, {col}).
     @param row The row of the board.
     @param col The column of the board.
     @param player The player, can be either 1 or 2.
     @return The current winning condition, can be either:
     0: No one wins.
     1: Player 1 wins.
     2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int playerValue = (player == 1) ? 1 : -1;
        if(row == col) {
            diagonalSum += playerValue;
        }

        if(col == (columns.length - row - 1)) {
            antiDiagonalSum += playerValue;
        }

        rows[row] += playerValue;
        columns[col] += playerValue;

        if((Math.abs(diagonalSum) == rows.length) ||
           (Math.abs(antiDiagonalSum) == rows.length) ||
           (Math.abs(rows[row]) == rows.length) ||
           (Math.abs(columns[col]) == rows.length))
        {
            System.out.println("Winner is player: " + player);
            return player;
        }
        return 0;
    }


    public static void main(String[] args) {
        TicTacToe board = new TicTacToe(3);
        board.move(0, 0, 1);
        board.move(0, 2, 2);
        board.move(2, 2, 1);
        board.move(1, 1, 2);
        board.move(2, 0, 1);
        board.move(1, 0, 2);
        board.move(2, 1, 1);
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */