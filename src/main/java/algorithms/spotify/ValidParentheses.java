package algorithms.spotify;

import org.junit.Test;

import java.util.Stack;

/**
 * Create by davidmateo
 * Date: 7/7/21
 * Time: 4:26 AM
 * Algorithm URL: https://leetcode.com/problems/valid-parentheses/
 */

public class ValidParentheses {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()) {
            if(
                !stack.isEmpty() && (
                    (c == ')' && stack.peek() == '(') ||
                    (c == '}' && stack.peek() == '{') ||
                    (c == ']' && stack.peek() == '[')
                )
            ) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    @Test
    public void ValidParenthesesTest() {

    }
}

