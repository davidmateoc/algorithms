package algorithms.arrays;

import org.hamcrest.core.Is;
import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Create by davidmateo
 * Date: 8/8/21
 * Time: 8:46 PM
 * Algorithm URL: https://www.hackerrank.com/challenges/birthday-cake-candles/
 */

public class BirthdayCakeCandles {

    public int birthdayCakeCandles(List<Integer> candles) {
        int highestCandle = 0;
        int numberOfHighestCandles = 0;

        for(int candle : candles) {
            if(candle > highestCandle) {
                highestCandle = candle;
                numberOfHighestCandles = 1;
            } else if(candle == highestCandle) {
                numberOfHighestCandles++;
            }
        }
        return numberOfHighestCandles;
    }

//    public int maxHeight(int[] ar) {
//        int max = ar[0];
//        for(int i : ar) {
//            if(max < i) {
//                max = i;
//            }
//        }
//        return max;
//    }
//
//    public int countCandlesWithHeight(int[] ar, int h) {
//        int count = 0;
//        for (int i : ar) {
//            if (i == h) {
//                count++;
//            }
//        }
//        return count;
//    }
//
//    public int birthdayCakeCandles(int[] ar) {
//        int highestCandle = maxHeight(ar);
//        return countCandlesWithHeight(ar, highestCandle);
//    }

    @Test
    public void birthdayCakeCandlesTest() {
        List<Integer> candles = List.of(3, 2, 1, 3);
        Assert.assertThat(birthdayCakeCandles(candles), Is.is(IsEqual.equalTo(2)));
    }
}
