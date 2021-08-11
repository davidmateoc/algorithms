package algorithms.strings;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Create by davidmateo
 * Date: 2021-08-09
 * Time: 1:29 PM
 * Algorithm URL: https://leetcode.com/problems/robot-return-to-origin/
 */

public class RobotReturnToOrigin {

    public boolean judgeCircle(String moves) {
        int x = 0;
        int y = 0;

        for(char c : moves.toCharArray()) {
            if(c == 'L') x--;
            if(c == 'R') x++;
            if(c == 'U') y++;
            if(c == 'D') y--;
        }
        return x==0 && y==0;
    }

    @Test
    public void judgeCircleTest() {
        assertTrue(judgeCircle("UD"));
    }

}
