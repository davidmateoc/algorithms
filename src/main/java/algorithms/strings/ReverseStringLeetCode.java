package algorithms.strings;

import org.junit.Assert;
import org.junit.Test;

/**
 * Create by davidmateo
 * Date: 2021-08-09
 * Time: 1:28 PM
 * Algorithm URL: https://leetcode.com/problems/reverse-string/
 */

public class ReverseStringLeetCode {

    public char[] reverseString(char[] s) {
        int aPointer = 0;
        int bPointer = s.length - 1;

        while(aPointer < bPointer) {
            char temp = s[aPointer];
            s[aPointer] = s[bPointer];
            s[bPointer] = temp;

            aPointer++;
            bPointer--;

        }
        return s;
    }

    @Test
    public void reverseStringTest() {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        char[] reversedS = {'o', 'l', 'l', 'e', 'h'};
        Assert.assertArrayEquals(reverseString(s), reversedS);
    }
}
