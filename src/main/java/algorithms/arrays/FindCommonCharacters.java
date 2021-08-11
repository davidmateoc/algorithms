package algorithms.arrays;

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
 * Time: 11:29 PM
 * Algorithm URL: https://leetcode.com/problems/find-common-characters/
 */

public class FindCommonCharacters {
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
    public void commonCharsTest() {
        assertThat(commonChars(new String[]{"bella", "label", "roller"}), is(equalTo(List.of("e", "l", "l"))));
    }
}
