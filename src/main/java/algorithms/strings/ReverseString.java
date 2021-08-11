package algorithms.strings;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Create by davidmateo
 * Date: 2021-08-08
 * Time: 11:23 PM
 * Algorithm URL: 
 */

public class ReverseString {
    public static String reverseString(String s) {
        String reversedString = "";

        for(int i = s.length() - 1; i >= 0; i-- ) {
            reversedString += s.charAt(i);
        }
        return reversedString;
    }

    public static String reverseEachWord(String s) {
        String[] sSplitted = s.split(" ");
        String reversedString = "";

        for(String str : sSplitted) {
            reversedString += reverseString(str) + " ";
        }
        return reversedString.trim();
    }


    @Test
    public void reverseWholeStringTest() {
        assertThat(reverseString("Probando el test"), is(equalTo("tset le odnaborP")));
    }


    @Test
    public void reverseEachWordTest() {
        assertThat(reverseEachWord("Probando el test"), is(equalTo("odnaborP le tset")));
    }
}
