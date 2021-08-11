package algorithms.integers;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Create by davidmateo
 * Date: 2021-08-08
 * Time: 10:58 PM
 * Algorithm URL: https://leetcode.com/problems/fibonacci-number/
 */

public class FibonacciNumber {

    public int fibonacci(int n) {
        if(n == 0) {
            return 0;
        }
        if(n == 1) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    public int fib(int n) {
        int first = 0;
        int second = 1;
        int result;

        if(n == 0) {
            return first;
        }

        for (int i = 2; i <= n; i++) {
            result = first + second;
            first = second;
            second = result;
        }

        return second;
    }

    @Test
    public void fibonacciTest() {
        assertThat(fibonacci(4), is(equalTo(3)));
        assertThat(fib(4), is(equalTo(3)));
    }
}
