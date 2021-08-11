package algorithms.strings;

import org.hamcrest.core.Is;
import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Test;

/**
 * Create by davidmateo
 * Date: 2021-08-08
 * Time: 11:06 PM
 * Algorithm URL: https://www.hackerrank.com/challenges/alternating-characters/problem
 */

public class AlternatingCharacters {

    public static int alternatingCharacters(String s) {
        if(s.length() < 2) {
            return 0;
        }

        int numberOfDeletions = 0;
        int pointerA = 0;
        int pointerB = 1;

        while(pointerB < s.length()) {
            if(s.charAt(pointerA) == s.charAt(pointerB)) {
                numberOfDeletions++;
            } else {
                pointerA = pointerB;
            }
            pointerB++;
        }
        return numberOfDeletions;
    }

//    public int alternatingCharacters(String s) {
//        int del = 0;
//        char[] aChars = s.toCharArray();
//        char currentChar = aChars[0];
//
//        for(int i = 1; i < aChars.length; i++) {
//            if(aChars[i] == currentChar) {
//                del++;
//            } else {
//                currentChar = aChars[i];
//            }
//        }
//
//        return del;
//    }

    @Test
    public void alternatingCharactersTest() {
        Assert.assertThat(alternatingCharacters("AAAA"), Is.is(IsEqual.equalTo(3)));
        Assert.assertThat(alternatingCharacters("BBBBB"), Is.is(IsEqual.equalTo(4)));
        Assert.assertThat(alternatingCharacters("ABABABAB"), Is.is(IsEqual.equalTo(0)));
        Assert.assertThat(alternatingCharacters("BABABA"), Is.is(IsEqual.equalTo(0)));
        Assert.assertThat(alternatingCharacters("AAABBB"), Is.is(IsEqual.equalTo(4)));
    }
}
