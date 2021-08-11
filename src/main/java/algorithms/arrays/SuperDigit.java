package algorithms.arrays;

import org.junit.Test;

/**
 * Create by davidmateo
 * Date: 2021-08-08
 * Time: 11:37 PM
 * Algorithm URL: https://www.hackerrank.com/challenges/super-digit
 */

public class SuperDigit {
    public static int superDigit(String n, int k) {
        if(n.length() < 2) {
            return Integer.parseInt(n);
        }
        long newDigit = 0;
        for(char c : n.toCharArray()) {
            newDigit += Character.getNumericValue(c);
        }
        return superDigit(Long.toString(newDigit * k), 1);
    }

    @Test
    public void superDigitTest() {
        superDigit("148", 3);
    }
}