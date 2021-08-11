package algorithms.strings;

import org.hamcrest.core.Is;
import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Test;

/**
 * Create by davidmateo
 * Date: 2021-08-08
 * Time: 10:59 PM
 * Algorithm URL: https://www.hackerrank.com/challenges/repeated-string/problem
 */

public class RepeatedString {
    public long repeatedString(String s, long n) {
        long numberOfTimesWordIsRepeated = n/s.length();
        long numberOfRemainingCharacters = n%s.length();

        return numberOfAsInWord(s) * numberOfTimesWordIsRepeated + numberOfAsInWord(s.substring(0, (int) numberOfRemainingCharacters));
    }

    private long numberOfAsInWord(String s) {
        long numberOfAs = 0;
        for(char c : s.toCharArray()) {
            if(c == 'a') {
                numberOfAs++;
            }
        }
        return numberOfAs;
    }

//    public long repeatedString(String s, long n) {
//        char[] sChar = s.toCharArray();
//        long repeatedTimes = n / s.length();
//        long remainingChars = n - (s.length()*repeatedTimes);
//        long numberOfAs = 0;
//
//        for (char c : sChar) {
//            if (c == 'a') {
//                numberOfAs++;
//            }
//        }
//
//        numberOfAs *= repeatedTimes;
//
//        for (int i = 0; i < remainingChars; i++) {
//            if(sChar[i] == 'a') {
//                numberOfAs++;
//            }
//        }
//        return numberOfAs;
//    }

    @Test
    public void repeatedStringTest() {
        Assert.assertThat(repeatedString("a", 1000000000000L), Is.is(IsEqual.equalTo(1000000000000L)));
        Assert.assertThat(repeatedString("aba", 10), Is.is(IsEqual.equalTo(7L)));
    }
}
