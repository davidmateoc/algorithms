package algorithms.integers;

import org.junit.Assert;
import org.junit.Test;

/**
 * Create by davidmateo
 * Date: 2021-08-09
 * Time: 12:47 PM
 * Algorithm URL: https://leetcode.com/problems/palindrome-number/
 */

public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        if(x < 0) return false;

        String xString = String.valueOf(x);

        for(int i = 0; i < xString.length() / 2; i++) {
            if(xString.charAt(i) != xString.charAt(xString.length() - 1 - i)) return false;
        }
        return true;
    }

    @Test
    public void isPalindromeTest() {
        Assert.assertTrue(isPalindrome(121));
    }
}
