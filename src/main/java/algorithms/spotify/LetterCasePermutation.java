package algorithms.spotify;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by davidmateo
 * Date: 7/7/21
 * Time: 12:22 PM
 * Algorithm URL: https://leetcode.com/problems/letter-case-permutation/
 */

public class LetterCasePermutation {

    public List<String> letterCasePermutation(String s) {
        List<String> output = new ArrayList();
        backtracking(output, "",0, s);
        return output;
    }

    public void backtracking(List<String> output, String current, int position, String s) {
        if(position == s.length()) {
            output.add(current);
            return;
        }

        if(Character.isDigit(s.charAt(position))) {
            backtracking(output, current + s.charAt(position), position + 1, s);
        } else {
            int newPosition = position + 1;
            backtracking(output, current + String.valueOf(s.charAt(position)).toLowerCase(), newPosition, s);
            backtracking(output, current + String.valueOf(s.charAt(position)).toUpperCase(), newPosition, s);
        }
    }

    @Test
    public void LetterCasePermutationTest() {
        String test = "ab9";
        letterCasePermutation(test);

    }
}

