package algorithms.integers;

import org.junit.Test;

/**
 * Create by davidmateo
 * Date: 8/6/21
 * Time: 12:51 AM
 * Algorithm URL: https://leetcode.com/problems/count-primes/
 */

public class CountPrimes {

    public int countPrimes(int n) {
        int numberOfPrimes = 0;

        for(int i = 0; i < n; i++) {
            if(isPrime(i)) {
                numberOfPrimes++;
            }
        }
        return numberOfPrimes;
    }

    private boolean isPrime(int n) {
        if(n < 2) {
            return false;
        }

        for(int i = 2; i <= n/2; i++) {
            if(n%i == 0) {
                return false;
            }
        }
        return true;
    }

    public int countPrimes_SieveOfEratosthenes(int n) {
        boolean[] primes = new boolean[n];
        for(int i = 0; i < primes.length; i++) {
            primes[i] = true;
        }
        //There's no primes bigger than its sqrt
        for(int i = 2; i * i < primes.length; i++) {
            if(primes[i]) {
                for(int j = i; j * i < primes.length; j++) {
                    primes[i * j] = false;
                }
            }
        }

        int primeCount = 0;
        for(int i = 2; i < primes.length; i++) {
            if(primes[i]) {
                primeCount++;
            }
        }
        return primeCount;

    }

    @Test
    public void CountPrimesTest() {

    }
}

