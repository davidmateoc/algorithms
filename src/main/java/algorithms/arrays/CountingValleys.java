package algorithms.arrays;

import org.hamcrest.core.Is;
import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Test;

/**
 * Create by davidmateo
 * Date: 2021-08-08
 * Time: 10:43 PM
 * Algorithm URL: https://www.hackerrank.com/challenges/counting-valleys/problem
 */

public class CountingValleys {

    public static int countingValleys(int steps, String path) {
        int level = 0;
        int valleys = 0;

        for(char c : path.toCharArray()) {
            if(c == 'U') {
                level++;
                if(level == 0) {
                    valleys++;
                }
            } else {
                level--;
            }
        }
        return valleys;
    }

    @Test
    public void countingValleysTest() {
        Assert.assertThat(countingValleys(8, "UDDDUDUU"), Is.is(IsEqual.equalTo(1)));
    }
}
