package algorithms.lists;

import org.hamcrest.core.Is;
import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Create by davidmateo
 * Date: 2021-08-09
 * Time: 12:55 PM
 * Algorithm URL: https://www.hackerrank.com/challenges/divisible-sum-pairs
 */

public class DivisibleSumPairs {

    public static int divisibleSumPairs(int n, int k, List<Integer> ar) {
        int total = 0;

        for(int i = 0; i < n - 1; i++) {
            for(int j = i + 1; j < n; j++) {
                if((ar.get(i) + ar.get(j))%k == 0) {
                    total++;
                }
            }
        }
        return total;
    }

    @Test
    public void divisibleSumPairsTest() {
        List<Integer> ar = List.of(1, 3, 2, 6, 1, 2);
        Assert.assertThat(divisibleSumPairs(6, 3, ar), Is.is(IsEqual.equalTo(5)));
    }
}
