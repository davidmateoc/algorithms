package algorithms.strings;

import org.junit.Test;

import java.util.Stack;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Create by davidmateo
 * Date: 2021-08-09
 * Time: 1:24 PM
 * Algorithm URL: https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
 */

public class MinimumRemoveToMakeValidParentheses {

    public String getMinimumRemoveToMakeValidaParenthesesStack(String s) {
        String str = "";
        Stack<Character> myStack = new Stack();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                myStack.push(c);
            } else if (c == ')') {
                if (myStack.isEmpty()) {
                    continue;
                }
                myStack.pop();
            }
            str += c;
        }

        StringBuilder sb = new StringBuilder();

        for(int i = str.length() - 1; i >= 0; i--) {
            if(!myStack.isEmpty() && str.charAt(i) == '(') {
                myStack.pop();
                continue;
            }
            sb.append(str.charAt(i));
        }

        return sb.reverse().toString();
    }

    public String getMinimumRemoveToMakeValidaParentheses(String s) {
        String validS = "";
        int open = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                open++;
            } else if (c == ')') {
                if (open == 0) {
                    continue;
                }
                open--;
            }
            validS += c;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = validS.length() - 1; i >= 0; i--) {
            if (validS.charAt(i) == '(' && open > 0) {
                open--;
                continue;
            }
            sb.append(validS.charAt(i));

        }

        return sb.reverse().toString();
    }

    @Test
    public void minimumRemoveToMakeValidParenthesesTest() {
        String s = "((h(ello))";
        assertThat(getMinimumRemoveToMakeValidaParentheses(s), is(equalTo("((hello))")));
    }

    @Test
    public void getMinimumRemoveToMakeValidaParenthesesStackTest() {
        String s = "((h(ello))";
        assertThat(getMinimumRemoveToMakeValidaParenthesesStack(s), is(equalTo("((hello))")));
    }

}
