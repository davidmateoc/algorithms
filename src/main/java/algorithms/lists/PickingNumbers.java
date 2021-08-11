package algorithms.lists;

import org.hamcrest.core.Is;
import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Create by davidmateo
 * Date: 2021-08-09
 * Time: 12:57 PM
 * Algorithm URL: https://www.hackerrank.com/challenges/picking-numbers
 */

public class PickingNumbers {

    public static int pickingNumbers(List<Integer> a) {
        Collections.sort(a);
        int pointerA = 0;
        int pointerB = 1;

        int longestSubArray = 1;

        while(pointerB < a.size()) {
            if (Math.abs(a.get(pointerB) - a.get(pointerA)) > 1) {
                longestSubArray = Math.max(longestSubArray, pointerB - pointerA);
                pointerA = pointerB;
            }
            pointerB++;
        }
        return Math.max(longestSubArray, pointerB - pointerA);
    }

    @Test
    public void pickingNumbersTest() {
        Assert.assertThat(pickingNumbers(Arrays.asList(1, 1, 2, 3, 4)), Is.is(IsEqual.equalTo(3)));
        Assert.assertThat(pickingNumbers(Arrays.asList(1, 1, 2, 2, 4, 4, 5, 5, 5)), Is.is(IsEqual.equalTo(5)));
    }
}
