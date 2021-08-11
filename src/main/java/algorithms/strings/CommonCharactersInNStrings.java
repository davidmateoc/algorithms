package algorithms.strings;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Create by davidmateo
 * Date: 2021-08-08
 * Time: 11:08 PM
 * Algorithm URL: https://leetcode.com/problems/find-common-characters/
 */

public class CommonCharactersInNStrings {

    public static List<Character> commonCharactersWithoutDuplicates(List<String> strings) {
        List<Character> containedCharacters = new ArrayList();
        boolean containedInAll = true;

        if(strings.isEmpty()) {
            return containedCharacters;
        }

        String firstString = strings.get(0);
        char[] firstStringChars = firstString.toCharArray();

        for(char c : firstStringChars) {
            for(String s : strings) {
                if(!s.contains(String.valueOf(c))) {
                    containedInAll = false;
                }
            }
            if(containedInAll && !containedCharacters.contains(c)) {
                containedCharacters.add(c);
            }
            containedInAll = true;
        }
        return containedCharacters;
    }

    public static List<String> commonChars(String[] A) {
        List<String> commonChars = new ArrayList();
        int[] minCharFrequencies = new int[26];
        Arrays.fill(minCharFrequencies, Integer.MAX_VALUE);

        if(A.length == 0) {
            return commonChars;
        }

        for(String s : A) {
            int[] currentCharFrequencies = new int[26];
            char[] sChars = s.toCharArray();

            for(char c : sChars) {
                currentCharFrequencies[c - 'a']++;
            }

            for(int i = 0; i < 26; i++) {
                minCharFrequencies[i] = Math.min(minCharFrequencies[i], currentCharFrequencies[i]);
            }
        }

        for(int i = 0; i < 26; i++) {
            while(minCharFrequencies[i] > 0) {
                commonChars.add("" + (char)(i + 'a'));
                minCharFrequencies[i]--;
            }
        }
        return commonChars;
    }


    @Test
    public void commonCharactersInNStringsTest() {
        List<String> listOfStringsA = List.of("bella", "label", "roller");
        List<String> listOfStringsB = List.of("cool", "lock", "cook");

        assertThat(commonCharactersWithoutDuplicates(listOfStringsA), is(equalTo(List.of('e', 'l'))));
        assertThat(commonCharactersWithoutDuplicates(listOfStringsB), is(equalTo(List.of('c', 'o'))));
    }

    @Test
    public void commonCharactersInNStringsWithDuplicatesTest() {
        String[] arrayOfStringsA = {"bella", "label", "roller"};
        String[] arrayOfStringsB = {"cool", "lock", "cook"};

        assertThat(commonChars(arrayOfStringsA), is(equalTo(List.of("e", "l", "l"))));
        assertThat(commonChars(arrayOfStringsB), is(equalTo(List.of("c", "o"))));
    }
}
