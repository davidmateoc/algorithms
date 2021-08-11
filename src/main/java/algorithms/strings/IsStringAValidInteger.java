package algorithms.strings;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Create by davidmateo
 * Date: 2021-08-09
 * Time: 1:25 PM
 * Algorithm URL: 
 */

public class IsStringAValidInteger {

    public boolean isStringValidInteger(String s) {
        try {
            Integer.valueOf(s);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public boolean isStringValidIntegerSecondApproach(String s) {
        String numbers = "1234567890";
        char[] sChars = s.toCharArray();

        for(char c : sChars) {
            if(!numbers.contains(String.valueOf(c))) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void isStringValidIntegerTest() {
        assertTrue(isStringValidInteger("1234"));
        assertFalse(isStringValidInteger("Hello"));
    }

    @Test
    public void isStringValidIntegerSecondApproachTest() {
        assertTrue(isStringValidIntegerSecondApproach("1234"));
        assertFalse(isStringValidIntegerSecondApproach("Hello"));
    }
}
