package algorithms.integers;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Create by davidmateo
 * Date: 2021-08-08
 * Time: 11:41 PM
 * Algorithm URL: https://leetcode.com/problems/generate-parentheses/
 */

public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> outputArray = new ArrayList();
        backtrack(outputArray, "", 0, 0, n);
        return outputArray;

    }

    public void backtrack(List<String> outputArray, String currentString, int open, int close, int max) {
        if(currentString.length() == max * 2) {
            outputArray.add(currentString);
            return;
        }

        if(open < max) {
            backtrack(outputArray, currentString + "(", open + 1, close, max);
        }
        if(close < open) {
            backtrack(outputArray, currentString + ")", open, close + 1, max);
        }
    }

    @Test
    public void generateParenthesisTest() {
        List<String> result = List.of("()()()", "(())()", "((()))", "()(())", "(()())");
        assertThat(generateParenthesis(3), is(equalTo(result)));
    }

}
