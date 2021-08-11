package algorithms.arrays;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Create by davidmateo
 * Date: 2021-08-08
 * Time: 11:36 PM
 * Algorithm URL: https://leetcode.com/problems/spiral-matrix-ii/
 */

public class SpiralMatrixII {

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        int rowBegin = 0;
        int rowEnd = n - 1;

        int colBegin = 0;
        int colEnd = n - 1;
        int counter = 1;

        while(rowBegin <= rowEnd && colBegin <= colEnd) {

            for(int i = colBegin; i <= colEnd; i++) {
                matrix[rowBegin][i] = counter;
                counter++;
            }
            rowBegin++;

            for(int i = rowBegin; i <= rowEnd; i++) {
                matrix[i][colEnd] = counter;
                counter++;
            }
            colEnd--;

            if(rowBegin <= rowEnd) {
                for(int i = colEnd; i >= colBegin; i--) {
                     matrix[rowEnd][i] = counter;
                     counter++;
                }
            }
            rowEnd--;

            if(colBegin <= colEnd) {
                for(int i = rowEnd; i >= rowBegin; i--) {
                    matrix[i][colBegin] = counter;
                    counter++;
                }
            }
            colBegin++;
        }
        return matrix;
    }

    @Test
    public void generateMatrixTest() {
        int[][] result = new int[][]{{1, 2, 3}, {8, 9, 4}, {7, 6, 5}};
        assertThat(generateMatrix(3), is(equalTo(result)));
    }
}
