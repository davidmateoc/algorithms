package algorithms.spotify;

import org.hamcrest.core.Is;
import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Test;

/**
 * Create by davidmateo
 * Date: 7/7/21
 * Time: 5:03 AM
 * Algorithm URL: https://leetcode.com/problems/plus-one/
 */

public class PlusOne {

    public int[] plusOne(int[] digits) {
        for(int i = digits.length - 1; i >= 0; i--) {
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] digitsPlusOne = new int[digits.length + 1];
        digitsPlusOne[0] = 1;
        return digitsPlusOne;
    }

    @Test
    public void PlusOneTest() {
        Assert.assertThat(plusOne(new int[]{1, 2, 3}), Is.is(IsEqual.equalTo(new int[]{1, 2, 4})));
        Assert.assertThat(plusOne(new int[]{1, 2, 9}), Is.is(IsEqual.equalTo(new int[]{1, 3, 0})));
        Assert.assertThat(plusOne(new int[]{9, 9, 9}), Is.is(IsEqual.equalTo(new int[]{1, 0, 0, 0})));
    }
}

