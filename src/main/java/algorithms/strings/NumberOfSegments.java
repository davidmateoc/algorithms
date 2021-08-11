package algorithms.strings;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Create by davidmateo
 * Date: 2021-08-09
 * Time: 1:26 PM
 * Algorithm URL: https://leetcode.com/problems/number-of-segments-in-a-string/
 */

public class NumberOfSegments {

    public int getNumberOfSegments(String s) {
        String[] sSplitted = s.split(" ");
        int numberOfSegments = 0;

        for(String str : sSplitted) {
            if(!str.isBlank()) {
                numberOfSegments++;
            }
        }
        return numberOfSegments;
    }

    @Test
    public void getNumberOfSegmentsTest() {
        assertThat(getNumberOfSegments("This is just a   test"), is(equalTo(5)));
    }
}
