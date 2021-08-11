package algorithms.integers;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Create by davidmateo
 * Date: 2021-08-09
 * Time: 12:49 PM
 * Algorithm URL: https://leetcode.com/problems/reverse-integer/
 */

public class ReverseInteger {

    public int reverse(int x) {

        boolean isPositive = x >= 0;
        x = Math.abs(x);

        String xString = String.valueOf(x);
        StringBuilder sb = new StringBuilder(xString);

        for(int i = 0; i < sb.length() / 2; i++) {
            char temp = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(sb.length() - 1 - i));
            sb.setCharAt(sb.length() - 1 - i, temp);
        }

        int reversedNumber;

        try {
            reversedNumber = Integer.parseInt(sb.toString());
        } catch (Exception e) {
            return 0;
        }
        return isPositive? reversedNumber : -reversedNumber;
    }

    public int reverseII(int x) {
        boolean isPositive = x >= 0;
        x = Math.abs(x);

        StringBuilder sb = new StringBuilder(String.valueOf(x));
        sb.reverse();

        int reverseNumber;
        try {
            reverseNumber = Integer.parseInt(sb.toString());
        } catch (Exception e) {
            return 0;
        }

        return isPositive? reverseNumber : -reverseNumber;
    }


    @Test
    public void reverseTest() {
        assertThat(reverse(1534236469), is(equalTo(0)));
        assertThat(reverseII(1534236469), is(equalTo(0)));
    }
}
