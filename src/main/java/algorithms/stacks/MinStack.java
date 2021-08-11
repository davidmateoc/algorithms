package algorithms.stacks;

import org.junit.Test;

import java.util.Stack;

/**
 * Create by davidmateo
 * Date: 8/3/21
 * Time: 3:04 AM
 * Algorithm URL: https://leetcode.com/problems/min-stack/
 */

public class MinStack {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minValues = new Stack<>();

    public MinStack() {

    }

    public void push(int val) {
        if(minValues.isEmpty() || val <= minValues.peek()) {
            minValues.push(val);
        }
        stack.push(val);
    }

    public void pop() {
        if(stack.peek().equals(minValues.peek())) {
            minValues.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minValues.peek();
    }

    @Test
    public void MinStackTest() {

    }
}

