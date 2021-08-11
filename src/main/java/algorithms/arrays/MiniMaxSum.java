package algorithms.arrays;

import org.junit.Test;

import java.util.List;

/**
 * Create by davidmateo
 * Date: 8/8/21
 * Time: 8:55 PM
 * Algorithm URL: https://www.hackerrank.com/challenges/mini-max-sum
 */

public class MiniMaxSum {

    public static void miniMaxSum(List<Integer> arr) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        long total = 0;
        for(int value : arr) {
            total += value;
            if(value > max) {
                max = value;
            }
            if(value < min) {
                min = value;
            }
        }
        System.out.println((total - max) + " " + (total - min));
    }

    @Test
    public void miniMaxSumTest() {
        List<Integer> values = List.of(256741038, 623958417, 467905213, 714532089, 938071625);
        miniMaxSum(values);
    }

}
