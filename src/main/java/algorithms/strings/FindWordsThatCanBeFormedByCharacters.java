package algorithms.strings;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Create by davidmateo
 * Date: 8/8/21
 * Time: 8:29 PM
 * Algorithm URL: https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/
 */

public class FindWordsThatCanBeFormedByCharacters {

    public int countCharacters(String[] words, String chars) {
        int totalCharacters = 0;
        int[] myChars = new int[26];

        for (char c : chars.toCharArray()) {
            myChars[c - 'a']++;
        }

        for (String word : words) {
            int[] currentWordChars = new int[26];

            for (char c : word.toCharArray()) {
                currentWordChars[c - 'a']++;
            }

            boolean possible = true;

            for (int i = 0; i < 26; i++) {
                if (currentWordChars[i] > myChars[i]) {
                    possible = false;
                }
            }

            if (possible) {
                totalCharacters += word.length();
            }
        }

        return totalCharacters;
    }

    public int countCharactersII(String[] words, String chars) {

        int totalCharacters = 0;
        int[] myChars = new int[26];

        for (char c : chars.toCharArray()) {
            myChars[c - 'a']++;
        }

        for (String word : words) {
            int[] tempChars = Arrays.copyOf(myChars, myChars.length);
            boolean possible = true;
            for (char c : word.toCharArray()) {
                if (tempChars[c - 'a'] > 0) {
                    tempChars[c - 'a']--;
                } else {
                    possible = false;
                }
            }
            if (possible) {
                totalCharacters += word.length();
            }
        }
        return totalCharacters;
    }

    @Test
    public void countCharactersTest() {
        String[] words = {"hello", "world", "leetcode"};
        String chars = "welldonehoneyr";

        assertThat(countCharacters(words, chars), is(equalTo(10)));
        assertThat(countCharactersII(words, chars), is(equalTo(10)));
    }
}
