package algorithms.strings;

import org.junit.Test;

import java.util.Stack;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Create by davidmateo
 * Date: 2021-08-09
 * Time: 1:29 PM
 * Algorithm URL: https://leetcode.com/problems/score-of-parentheses/
 */

public class ScoreOfParentheses {

    public int scoreOfParentheses(String s) {
        int score = 0;
        Stack<Integer> myStack = new Stack();

        for(char c : s.toCharArray()) {
            if(c == '(') {
                myStack.push(score);
                score = 0;
            } else {
                score = myStack.pop() + Math.max(2*score, 1);
            }
        }
        return score;

    }

    @Test
    public void scoreOfParenthesesTest() {
        assertThat(scoreOfParentheses("(()())"), is(equalTo(4)));
    }
}
