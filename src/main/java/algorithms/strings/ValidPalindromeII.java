package algorithms.strings;

import org.junit.Assert;
import org.junit.Test;

/**
 * Create by davidmateo
 * Date: 2021-08-09
 * Time: 1:31 PM
 * Algorithm URL: https://leetcode.com/problems/valid-palindrome-ii/
 */

public class ValidPalindromeII {

    public boolean validPalindrome(String s) {
        int aPointer = 0;
        int bPointer = s.length() - 1;

        while (aPointer <= bPointer) {
            if (s.charAt(aPointer) != s.charAt(bPointer)) {
                return helperValidPalindrome(s.substring(aPointer, bPointer)) || helperValidPalindrome(s.substring(aPointer + 1, bPointer + 1));
            }
            aPointer++;
            bPointer--;
        }
        return true;
    }

    public boolean helperValidPalindrome(String s) {
        int aPointer = 0;
        int bPointer = s.length() - 1;

        while (aPointer <= bPointer) {
            if (s.charAt(aPointer) != s.charAt(bPointer)) {
                return false;
            }
            aPointer++;
            bPointer--;
        }
        return true;
    }

    @Test
    public void validPalindromeTest() {
        Assert.assertTrue(validPalindrome("abc"));
    }
}
