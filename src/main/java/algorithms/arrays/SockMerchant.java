package algorithms.arrays;

import org.hamcrest.core.Is;
import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Create by davidmateo
 * Date: 2021-08-08
 * Time: 11:01 PM
 * Algorithm URL: https://www.hackerrank.com/challenges/sock-merchant/problem
 */

public class SockMerchant {
    public static int sockMerchant(int n, List<Integer> ar) {
        int numberOfPairs = 0;
        Set<Integer> socks = new HashSet();

        for(Integer sock : ar) {
            if(socks.contains(sock)) {
                numberOfPairs++;
                socks.remove(sock);
            } else {
                socks.add(sock);
            }
        }
        return numberOfPairs;
    }

    @Test
    public void sockMerchantTest() {
        List<Integer> socks = List.of(10, 20, 20, 10, 10, 30, 50, 10, 20);
        Assert.assertThat(sockMerchant(0, socks), Is.is(IsEqual.equalTo(3)));
    }

}
