package algorithms.integers;

import org.junit.Test;

import java.io.IOException;

/**
 * Create by davidmateo
 * Date: 8/8/21
 * Time: 8:43 PM
 * Algorithm URL: https://www.hackerrank.com/challenges/30-recursion/problem
 */

public class Factorial {

    static int factorial(int n) {
        if(n <= 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    public static int doBetterFactorial(int n) {
        int factorial = 1;
        for(int i = 1; i <= n; i++) {
            factorial = i * factorial;
        }
        return factorial;
    }

    @Test
    public void FactorialTest() throws IOException {

        long t0 = System.nanoTime();
        System.out.println(factorial(5));
        long t1 = System.nanoTime();
        System.out.println(doBetterFactorial(5));
        long t2 = System.nanoTime();

        System.out.println("Wrong one took: " + (t1 - t0)/1000);
        System.out.println("Good one took: " + (t2 - t1)/1000);
    }
}

