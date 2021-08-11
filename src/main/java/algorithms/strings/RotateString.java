package algorithms.strings;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Create by davidmateo
 * Date: 2021-08-08
 * Time: 11:13 PM
 * Algorithm URL: https://leetcode.com/problems/rotate-string/
 */

public class RotateString {

//    public boolean rotateString(String A, String B) {
//
//        for(int i = 0; i <= A.length(); i++) {
//            String rotatedA = rotateTimes(A, i);
//            if(rotatedA.equals(B)) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public String rotateTimes(String A, int times) {
//        String rotatedString = "";
//        char[] sChars = A.toCharArray();
//
//        for(int i = 0; i < sChars.length; i++) {
//            rotatedString += sChars[(i + times) % A.length()];
//        }
//
//        return rotatedString;
//    }

    public boolean rotateString(String A, String B) {
        return (A.length() == B.length()) && (A+A).contains(B);
    }

    @Test
    public void rotateStringTest() {
        assertTrue(rotateString("abcde", "cdeab"));
    }
}
