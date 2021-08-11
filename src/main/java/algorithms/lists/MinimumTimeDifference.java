package algorithms.lists;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Create by davidmateo
 * Date: 2021-08-09
 * Time: 12:56 PM
 * Algorithm URL: https://leetcode.com/problems/minimum-time-difference/
 */

public class MinimumTimeDifference {

    public int findMinDifference(List<String> timePoints) {
        boolean[] seen = new boolean[24 * 60];

        for(String timePoint : timePoints) {
            String[] timePointSplit = timePoint.split(":");
            int hours = Integer.parseInt(timePointSplit[0]);
            int minutes = Integer.parseInt(timePointSplit[1]);

            if(seen[(hours * 60) + minutes]) return 0;
            seen[(hours * 60) + minutes] = true;
        }

        Integer firstTimeSeen = null;
        Integer prevTimeSeen = null;
        Integer min = Integer.MAX_VALUE;


        for(int i = 0; i < 1440; i++) {
            if(seen[i]) {
                if(firstTimeSeen == null) {
                    firstTimeSeen = i;
                    prevTimeSeen = i;
                } else {
                    min = Math.min(min, Math.min(i - prevTimeSeen, 1440 - i + prevTimeSeen));
                    prevTimeSeen = i;
                }
            }
        }
        min = Math.min(min, Math.min(prevTimeSeen - firstTimeSeen, 1440 - prevTimeSeen + firstTimeSeen));
        return min;

    }

    @Test
    public void findMinDifferenceTest() {
        assertThat(findMinDifference(List.of("23:59", "00:00")), is(equalTo(1)));
    }

}
