package algorithms.arrays;

import org.junit.Test;

import java.math.BigInteger;

/**
 * Create by davidmateo
 * Date: 8/4/21
 * Time: 2:40 AM
 * Algorithm URL: https://leetcode.com/problems/factorial-trailing-zeroes/
 */

public class FactorialTrailingZeroes {

    //This implementation is bad because input n can be up to 10_000
    public int trailingZeroesBad(int n) {
        int factorialResult = factorialBad(n);
        System.out.println(factorialResult);
        String factorialString = String.valueOf(factorialResult);
        int trailingZeros = 0;

        for(int i = factorialString.length() - 1; i>=0; i--) {
            if(factorialString.charAt(i) == '0') {
                trailingZeros++;
            } else {
                return trailingZeros;
            }
        }
        return trailingZeros;
    }

    private int factorialBad(int n) {
        if(n < 20) {
            return 1;
        } else {
            return n*factorialBad(n-1);
        }
    }

    //Better because we have BigInteger for the big numbers
    public int trailingZeroesBetter(int n) {
        BigInteger factorialResult = factorialBetter(n);
        String factorialString = factorialResult.toString();
        int trailingZeros = 0;

        for(int i = factorialString.length() - 1; i>=0; i--) {
            if(factorialString.charAt(i) == '0') {
                trailingZeros++;
            } else {
                return trailingZeros;
            }
        }
        return trailingZeros;
    }

    private BigInteger factorialBetter(int n) {
        BigInteger factorial = BigInteger.ONE;
        for(int i = 1; i <= n; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }
        return factorial;
    }


    public int trailingZeroesOptimal(int n) {
        int zeros = 0;
        while(n >= 5) {
            zeros += n/5;
            n = n/5;
        }
        return zeros;
    }

    @Test
    public void FactorialTrailingZeroesTest() {

    }
}

