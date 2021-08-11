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
 * Algorithm URL: https://leetcode.com/problems/remove-k-digits/
 */

public class RemoveKDigits {

    public String removeKdigits(String num, int k) {

        if(num.length() == k) {
            return "0";
        }

        Stack<Character> stack = new Stack();

        int counter = 0;
        while(counter < num.length()) {

            while(k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(counter)) {
                stack.pop();
                k--;
            }

            stack.push(num.charAt(counter));
            counter++;
        }

        while(k > 0) {
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            char currentChar = stack.pop();
            sb.append(currentChar);
        }

        sb.reverse();
        while(sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        return sb.toString();
    }

    @Test
    public void removeKDigitsTest() {
        assertThat(removeKdigits("1173", 2), is(equalTo("11")));
    }

}
