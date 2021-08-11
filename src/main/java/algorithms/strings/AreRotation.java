package algorithms.strings;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Create by davidmateo
 * Date: 2021-08-09
 * Time: 1:17 PM
 * Algorithm URL: https://leetcode.com/problems/rotate-string/
 */

public class AreRotation {

    public boolean isRotation(String s1, String s2) {
        return (s1 + s1).contains(s2) && s1.length() == s2.length();
    }

    @Test
    public void isRotationTest() {
        assertTrue(isRotation("abcde", "cdeab"));
        assertFalse(isRotation("abc", "cdeab"));
    }
}
