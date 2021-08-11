package algorithms.strings;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;

/**
 * Create by davidmateo
 * Date: 2021-08-09
 * Time: 1:32 PM
 * Algorithm URL: https://leetcode.com/problems/word-subsets/
 */

public class WordSubsets {

    public List<String> wordSubsets(String[] A, String[] B) {
        List<String> subsets = new ArrayList();
        int[] maxBFrequencies = new int[26];

        for(String b : B) {
            int[] frequencies = getCharFrequencies(b);

            for(int i = 0; i < 26; i++) {
                maxBFrequencies[i] = Math.max(maxBFrequencies[i], frequencies[i]);
            }
        }

        for(String a : A) {
            int[] frequencies = getCharFrequencies(a);

            boolean valid = true;
            for(int i = 0; i < 26; i++) {
                if(frequencies[i] < maxBFrequencies[i]) {
                    valid = false;
                    break;
                }
            }

            if(valid) {
                subsets.add(a);
            }

        }

        return subsets;
    }

    public int[] getCharFrequencies(String s) {
        int[] frequencies = new int[26];

        for(char c : s.toCharArray()) {
            frequencies[c - 'a']++;
        }
        return frequencies;
    }


    @Test
    public void wordSubsetsTest() {
        String[] A = {"amazon","apple","facebook","google","leetcode"};
        String[] B = {"lo","eo"};

        assertEquals(wordSubsets(A, B), is(equalTo(List.of("leetcode", "google"))));
    }
}
