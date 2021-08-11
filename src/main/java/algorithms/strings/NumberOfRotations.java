package algorithms.strings;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Create by davidmateo
 * Date: 2021-08-09
 * Time: 1:28 PM
 * Algorithm URL: 
 */

public class NumberOfRotations {

    public int numberOfLeftRotations(String s1, String s2) {
        int numberOfLeftRotations = 0;
        for(int i = 0; i < s1.length(); i++) {
            if(s1.equals(s2)) {
                return numberOfLeftRotations;
            } else {
                s2 = rotateLeft(s2);
                numberOfLeftRotations++;
            }
        }
        return numberOfLeftRotations;
    }

    public String rotateLeft(String s1) {
        String rotatedString = "";
        char[] sChars = s1.toCharArray();

        for(int i = 0; i < sChars.length; i++) {
            rotatedString += sChars[(i + 1) % s1.length()];
        }

        return rotatedString;
    }

    @Test
    public void numberOfRotationsTest() {
        assertThat(numberOfLeftRotations("abcde", "cdeab"), is(equalTo(3)));
    }
}
