package algorithms.arrays;

/**
 * Create by davidmateo
 * Date: 8/8/21
 * Time: 8:43 PM
 * Algorithm URL: https://leetcode.com/problems/matrix-diagonal-sum/
 */

public class DiagonalSum {

    public static int diagonalSum(int[][] matrix) {
        int firstDiagonal = 0;
        int secondDiagonal = 0;

        for(int i = 0; i < matrix.length; i++) {
            firstDiagonal += matrix[i][i];
            secondDiagonal += matrix[i][matrix.length - i - 1];
        }
        if(matrix.length % 2 != 0) {
            secondDiagonal -= matrix[matrix.length/2][matrix.length/2];
        }

        return firstDiagonal + secondDiagonal;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {9, 8, 9}};
        System.out.println("Diagonal sum: " + diagonalSum(matrix));
    }

}
