package algorithms.strings;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Create by davidmateo
 * Date: 2021-08-09
 * Time: 1:24 PM
 * Algorithm URL: https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */

public class LetterCombinationsOfAPhoneNumber {

    public List<String> letterCombinations(String digits) {
        LinkedList<String> output = new LinkedList();
        if(digits.length() == 0) {
            return output;
        }

        String[] charMap = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        output.add("");

        for(int i = 0; i < digits.length(); i++) {
            int index = Character.getNumericValue(digits.charAt(i));

            while(output.peek().length() == i) {
                String permutations = output.remove();

                for(char c : charMap[index].toCharArray()) {

                    output.add(permutations + c);
                }
            }
        }
        return output;
    }



    @Test
    public void letterCombinationsTest() {
        assertThat(letterCombinations("23"), is(equalTo(List.of("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"))));
        assertThat(letterCombinations("2"), is(equalTo(List.of("a", "b", "c"))));
        assertThat(letterCombinations("4"), is(equalTo(List.of("g", "h", "i"))));
    }
}
