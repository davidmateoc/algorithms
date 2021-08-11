package algorithms.strings;

import org.junit.Assert;
import org.junit.Test;

/**
 * Create by davidmateo
 * Date: 2021-08-09
 * Time: 1:24 PM
 * Algorithm URL: 
 */

public class IsPalindrome {

    public boolean isPalindrome(String s) {
        return s.equals(reverse(s));
    }

    private String reverse(String s) {
        String reversedString = "";
        for(int i = s.length() - 1; i >= 0; i--) {
            reversedString += s.charAt(i);
        }
        return reversedString;
    }

    @Test
    public void palindromeTest() {
        Assert.assertTrue(isPalindrome("radar"));
        Assert.assertFalse(isPalindrome("hello"));
    }
}
