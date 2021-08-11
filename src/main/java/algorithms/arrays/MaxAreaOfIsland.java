package algorithms.arrays;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Create by davidmateo
 * Date: 7/6/21
 * Time: 2:07 AM
 * Algorithm URL: https://leetcode.com/problems/max-area-of-island/
 */

public class MaxAreaOfIsland {

    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 1) {
                    int maxIsland = callDFS(grid, i, j);
                    max = Math.max(max, maxIsland);
                }
            }
        }
        return max;
    }

    private int callDFS(int[][] grid, int i, int j) {
        int currentMax = 1;
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;
        currentMax += callDFS(grid, i - 1, j);  //up
        currentMax += callDFS(grid,i + 1, j);  //down
        currentMax += callDFS(grid, i, j - 1);  //left
        currentMax += callDFS(grid, i, j + 1);  //right

        return currentMax;
    }

    public void printMatrix(int[][] matrix) {
        for(int[] m : matrix) {
            for(int n : m) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }

    @Test
    public void maxAreaOfIslandTest() {
        int[][] grid = new int[][]
            {
                {1, 1, 1, 1, 0},
                {1, 1, 0, 1, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0}
            };

        assertThat(maxAreaOfIsland(grid), is(equalTo(9)));

    }
}
