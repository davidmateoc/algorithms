package algorithms.strings;

import org.junit.Test;

import java.util.Stack;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Create by davidmateo
 * Date: 2021-08-09
 * Time: 1:27 PM
 * Algorithm URL: https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
 */

public class RemoveAllAdjacentDuplicates {

    public String removeDuplicates(String S) {
        Stack<Character> stack = new Stack();
        char[] sChars = S.toCharArray();

        for(char c : sChars) {
            if(!stack.isEmpty()) {
                if(stack.peek() == c) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            } else {
                stack.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        sb.reverse();
        return sb.toString();
    }

    @Test
    public void removeDuplicatesTest() {
        assertThat(removeDuplicates("abbaca"), is(equalTo("ca")));
    }
}
