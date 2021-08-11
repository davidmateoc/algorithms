package algorithms.spotify;

import org.hamcrest.core.Is;
import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Test;

/**
 * Create by davidmateo
 * Date: 7/17/21
 * Time: 6:51 PM
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


    public int countPrimesOptimal(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (notPrime[i] == false) {
                count++;
                for (int j = 2; i*j < n; j++) {
                    notPrime[i*j] = true;
                }
            }
        }

        return count;
    }

    @Test
    public void CountPrimesTest() {
        Assert.assertThat(countPrimes(499979), Is.is(IsEqual.equalTo(41537)));
    }
    @Test
    public void CountPrimesOptimalTest() {
        Assert.assertThat(countPrimesOptimal(499979), Is.is(IsEqual.equalTo(41537)));
    }
}

