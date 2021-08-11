package algorithms.arrays;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Create by davidmateo
 * Date: 2021-08-08
 * Time: 11:31 PM
 * Algorithm URL: https://leetcode.com/problems/island-perimeter/
 */

public class IslandPerimeter {

    public int islandPerimeter(int[][] grid) {

        //There's no need of check this, because in the problem it says that 1 <= row, col <= 100
        //if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;

        int result = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    result += 4;

                    if(i > 0 && grid[i - 1][j] == 1) {
                        result -= 2;
                    }

                    if(j > 0 && grid[i][j - 1] == 1) {
                        result -= 2;
                    }
                }
            }
        }
        return result;
    }

    @Test
    public void islandPerimeterTest() {
        int[][] grid = {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
        assertThat(islandPerimeter(grid), is(equalTo(16)));
    }
}
