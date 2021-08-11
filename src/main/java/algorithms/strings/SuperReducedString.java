package algorithms.strings;

import org.hamcrest.core.Is;
import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Test;

/**
 * Create by davidmateo
 * Date: 8/8/21
 * Time: 8:46 PM
 * Algorithm URL: https://www.hackerrank.com/challenges/reduced-string/problem
 */

public class SuperReducedString {

    public String superReducedString(String s) {
        for(int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == s.charAt(i-1)) {
                s = s.substring(0, i - 1) + s.substring(i+1);
                i = 0;
            }
        }

        if (s.length() == 0) {
            return "Empty String";
        } else {
            return s;
        }
    }

    @Test
    public void SuperReducedStringTest() {
        Assert.assertThat(superReducedString("aacabbc"), Is.is(IsEqual.equalTo("cac")));
    }
}

