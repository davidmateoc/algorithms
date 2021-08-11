package algorithms.arrays;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Create by davidmateo
 * Date: 2021-08-08
 * Time: 11:35 PM
 * Algorithm URL: https://leetcode.com/problems/search-a-2d-matrix/
 */

public class SearchA2DMatrix {

    //Time Complexity is O(N*M) where N is the number of rows and M is the number of columns in the matrix
    //Space Complexity is O(1)
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    //Time Complexity is O(M*LOGN) where N is the number of rows and M is the number of columns in the matrix
    //Space Complexity is O(1)
    public boolean searchMatrixOptimal(int[][] matrix, int target) {
        int firstRow = 0;
        int lastRow = matrix.length - 1;
        int lastCol = matrix[0].length - 1;

        while(target > matrix[firstRow][lastCol] && firstRow < lastRow) {
            firstRow++;
        }

        for(int i = 0; i <= lastCol; i++) {
            if(target == matrix[firstRow][i]) {
                return true;
            }
        }
        return false;
    }

    @Test
    public void searchMatrixTest() {
        int[][] matrix = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        assertTrue(searchMatrix(matrix, 3));
    }

    @Test
    public void searchMatrixOptimalTest() {
        int[][] matrix = new int[][]{{1, 1}};
        assertFalse(searchMatrixOptimal(matrix, 3));
    }
}
