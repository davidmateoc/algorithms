package algorithms.strings;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Create by davidmateo
 * Date: 2021-08-08
 * Time: 11:10 PM
 * Algorithm URL: https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram/
 */

public class NumberOfCharactersDeletionsForAnagram {

    public int numberOfCharacterDeletionsForAnagram(String wordA, String wordB) {
        int numberOfDeletedCharacters = 0;

        char[] charsA = wordA.toCharArray();
        char[] charsB = wordB.toCharArray();

        Map<Character, Integer> mapA = new HashMap();

        for(char c : charsA) {
            if(mapA.containsKey(c)) {
                mapA.put(c, mapA.get(c) + 1);
            } else {
                mapA.put(c, 1);
            }
        }

        for(char c : charsB) {
            if(mapA.containsKey(c) && mapA.get(c) > 0) {
                mapA.put(c, mapA.get(c) - 1);
            } else {
                numberOfDeletedCharacters++;
            }
        }

        for(char c : mapA.keySet()) {
            numberOfDeletedCharacters += mapA.get(c);
        }

        return numberOfDeletedCharacters;
    }

    @Test
    public void numberOfCharacterDeletionsForAnagramTest() {
        String wordA = "parta";
        String wordB = "trap";

        Assert.assertThat(numberOfCharacterDeletionsForAnagram(wordA, wordB), is(equalTo(1)));
    }
}
