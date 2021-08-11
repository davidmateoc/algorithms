package algorithms.integers;

import org.hamcrest.core.Is;
import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Create by davidmateo
 * Date: 8/8/21
 * Time: 8:46 PM
 * Algorithm URL: https://www.hackerrank.com/challenges/a-very-big-sum
 */

public class AVeryBigSum {

    public long aVeryBigSum(List<Long> ar) {
        long result = 0;
        for(long value : ar) {
            result += value;
        }
        return result;
    }

//    public long aVeryBigSum(long[] ar) {
//        long sum = 0;
//        for (long i : ar) {
//            sum += i;
//        }
//        return sum;
//    }

    @Test
    public void aVeryBigSumTest() {
        List<Long> values = List.of(1000000001L, 1000000002L, 1000000003L, 1000000004L, 1000000005L);
        Assert.assertThat(aVeryBigSum(values), Is.is(IsEqual.equalTo(5000000015L)));
    }

}
