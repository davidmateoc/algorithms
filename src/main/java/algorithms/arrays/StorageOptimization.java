package algorithms.arrays;

import java.util.List;

/**
 * Create by davidmateo
 * Date: 7/6/21
 * Time: 2:07 AM
 * Algorithm URL: Amazon | OA | April 2021 | Storage Optimization
 */

public class StorageOptimization {

    boolean seen[][];

    public long storage(int n, int m, List<Integer> h, List<Integer> v) {

        int[][] matrix = getMatrix(n, m, h, v);

        int maxArea = 0;
        int rows = matrix.length;
        int columns = matrix[0].length;

        seen = new boolean[rows][columns];

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                maxArea = Math.max(maxArea, area(i, j, matrix));
            }
        }


        return maxArea;
    }

    public int[][] getMatrix(int n, int m, List<Integer> h, List<Integer> v) {
        int[][] matrix = new int[n + 1][m + 1];

        for(int row = 0; row < n + 1; row++) {
            for(int col = 0; col < m + 1; col++) {
                if(h.contains(row) && v.contains(col)) {
                    matrix[row][col] = 1;
                    matrix[row - 1][col] = 1;
                    matrix[row][col - 1] = 1;
                    matrix[row - 1][col - 1] = 1;
                }
            }
        }
        System.out.println("-----------------------");
        printMatrix(matrix);
        System.out.println("-----------------------");
        return  matrix;
    }

    public int area(int row, int column, int[][] grid) {
        if(row <  0 || row >= grid.length || column < 0 || column >= grid[row].length || seen[row][column] || (grid[row][column] == 0)) {
            return 0;
        }

        seen[row][column] = true;

        return (1 + area(row+1, column, grid) + area(row-1, column, grid) + area(row, column-1, grid) + area(row, column+1, grid));

    }


    public void printMatrix(int[][] matrix) {
        for(int[] m : matrix) {
            for(int n : m) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        int n = 6;
        int m = 6;
        List<Integer> v = List.of(2);
        List<Integer> h = List.of(4);

        StorageOptimization so = new StorageOptimization();

        System.out.println("The max area is: " + so.storage(n, m, h, v));
    }


}
