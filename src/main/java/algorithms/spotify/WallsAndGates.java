package algorithms.spotify;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Create by davidmateo
 * Date: 8/10/21
 * Time: 11:01 AM
 * Algorithm URL: https://leetcode.com/problems/walls-and-gates/
 */

public class WallsAndGates {

    public static final int WALL = -1;
    public static final int GATE = 0;
    public static final int EMPTY = Integer.MAX_VALUE;
    public static final List<int[]> DIRECTIONS = Arrays.asList(
        new int[]{1, 0},
        new int[]{-1, 0},
        new int[]{0, 1},
        new int[]{0, -1}
    );

    public void wallsAndGates(int[][] rooms) {
    Queue<int[]> queue = new LinkedList<>();

        if(rooms.length == 0) {
            return;
        }

        for(int row = 0; row < rooms.length; row++) {
            for(int col = 0; col < rooms[0].length; col++) {
                if(rooms[row][col] == GATE) {
                    queue.add(new int[]{row, col});
                }
            }
        }

        while(!queue.isEmpty()) {
            int[] position = queue.poll();
            int row = position[0];
            int col = position[1];

            for(int[] direction : DIRECTIONS) {
                int r = row + direction[0];
                int c = col + direction[1];
                if(r < 0 || r >= rooms.length || c < 0 || c >= rooms[0].length || rooms[r][c] != EMPTY) {
                    continue;
                }
                rooms[r][c] = rooms[row][col] + 1;
                queue.add(new int[]{r, c});
            }
        }
    }

    @Test
    public void WallsAndGatesTest() {

    }
}

