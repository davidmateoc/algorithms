package algorithms.arrays;

import org.hamcrest.core.Is;
import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Create by davidmateo
 * Date: 2021-08-08
 * Time: 11:30 PM
 * Algorithm URL: https://www.hackerrank.com/challenges/the-hurdle-race
 */

public class HurdleRace {

    public static int hurdleRace(int k, List<Integer> height) {
        int max = k;
        for(int singleHeight : height) {
            if(singleHeight > max) {
                max = singleHeight;
            }
        }
        return max - k;
    }

    @Test
    public void hurdleRaceTest() {
        List<Integer> heights = List.of(1, 6, 3, 5, 2);
        Assert.assertThat(hurdleRace(4, heights), Is.is(IsEqual.equalTo(2)));
    }
}
