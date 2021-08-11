package algorithms.lists;

import org.hamcrest.core.Is;
import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Create by davidmateo
 * Date: 2021-08-09
 * Time: 12:56 PM
 * Algorithm URL: https://www.hackerrank.com/challenges/minimum-absolute-difference-in-an-array/problem
 */

public class MinimumAbsoluteDifference {

    public static int minimumAbsoluteDifference(List<Integer> arr) {
        Collections.sort(arr);
        int minAbsoluteDifference = Integer.MAX_VALUE;

        for(int i = 0; i < arr.size() - 1; i++) {
            int difference = Math.abs(arr.get(i + 1) - arr.get(i));
            if(minAbsoluteDifference > difference) {
                minAbsoluteDifference = difference;
            }
        }
        return minAbsoluteDifference;
    }

    @Test
    public void minimumAbsoluteDifferenceTest() {
        List<Integer> numbers = Arrays.asList( -36, -13, 1, -53, -92, -2, -96, -54, 75);        //I cant use the List.of() because its unmutable
        Assert.assertThat(minimumAbsoluteDifference(numbers), Is.is(IsEqual.equalTo(1)));
    }

}
