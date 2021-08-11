package algorithms.arrays;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Create by davidmateo
 * Date: 2021-08-08
 * Time: 11:24 PM
 * Algorithm URL: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */

public class BestTimeToBuyAndSellStock {
    //Time Complexity is O(N) where N is the length of prices
    //Space Complexity is O(1) since we are just using 3 variables
     public int maxProfit(int[] prices) {
        int aPointer = 0;
        int bPointer = 1;

        int max = 0;

        for(int i = 0; i < prices.length - 1; i++) {
            if(prices[aPointer] > prices[bPointer]) {
                aPointer = bPointer;
            } else {
                max = Math.max(max, prices[bPointer] - prices[aPointer]);
            }
            bPointer++;
        }
        return max;
    }

    //Time Complexity is O(N) where N is the length of prices
    //Space Complexity is O(1) since we are just using 2 variables
    public int maxProfitII(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = 0;

        for(int i = 0; i < prices.length; i++) {
            if(prices[i] < min) {
                min = prices[i];
            }

            if(prices[i] - min > max) {
                max = prices[i] - min;
            }
        }

        return max;
    }

    @Test
    public void maxProfitTest() {
        assertThat(maxProfit(new int[]{7, 1, 5, 3, 6, 4}), is(equalTo(5)));
    }

    @Test
    public void maxProfitIITest() {
        assertThat(maxProfitII(new int[]{7, 1, 5, 3, 6, 4}), is(equalTo(5)));
    }
}
