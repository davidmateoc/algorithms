package algorithms.arrays;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Create by davidmateo
 * Date: 2021-08-08
 * Time: 11:36 PM
 * Algorithm URL: https://leetcode.com/problems/spiral-matrix/
 */

public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList();

        if(matrix.length == 0) return res;

        int rowBegin = 0;
        int rowEnd = matrix.length - 1;

        int colBegin = 0;
        int colEnd = matrix[0].length - 1;

        while(rowBegin <= rowEnd && colBegin <= colEnd) {

            for(int i = colBegin; i <= colEnd; i++) {
                res.add(matrix[rowBegin][i]);
            }
            rowBegin++;

            for(int i = rowBegin; i <= rowEnd; i++) {
                res.add(matrix[i][colEnd]);
            }
            colEnd--;

            if(rowBegin <= rowEnd) {
                for(int i = colEnd; i >= colBegin; i--) {
                    res.add(matrix[rowEnd][i]);
                }
            }
            rowEnd--;

            if(colBegin <= colEnd) {
                for(int i = rowEnd; i >= rowBegin; i--) {
                    res.add(matrix[i][colBegin]);
                }
            }
            colBegin--;
        }
        return res;
    }

    @Test
    public void spiralOrderTest() {
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        List<Integer> result = List.of(1, 2, 3, 6, 9, 8, 7, 4, 5);

        assertThat(spiralOrder(matrix), is(equalTo(result)));
    }
}
