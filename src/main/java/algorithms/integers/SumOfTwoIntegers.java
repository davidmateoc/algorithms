package algorithms.integers;

import org.junit.Test;

import java.math.BigInteger;

/**
 * Create by davidmateo
 * Date: 8/4/21
 * Time: 2:47 AM
 * Algorithm URL: https://leetcode.com/problems/sum-of-two-integers/
 */

public class SumOfTwoIntegers {

    public int getSum(int a, int b) {
        return BigInteger.valueOf(a).add(BigInteger.valueOf(b)).intValue();
    }

    @Test
    public void SumOfTwoIntegersTest() {

    }
}

