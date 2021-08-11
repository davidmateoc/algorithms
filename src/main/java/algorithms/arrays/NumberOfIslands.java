package algorithms.arrays;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Create by davidmateo
 * Date: 7/6/21
 * Time: 2:07 AM
 * Algorithm URL: https://leetcode.com/problems/number-of-islands/
 */


public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        int count = 0;

        for(int i = 0;  i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == '1') {
                    count++;
                    callDFS(grid, i, j);
                }
            }
        }
        return count;
    }

    public void callDFS(char[][] grid, int i, int j) {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0';
        callDFS(grid, i - 1, j);    //up
        callDFS(grid, i + 1, j);    //down
        callDFS(grid, i, j - 1);    //left
        callDFS(grid, i, j + 1);    //right
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
    public void numIslandsTestA() {
        char[][] exampleA = new char[][]
        {
            {'1','1','1','1','0'},
            {'1','1','0','1','0'},
            {'1','1','0','0','0'},
            {'0','0','0','0','0'}
        };

        assertThat(numIslands(exampleA), is(equalTo(1)));

    }

    @Test
    public void numIslandsTestB() {
        char[][] exampleB  = {
            {'1','1','0','0','0'},
            {'1','1','0','0','0'},
            {'0','0','1','0','0'},
            {'0','0','0','1','1'}
        };

        assertThat(numIslands(exampleB), is(equalTo(3)));

    }
}
