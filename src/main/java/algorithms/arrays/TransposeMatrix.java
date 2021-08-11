package algorithms.arrays;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Create by davidmateo
 * Date: 2021-08-08
 * Time: 10:30 PM
 * Algorithm URL: https://leetcode.com/problems/transpose-matrix/
 */

public class TransposeMatrix {
    public int[][] transpose(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        int[][] transposed = new int[col][row];

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                transposed[j][i] = matrix[i][j];
            }
        }
        return transposed;
    }

    @Test
    public void transposeTest() {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] transposedMatrix = {{1, 4, 7}, {2, 5, 8}, {3, 6, 9}};
        assertThat(transpose(matrix), is(equalTo(transposedMatrix)));
    }
}
