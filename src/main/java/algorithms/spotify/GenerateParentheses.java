package algorithms.spotify;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Create by davidmateo
 * Date: 7/7/21
 * Time: 1:23 AM
 * Algorithm URL: https://leetcode.com/problems/generate-parentheses/
 */

public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> output = new ArrayList();
        backtracking(output, "", 0, 0, n);
        return output;

    }

    public void backtracking(List<String> output, String current, int open, int closed, int max) {
        if(current.length() == max * 2) {
            output.add(current);
            return;
        }

        if(open < max) {
            backtracking(output, current + "(", open + 1, closed, max);
        }

        if(closed < open) {
            backtracking(output, current + ")", open, closed + 1, max);
        }
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

//    public List<String> generateParenthesisWithStack(int n) {
//
//    }

    @Test
    public void generateParenthesisTest() {
        List<String> result = List.of("()()()", "(())()", "((()))", "()(())", "(()())");
        assertThat(generateParenthesis(3), is(equalTo(result)));
    }

}
